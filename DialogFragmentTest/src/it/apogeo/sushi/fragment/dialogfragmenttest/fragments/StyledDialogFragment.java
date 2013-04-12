package it.apogeo.sushi.fragment.dialogfragmenttest.fragments;

import it.apogeo.sushi.fragment.dialogfragmenttest.R;
import it.apogeo.sushi.fragment.dialogfragmenttest.fragments.MenuFragment.MenuItem;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is a Dialog that uses a specific style and theme with a custom data inside
 * 
 * @author Massimo Carli - Apr 4, 2013
 *
 */
public class StyledDialogFragment extends DialogFragment {
	
	/*
	 * The Key for the MenuItem in the arguments
	 */
	private static final String MENU_ITEM_KEY = "it.apogeo.sushi.fragment.dialogfragmenttest.fragments.MENU_ITEM_KEY";
		
	/**
	 * Create a StyledDialogFragment with the given 
	 * @param style The style to use for this dialog
	 * @param theme THe theme to use for this dialog
	 * @return The StyledDialogFragment instance
	 */
	public static StyledDialogFragment getStyledDialogFragment(MenuItem menuItem) {
		StyledDialogFragment fragment = new StyledDialogFragment();
		// We create the arguments
		Bundle args = new Bundle();
		args.putSerializable(MENU_ITEM_KEY, menuItem);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// We set the style and theme
		MenuItem menuItem = (MenuItem) getArguments().getSerializable(MENU_ITEM_KEY);
		setStyle(menuItem.style, menuItem.theme);
	}	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// We use the same layout of the row in the list
		View dialogLayout = inflater.inflate(R.layout.layout_dialog, container, false);
		// We show the related values
		TextView styleView = (TextView) dialogLayout.findViewById(R.id.style_name);
		TextView themeView = (TextView) dialogLayout.findViewById(R.id.theme_name);
		// Set the values
		MenuItem menuItem = (MenuItem) getArguments().getSerializable(MENU_ITEM_KEY);
		styleView.setText(menuItem.styleName);
		themeView.setText(menuItem.themeName);
		// Manage the Button
		dialogLayout.findViewById(R.id.close_button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// We have to dismiss the Dialog
				dismiss();
			}
		});
		// Return the created layout
		return dialogLayout;
	}

}
