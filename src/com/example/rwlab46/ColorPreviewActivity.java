package com.example.rwlab46;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class ColorPreviewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_preview);
		
		int mColorResource = getColorResource(getIntent().getIntExtra("color", SecondActivity.CHOOSED_RED));
		
		RelativeLayout rlPreview = (RelativeLayout)findViewById(R.id.rlThirdActivity);
		rlPreview.setBackgroundColor(getResources().getColor(mColorResource));
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
	
}
