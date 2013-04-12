package it.apogeo.sushi.fragment.otherdialogfragmenttest;

import it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments.CustomAlertDialog;
import it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments.ProgressAlertDialog;
import it.apogeo.sushi.fragment.otherdialogfragmenttest.fragments.ProgressAlertDialog.OnProgressDialogListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity 
			implements CustomAlertDialog.AlertDialogListener, OnProgressDialogListener {
	
	/*
	 * The tag for the Fragment for AlertDialog into the layout
	 */
	private static final String ALERT_DIALOG_TAG = "ALERT_DIALOG";
	
	/*
	 * The tag for the Fragment for ProgressDialog into the layout
	 */
	private static final String PROGRESS_DIALOG_TAG = "PROGRESS_DIALOG";		

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/**
	 * Called when we press on the alertDialog button
	 * @param alertDialogButton The button
	 */
	public void showAlertDialog(View alertDialogButton) {
		CustomAlertDialog alertDialog = new CustomAlertDialog();
		alertDialog.show(getSupportFragmentManager(), ALERT_DIALOG_TAG);
	}

	/**
	 * Called when we press on the progressDialog button
	 * @param progressDialogButton The button
	 */	
	public void showProgressDialog(View progressDialogButton) {
		ProgressAlertDialog alertDialog = new ProgressAlertDialog();
		alertDialog.show(getSupportFragmentManager(), PROGRESS_DIALOG_TAG);		
	}

	@Override
	public void yesPressed() {
		Toast.makeText(this, "YES PRESSED", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void noPressed() {
		Toast.makeText(this, "NO PRESSED", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void taskCancelled() {
		Toast.makeText(this, "TASK CANCELLED", Toast.LENGTH_SHORT).show();
	}	

}
