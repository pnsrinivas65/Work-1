package com.github.kafka.producer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleProducerKey {

	static Logger logger = LoggerFactory.getLogger(SimpleProducerWithCallBack.class);
	
	public static String BOOTSTRAP_SERVER = "localhost:9092";
	public static String TOPIC_NAME = "demo";

	public static final ZoneId ZONE_UTC = ZoneId.of("UTC");
	public static final String DATE_FORMAT_MM_DD_YY_HH_MM_SS = "MM/dd/yy HH:mm:ss";
	public static final DateTimeFormatter DATE_FORMATTER_MMDDYY_HMMSS = DateTimeFormatter
			.ofPattern(DATE_FORMAT_MM_DD_YY_HH_MM_SS).withZone(ZONE_UTC);

	public static void main(String string[]) {
		// create producer properties
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		String key = "Id_";

		String datetime = LocalDateTime.now().format(DATE_FORMATTER_MMDDYY_HMMSS);
		// create producer record
		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, key,
				"Hello, Current Date and Time :" + datetime);
		logger.info("record -->", record.toString());
		// publish the record
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				// execute every time a record is succesfully sent
				if( exception == null) {
					logger.info("Received new metadata \n"
							+"Topic Name : "+metadata.topic()+"\n"
							+"Partion Id : "+metadata.partition()+"\n"
							+"Offset Id : "+metadata.offset()+"\n"
							+"Key : "+record.key()+"\n"
							);
				} else {
					logger.error("Error in Publishing the message"+exception);
				}
				
			}
		});

		// flush the record
		producer.flush();

		// close the producer
		producer.close();
	}
}
