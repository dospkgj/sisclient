package com.guo.sisclient.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class BaseActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
	}
}
