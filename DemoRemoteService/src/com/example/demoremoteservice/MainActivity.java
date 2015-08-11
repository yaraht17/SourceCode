package com.example.demoremoteservice;

import com.example.demoservice2.IHelloService;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	EditText edit;
	Button btnStart, btnStop, btnSend;

	String pack = "com.example.demoservice2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button) findViewById(R.id.btnStart);
		btnStop = (Button) findViewById(R.id.btnStop);
		btnSend = (Button) findViewById(R.id.btnSend);
		edit = (EditText) findViewById(R.id.sendMessage);

		btnStart.setOnClickListener(this);
		btnStop.setOnClickListener(this);
		btnSend.setOnClickListener(this);
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

	private void sendMsg(String msg) {
		try {
			mService.sendMessage(msg);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(pack);
		// this.startService(intent);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
	};

	private IHelloService mService;
	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			mService = IHelloService.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}
	};

	private void stop() {
		Intent intent = new Intent(pack);
		// this.stopService(intent);
		unbindService(mConnection);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnStart:
			Toast.makeText(getApplicationContext(), "start service",
					Toast.LENGTH_LONG).show();

			start();
			break;
		case R.id.btnStop:
			stop();
			break;
		case R.id.btnSend:
			sendMsg(edit.getText().toString());
			break;
		default:
			break;
		}
	}
}
