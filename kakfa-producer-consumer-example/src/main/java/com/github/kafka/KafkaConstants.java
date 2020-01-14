package com.github.kafka;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface KafkaConstants {

	ZoneId ZONE_UTC = ZoneId.of("UTC");
	String DATE_FORMAT_MM_DD_YY_HH_MM_SS = "MM/dd/yy HH:mm:ss";
	DateTimeFormatter DATE_FORMATTER_MMDDYY_HMMSS = DateTimeFormatter.
			ofPattern(DATE_FORMAT_MM_DD_YY_HH_MM_SS).withZone(ZONE_UTC);
	String BOOTSTRAP_SERVER = "localhost:9092";
	String TOPIC_NAME = "demo";
	
	String CONSUMER_KEY = "";
	String KEY = "";
	String TOKEN = "";
	String SECRET = "";

}