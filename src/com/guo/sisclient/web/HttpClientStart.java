package com.guo.sisclient.web;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;


import android.os.Handler;
import android.os.Message;

public class HttpClientStart {
	public static void exc(final Handler handler, final int what,
			final String url, final List<NameValuePair> list,
			final WebCallBack back) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpEntity conncent = HttpConcent.conncent(url, list);
					Message obtainMessage = handler.obtainMessage();
					if (back != null) {
						Object webService = back.webService(conncent);
						obtainMessage.obj = webService;
					} else {
						obtainMessage.obj = obtainMessage;
					}
					obtainMessage.what = what;
					handler.sendMessage(obtainMessage);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		HttpClientExecutorService.INSTANCE.getExecutor().execute(thread);
	}
}
