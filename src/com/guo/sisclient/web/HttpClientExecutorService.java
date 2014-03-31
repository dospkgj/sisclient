package com.guo.sisclient.web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * webservice线程池
 * 
 * @author gj
 * 
 */
public enum HttpClientExecutorService {
	INSTANCE;
	private ExecutorService executorService;

	private HttpClientExecutorService() {
		executorService = Executors.newFixedThreadPool(5);

	}

	public  ExecutorService getExecutor() {
		return executorService;
	}
}
