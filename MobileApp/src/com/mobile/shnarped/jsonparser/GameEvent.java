package com.mobile.shnarped.jsonparser;

/**
 * This class contains game event specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class GameEvent extends Event
{
	private String description = "";
	private String player_stats = "";
	private String box_score_url = "";
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlayer_stats() {
		return player_stats;
	}
	public void setPlayer_stats(String player_stats) {
		this.player_stats = player_stats;
	}
	public String getBox_score_url() {
		return box_score_url;
	}
	public void setBox_score_url(String box_score_url) {
		this.box_score_url = box_score_url;
	}
}
