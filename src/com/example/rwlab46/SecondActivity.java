package com.example.rwlab46;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity implements OnClickListener {
	
	private static final String LOG_TAG = "SecondActivity";
	public static final int CHOOSED_RED = 1;
	public static final int CHOOSED_GREEN = 2;
	public static final int CHOOSED_BLUE = 3;
	public static final int CHOOSED_YELLOW = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Button mBtnRed = (Button)findViewById(R.id.buttonColorRed);
		mBtnRed.setOnClickListener(this);
		Button mBtnGreen = (Button)findViewById(R.id.buttonColorGreen);
		mBtnGreen.setOnClickListener(this);
		Button mBtnBlue = (Button)findViewById(R.id.buttonColorBlue);
		mBtnBlue.setOnClickListener(this);
		Button mBtnYellow = (Button)findViewById(R.id.buttonColorYellow);
		mBtnYellow.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonColorRed:
			startColorPreviewActivity(CHOOSED_RED);
			break;
		case R.id.buttonColorGreen:
			startColorPreviewActivity(CHOOSED_GREEN);
			break;
		case R.id.buttonColorBlue:
			startColorPreviewActivity(CHOOSED_BLUE);
			break;
		case R.id.buttonColorYellow:
			startColorPreviewActivity(CHOOSED_YELLOW);
			break;
		default:
			break;
		}
	}

	private void startColorPreviewActivity(int color) {
		Intent intentPreviewActivity = new Intent(SecondActivity.this, ColorPreviewActivity.class);
		intentPreviewActivity.putExtra("color", color);
		startActivity(intentPreviewActivity);
		Log.d(LOG_TAG, "Pressed one of the buttons");
	}
	
}
