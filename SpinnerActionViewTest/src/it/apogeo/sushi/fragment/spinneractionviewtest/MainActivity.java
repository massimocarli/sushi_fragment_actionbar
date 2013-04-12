package it.apogeo.sushi.fragment.spinneractionviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MainActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		// We get the reference to the Spinner to manage it's events
		final MenuItem spinnerMenuItem = menu.findItem(R.id.menu_spinner); 
		final Spinner spinner = (Spinner) spinnerMenuItem.getActionView()
				.findViewById(R.id.menu_spinner);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> spinner, View view,
					int position, long id) {
				Log.i(TAG_LOG,"In Spinner selected item " + spinner.getItemAtPosition(position));
			}

			@Override
			public void onNothingSelected(AdapterView<?> spinner) {
				Log.i(TAG_LOG,"Nothing selected in Spinner");
			}
		});
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG_LOG,"Selected item " + item.getTitle());
		return super.onOptionsItemSelected(item);
	}

}
