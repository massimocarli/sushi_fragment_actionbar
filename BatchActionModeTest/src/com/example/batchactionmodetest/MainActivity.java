package com.example.batchactionmodetest;

import java.util.HashSet;
import java.util.Set;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String LOG_TAG = MainActivity.class.getName();
	
	/*
	 * The Adapter
	 */
	private ArrayAdapter<String> mAdapter;
	
	/*
	 * Set of selection
	 */
	private Set<Integer> mSelectedSet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Selections
		mSelectedSet = new HashSet<Integer>();
		// Manage the ListView
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		getListView().setMultiChoiceModeListener(new MultiChoiceModeListener() {
			
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
			}

			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				// Action executed on selected items
				CharSequence selectedTitle = item.getTitle();
				Log.i(LOG_TAG, "onActionItemClicked " + selectedTitle + " on " + mSelectedSet);
				return false;
			}
			
			@Override
			public void onItemCheckedStateChanged(ActionMode mode, int position,
					long id, boolean checked) {
				String selectedItem = (String) getListAdapter().getItem(position);
				Log.i(LOG_TAG, "onItemCheckedStateChanged :" + selectedItem + " checked: " + checked);
				if (checked) {
					mSelectedSet.add(position);
				} else {
					mSelectedSet.remove(position);
				}
			}
		});
		// Manage data
		String[] mockData = new String[100];
		for (int i = 0; i < mockData.length; i++) {
			mockData[i] = "Mock Data #"+i;
		}
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mockData);
		setListAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
