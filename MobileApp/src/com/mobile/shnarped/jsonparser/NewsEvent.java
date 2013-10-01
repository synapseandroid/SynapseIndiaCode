package com.mobile.shnarped.jsonparser;
/**
 * This class contains news event specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class NewsEvent extends Event 
{
	private String title = "";
	private String body = "";
	private Link[] links = null;
	private String team_id = "";
	private String team_name = "";
    private String read = "";
    private String replied = "";
    private String reply_id = "";
    private boolean reply_enabled = false;
    private boolean reply_active = false;
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Link[] getLinks() {
		return links;
	}
	public void setLinks(Link[] links) {
		this.links = links;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getRead() {
		return read;
	}
	public void setRead(String read) {
		this.read = read;
	}
	public String getReplied() {
		return replied;
	}
	public void setReplied(String replied) {
		this.replied = replied;
	}
	public String getReply_id() {
		return reply_id;
	}
	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}
	public boolean isReply_enabled() {
		return reply_enabled;
	}
	public void setReply_enabled(boolean reply_enabled) {
		this.reply_enabled = reply_enabled;
	}
	public boolean isReply_active() {
		return reply_active;
	}
	public void setReply_active(boolean reply_active) {
		this.reply_active = reply_active;
	}
    
  

}
