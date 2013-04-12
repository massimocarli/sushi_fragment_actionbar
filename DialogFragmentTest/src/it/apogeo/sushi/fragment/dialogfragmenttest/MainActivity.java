package it.apogeo.sushi.fragment.dialogfragmenttest;

import it.apogeo.sushi.fragment.dialogfragmenttest.fragments.MenuFragment;
import it.apogeo.sushi.fragment.dialogfragmenttest.fragments.MenuFragment.MenuItem;
import it.apogeo.sushi.fragment.dialogfragmenttest.fragments.StyledDialogFragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class MainActivity extends FragmentActivity implements MenuFragment.StyledDialogItemListener {
	
	/**
	 * The Tag for the Log
	 */
	private static final String TAG_LOG = MainActivity.class.getName();
	
	/**
	 * The Fragment with the different options
	 */
	private static MenuFragment mMenuFragment;
	
	/*
	 * The tag for the Fragment into the layout
	 */
	private static final String MENU_FRAGMENT_TAG = "MENU_FRAGMENT";
	
	/*
	 * The tag for the DialogFragment into the layout
	 */
	private static final String DIALOG_FRAGMENT_TAG = "DIALOG_FRAGMENT";	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // If the fragment is not into the state we create and insert into
        // the main layout
        if (savedInstanceState == null) {
        	mMenuFragment = MenuFragment.getMenuFragment(this);
        	getSupportFragmentManager().beginTransaction()
        		.add(R.id.fragment_container, mMenuFragment).commit();
        	Log.d(TAG_LOG, MENU_FRAGMENT_TAG + " created and added!");
        } else {
        	Log.d(TAG_LOG, MENU_FRAGMENT_TAG + " already present!");
        }
    }

	@Override
	public void itemSelected(final MenuItem menuItem) {
		Log.d(TAG_LOG, "Style " + menuItem.styleName + " and theme " + menuItem.themeName + " selected!");
		// We create a Fragment Transaction
		final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		// And check if a DialogFragment is already present
	    Fragment previousFragment = getSupportFragmentManager().findFragmentByTag(DIALOG_FRAGMENT_TAG);
	    if (previousFragment != null) {
	    	// If it is we remove it into the same transaction
	    	fragmentTransaction.remove(previousFragment);
	    }
	    // Uncomment the next instruction to test what happen with the back key and
	    // transaction into the Back Stack
	    // fragmentTransaction.addToBackStack(null);
	    // Create and show the dialog.
	    DialogFragment newDialogFragment = StyledDialogFragment.getStyledDialogFragment(menuItem);
	    // BE carefull that this show also commit the transaction
	    newDialogFragment.show(fragmentTransaction, DIALOG_FRAGMENT_TAG);
	}
    
}
