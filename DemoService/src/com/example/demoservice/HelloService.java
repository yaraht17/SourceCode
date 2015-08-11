package com.example.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class HelloService extends Service {
	private final IBinder mBinder = new LocalBinder();

	public class LocalBinder extends Binder {
		HelloService getService() {
			return HelloService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.d("TienDH", "On Bind");
		return mBinder;

	}

	public void sendMessage(String msg) {
		Log.d("TienDH", "Send msg: " + msg);
	}

	public String getReponse() {
		Log.d("TienDH", "get Reponse");
		return " Service Reponse ";
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("TienDH", "Unbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		Log.d("TienDH", "On Create");
		// Toast.makeText(getApplicationContext(), "start r ma",
		// Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("tiendh", "Start comand");

		String msg = intent.getStringExtra("Data");

		if (msg != null)
			Log.d("TienDH", msg);
		return super.onStartCommand(intent, flags, startId);

	}
}
