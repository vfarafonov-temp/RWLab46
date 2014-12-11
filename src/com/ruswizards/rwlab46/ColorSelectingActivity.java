/**
 * Copyright (C) 2014 Rus Wizards
 * 
 * Created: 11.12.2014
 * Vladimir Farafonov
 */

package com.ruswizards.rwlab46;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Class for activity where user can choose color
 * 
 * @author vfarafonov
 * 
 */
public class ColorSelectingActivity extends Activity implements OnClickListener {

	/**
	 * Constant key name used when passing intent to open preview activity
	 */
	public static final String TAG_COLOR = "color";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
	}

	/**
	 * Calls startColorPreviewActivity method to launch new activity depends on
	 * button that was pressed
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_color_red:
			startColorPreviewActivity(SelectedColor.RED);
			break;
		case R.id.button_color_green:
			startColorPreviewActivity(SelectedColor.GREEN);
			break;
		case R.id.button_color_blue:
			startColorPreviewActivity(SelectedColor.BLUE);
			break;
		case R.id.button_color_yellow:
			startColorPreviewActivity(SelectedColor.YELLOW);
			break;
		default:
			break;
		}
	}

	/**
	 * Starts activity with color preview. Puts in intents' extra color code.
	 * 
	 * @param selectedColor
	 *            The color enum
	 */
	private void startColorPreviewActivity(SelectedColor selectedColor) {
		Intent intentPreviewActivity = new Intent(this,
				ColorPreviewActivity.class);
		intentPreviewActivity.putExtra(TAG_COLOR, selectedColor.getCode());

		startActivity(intentPreviewActivity);
	}

}
