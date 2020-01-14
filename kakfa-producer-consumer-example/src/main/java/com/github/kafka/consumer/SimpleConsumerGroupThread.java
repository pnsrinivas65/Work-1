package com.github.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kafka.KafkaConstants;

public class SimpleConsumerGroupThread {

	public static Logger logger = LoggerFactory.getLogger(SimpleConsumerGroupThread.class);
	public static String GROUP_ID = "consumer-app-group";
	public static String AUTO_CONFIG[] = { "earliest", "latest", "none" };// earliest/ latest / none
	public static String TOPIC_NAME = "demo";

	public static void main(String s[]) {
		new SimpleConsumerGroupThread().runConsumerThread();
	}

	public SimpleConsumerGroupThread() {

	}

	private void runConsumerThread() {
		CountDownLatch latch = new CountDownLatch(1);

		logger.info("Creating consumer with Thread");
		Runnable consumerRunnable = new ConsumerRunnable(latch);
		
		// start the thread
		Thread myConsumerRunnable = new Thread(consumerRunnable);
		myConsumerRunnable.start();
		
		// add a shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			logger.info("Caught shutdonw hook");
			((ConsumerRunnable)consumerRunnable).shutdown();
		}));
		try {
			latch.wait();
		} catch(InterruptedException e) {
			logger.error("Got Interuption",e);
		} finally {
			logger.error("Closing Application");
		}
	}

	public class ConsumerRunnable implements Runnable {

		private CountDownLatch latch;
		private KafkaConsumer<String, String> consumer;
		private Logger logger = LoggerFactory.getLogger(ConsumerRunnable.class);

		public ConsumerRunnable(CountDownLatch latch) {
			this.latch = latch;

			// Create consumer config
			Properties props = new Properties();
			props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVER);
			props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
			props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
			props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
			props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Arrays.stream(AUTO_CONFIG).findFirst().get());

			// create the consumer
			consumer = new KafkaConsumer<>(props);
			
			// consumer.subscribe(Collections.singleton(TOPIC_NAME));
			consumer.subscribe(Arrays.asList(TOPIC_NAME));

		}

		@Override
		public void run() {
			try {
				// poll for new data
				while (true) {
					ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
					for (ConsumerRecord<String, String> consumerRecord : records) {
						logger.info(" Key " + consumerRecord.key());
						logger.info(" Value " + consumerRecord.value());
						logger.info(" Partion " + consumerRecord.partition());
						logger.info(" Offset " + consumerRecord.offset());
					}
				}
			} catch (WakeupException e) {
				logger.error("Received shutdonw signal!!!" + e);
			} finally {
				consumer.close();
				latch.countDown();
			}

		}

		public void shutdown() {
			// to interupt poll method
			consumer.wakeup();
		}

	}
}
