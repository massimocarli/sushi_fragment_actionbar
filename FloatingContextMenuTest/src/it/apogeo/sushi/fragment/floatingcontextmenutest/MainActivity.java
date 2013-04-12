package it.apogeo.sushi.fragment.floatingcontextmenutest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MainActivity.class.getName();	
	
	/*
	 * The tag for the ListFragment
	 */
	private static final String LIST_TAG = "LIST_FRAG";	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// We add the Fragment
		if (savedInstanceState == null) {
			MyListFragment frag = new MyListFragment();
			getSupportFragmentManager().beginTransaction().add(R.id.container,frag, LIST_TAG).commit();
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.i(TAG_LOG, "In Activity selected item: " + item.getTitle());
		// return true;
		return super.onContextItemSelected(item);
	}

}
