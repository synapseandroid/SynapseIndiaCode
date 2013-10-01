package com.mobile.shnarped.jsonparser;
/**
 * This class contains player specific information and provides method for get/set information.
 * @author Amit kumar
 *
 */
public class Player
{
	private int id = 0; 
	private String first_name = "";
	private String last_name = "";
	private String birthdate = "";
	private String hometown = "";
	private String image = "";
	private String position = "";
	private int jersey = 0;
	private String weight = "";
	private String weight_metric = "";
	private String height = "";
	private String height_metric = "";
	private String shoots = "";
	private String cap_hit = "";
	private String contract_thru = "";
	private int current_team_id = 0;
	private String current_team = "";
	private int questions = 0;
	private int questions_answered = 0;
	
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
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getJersey() {
		return jersey;
	}
	public void setJersey(int jersey) {
		this.jersey = jersey;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeight_metric() {
		return weight_metric;
	}
	public void setWeight_metric(String weight_metric) {
		this.weight_metric = weight_metric;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getHeight_metric() {
		return height_metric;
	}
	public void setHeight_metric(String height_metric) {
		this.height_metric = height_metric;
	}
	public String getShoots() {
		return shoots;
	}
	public void setShoots(String shoots) {
		this.shoots = shoots;
	}
	public String getCap_hit() {
		return cap_hit;
	}
	public void setCap_hit(String cap_hit) {
		this.cap_hit = cap_hit;
	}
	public String getContract_thru() {
		return contract_thru;
	}
	public void setContract_thru(String contract_thru) {
		this.contract_thru = contract_thru;
	}
	public int getCurrent_team_id() {
		return current_team_id;
	}
	public void setCurrent_team_id(int current_team_id) {
		this.current_team_id = current_team_id;
	}
	public String getCurrent_team() {
		return current_team;
	}
	public void setCurrent_team(String current_team) {
		this.current_team = current_team;
	}
	public int getQuestions() {
		return questions;
	}
	public void setQuestions(int questions) {
		this.questions = questions;
	}
	public int getQuestions_answered() {
		return questions_answered;
	}
	public void setQuestions_answered(int questions_answered) {
		this.questions_answered = questions_answered;
	}
	
}
