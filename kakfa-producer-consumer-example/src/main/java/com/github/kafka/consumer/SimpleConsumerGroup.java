package com.github.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kafka.KafkaConstants;

public class SimpleConsumerGroup {

	public static Logger logger = LoggerFactory.getLogger(SimpleConsumerGroup.class);
	public static String GROUP_ID = "consumer-app-group";
	public static String AUTO_CONFIG[] = { "earliest", "latest", "none" };// earliest/ latest / none
	public static String TOPIC_NAME = "demo";

	public static void main(String s[]) {

		// Create consumer config
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVER);
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		props.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, Arrays.stream(AUTO_CONFIG).findFirst().get());

		// create the consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

		// consumer.subscribe(Collections.singleton(TOPIC_NAME));
		consumer.subscribe(Arrays.asList(TOPIC_NAME));
		int i = 0;
		// poll for new data
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
					//consumer.poll(100);
			i++;
			// consumer.poll(Duration.ofSeconds(1));
			for (ConsumerRecord<String, String> consumerRecord : records) {
				logger.info(" Key " + consumerRecord.key());
				logger.info(" Value " + consumerRecord.value());
				logger.info(" Partion " + consumerRecord.partition());
				logger.info(" Offset " + consumerRecord.offset());
			}
			if (i >= 3) {
				break;
			}
		}
		consumer.close();

	}
}
