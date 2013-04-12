package it.apogeo.sushi.fragment.dropdownnavigationtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Massimo Carli - Apr 11, 2013
 *
 */
public class LabelFragment extends Fragment {
	
	/*
	 * The key for the params about the label
	 */
	private static final String LABEL_EXTRA = "it.apogeo.sushi.fragment.dropdownnavigationtest.extra.LABEL_EXTRA";
	
	/*
	 * The Label to show
	 */
	private String mLabel;
	
	/**
	 * Static Factory Method that returns a LabelFragment
	 * @param label The label to show into the fragment
	 * @return The istance of the LabelFragment
	 */
	public static LabelFragment getLabelFragment(String label) {
		LabelFragment labelFragment = new LabelFragment();
		Bundle inputArgs = new Bundle();
		inputArgs.putString(LABEL_EXTRA, label);
		labelFragment.setArguments(inputArgs);
		return labelFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.label_fragment, null);
		// Get the label to show
		String label = getArguments().getString(LABEL_EXTRA);
		if (TextUtils.isEmpty(label)) {
			label = "No Label!";
		}
		TextView textView = (TextView) fragmentView.findViewById(R.id.output_label);
		textView.setText(label);
		return fragmentView;
	}

}
