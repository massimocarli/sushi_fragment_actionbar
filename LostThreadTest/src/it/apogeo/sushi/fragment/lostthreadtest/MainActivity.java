package it.apogeo.sushi.fragment.lostthreadtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	/**
	 * The Tag for the Log
	 */
	private static final String LOG_TAG = MainActivity.class.getName();	
	
	/*
	 * Key for the extra about counter state
	 */
	private static final String COUNTER_EXTRA = "it.apogeo.sushi.fragment.lostthreadtest.extra.COUNTER_EXTRA";
	
	/*
	 * The Counter
	 */
	private int mCounter;
	
	/*
	 * The output for the counter
	 */
	private TextView mOutput;
	
	/*
	 * The CounterThread
	 */
	private CounterThread mCounterThread;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState != null) {
			mCounter = 	savedInstanceState.getInt(COUNTER_EXTRA, 0);		
		}
		mOutput = (TextView) findViewById(R.id.output);
		mCounterThread = new CounterThread();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(COUNTER_EXTRA, mCounter);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		mCounterThread.start();		
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mCounterThread.stopCounter();
	}

	public class CounterThread extends Thread {
		
		private boolean mRunner = true;
		
		@Override
		public void run() {
			super.run();
			Log.d(LOG_TAG, "Counter STARTED from " + mCounter);
			while (mRunner){
				try{Thread.sleep(500L);}catch(InterruptedException ie){}
				mCounter++;
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						mOutput.setText("Counter: " + mCounter);
					}
				});
				Log.d(LOG_TAG, "Counter in Fragment is: " + mCounter);
			}
			Log.d(LOG_TAG, "Counter ENDED at " + mCounter);
		}
		
		public void stopCounter() {
			mRunner = false;
		}
		
	}
	
}
