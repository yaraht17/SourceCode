package com.example.demogridview;

import java.util.ArrayList;

import adapterpack.GridAdapter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener {
	private GridView gridView;
	private ArrayList<ImageView> list = new ArrayList<>();
	private GridAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridView = (GridView) findViewById(R.id.gridview);
		for (int i = 0; i < 16; i++) {
			ImageView img = new ImageView(this);
			img.setImageResource(R.drawable.ic_launcher);
			list.add(img);
		}
		gridView.setOnItemClickListener(this);

		adapter = new GridAdapter(this, R.layout.item, list);
		gridView.setAdapter(adapter);
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

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		gridView = (GridView) findViewById(R.id.gridview);
		adapter = new GridAdapter(this, R.layout.item, list);
		gridView.setAdapter(adapter);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		adapter = new GridAdapter(this, R.layout.item, list);
		gridView.setAdapter(adapter);

	}
}
