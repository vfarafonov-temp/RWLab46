/**
 * Copyright (C) 2014 Rus Wizards 
 */

package com.ruswizards.rwlab46;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Class for activity where user can choose color
 * @author vfarafonov
 *
 */
public class SecondActivity extends Activity implements OnClickListener {
	
	public static final int CHOOSED_RED = 1;
	public static final int CHOOSED_GREEN = 2;
	public static final int CHOOSED_BLUE = 3;
	public static final int CHOOSED_YELLOW = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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

	/**
	 * Calls startColorPreviewActivity(int color) method to launch new activity depends on button that was pressed
	 */
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

	/**
	 * Starts activity with color preview. Puts in intents' extra color code.
	 * @param color The color number
	 */
	private void startColorPreviewActivity(int color) {
		
		Intent mIntentPreviewActivity = new Intent(SecondActivity.this, ColorPreviewActivity.class);
		mIntentPreviewActivity.putExtra("color", color);
		
		startActivity(mIntentPreviewActivity);
	}
	
}
