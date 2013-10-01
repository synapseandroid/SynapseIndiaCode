package com.mobile.shnarped.jsonparser;

/**
 * This class is base for all event. Basically this class contains common property of all event.
 * @author Amit Kumar
 *
 */
public class Event
{
	private int id  = 0;
	private User publisher = null;
	private boolean conversation = false;
	private int event_count = 0;
	private boolean featured = false;
	private boolean stream = false;
	private String created_at = "";
	private String updated_at = "";
	private User[] recipients = null;
	private String type = ""; //‘pound’, ‘news’, or ‘game’
	private String twitter_message = "";
	private String facebook_message = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public boolean isConversation() {
		return conversation;
	}
	public void setConversation(boolean conversation) {
		this.conversation = conversation;
	}
	public int getEvent_count() {
		return event_count;
	}
	public void setEvent_count(int event_count) {
		this.event_count = event_count;
	}
	public boolean isFeatured() {
		return featured;
	}
	public void setFeatured(boolean featured) {
		this.featured = featured;
	}
	public boolean isStream() {
		return stream;
	}
	public void setStream(boolean stream) {
		this.stream = stream;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public User[] getRecipients() {
		return recipients;
	}
	public void setRecipients(User[] recipients) {
		this.recipients = recipients;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTwitter_message() {
		return twitter_message;
	}
	public void setTwitter_message(String twitter_message) {
		this.twitter_message = twitter_message;
	}
	public String getFacebook_message() {
		return facebook_message;
	}
	public void setFacebook_message(String facebook_message) {
		this.facebook_message = facebook_message;
	}
}



