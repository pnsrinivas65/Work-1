package com.github.kafka.producer.twitter;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.kafka.KafkaConstants;
import com.github.kafka.config.twitter.TwitterConfig;
import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

public class HighThroughPutProducer {

	static Logger logger = LoggerFactory.getLogger(HighThroughPutProducer.class);

	private BlockingQueue<String> msgQueue;
	private Hosts hosebirdHosts;
	private Authentication hosebirdAuth;

	private TwitterConfig twitterConfig;

	public HighThroughPutProducer() {
		twitterConfig = new TwitterConfig(KafkaConstants.CONSUMER_KEY, KafkaConstants.KEY, KafkaConstants.TOKEN,
				KafkaConstants.SECRET);
	}

	public static void main(String string[]) {
		new TwitterProducer().run();
	}

	public void run() {

		logger.info(" Twitter Producer Set Up");
		// create a twitter producer
		msgQueue = new LinkedBlockingQueue<>(100);

		KafkaProducer<String, String> producer = createKafkaProducer();

		Client client = createTwitterClient();
		// Attempts to establish the connection
		client.connect();
		
		Runtime.getRuntime().addShutdownHook(new Thread(() ->  {
			logger.info("stopping the application");
			logger.info("shutting down client from Twitter");
			client.stop();
			logger.info("Closing the producer");
			producer.close();
			logger.info("done!!!");
		}));

		// on a different thread, or multiple different threads....
		while (!client.isDone()) {
			String msg = null;
			try {
				msg = msgQueue.poll(10, TimeUnit.SECONDS);
				producer.send(new ProducerRecord<String, String>("twitter_tweets", "ID_", msg), new Callback() {

					@Override
					public void onCompletion(RecordMetadata metadata, Exception exception) {

						if (exception != null) {
							logger.error("Something bad happen");
						}
					}
				});
			} catch (InterruptedException e) {
				logger.error("Error in Connection" + e);
				client.stop();
			}
			if (msg != null) {
				logger.info("Msg from Twitter -->" + msg);
			}
		}

		logger.info("End of Application");
	}

	public Client createTwitterClient() {

		logger.info("Setting up Twitter Producer Process ");

		hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

		// Optional: set up some followings and track terms
		List<String> terms = Lists.newArrayList("bitcoin", "sports","usa", "politics");
		hosebirdEndpoint.trackTerms(terms);

		hosebirdAuth = new OAuth1(twitterConfig.getConsumerKey(), twitterConfig.getConsumerSecret(),
				twitterConfig.getToken(), twitterConfig.getSecret());
		logger.info("Autentication is successful with Twitter");

		ClientBuilder builder = new ClientBuilder().name("Hosebird-Client-01") // optional: mainly for the logs
				.hosts(hosebirdHosts).authentication(hosebirdAuth).endpoint(hosebirdEndpoint)
				.processor(new StringDelimitedProcessor(msgQueue));

		Client hosebirdClient = builder.build();
		// Attempts to establish a connection.
		logger.info("Getting Twitter Producer Connection");

		return hosebirdClient;
	}

	public KafkaProducer<String, String> createKafkaProducer() {

		// create producer properties
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVER);
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// Safe producer config
		props.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");
		props.setProperty(ProducerConfig.ACKS_CONFIG, "all");
		props.setProperty(ProducerConfig.RETRIES_CONFIG, "3"); //Integer.MAX_VALUE
		props.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5"); // 5
		// Caused by: org.apache.kafka.common.config.ConfigException: Must set max.in.flight.requests.per.connection to at most 5 to use the idempotent producer.
		// Safe Producer config
		
		// high throughput producer (at the expense of a bit of latency and CPU usage)
		props.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
		props.setProperty(ProducerConfig.LINGER_MS_CONFIG, "200");
		props.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, Integer.toString(32*1024)); // 32 KB batch size
		
		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		logger.info("Safe Producer");
		return producer;

	}
}
