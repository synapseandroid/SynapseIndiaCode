package com.mobile.shnarped.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class provides common method which will be used in application anywhere.
 * @author Amit kumar
 *
 */
public class Utility 
{
	public static Date getserverDate(String date)
	{
		SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");  
		try {  
			Date dateformat = format.parse(date);  
			return dateformat; 
		} catch (Exception e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace(); 
			return null;
		}
	}
	
	public static String getDeviceFormatdate(Date date)
	{
		SimpleDateFormat  format = new SimpleDateFormat("MMM dd 'at' HH:mm aa");
		return format.format(date);
	}
}
