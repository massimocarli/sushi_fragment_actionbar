package it.apogeo.sushi.fragment.showactionbartest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// This must be done after API Level 14. Before that it's implicit
		getActionBar().setHomeButtonEnabled(true);		
	}

	/**
	 * Show the ActionBar
	 */
	public void showActionBar(View button) {
		getActionBar().show();
	}

	/**
	 * Hide the ActionBar
	 */
	public void hideActionBar(View button) {
		getActionBar().hide();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			Log.i(TAG_LOG, "HOME PRESSED!");
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
