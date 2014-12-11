/**
 * Copyright (C) 2014 Rus Wizards
 * 
 * Created: 11.12.2014
 * Vladimir Farafonov
 */

package com.ruswizards.rwlab46;

import com.ruswizards.rwlab46.ColorSelectingActivity.SelectedColor;

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
 */
public class ColorPreviewActivity extends Activity implements OnClickListener {

	private int backButtonPressesCount = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_preview);

		// Get color resource id
		int colorResource = SelectedColor.getColor(getIntent().getIntExtra(
				ColorSelectingActivity.INTENT_COLOR, 0));

		// Set background color
		RelativeLayout rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
		rootLayout.setBackgroundColor(getResources().getColor(colorResource));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_back:
			// Closes activity after back button pressed (similar to pressing on
			// devices' back button)
			onBackPressed();
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
