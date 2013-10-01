package com.mobile.shnarped.controller;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/**
 * 
 * @author Amit kumar
 *
 */
public class LooperThread extends Thread 
{
	private Handler mHandler = null;
	private MessageHandler handler = null;

	public void run() {
		Looper.prepare();

		mHandler = new Handler() {
			public void handleMessage(Message msg) 
			{
				handler.handleMessage(msg);
			}
		};

		Looper.loop();
	}
	
	public Handler getHandler()
	{
		while(mHandler == null)
		{
			
		}
		return mHandler;
	}
	

	public void stopLooper()
	{
		mHandler.getLooper().quit();
	}
	
	
	public interface MessageHandler
	{
		public void handleMessage(Message msg);
	}
	
	public void setMessageListener(MessageHandler listener)
	{
		handler = listener;
	}
}
