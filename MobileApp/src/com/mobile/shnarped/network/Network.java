package com.mobile.shnarped.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;



/**
 * This class provides API for Networking. It executes it's method in caller thread.
 * @author Amit Kumar
 *
 */
public class Network 
{
	private String serverUrl = null;
	private Context context = null;
	private boolean initFlag = false;
	private int connectionTime = 10000; //default time
	private final String LOGGERTAG= "NETWORK";

	public static final String NETWORK_NOT_AVAILABLE = "Network not available";
	public static final String NETWORK_NOT_CONNECTED = "Network not connected";
	public static final String NETWORK_NOT_INITIALIZED ="Network is not initialized";
	public static final String CONNECTION_TIME_OUT = "Connection time out";
	public static final String INVALID_URL = "Url is invalid";
	public static final String SERVICE_NOT_AVAILABLE = "Resource not found";
	
	public static final String HTTP_POST = "POST";
	public static final String HTTP_GET  = "GET";

	public boolean init(String serverUrl, Context ctx)
	{
		if(serverUrl != null && serverUrl.length() > 0 && ctx != null){
			this.serverUrl = serverUrl;
			this.context = ctx;
			initFlag = true;
		}
		else
			initFlag = false;

		return initFlag;
	}

	/**
	 * This method sends the request to server using HTTP GET method. It return's synchronous response.
	 * @param reqJson
	 * @param api
	 * @return responseJson
	 */
	public String sendRequestToServer(String api)
	{
		String responseJson = "";
		if(!initFlag)
			responseJson = NETWORK_NOT_INITIALIZED;
		else
		{
			int networkState = checkNetworkState();
			if(networkState == 0)
			{
				String finalUrl = serverUrl + api;

				try {
					URL url = new URL(finalUrl);
					
					HttpClient client = new DefaultHttpClient();
		        	HttpGet request = new HttpGet(finalUrl);
		            
		            HttpResponse response = client.execute(request);
		            responseJson = EntityUtils.toString(response.getEntity(), "UTF-8");
					
				} 
				catch(SocketTimeoutException timeoutExp)
				{
					responseJson = CONNECTION_TIME_OUT;

				}
				catch (MalformedURLException e)
				{
					responseJson = INVALID_URL;

				} 
				catch (IOException e) 
				{
					responseJson = SERVICE_NOT_AVAILABLE;

				}
				catch(Exception exp)
				{
					responseJson = SERVICE_NOT_AVAILABLE;

				}

			}
			else if(networkState == 1)
				responseJson = NETWORK_NOT_CONNECTED;
			else
				responseJson = NETWORK_NOT_AVAILABLE;
		}
		return responseJson;
	}

	/**
	 * This helper method for checking network state on device
	 * @return status code
	 */
	public int checkNetworkState()
	{
		int state = -1;
		ConnectivityManager connectvityMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectvityMgr.getActiveNetworkInfo();
		if(networkInfo == null)
		{
			state = -1;
		}
		else if(networkInfo.isConnected())
		{
			state = 0;
		}
		else
		{
			state = 1;
		}

		return state;
	}
}
