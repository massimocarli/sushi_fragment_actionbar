package it.apogeo.sushi.fragment.popuptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	/*
	 * The Tag for the Log
	 */
	private static final String LOG_TAG = MainActivity.class.getName();	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * Called to show a popup
	 */
	public void showPopup(View button) {
		// We create the PopupMenu with the reference of the related View
		PopupMenu popup = new PopupMenu(this, button);
		// We register a listener for the selection
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Log.i(LOG_TAG, "Selected " + item.getTitle());
				Toast.makeText(getApplicationContext(), "Selected " + item.getTitle(), Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		// We register a listener for the dismiss from API level 14
		/*
		popup.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss(PopupMenu menu) {
				
			}
		});
		*/
		// We add menu options
	    MenuInflater inflater = popup.getMenuInflater();
	    inflater.inflate(R.menu.popup_menu, popup.getMenu());
	    // We show the popup
	    popup.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
