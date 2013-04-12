package it.apogeo.sushi.fragment.tabfragmenttest;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

/**
 * This is a super simple Fragment with a simple label inside. It has testing purpose.
 * 
 * @author Massimo Carli - 11/apr/2013
 *
 */
public class TabFragment extends Fragment {
	
	/*
	 * The tag for the Log
	 */
	private final static String LOG_TAG = "TabFragment";

	/*
	 * The keys to manage the data into the Bundle
	 */
	private final static String LABEL_INIT_PARAM = "LABEL_INIT_PARAM";
	

	/**
	 * Static Factory Method for the TabFragment with the label it will show.
	 * 
	 * @param label The label to show into the Fragment
	 * @return The TabFragment instance
	 */
	public static TabFragment getInstance(String label){
		// We create the Fragment
		TabFragment fragment = new TabFragment();
		// Save initialization data
		Bundle bundle = new Bundle();
		bundle.putString(LABEL_INIT_PARAM, label);
		fragment.setArguments(bundle);
		Log.i(LOG_TAG, "TabFragment created");
		// Return the created Fragment
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// The layout is just a TextView
		TextView labelTextView = new TextView(getActivity());
		// We set layout informations
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		labelTextView.setLayoutParams(lp);
		// We read the label and set as output
		labelTextView.setText(getArguments().getString(LABEL_INIT_PARAM));
		Log.i(LOG_TAG, "TabFragment View created");
		// We return just the label as a View
		return labelTextView;
	}
	
}
