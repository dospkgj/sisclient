package com.guo.sisclient.web;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;

public class HttpConcent {
	public static HttpEntity conncent(String url, List<NameValuePair> list)
			throws ClientProtocolException, IOException {
		HttpClient client = HttpClientSingle.INSTANCE.getInStance();
		HttpPost httpPost = new HttpPost(url);
		if (list != null)
//			httpPost.setEntity(new UrlEncodedFormEntity(list, "GBK"));
			httpPost.setEntity(new UrlEncodedFormEntity(list));
		HttpResponse execute = client.execute(httpPost);
		 //读取cookie并保存文件  
        List<Cookie> cookies = ((AbstractHttpClient) client).getCookieStore().getCookies();    
        if (cookies.isEmpty()) {    
            System.out.println("None");    
        } else {    
            for (int i = 0; i < cookies.size(); i++) {  
                System.out.println("- " + cookies.get(i).toString());
            }    
        }  
		HttpEntity entity = execute.getEntity();
		return entity;
	}
}
