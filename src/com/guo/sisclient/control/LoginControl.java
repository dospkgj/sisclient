package com.guo.sisclient.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.guo.sisclient.config.WebConfig;
import com.guo.sisclient.web.HttpClientStart;
import com.guo.sisclient.web.WebCallBack;

import android.os.Handler;


public class LoginControl  implements WebCallBack{
	public void login(Handler handler,int what,String user, String passwd) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//		nameValuePairs.add(new BasicNameValuePair("username", user));
//		nameValuePairs.add(new BasicNameValuePair("password", passwd));
		nameValuePairs.add(new BasicNameValuePair("username", "dospkgj"));
		nameValuePairs.add(new BasicNameValuePair("password", "4339158"));
		nameValuePairs.add(new BasicNameValuePair("referer", "index.php"));
		
		nameValuePairs.add(new BasicNameValuePair("formhash", "b70afb25"));
		nameValuePairs.add(new BasicNameValuePair("loginfield", "username"));
		nameValuePairs.add(new BasicNameValuePair("questionid", "0"));
		nameValuePairs.add(new BasicNameValuePair("answer", ""));
		nameValuePairs.add(new BasicNameValuePair("cookietime", "2592000"));
		nameValuePairs.add(new BasicNameValuePair("loginmode", ""));
		nameValuePairs.add(new BasicNameValuePair("styleid", ""));
		nameValuePairs.add(new BasicNameValuePair("styleid", "true"));
		
		HttpClientStart.exc(handler, what, WebConfig.ACTION_LOGIN, nameValuePairs, this);
	}
	@Override
	public Object webService(HttpEntity object) throws ParseException, IOException {
		String string = EntityUtils.toString(object, "GBK");
		boolean contains = string.contains("欢迎您回来");
//		ReslutEntity reslutEntity = new ReslutEntity();
//		reslutEntity.isOK = contains;
		return null;
	}
}
