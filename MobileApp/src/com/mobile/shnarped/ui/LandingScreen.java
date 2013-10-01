package com.mobile.shnarped.ui;

import com.mobile.shnarped.controller.ApplicationManager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
/**
 * This class is provides base frame to all screens
 * @author Amit Kumar
 *
 */
public class LandingScreen extends FragmentActivity
{
	private FragmentManager fragmentManager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_landing_screen);
		
		fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		NewsFeedFragment newsFragment = new NewsFeedFragment();
		transaction.add(R.id.fragment_container, newsFragment, "NewsFeedFragment");
		transaction.addToBackStack("NewsFeedFragment");
		transaction.commit();
		
	}
	
	
	@Override
	public void onResume()
	{
		super.onResume();
	}
	
	@Override
	public void onPause()
	{
		super.onPause();
	}
	
	@Override
	public void onStart()
	{
		super.onStart();
		if(MenuItemFragment.selectedTab.equals(MenuItemFragment.NEWS_FEED))
		{
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			NewsFeedFragment newsFragment = null;
			newsFragment = (NewsFeedFragment) fragmentManager.findFragmentByTag("NewsFeedFragment");
			if(newsFragment == null)
				newsFragment = new NewsFeedFragment();
			
			transaction.replace(R.id.fragment_container, newsFragment, "NewsFeedFragment");
			transaction.addToBackStack("NewsFeedFragment");
			transaction.commit();
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.PLAYER_SEARCH))
		{
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			PlayerSearchFragment newsFragment = null;
			newsFragment = (PlayerSearchFragment) fragmentManager.findFragmentByTag("PlayerSearchFragment");
			if(newsFragment == null)
				newsFragment = new PlayerSearchFragment();
			
			transaction.replace(R.id.fragment_container, newsFragment, "PlayerSearchFragment");
			transaction.addToBackStack("PlayerSearchFragment");
			transaction.commit();
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.POUND_RECEIVED))
		{
			
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.POUND_SENT))
		{
			
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.TRAKING_LIST))
		{
			
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.WHATS_HOT))
		{
			
		}
		else if(MenuItemFragment.selectedTab.equals(MenuItemFragment.EDIT_PROFILE))
		{
			
		}
		
	}
	
	
	@Override
	public void onBackPressed()
	{
		ApplicationManager.getInstance(getApplicationContext()).stopApplicationManager();
		finish();
		android.os.Process.killProcess(android.os.Process.myPid());
		super.onBackPressed();
	}
	
}
