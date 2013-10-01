package com.mobile.shnarped.ui;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * This Manges the UI for Menus.
 * @author Amit Kumar
 *
 */
public class MenuItemFragment extends Fragment implements OnClickListener
{
	private LinearLayout newsFeed = null, playerSearch = null, whatsHot = null, poundReceive = null, poundSent = null, trackingList = null, editProfile = null;
	private Button inviteFriend= null;
	private Typeface eurostiFont = null;

	public static final String NEWS_FEED              = "News Feed";
	public static final String PLAYER_SEARCH          = "Player Search";
	public static final String WHATS_HOT              = "What's Hot";
	public static final String POUND_RECEIVED         = "Pounds Received";
	public static final String POUND_SENT             = "Pounds Sent";
	public static final String TRAKING_LIST           = "Tracking List";
	public static final String EDIT_PROFILE           = "Edit Profile";

	public static String selectedTab = NEWS_FEED;
	private View selectedView = null;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rView = inflater.inflate(R.layout.menu_item_fragment, container, false);
		return rView;
	}



	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		initUI();
	}

	/**
	 * this method initialise the UI component
	 */
	private void initUI()
	{
		eurostiFont = Typeface.createFromAsset(getActivity().getAssets(), "font/Eurosti.ttf");

		inviteFriend = (Button)getActivity().findViewById(R.id.invite_friend);
		inviteFriend.setTypeface(eurostiFont);
		inviteFriend.setTextColor(Color.rgb(229, 224, 213));

		newsFeed = (LinearLayout)getActivity().findViewById(R.id.news_feed);
		((ImageView)newsFeed.getChildAt(0)).setImageResource(R.drawable.stream);
		((TextView)newsFeed.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)newsFeed.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)newsFeed.getChildAt(1)).setText(NEWS_FEED);

		newsFeed.setOnClickListener(this);

		playerSearch = (LinearLayout)getActivity().findViewById(R.id.player_search);
		((ImageView)playerSearch.getChildAt(0)).setImageResource(R.drawable.search);
		((TextView)playerSearch.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)playerSearch.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)playerSearch.getChildAt(1)).setText(PLAYER_SEARCH);
		playerSearch.setOnClickListener(this);

		whatsHot = (LinearLayout)getActivity().findViewById(R.id.whats_hot);
		((ImageView)whatsHot.getChildAt(0)).setImageResource(R.drawable.whats_hot);
		((TextView)whatsHot.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)whatsHot.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)whatsHot.getChildAt(1)).setText(WHATS_HOT);
		whatsHot.setOnClickListener(this);

		poundReceive = (LinearLayout)getActivity().findViewById(R.id.pounds_receive);
		((ImageView)poundReceive.getChildAt(0)).setImageResource(R.drawable.pounds);
		((TextView)poundReceive.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)poundReceive.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)poundReceive.getChildAt(1)).setText(POUND_RECEIVED);
		poundReceive.setOnClickListener(this);

		poundSent = (LinearLayout)getActivity().findViewById(R.id.pound_sent);
		((ImageView)poundSent.getChildAt(0)).setImageResource(R.drawable.pounds);
		((TextView)poundSent.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)poundSent.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)poundSent.getChildAt(1)).setText(POUND_SENT);
		poundSent.setOnClickListener(this);


		trackingList = (LinearLayout)getActivity().findViewById(R.id.tracking_list);
		((ImageView)trackingList.getChildAt(0)).setImageResource(R.drawable.account);
		((TextView)trackingList.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)trackingList.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)trackingList.getChildAt(1)).setText(TRAKING_LIST);
		trackingList.setOnClickListener(this);


		editProfile = (LinearLayout)getActivity().findViewById(R.id.edit_profile);
		((ImageView)editProfile.getChildAt(0)).setImageResource(R.drawable.account);
		((TextView)editProfile.getChildAt(1)).setTypeface(eurostiFont);
		((TextView)editProfile.getChildAt(1)).setTextColor(Color.rgb(229, 224, 213));
		((TextView)editProfile.getChildAt(1)).setText(EDIT_PROFILE);
		editProfile.setOnClickListener(this);

		setselection(selectedTab);
	}

	/**
	 * This set the selected item.
	 * @param selectedTab
	 */
	private void setselection(String selectedTab2)
	{


		if(selectedTab2.equals(NEWS_FEED))
		{
			((ImageView)newsFeed.getChildAt(0)).setImageResource(R.drawable.stream_selected);
			selectedTab = NEWS_FEED;
			selectedView = newsFeed;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(PLAYER_SEARCH))
		{
			((ImageView)playerSearch.getChildAt(0)).setImageResource(R.drawable.search_selected);
			selectedTab = PLAYER_SEARCH;
			selectedView = playerSearch;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(WHATS_HOT))
		{
			((ImageView)whatsHot.getChildAt(0)).setImageResource(R.drawable.whats_hot_selected);
			selectedTab = WHATS_HOT;
			selectedView = whatsHot;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(POUND_RECEIVED))
		{
			((ImageView)poundReceive.getChildAt(0)).setImageResource(R.drawable.pounds_selected);
			selectedTab = POUND_RECEIVED;
			selectedView = poundReceive;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(POUND_SENT))
		{
			((ImageView)poundSent.getChildAt(0)).setImageResource(R.drawable.pounds_selected);
			selectedTab = POUND_SENT;
			selectedView = poundSent;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(TRAKING_LIST))
		{
			((ImageView)trackingList.getChildAt(0)).setImageResource(R.drawable.account_selected);
			selectedTab = TRAKING_LIST;
			selectedView = trackingList;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}
		else if(selectedTab2.equals(EDIT_PROFILE))
		{
			((ImageView)editProfile.getChildAt(0)).setImageResource(R.drawable.account_selected);
			selectedTab = EDIT_PROFILE;
			selectedView = editProfile;
			selectedView.setBackgroundColor(Color.rgb(105, 46, 47));
		}


	}


	@Override
	public void onClick(View v) 
	{
		switch (v.getId()) 
		{

		case R.id.news_feed:
			changeAlreadySelectedRow(selectedView);
			((ImageView)newsFeed.getChildAt(0)).setImageResource(R.drawable.stream_selected);

			selectedTab = NEWS_FEED;
			newsFeed.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = newsFeed;

			break;
		case R.id.player_search:
			changeAlreadySelectedRow(selectedView);

			((ImageView)playerSearch.getChildAt(0)).setImageResource(R.drawable.search_selected);

			selectedTab = PLAYER_SEARCH;
			playerSearch.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = playerSearch;

			break;
		case R.id.whats_hot:

			changeAlreadySelectedRow(selectedView);

			((ImageView)whatsHot.getChildAt(0)).setImageResource(R.drawable.whats_hot_selected);

			selectedTab = WHATS_HOT;
			whatsHot.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = whatsHot;
			break;
		case R.id.pounds_receive:

			changeAlreadySelectedRow(selectedView);

			((ImageView)poundReceive.getChildAt(0)).setImageResource(R.drawable.pounds_selected);

			selectedTab = POUND_RECEIVED;
			poundReceive.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = poundReceive;
			break;
		case R.id.pound_sent:

			changeAlreadySelectedRow(selectedView);

			((ImageView)poundSent.getChildAt(0)).setImageResource(R.drawable.pounds_selected);

			selectedTab = POUND_SENT;
			poundSent.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = poundSent;
			break;

		case R.id.tracking_list:
			changeAlreadySelectedRow(selectedView);

			((ImageView)trackingList.getChildAt(0)).setImageResource(R.drawable.account_selected);

			selectedTab = TRAKING_LIST;
			trackingList.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = trackingList;
			break;
		case R.id.edit_profile:
			changeAlreadySelectedRow(selectedView);

			((ImageView)editProfile.getChildAt(0)).setImageResource(R.drawable.account_selected);

			selectedTab = EDIT_PROFILE;
			editProfile.setBackgroundColor(Color.rgb(105, 46, 47));
			selectedView = editProfile;
			break;

		}
		((MenuFragmentActivity)getActivity()).getSlideoutHelper().close();
	}


	private void changeAlreadySelectedRow(View selectedView2)
	{
		switch (selectedView2.getId()) 
		{

		case R.id.news_feed:
			((ImageView)newsFeed.getChildAt(0)).setImageResource(R.drawable.stream);
			break;
		case R.id.player_search:
			((ImageView)playerSearch.getChildAt(0)).setImageResource(R.drawable.search);;
			break;
		case R.id.whats_hot:
			((ImageView)whatsHot.getChildAt(0)).setImageResource(R.drawable.whats_hot);
			break;
		case R.id.pounds_receive:
			((ImageView)poundReceive.getChildAt(0)).setImageResource(R.drawable.pounds);
			break;
		case R.id.pound_sent:
			((ImageView)poundSent.getChildAt(0)).setImageResource(R.drawable.pounds);
			break;

		case R.id.tracking_list:
			((ImageView)trackingList.getChildAt(0)).setImageResource(R.drawable.account);
			break;
		case R.id.edit_profile:
			((ImageView)editProfile.getChildAt(0)).setImageResource(R.drawable.account);
			break;

		}
		selectedView2.setBackgroundColor(Color.TRANSPARENT);
	}

}
