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
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Activity with picked up color preview
 * 
 * @author vfarafonov
 * 
 */
public class ColorPreviewActivity extends Activity implements OnClickListener {

	int backButtonPressesCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_preview);

		// Get color resource id
		int colorResource = getColorResource(getIntent().getIntExtra(
				ColorSelectingActivity.TAG_COLOR, SelectedColor.RED.getCode()));

		// Set background color
		RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
		rootLayout.setBackgroundColor(getResources().getColor(colorResource));

		Button buttonBack = (Button) findViewById(R.id.button_back);
		buttonBack.setOnClickListener(this);

		Button buttonHome = (Button) findViewById(R.id.button_home);
		buttonHome.setOnClickListener(this);
	}

	/**
	 * Returns colors' resource id from picked up color number.
	 * 
	 * @param color
	 *            The color number
	 * @return resource id
	 */
	private int getColorResource(int color) {
		if (color == SelectedColor.BLUE.getCode()) {
			return R.color.blue;
		} else if (color == SelectedColor.GREEN.getCode()) {
			return R.color.green;
		} else if (color == SelectedColor.YELLOW.getCode()) {
			return R.color.yellow;
		} else {
			return R.color.red;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_back:
			// Closes activity after back button pressed (similar to pressing on
			// devices' back button)
			onBackPressed();
			// finish();
			break;
		case R.id.button_home:
			// Starts home activity with clearing top activities in task
			Intent intentHome = new Intent(this, MainActivity.class);
			intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentHome);
			break;
		default:
			break;
		}
	}

	/**
	 * Closes activity after back button was pressed twice.
	 */
	@Override
	public void onBackPressed() {
		if (backButtonPressesCount == 1) {
			super.onBackPressed();
		} else {
			Toast.makeText(this, R.string.toast_back_button_need_twice,
					Toast.LENGTH_SHORT).show();
			backButtonPressesCount++;
		}
	}
}
