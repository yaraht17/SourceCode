package com.example.nodedemo;

import java.util.ArrayList;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ParseException;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nodedemo.adapter.PersonAdapter;
import com.example.nodedemo.data.Person;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener, OnItemLongClickListener {
	// SQLiteDatabase database = null;
	private ListView listview;
	private SQLiteDatabase db;
	private ArrayList<Person> arrayList = new ArrayList<Person>();
	private PersonAdapter adapter;

	// private Person itemPerson;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		createDB();
		Button btn_Add = (Button) findViewById(R.id.btn_Add);

		btn_Add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(getApplicationContext(),
						ManHinh2.class);

				startActivity(intent);

			}
		});

		listview = (ListView) findViewById(R.id.listview);
		listview.setOnItemClickListener(this);
		listview.setOnItemLongClickListener(this);
		adapter = new PersonAdapter(this, -1, loadAllNote());
		listview.setAdapter(adapter);

	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		adapter = new PersonAdapter(this, -1, loadAllNote());
		listview.setAdapter(adapter);
		super.onRestart();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void createDB() {
		db = openOrCreateDatabase(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/dbNote3.db", MODE_PRIVATE, null);
		if (db != null) {
			if (isTableExists("tblNote"))
				return;
			db.setLocale(Locale.getDefault());
			db.setVersion(1);
			String sql = "CREATE TABLE tblNote (id integer primary key autoincrement, name text, age text, address text)";
			db.execSQL(sql);
			Toast.makeText(this, "DATABASE OK", Toast.LENGTH_LONG).show();
		}
	}

	public boolean isTableExists(String tableName) {
		Cursor cursor = db.rawQuery(
				"select DISTINCT tbl_name from sqlite_master where tbl_name = '"
						+ tableName + "'", null);
		if (cursor != null) {
			if (cursor.getCount() > 0) {
				cursor.close();
				return true;
			}
			cursor.close();
		}
		return false;
	}

	public ArrayList<Person> loadAllNote() throws ParseException {
		arrayList = new ArrayList<Person>();
		Cursor c = db.query("tblNote", null, null, null, null, null, null);
		if (c != null) {
			c.moveToFirst();
			while (!c.isAfterLast()) {
				arrayList.add(new Person(c.getInt(0), c.getString(1), c
						.getString(2), c.getString(3)));
				c.moveToNext();
			}
			c.close();
		}
		return arrayList;
	}

	public void doAddNote() {
		db = openOrCreateDatabase(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/locationDB.db", MODE_PRIVATE, null);
		// database = openOrCreateDatabase("dbNote.db", MODE_PRIVATE, null);
		ContentValues values = new ContentValues();
		/*
		 * values.put("nameLocation", editName.getText().toString());
		 * values.put("diaChi", editAddress.getText().toString());
		 * values.put("lon", String.valueOf(lon1)); values.put("lat",
		 * String.valueOf(lat1)); values.put("content",
		 * editContent.getText().toString()); values.put("image", "");
		 */

		String msg = "";
		if (db.insert("tblNote", null, values) == -1) {
			msg = "Thêm note thất bại";
		} else {
			msg = "Thêm note thành công";
		}
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
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
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getApplicationContext(),
				ManHinh3_EditNote.class);
		intent.putExtra("LIST", arrayList);
		/*
		 * intent.putExtra("NAME", arrayList.get(position).getName());
		 * intent.putExtra("AGE", arrayList.get(position).getAge());
		 * intent.putExtra("ADDRESS", arrayList.get(position).getAddress());
		 */
		intent.putExtra("INDEX", position);
		startActivity(intent);
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		Toast.makeText(getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
		return false;
	}
}
