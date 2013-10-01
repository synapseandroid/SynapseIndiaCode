package com.mobile.shnarped.jsonparser;

/**
 * This class contains user specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class User 
{
	private int id = 0;
	private String first_name = "";
	private String last_name = "";
	private String email = "";
	private String twitter = "";
	private String avatar = "";
	private String avatar_url = "";
	private String avatar_thumb_url = "";
	private String gender = "";
	private String birthdate = "";
	private boolean verified = false;
	private int favourite_team_id = 0;
	private String favourite_team = "";
	private PoundCount pound_count = null;
	private boolean following = false;
	private boolean push = false;
	private int player_id = 0;
	private Player player = null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar_url() {
		return avatar_url;
	}
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
	public String getAvatar_thumb_url() {
		return avatar_thumb_url;
	}
	public void setAvatar_thumb_url(String avatar_thumb_url) {
		this.avatar_thumb_url = avatar_thumb_url;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public int getFavourite_team_id() {
		return favourite_team_id;
	}
	public void setFavourite_team_id(int favourite_team_id) {
		this.favourite_team_id = favourite_team_id;
	}
	public String getFavourite_team() {
		return favourite_team;
	}
	public void setFavourite_team(String favourite_team) {
		this.favourite_team = favourite_team;
	}
	public PoundCount getPound_count() {
		return pound_count;
	}
	public void setPound_count(PoundCount pound_count) {
		this.pound_count = pound_count;
	}
	public boolean isFollowing() {
		return following;
	}
	public void setFollowing(boolean following) {
		this.following = following;
	}
	public boolean isPush() {
		return push;
	}
	public void setPush(boolean push) {
		this.push = push;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
 
}
