package com.mobile.shnarped.ui;

import com.mobile.shnarped.slideout.SlideoutHelper;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Window;

public class MenuFragmentActivity extends FragmentActivity {

	/** Called when the activity is first created. */
	private SlideoutHelper mSlideoutHelper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    // TODO Auto-generated method stub
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    mSlideoutHelper = new SlideoutHelper(this);
	    mSlideoutHelper.activate();
	    getSupportFragmentManager().beginTransaction().add(R.id.slideout_placeholder, new MenuItemFragment(),"menu").commit();
	    mSlideoutHelper.open();
	    
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			mSlideoutHelper.close();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public SlideoutHelper getSlideoutHelper(){
		return mSlideoutHelper;
	}
}
