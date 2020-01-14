package com.github.kafka.config.twitter;

public class TwitterConfig {
	private String consumerKey;
	private String consumerSecret;
	private String token;
	private String secret;

	public TwitterConfig(String consumerKey, String consumerSecret, String token, String secret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.token = token;
		this.secret = secret;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
}