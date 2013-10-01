package com.mobile.shnarped.ui;


import java.util.ArrayList;

import com.mobile.shnarped.adapter.NewsFeedAdapter;
import com.mobile.shnarped.controller.ApplicationManager;
import com.mobile.shnarped.controller.RequestType;
import com.mobile.shnarped.jsonparser.Event;
import com.mobile.shnarped.slideout.SlideoutActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.style.TypefaceSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
/**
 * This is fragment is responsible for managing the UI for News Feed.
 * @author Amit Kumar
 *
 */
public class NewsFeedFragment extends Fragment implements OnClickListener
{
	private Button menuButton = null;
	private TextView middleText = null;
	private Button trackingButton = null;
	private ListView newsFeedListView  = null;
	private ApplicationManager appManager = null;
	private Handler uiHandler = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rView = inflater.inflate(R.layout.fragment_news_feed, container, false);
		return rView;
	}


	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		initUI();
	}

	/**
	 * This method initialise the UI related component.
	 */
	private void initUI() 
	{
		Typeface collegeFont = Typeface.createFromAsset(getActivity().getAssets(), "font/COLLEGE.ttf");
		
		uiHandler = new Handler(){
			public void handleMessage(Message msg)
			{
				handleEvent(msg.what, msg.obj);
			}
		};	
		
		appManager = ApplicationManager.getInstance(getActivity());
		appManager.setUIHandler(uiHandler);
		
		menuButton = (Button)getActivity().findViewById(R.id.menu_button);
		menuButton.setOnClickListener(this);
		middleText = (TextView)getActivity().findViewById(R.id.middle_level); 
		middleText.setTypeface(collegeFont);
		middleText.setTextColor(Color.rgb(229, 224, 213));
		
		trackingButton = (Button)getActivity().findViewById(R.id.tracking_button);
		trackingButton.setOnClickListener(this);
		
		newsFeedListView = (ListView)getActivity().findViewById(R.id.news_feed_listview);
		newsFeedListView.setAdapter(new NewsFeedAdapter(null,getActivity().getLayoutInflater(),getActivity()));
		
		appManager.addRequest(RequestType.NEWS_FEED_REQ, null);
	}


	protected void handleEvent(int what, Object obj)
	{
		if(what == RequestType.NEWS_FEED_REQ)
		{
			ArrayList<Event> event = (ArrayList<Event>)obj;
			((NewsFeedAdapter)newsFeedListView.getAdapter()).refreshAdapter(event);
		}
	}


	@Override
	public void onClick(View v)
	{
		switch (v.getId()) {
		case R.id.menu_button:
			int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40,getResources().getDisplayMetrics());
			SlideoutActivity.prepare(getActivity(),R.id.inner_content, width);
			startActivity(new Intent(getActivity(),MenuFragmentActivity.class));
			getActivity().overridePendingTransition(0, 0);
			break;

		
		}
	}
	
}
