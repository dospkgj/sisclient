package com.guo.sisclient.activity;

import com.guo.sisclient.R;
import com.guo.sisclient.control.LoginControl;
import com.guo.sisclient.util.ToastUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

	private Button buttonLogin;
	private EditText editTextUser;
	private EditText editTextPasswd;
	private final int LONGIN_HAN = 0x01;
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 0x01:
//				ReslutEntity entity = (ReslutEntity) msg.obj;
//				if (entity.isOK) {
//					ToastUtil.customMes(getBaseContext(), "登录成功");
//					Intent intent = new Intent();
////					intent.setClass(getApplicationContext(), IndexActivity.class);
//					LoginActivity.this.startActivity(intent);
//				}
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		doString();
	}

	private void doString() {
		initView();
	}

	private void initView() {
		buttonLogin = (Button) findViewById(R.id.activity_login_button_login);
		buttonLogin.setOnClickListener(this);
		editTextUser = (EditText) findViewById(R.id.activity_login_edittext_user);
		editTextPasswd = (EditText) findViewById(R.id.activity_login_edittext_passwd);
	}

	private void login() {
		LoginControl loginControl = new LoginControl();
		loginControl.login(handler, LONGIN_HAN, editTextUser.getText()
				.toString(), editTextPasswd.getText().toString());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_login_button_login:
			login();
			break;
		}
	}

}
