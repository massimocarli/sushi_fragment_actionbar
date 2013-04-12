package it.apogeo.sushi.fragment.floatingcontextmenutest;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

/**
 * @author Massimo Carli - 10/apr/2013
 *
 */
public class MyListFragment extends ListFragment {
	
	/*
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MyListFragment.class.getName();
	
	/*
	 * The size of our model
	 */
	private static final int ARRAY_SIZE = 100;
	
	/*
	 * Out model for test
	 */
	private String[] mModel;
	
	/*
	 * The Adapter
	 */
	private ArrayAdapter<String> mAdapter;
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Create the model
		mModel = new String[ARRAY_SIZE];
		for (int i = 0 ; i < mModel.length; i++) {
			mModel[i] = "Item "+ i;
		}
		// We create the Adpater
		mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mModel);
		// We set the Adapter
		setListAdapter(mAdapter);
		// We register the contextual menu
		registerForContextMenu(getListView());
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		MenuInflater menuInflater = new MenuInflater(getActivity());
		menuInflater.inflate(R.menu.main, menu);
		Log.i(TAG_LOG, "In Fragment onCreateContextMenu ");
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Log.i(TAG_LOG, "In Fragment selected item: " + item.getTitle());
		return super.onContextItemSelected(item);
	}

}
