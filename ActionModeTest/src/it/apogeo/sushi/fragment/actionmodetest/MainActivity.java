package it.apogeo.sushi.fragment.actionmodetest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	/*
	 * The Tag for the Log
	 */
	private static final String LOG_TAG = MainActivity.class.getName();

	/*
	 * The current ActionMode
	 */
	private ActionMode mActionMode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * Called when we press the startActionMode button
	 */
	public void startActionMode(final View button) {
		if (mActionMode != null) {
			// We don't want it created more times
			return;
		}
		mActionMode = startActionMode(new Callback() {

			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				Log.i(LOG_TAG, "onCreateActionMode");
				// We load and put the menu configuration file
				MenuInflater inflater = mode.getMenuInflater();
				inflater.inflate(R.menu.action_mode_menu, menu);
				return true;
			}

			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
				Log.i(LOG_TAG, "onPrepareActionMode");
				return false;
			}

			@Override
			public void onDestroyActionMode(ActionMode mode) {
				Log.i(LOG_TAG, "onDestroyActionMode");
				mActionMode = null;
			}

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				Log.i(LOG_TAG, "onActionItemClicked");
				CharSequence selectedTitle = item.getTitle();
				if (TextUtils.isEmpty(selectedTitle)) {
					selectedTitle = "Unknown";
				}
				Toast.makeText(getApplicationContext(), selectedTitle.toString() , Toast.LENGTH_SHORT).show();
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
