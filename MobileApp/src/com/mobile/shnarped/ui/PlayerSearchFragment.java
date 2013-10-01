package com.mobile.shnarped.ui;

import com.mobile.shnarped.slideout.SlideoutActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
/**
 * This class is responsible for player search 
 * @author Amit kumar
 *
 */
public class PlayerSearchFragment extends Fragment implements OnClickListener
{
	private Button menuButton = null;
	private TextView middleText = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rView = inflater.inflate(R.layout.fragment_player_search, container, false);
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
		
		menuButton = (Button)getActivity().findViewById(R.id.menu_button);
		menuButton.setOnClickListener(this);
		middleText = (TextView)getActivity().findViewById(R.id.middle_level); 
		middleText.setTypeface(collegeFont);
		middleText.setTextColor(Color.rgb(229, 224, 213));
		
		
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
