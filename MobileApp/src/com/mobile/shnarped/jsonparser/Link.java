package com.mobile.shnarped.jsonparser;
/**
 * This class contains link specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class Link 
{
	private String image_url = "";
	private String image_thumb_url = "";
	private String link_type = "";
	private String link_name = "";
	private String link_url = "";
	private String embed_url = "";
	private String embed = "";
	
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
	public String getLink_type() {
		return link_type;
	}
	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}
	public String getLink_name() {
		return link_name;
	}
	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}
	public String getLink_url() {
		return link_url;
	}
	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}
	public String getEmbed_url() {
		return embed_url;
	}
	public void setEmbed_url(String embed_url) {
		this.embed_url = embed_url;
	}
	public String getEmbed() {
		return embed;
	}
	public void setEmbed(String embed) {
		this.embed = embed;
	}
}
