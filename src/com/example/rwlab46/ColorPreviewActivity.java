package com.example.rwlab46;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ColorPreviewActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_preview);
		
		int mColorResource = getColorResource(getIntent().getIntExtra("color", SecondActivity.CHOOSED_RED));
		
		RelativeLayout rlPreview = (RelativeLayout)findViewById(R.id.rlThirdActivity);
		rlPreview.setBackgroundColor(getResources().getColor(mColorResource));
		
		Button mBtnBack = (Button)findViewById(R.id.btnBack);
		mBtnBack.setOnClickListener(this);
		
		Button mBtnHome = (Button)findViewById(R.id.btnHome);
		mBtnHome.setOnClickListener(this);
	}

	private int getColorResource(int color) {
		switch (color) {
		case SecondActivity.CHOOSED_RED:
			return R.color.red;
		case SecondActivity.CHOOSED_BLUE:
			return R.color.blue;
		case SecondActivity.CHOOSED_GREEN:
			return R.color.green;
		case SecondActivity.CHOOSED_YELLOW:
			return R.color.yellow;
		default:
			return R.color.red;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBack:
			finish();
			break;
		case R.id.btnHome:
			Intent intentHome = new Intent(this, MainActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentHome);
			break;
		default:	
			break;
		}
	}
	
}
