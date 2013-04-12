package it.apogeo.sushi.fragment.overlayactionbartest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
