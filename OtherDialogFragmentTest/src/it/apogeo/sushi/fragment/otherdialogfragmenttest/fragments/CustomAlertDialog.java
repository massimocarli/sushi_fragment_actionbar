package it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments;

import it.apogeo.sushi.fragment.otherdialogfragmenttest.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Example of an AlertDialog with Fragment
 * 
 * @author Massimo Carli - Apr 4, 2013
 *
 */
public class CustomAlertDialog extends DialogFragment {
	
	/**
	 * Callback interface that the listening activity should implement to receive information
	 * from the AlertDialog
	 *
	 */
	public interface AlertDialogListener {
		
		/**
		 * Pressed when user press yes
		 */
		void yesPressed();

		/**
		 * Pressed when user press no
		 */		
		void noPressed();
		
	} 	
	
	/*
	 * The Listener of the  AlertDialog
	 */
	private OnClickListener mOnClickListener;	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// if the Activity implements the listener interface we save its reference
		if (activity instanceof AlertDialogListener) {
			final AlertDialogListener listener = (AlertDialogListener) activity;
			mOnClickListener = new OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case Dialog.BUTTON_POSITIVE:
						listener.yesPressed();
						break;
					case Dialog.BUTTON_NEGATIVE:
						listener.noPressed();
						break;
					default:
						// Not managed
						break;
					}
					
				}
				
			};
		}
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Here we create and return the AlertDialog using a Builder
		AlertDialog.Builder builder =  new AlertDialog.Builder(getActivity()).setIcon(R.drawable.ic_launcher)
				.setTitle(R.string.alert_dialog_title)
				.setPositiveButton(R.string.yes_label,mOnClickListener)
				.setNegativeButton(R.string.no_label, mOnClickListener);
		
		return builder.create();
	}
	
}
