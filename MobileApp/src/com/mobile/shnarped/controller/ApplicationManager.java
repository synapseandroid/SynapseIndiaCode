package com.mobile.shnarped.controller;

import java.util.ArrayList;

import com.mobile.shnarped.controller.LooperThread.MessageHandler;
import com.mobile.shnarped.jsonparser.Event;
import com.mobile.shnarped.jsonparser.EventParser;
import com.mobile.shnarped.network.Network;
import com.mobile.shnarped.network.ServerApi;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

/**
 * This class is singleton class and work between UI and database, network calls. This class separates the 
 * business logic from UI part. UI always will request for data to the manager, it will be totally depend on manager 
 * from where will be provided to UI.  Application manger handles all the request of UI. 
 * Application manager handles all request in separate thread.
 * 
 * @author Amit Kumar
 *
 */

public class ApplicationManager implements MessageHandler
{
	public static ApplicationManager appManager = null;
	private Network network = null;
	private static Context context = null;
	private Handler uiHandler = null;
	private LooperThread looperThread = null;

	/**
	 * This method returns the instance of application manager
	 * @return
	 */
	public static ApplicationManager getInstance(Context ctx)
	{

		context = ctx; 
		
		if(appManager == null)
			appManager = new ApplicationManager();

		return appManager;
	}

	private ApplicationManager()
	{
		network = new Network();
		network.init(ServerApi.SERVER_BASE_URL, context);
		looperThread = new LooperThread();
		looperThread.setMessageListener(this);
		looperThread.start();
	}

	/**
	 * This method is used to pass the handle to application manager. Application manager uses this handler to notify
	 * the UI.
	 * @param Handler handler
	 */
	public void setUIHandler(Handler handler)
	{
		uiHandler = handler;
	}

	/**
	 * This method adds the request to the queue of application manager
	 * @param requestType
	 * @return
	 */
	public Object addRequest(int requestType, Object data)
	{

		//first get data from database 

		
		Message message = looperThread.getHandler().obtainMessage();
		message.what = requestType;
		message.obj = data;

		looperThread.getHandler().sendMessage(message);

		return null;
	}

	/**
	 * This is helper method for handling the request.
	 */
	private void handleRequest(Message message)
	{
		
		
		
		if(RequestType.NEWS_FEED_REQ == message.what)
			getNewsFeedData(message);
	}

	/**
	 * This method notifies the UI, so that UI can refresh itself.
	 * @param int reqType
	 * @param Object data
	 */
	private void notifyUI(int reqType, Object data)
	{
		if(uiHandler != null)
		{
			Message message = uiHandler.obtainMessage();
			message.what = reqType;
			message.obj = data;

			uiHandler.sendMessage(message);
		}	
	}

	@Override
	public void handleMessage(Message msg)
	{
		handleRequest(msg);
	}

	/**
	 * This method stops the application manger and release the resources held by application manager 
	 */
	public void stopApplicationManager()
	{
		looperThread.stopLooper();
	}


	public int isNetworkConnected()
	{
		return network.checkNetworkState();
	}
	
	/**
	 * This method sends request to server for News Feed data. After getting the data, it will first save data into 
	 * database and then notify the UI. So that UI can refresh itself.
	 * @param Message msg
	 */
	private void getNewsFeedData(Message msg)
	{
		String req = ServerApi.EVENTS_URL + "?auth_token=" + "abcdefg" + "&user_id=" +"12345";
		String str = network.sendRequestToServer(req);
		ArrayList<Event> eventList = new EventParser().parse(str);
		//and save the data in database
		notifyUI(msg.what, eventList);
	}
}
