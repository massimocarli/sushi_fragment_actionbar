package it.apogeo.sushi.fragment.tabfragmenttest;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

	/*
	 * We use this key to save the current state
	 */
	private final static String SELECTED_TAG_INDEX_PARAM = "SELECTED_TAG_INDEX_PARAM";
	
	/**
	 * The TabListener to be notified of some selection
	 */
	private class MyTabListener implements TabListener{
		
		/*
		 * The Fragment for the Tab
		 */
		private Fragment fragment;
		
		/**
		 * Create a MyTabListener implementation for a given Tab
		 * @param fragment The Fragment related to the Tab
		 */
		public MyTabListener(Fragment fragment){
			this.fragment= fragment;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// This method is invoked when a Tab, already selected, is selected again.
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// This is invoked to notify a selection
			ft.add(R.id.anchor_container, fragment);
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// This is invoked to notify a de-selection
			ft.remove(fragment);
		}
		
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ActionBar reference
        ActionBar actionBar = getActionBar();
        // We set the navigation mode
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        // We create the Tab to add
        Tab tab1 = actionBar.newTab().setIcon(R.drawable.ic_launcher).setText("First Tab");
        Tab tab2 = actionBar.newTab().setIcon(R.drawable.ic_launcher).setText("Second Tab");
        Tab tab3 = actionBar.newTab().setIcon(R.drawable.ic_launcher).setText("Third Tab");
        // And the related Fragment
        TabFragment frag1 = TabFragment.getInstance("FIRST TAB BODY");
        TabFragment frag2 = TabFragment.getInstance("SECOND TAB BODY");
        TabFragment frag3 = TabFragment.getInstance("THIRD TAB BODY");
        // We register the Listener 
        tab1.setTabListener(new MyTabListener(frag1));
        tab2.setTabListener(new MyTabListener(frag2));
        tab3.setTabListener(new MyTabListener(frag3));
        // And add the tab to the ActionBar
        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        // We set, if any, the previous state is restored if we are here after a device 
        // rotation or other configuration changes
        int selectedTabIndex = 0;
		if(savedInstanceState!=null){
			selectedTabIndex = savedInstanceState.getInt(SELECTED_TAG_INDEX_PARAM, 0);
		}
        actionBar.setSelectedNavigationItem(selectedTabIndex);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	// Otteniamo il riferimento al tab selezionato
    	int selectedTabIndex = getActionBar().getSelectedNavigationIndex();
    	outState.putInt(SELECTED_TAG_INDEX_PARAM, selectedTabIndex);
    }

}
