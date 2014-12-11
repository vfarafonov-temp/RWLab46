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
 */
public class ColorSelectingActivity extends Activity implements OnClickListener {

	/**
	 * Enum for color codes
	 */
	public enum SelectedColor {
		RED(1), GREEN(2), BLUE(3), YELLOW(4);

		private final int id_;

		/**
		 * Returns colors' resource id from picked up color number.
		 * @param id SelectedColor id
		 * @return color resource id
		 * @throws IllegalArgumentException 
		 */
		public static int getColor(final int id) throws IllegalArgumentException {
			if (id == SelectedColor.BLUE.getId()) {
				return R.color.blue;
			} else if (id == SelectedColor.GREEN.getId()) {
				return R.color.green;
			} else if (id == SelectedColor.YELLOW.getId()) {
				return R.color.yellow;
			} else if (id == SelectedColor.RED.getId()) {
				return R.color.red;
			} else {
				throw new IllegalArgumentException("Color not identified");
			}
		}
		
		SelectedColor(int id) {
			this.id_ = id;
		}

		/**
		 * Returns id for enum
		 * 
		 * @return The color code
		 */
		public int getId() {
			return id_;
		}
	}
	
	/**
	 * Constant key name used when passing intent to open preview activity
	 */
	public static final String INTENT_COLOR = "color";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_selecting);
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
		case R.id.button_color_wrong:
			Intent intentPreviewActivity = new Intent(this,
					ColorPreviewActivity.class);
			intentPreviewActivity.putExtra(INTENT_COLOR, 0);
			startActivity(intentPreviewActivity);
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
		intentPreviewActivity.putExtra(INTENT_COLOR, selectedColor.getId());

		startActivity(intentPreviewActivity);
	}
}
