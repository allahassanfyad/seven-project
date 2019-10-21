package com.besolutions.seven.ScenarioSeven.Models;//
//  RootClass.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on October 8, 2019

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class User{

	@SerializedName("Active")
	private String active;
	@SerializedName("Balance")
	private String balance;
	@SerializedName("City")
	private String city;
	@SerializedName("Country")
	private String country;
	@SerializedName("Datee")
	private Object datee;
	@SerializedName("Email")
	private String email;
	@SerializedName("Id")
	private int id;
	@SerializedName("IdMedia")
	private int idMedia;
	@SerializedName("ImageProfile")
	private String imageProfile;
	@SerializedName("Name")
	private String name;
	@SerializedName("Password")
	private String password;
	@SerializedName("Phone")
	private String phone;
	@SerializedName("URL")
	private String uRL;

	public void setActive(String active){
		this.active = active;
	}
	public String getActive(){
		return this.active;
	}
	public void setBalance(String balance){
		this.balance = balance;
	}
	public String getBalance(){
		return this.balance;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return this.country;
	}
	public void setDatee(Object datee){
		this.datee = datee;
	}
	public Object getDatee(){
		return this.datee;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setIdMedia(int idMedia){
		this.idMedia = idMedia;
	}
	public int getIdMedia(){
		return this.idMedia;
	}
	public void setImageProfile(String imageProfile){
		this.imageProfile = imageProfile;
	}
	public String getImageProfile(){
		return this.imageProfile;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setURL(String uRL){
		this.uRL = uRL;
	}
	public String getURL(){
		return this.uRL;
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */
	public User(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		active = (String) jsonObject.opt("Active");
		balance = (String) jsonObject.opt("Balance");
		city = (String) jsonObject.opt("City");
		country = (String) jsonObject.opt("Country");
		email = (String) jsonObject.opt("Email");
		imageProfile = (String) jsonObject.opt("ImageProfile");
		name = (String) jsonObject.opt("Name");
		password = (String) jsonObject.opt("Password");
		phone = (String) jsonObject.opt("Phone");
		uRL = (String) jsonObject.opt("URL");
		datee = jsonObject.opt("Datee");
		id = jsonObject.optInt("Id");
		idMedia = jsonObject.optInt("IdMedia");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Active", active);
			jsonObject.put("Balance", balance);
			jsonObject.put("City", city);
			jsonObject.put("Country", country);
			jsonObject.put("Datee", datee);
			jsonObject.put("Email", email);
			jsonObject.put("Id", id);
			jsonObject.put("IdMedia", idMedia);
			jsonObject.put("ImageProfile", imageProfile);
			jsonObject.put("Name", name);
			jsonObject.put("Password", password);
			jsonObject.put("Phone", phone);
			jsonObject.put("URL", uRL);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}