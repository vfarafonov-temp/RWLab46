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
import android.widget.Button;

/**
 * Class for the main activity. Activity has just one button to open second
 * activity
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button buttonChangeColor = (Button) findViewById(R.id.button_change_color);
		buttonChangeColor.setOnClickListener(new OnClickListener() {

			// Opens second activity
			@Override
			public void onClick(View v) {
				Intent intentSecondActivity = new Intent(MainActivity.this,
						ColorSelectingActivity.class);
				startActivity(intentSecondActivity);
			}
		});
	}
}
