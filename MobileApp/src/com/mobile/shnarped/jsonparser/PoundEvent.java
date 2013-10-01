package com.mobile.shnarped.jsonparser;

/**
 * This class contains pound event specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class PoundEvent extends Event
{
	private String message = "";
	private String image_url = "";
	private String image_thumb_url = "";
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getImage_thumb_url() {
		return image_thumb_url;
	}
	public void setImage_thumb_url(String image_thumb_url) {
		this.image_thumb_url = image_thumb_url;
	}
}
