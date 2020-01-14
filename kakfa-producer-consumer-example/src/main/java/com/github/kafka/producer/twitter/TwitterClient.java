package com.github.kafka.producer.twitter;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

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

public class TwitterClient {

	static Logger logger = LoggerFactory.getLogger(TwitterClient.class);

	private BlockingQueue<String> msgQueue;
	private Hosts hosebirdHosts;
	private Authentication hosebirdAuth;

	private TwitterConfig twitterConfig;

	public TwitterClient() {
		twitterConfig = new TwitterConfig(KafkaConstants.CONSUMER_KEY, 
				KafkaConstants.KEY, KafkaConstants.TOKEN, KafkaConstants.SECRET);
	}

	public static void main(String string[]) {
		new TwitterClient().run();
	}

	public void run() {

		logger.info(" Twitter Client Set Up");
		// create a twitter client
		msgQueue = new LinkedBlockingQueue<>(100);
		Client client = createTwitterClient();
		// Attempts to establish the connection
		client.connect();

		// on a different thread, or multiple different threads....
		while (!client.isDone()) {
			String msg = null;
			try {
				msg = msgQueue.poll(10, TimeUnit.SECONDS);
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

		logger.info("Setting up Twitter Client Process ");

		hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

		// Optional: set up some followings and track terms
		List<String> terms = Lists.newArrayList("bitcoin");
		hosebirdEndpoint.trackTerms(terms);

		hosebirdAuth = new OAuth1(twitterConfig.getConsumerKey(), twitterConfig.getConsumerSecret(),
				twitterConfig.getToken(), twitterConfig.getSecret());
		logger.info("Autentication is successful with Twitter");

		ClientBuilder builder = new ClientBuilder().name("Hosebird-Client-01") // optional: mainly for the logs
				.hosts(hosebirdHosts).authentication(hosebirdAuth).endpoint(hosebirdEndpoint)
				.processor(new StringDelimitedProcessor(msgQueue));

		Client hosebirdClient = builder.build();
		// Attempts to establish a connection.
		logger.info("Getting Twitter Client Connection");

		return hosebirdClient;
	}
}
