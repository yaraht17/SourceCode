package com.example.nodedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManHinh2 extends ActionBarActivity {
	private Button btn_Ok;
	private EditText edit_Name, edit_Age, edit_Address;
	private SQLiteDatabase db;
	private String name, age, address;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_man_hinh2);
		
		Button btn_Ok = (Button) findViewById(R.id.btn_Ok);
		edit_Name = (EditText) findViewById(R.id.edit_Name);
		edit_Age = (EditText) findViewById(R.id.edit_Age);
		edit_Address = (EditText) findViewById(R.id.edit_Address);

		btn_Ok.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Nhan thong tin nhap vao, roi gui ve MainActivity
				doAddNote();
				finish();
			}
		});

	}

	public void doAddNote() {
		db = openOrCreateDatabase(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/dbNote3.db", MODE_PRIVATE, null);
		// database = openOrCreateDatabase("dbNote.db", MODE_PRIVATE, null);
		ContentValues values = new ContentValues();
		values.put("name", edit_Name.getText().toString());
		values.put("age", edit_Age.getText().toString());
		values.put("address", edit_Address.getText().toString());

		String msg = "";
		if (db.insert("tblNote", null, values) == -1) {
			msg = "Thêm note thất bại";
		} else {
			msg = "Thêm note thành công";
		}
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.man_hinh2, menu);
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
