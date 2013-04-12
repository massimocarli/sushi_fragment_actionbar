package it.apogeo.sushi.fragment.nouifragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * This is an example of a NO UI Fragment. In out case this fragment counts 
 * data into a Thread.
 * 
 * @author Massimo Carli - Apr 3, 2013
 *
 */
public class CounterFragment extends Fragment {
	
	/**
	 * The Tag for the Log
	 */
	private static final String LOG_TAG = CounterFragment.class.getName();	
	
	/*
	 * Key for the extra about counter state
	 */
	//private static final String COUNTER_EXTRA = "it.apogeo.sushi.fragment.nouifragmenttest.extra.COUNTER_EXTRA";	
	
	/**
	 * Interface to implement to listen to the CounterThread 
	 */
	public interface CounterListener {
		
		/**
		 * @param countValue The value of the counter to notify
		 */
		void count(int countValue);
		
	}
	
	/*
	 * The Counter
	 */
	private int mCounter;
	
	/*
	 * The CounterThread
	 */
	private CounterThread mCounterThread;
	
	/*
	 * The listener of the counter
	 */
	private CounterListener mCounterListener;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(LOG_TAG, "ONCREATE INVOKED ON FRAGMENT");
		/*
		if (savedInstanceState != null) {
			mCounter = 	savedInstanceState.getInt(COUNTER_EXTRA, 0);		
		}
		*/		
		mCounterThread = new CounterThread();
		mCounterThread.start();		
	}
	
	/*
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(COUNTER_EXTRA, mCounter);		
	}
	*/
		
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "ONDESTROY INVOKED ON FRAGMENT");
		mCounterThread.stopCounter();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d(LOG_TAG, "ONATTACH INVOKED ON FRAGMENT");
		if (activity instanceof CounterListener) {
			mCounterListener = (CounterListener) activity;
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mCounterListener = null;
		Log.d(LOG_TAG, "ONDETACH INVOKED ON FRAGMENT");
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
				Log.d(LOG_TAG, "Counter in Fragment is: " + mCounter);
				if (mCounterListener != null) {
					mCounterListener.count(mCounter);					
				}

			}
			Log.d(LOG_TAG, "Counter ENDED at " + mCounter);
		}
		
		public void stopCounter() {
			mRunner = false;
		}
		
	}

}
