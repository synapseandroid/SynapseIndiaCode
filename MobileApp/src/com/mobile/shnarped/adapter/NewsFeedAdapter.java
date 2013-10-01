package com.mobile.shnarped.adapter;

import java.util.ArrayList;

import com.mobile.shnarped.controller.ApplicationManager;
import com.mobile.shnarped.jsonparser.Event;
import com.mobile.shnarped.jsonparser.Link;
import com.mobile.shnarped.jsonparser.NewsEvent;
import com.mobile.shnarped.jsonparser.Player;
import com.mobile.shnarped.jsonparser.User;
import com.mobile.shnarped.ui.R;
import com.mobile.shnarped.utility.Utility;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This adapter manges the UI for News Feed list.
 * @author Amit Kumar
 *
 */
public class NewsFeedAdapter extends BaseAdapter
{
	private ArrayList<Event> eventList = null;
	private LayoutInflater inflator = null;
	private Context context = null;

	public NewsFeedAdapter(ArrayList<Event> eventList, LayoutInflater inflator, Context ctx)
	{
		this.context = ctx;
		this.eventList = eventList;
		this.inflator = inflator;
	}

	public void refreshAdapter(ArrayList<Event> eventList)
	{
		this.eventList = eventList;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if(eventList != null)
			return eventList.size();
		else
			return 0;
	}

	@Override
	public Object getItem(int position)
	{

		return eventList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{

		if(convertView == null)
		{
			RelativeLayout rl = (RelativeLayout) inflator.inflate(R.layout.row_news_feed, null);
			ViewHolder holder = new  ViewHolder();

			holder.playerImg = (ImageView)rl.findViewById(R.id.player_img); 
			holder.verificationImg = (ImageView)rl.findViewById(R.id.verified_img);

			Typeface eurostileFont = Typeface.createFromAsset(context.getAssets(), "font/EurostileBold.ttf");
			holder.playerName = (TextView)rl.findViewById(R.id.player_name);
			holder.playerName.setTypeface(eurostileFont);


			holder.playerhomeTown = (TextView)rl.findViewById(R.id.player_hmtwn);
			holder.createdDate = (TextView)rl.findViewById(R.id.player_add_date);

			holder.title = (TextView)rl.findViewById(R.id.tv_title);

			holder.linkholder = (LinearLayout)rl.findViewById(R.id.ll_playerimglinks);
			holder.body = (TextView)rl.findViewById(R.id.tv_body);
			holder.pound = (TextView)rl.findViewById(R.id.tv_pounds);

			rl.setTag(holder);
			convertView = rl;
		}

		RelativeLayout rl = (RelativeLayout)convertView;
		ViewHolder holder = (ViewHolder)rl.getTag();


		Event event = eventList.get(position);
		String evType = event.getType();
		if(evType.equals("news"))
		{
			NewsEvent nEvent = (NewsEvent)event;

			User publisher = nEvent.getPublisher();
			String img = publisher.getAvatar();
			//			if(img != null)
			//				replace player image

			if(publisher.isVerified())
				holder.verificationImg.setVisibility(View.VISIBLE);
			else
				holder.verificationImg.setVisibility(View.GONE);


			SpannableString content = new SpannableString(publisher.getFirst_name() + " " + publisher.getLast_name());
			content.setSpan(new ClickableSpan() {

				@Override
				public void updateDrawState(TextPaint ds)
				{
					ds.setColor(Color.rgb(140, 34, 27));
					ds.setUnderlineText(true);
				}

				@Override
				public void onClick(View widget) {
					// TODO Auto-generated method stub

				}
			}, 0, content.length(), 0);


			holder.playerName.setText(content);

			Player player = publisher.getPlayer();
			if(player != null)
				holder.playerhomeTown.setText(player.getHometown());
			String strDate = Utility.getDeviceFormatdate(Utility.getserverDate(nEvent.getCreated_at()));
			holder.createdDate.setText(strDate);
			holder.title.setText(nEvent.getTitle());


			holder.linkholder.removeAllViews();
			Link[] linkArray = nEvent.getLinks();
			if(linkArray != null && linkArray.length > 0)
			{
				int size = linkArray.length;
				for(int i=0; i < size; i++)
				{

					RelativeLayout linkLay = (RelativeLayout) inflator.inflate(R.layout.adpt_view_link, null);

					ImageView iv_linkimage = (ImageView) linkLay.findViewById(R.id.iv_linkimage);
					ImageView iv_playvideoicon = (ImageView) linkLay.findViewById(R.id.iv_playvideoicon);
					Button ll_linkname = (Button) linkLay.findViewById(R.id.ll_linkname);
					WebView wv_videoembeded = (WebView) linkLay.findViewById(R.id.wv_videoembeded);
					wv_videoembeded.getSettings().setJavaScriptEnabled(true);
					wv_videoembeded.getSettings().setPluginsEnabled(true);

					Link link = linkArray[i];
					if(link.getEmbed() != null && link.getEmbed() != "")
					{
						if(link.getLink_type().equals("video"))
						{
							iv_linkimage.setVisibility(View.GONE);
							ll_linkname.setVisibility(View.GONE);
							iv_playvideoicon.setVisibility(View.GONE);
							if(ApplicationManager.getInstance(context).isNetworkConnected() == 0)
							{
								wv_videoembeded.setVisibility(View.VISIBLE);

								wv_videoembeded.loadData(
										"<html><body style='margin:0;padding:0;'>" + link.getEmbed() + "</body></html>",
										"text/html", "utf-8");
							}
							else
								wv_videoembeded.setVisibility(View.GONE);

							//	wv_videoembeded.loadUrl(link.getEmbed_url());
						}
					}
					else
					{
						wv_videoembeded.setVisibility(View.GONE);
					}

					holder.linkholder.addView(linkLay);

				}


			}


			holder.body.setText(nEvent.getBody());
			int poundNum = publisher.getPound_count().getTotal();
			if(poundNum > 1)
				holder.pound.setText(poundNum + " Pounds");
			else
				holder.pound.setText(poundNum + " Pound");

		}
		else if(evType.equals("pound"))
		{

		}
		else if(evType.equals("game"))
		{

		}


		return convertView;
	}


	private class ViewHolder
	{
		public ImageView playerImg                = null;
		public ImageView verificationImg          = null;
		public TextView playerName                = null;
		public TextView playerhomeTown            = null;
		public TextView createdDate               = null;
		public TextView title               = null;
		public TextView body               = null;
		public TextView pound               = null;
		public LinearLayout linkholder = null;
	}

}
