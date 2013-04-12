package it.apogeo.sushi.fragment.dropdownnavigationtest;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

public class MainActivity extends FragmentActivity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MainActivity.class.getName();
	
	/**
	 * The SpinnedAdapter to use
	 */
	private SpinnerAdapter mSpinnerAdapter;
	
	/**
	 * The current Fragment shown
	 */
	private LabelFragment mCurrentFragment;
	
	/*
	 * The Listener for the navigation item selection
	 */
	private ActionBar.OnNavigationListener  mOnNavigationListener = new ActionBar.OnNavigationListener(){

		@Override
		public boolean onNavigationItemSelected(int itemPosition, long itemId) {
			mCurrentFragment = LabelFragment.getLabelFragment(mSpinnerAdapter.getItem(itemPosition).toString());
			getSupportFragmentManager().beginTransaction().replace(R.id.container, mCurrentFragment)
						.addToBackStack(null).commit();
			Log.i(TAG_LOG, "Navigation Item Selected!" + mSpinnerAdapter.getItem(itemPosition));
			return false;
		}
		
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Initialize the SpinnerAdapter with the resouurce
		mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.navigation_options,
				R.layout.spinner_item);
		// Set the Navigation mode
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		// Register the listener
		actionBar.setListNavigationCallbacks(mSpinnerAdapter, mOnNavigationListener);
		if (savedInstanceState == null) {
			mCurrentFragment = LabelFragment.getLabelFragment(mSpinnerAdapter.getItem(0).toString());
			getSupportFragmentManager().beginTransaction().add(R.id.container, mCurrentFragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
