package com.example.ringbelloff;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import android.R.integer;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TimePicker timePickerFrom;
	private TimePicker timePickerTo;
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {

		}
		
		timePickerFrom = (TimePicker)findViewById(R.id.timePicker1);
		timePickerTo = (TimePicker)findViewById(R.id.timePicker2);
		button = (Button)findViewById(R.id.button1);
		
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Calendar c = Calendar.getInstance(); 
				
				int hourCurrent = c.get(Calendar.HOUR_OF_DAY);
				int minCurrent = c.get(Calendar.MINUTE);
				
				
				int hourFrom = timePickerFrom.getCurrentHour();
				int minFrom = timePickerFrom.getCurrentMinute();
				
				
				int hourTo = timePickerTo.getCurrentHour();
				int minTo = timePickerTo.getCurrentMinute();
				
				if(hourFrom<=hourCurrent && minFrom<=minCurrent 
						&& hourTo>=hourCurrent && minTo>=minCurrent){
					AudioManager manager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
					manager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
					//View backView = (View)findViewById(R.layout.activity_main);
					//backView.setBackgroundColor(android.R.color.holo_green_dark);
					getWindow().getDecorView().setBackgroundColor(Color.GREEN);
					Toast.makeText(getApplicationContext(), hourFrom+":"+minFrom+" "+
					" "+hourCurrent+":"+minCurrent+" "+hourTo+":"+minTo+" Green", 1000).show();
				}
				else{
					AudioManager manager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
					manager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
					//View backView = (View)findViewById(R.layout.activity_main);
					//backView.setBackgroundColor(android.R.color.holo_red_dark);
					getWindow().getDecorView().setBackgroundColor(Color.RED);
					Toast.makeText(getApplicationContext(),  hourFrom+":"+minFrom+" "+
							" "+hourCurrent+":"+minCurrent+" "+hourTo+":"+minTo+" Red", 1000).show();
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
