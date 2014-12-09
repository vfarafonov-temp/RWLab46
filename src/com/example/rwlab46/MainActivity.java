/**
 * Copyright (C) 2014 Rus Wizards 
 */

package com.example.rwlab46;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Class for the main activity. Activity has just one button to open second activity 
 * @author vfarafonov
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button mBtnChangeColor = (Button)findViewById(R.id.buttonChangeColor);
        mBtnChangeColor.setOnClickListener(new OnClickListener() {
			
        	//Opens second activity
			@Override
			public void onClick(View v) {
				Intent mIntentSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(mIntentSecondActivity);
			}
		});
    }
}
