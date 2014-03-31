package com.guo.sisclient.web;

import org.apache.http.client.HttpClient;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;

public enum HttpClientSingle {

	INSTANCE;
	private DefaultHttpClient defaultHttpClient;

	private HttpClientSingle() {
		defaultHttpClient = new DefaultHttpClient();
		defaultHttpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,
				CookiePolicy.BEST_MATCH);
	}

	public HttpClient getInStance() {
		return defaultHttpClient;
	}
}
