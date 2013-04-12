package it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments;

import it.apogeo.sushi.fragment.otherdialogfragmenttest.R;
import it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments.CustomAlertDialog.AlertDialogListener;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;

/**
 * Example of an ProgressDialog with Fragment
 * 
 * @author Massimo Carli - Apr 4, 2013
 *
 */
public class ProgressAlertDialog extends DialogFragment {
	
	/**
	 * Callback interface that the listening activity should implement to receive information
	 * from the ProgressDialog. In our case we want to stop the task when the user press
	 * back.
	 */
	public interface OnProgressDialogListener {
		
		/**
		 * The task was cancelled
		 */
		void taskCancelled();
		
	} 	
	
	/*
	 * The Listener of the  ProgressDialog about the back key
	 */
	private OnKeyListener mOnKeyListener;	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// if the Activity implements the listener interface we save its reference
		if (activity instanceof AlertDialogListener) {
			final OnProgressDialogListener listener = (OnProgressDialogListener) activity;
			mOnKeyListener = new OnKeyListener() {
				
				@Override
				public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
					if( keyCode == KeyEvent.KEYCODE_BACK){	
						// The key is back so we return true to tells we intercept it
						// and notify the listener
						listener.taskCancelled();
						dialog.dismiss();
						return true;
					}
					return false;
				}
			};
		}
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// We create a ProgressDialog
		final ProgressDialog progressDialog = new ProgressDialog(getActivity());
		progressDialog.setMessage(getString(R.string.loading_text));
		progressDialog.setIndeterminate(true);
		progressDialog.setCancelable(false);
		// We DON'T close the Dialog if we touch outside
		progressDialog.setCanceledOnTouchOutside(false);
		// We manage the back button
		progressDialog.setOnKeyListener(mOnKeyListener);
		return progressDialog;
	}
	
}
