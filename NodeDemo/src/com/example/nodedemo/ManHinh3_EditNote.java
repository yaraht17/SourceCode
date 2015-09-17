package com.example.nodedemo;

import java.util.ArrayList;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nodedemo.data.Person;

public class ManHinh3_EditNote extends ActionBarActivity implements
		OnTouchListener {
	private TextView txt_Name3, txt_Age3, txt_Address3;
	private Button btn_Update, btn_Listen;
	private float mLastX, mLastY, mLastZ;
	private boolean mInitialized;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private final float NOISE = (float) 2.0;
	private ArrayList<Person> list = new ArrayList<Person>();
	private int index;
	private float X, Y;
	private int width;
	private int height;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_man_hinh3__edit_note);
		mInitialized = false;

		txt_Name3 = (TextView) findViewById(R.id.txt_NameView3);
		txt_Age3 = (TextView) findViewById(R.id.txt_AgeView3);
		txt_Address3 = (TextView) findViewById(R.id.txt_AddressView3);

		/*
		 * String name = this.getIntent().getExtras().getString("NAME"); String
		 * age = this.getIntent().getExtras().getString("AGE"); String address =
		 * this.getIntent().getExtras().getString("ADDRESS");
		 * txt_Name3.setText(name); txt_Age3.setText(age);
		 * txt_Address3.setText(address);
		 */
		list = (ArrayList<Person>) this.getIntent()
				.getSerializableExtra("LIST");
		index = this.getIntent().getExtras().getInt("INDEX");
		txt_Name3.setText(list.get(index).getName());
		txt_Age3.setText(list.get(index).getAge());
		txt_Address3.setText(list.get(index).getAddress());
		// Toast.makeText(getApplicationContext(), "OK",
		// Toast.LENGTH_LONG).show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.man_hinh3__edit_note, menu);
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

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		X = event.getRawX();
		Y = event.getRawY();

		if (X - Y >= 0) {
			Toast.makeText(getApplicationContext(), "right", Toast.LENGTH_SHORT)
					.show();

		} else {
			Toast.makeText(getApplicationContext(), "Left", Toast.LENGTH_SHORT)
					.show();

		}
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
