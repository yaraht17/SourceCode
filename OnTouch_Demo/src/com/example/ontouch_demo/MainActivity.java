package com.example.ontouch_demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements OnGestureListener{

	private TextView tv1;
    private TextView tv2;
    private GestureDetector gestureDetector = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.text_view);
        tv2 = (TextView) findViewById(R.id.text_view_value);
        gestureDetector = new GestureDetector(this,(OnGestureListener) this);
    }
    
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return  gestureDetector.onTouchEvent(event);
	}
	@Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		float x1 = e1.getX();
		float x2 = e2.getX();
		float disX = Math.abs(e1.getX()-e2.getX());
		float speed = Math.abs(velocityX);
		if( disX>100 && speed>100){
			if( x1>x2){
				tv1.setText("Left");
			} else {
				tv1.setText("Right");
			}
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
