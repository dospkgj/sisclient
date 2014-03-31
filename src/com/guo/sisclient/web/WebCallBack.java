package com.guo.sisclient.web;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;

public interface WebCallBack {
	 Object webService(HttpEntity object) throws ParseException, IOException;
}
