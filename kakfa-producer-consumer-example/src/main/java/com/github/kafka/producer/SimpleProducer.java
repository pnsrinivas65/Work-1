package com.github.kafka.producer;

import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import com.github.kafka.KafkaConstants;

public class SimpleProducer {

	public static void main(String string[]) {
		// create producer properties
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVER);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		
		
		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);

		String datetime = LocalDateTime.now().format(KafkaConstants.DATE_FORMATTER_MMDDYY_HMMSS);
		// create producer record
		ProducerRecord<String, String> record = new ProducerRecord<>(KafkaConstants.TOPIC_NAME,
				"Hello, Current Date and Time :" + datetime);

		// publish the record
		producer.send(record);

		// flush the record
		producer.flush();

		// close the producer
		producer.close();
	}
}
