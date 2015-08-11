package com.example.demolistview;

import java.util.ArrayList;

import Adapter.DataAdapter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import data.Data;

public class MainActivity extends ActionBarActivity {
	private ListView listview;
	private ArrayList<Data> dataList;
	private DataAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listview);
		adapter = new DataAdapter(this, -1, autoGEN());
		listview.setAdapter(adapter);
	}

	public ArrayList<Data> autoGEN() {
		Data item1 = new Data("Tien", "1234567");
		dataList.add(item1);
		Data item2 = new Data("Yara", "2134556");
		dataList.add(item2);
		return dataList;
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
