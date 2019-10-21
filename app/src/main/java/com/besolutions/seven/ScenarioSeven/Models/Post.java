package com.besolutions.seven.ScenarioSeven.Models;//
//  RootClass.java
//  Model Generated using http://www.jsoncafe.com/ 
//  Created on October 8, 2019

import org.json.*;
import java.util.*;
import com.google.gson.annotations.SerializedName;


public class Post{

	@SerializedName("Aceept")
	private String aceept;
	@SerializedName("City")
	private String city;
	@SerializedName("Country")
	private String country;
	@SerializedName("datee")
	private String datee;
	@SerializedName("datee_c")
	private String dateeC;
	@SerializedName("Department")
	private String department;
	@SerializedName("Des")
	private String des;
	@SerializedName("device")
	private String device;
	@SerializedName("Email")
	private String email;
	@SerializedName("Id")
	private int id;
	@SerializedName("IdMember")
	private String idMember;
	@SerializedName("Image")
	private String image;
	@SerializedName("Image_2")
	private String image2;
	@SerializedName("Image_3")
	private String image3;
	@SerializedName("Image_4")
	private String image4;
	@SerializedName("Image_5")
	private String image5;
	@SerializedName("Image_6")
	private String image6;
	@SerializedName("Image_7")
	private String image7;
	@SerializedName("Image_8")
	private String image8;
	@SerializedName("ImageMember")
	private String imageMember;
	@SerializedName("NameMember")
	private String nameMember;
	@SerializedName("Phone")
	private String phone;
	@SerializedName("Price")
	private String price;
	@SerializedName("sort")
	private String sort;
	@SerializedName("SubDep")
	private String subDep;
	@SerializedName("Title")
	private String title;
	@SerializedName("URL")
	private String uRL;
	@SerializedName("URLMember")
	private String uRLMember;

	public void setAceept(String aceept){
		this.aceept = aceept;
	}
	public String getAceept(){
		return this.aceept;
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
	public void setDatee(String datee){
		this.datee = datee;
	}
	public String getDatee(){
		return this.datee;
	}
	public void setDateeC(String dateeC){
		this.dateeC = dateeC;
	}
	public String getDateeC(){
		return this.dateeC;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return this.department;
	}
	public void setDes(String des){
		this.des = des;
	}
	public String getDes(){
		return this.des;
	}
	public void setDevice(String device){
		this.device = device;
	}
	public String getDevice(){
		return this.device;
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
	public void setIdMember(String idMember){
		this.idMember = idMember;
	}
	public String getIdMember(){
		return this.idMember;
	}
	public void setImage(String image){
		this.image = image;
	}
	public String getImage(){
		return this.image;
	}
	public void setImage2(String image2){
		this.image2 = image2;
	}
	public String getImage2(){
		return this.image2;
	}
	public void setImage3(String image3){
		this.image3 = image3;
	}
	public String getImage3(){
		return this.image3;
	}
	public void setImage4(String image4){
		this.image4 = image4;
	}
	public String getImage4(){
		return this.image4;
	}
	public void setImage5(String image5){
		this.image5 = image5;
	}
	public String getImage5(){
		return this.image5;
	}
	public void setImage6(String image6){
		this.image6 = image6;
	}
	public String getImage6(){
		return this.image6;
	}
	public void setImage7(String image7){
		this.image7 = image7;
	}
	public String getImage7(){
		return this.image7;
	}
	public void setImage8(String image8){
		this.image8 = image8;
	}
	public String getImage8(){
		return this.image8;
	}
	public void setImageMember(String imageMember){
		this.imageMember = imageMember;
	}
	public String getImageMember(){
		return this.imageMember;
	}
	public void setNameMember(String nameMember){
		this.nameMember = nameMember;
	}
	public String getNameMember(){
		return this.nameMember;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPrice(String price){
		this.price = price;
	}
	public String getPrice(){
		return this.price;
	}
	public void setSort(String sort){
		this.sort = sort;
	}
	public String getSort(){
		return this.sort;
	}
	public void setSubDep(String subDep){
		this.subDep = subDep;
	}
	public String getSubDep(){
		return this.subDep;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setURL(String uRL){
		this.uRL = uRL;
	}
	public String getURL(){
		return this.uRL;
	}
	public void setURLMember(String uRLMember){
		this.uRLMember = uRLMember;
	}
	public String getURLMember(){
		return this.uRLMember;
	}

	public Post() {
	}

	/**
	 * Instantiate the instance using the passed jsonObject to set the properties values
	 */



	public Post(JSONObject jsonObject){
		if(jsonObject == null){
			return;
		}
		aceept = (String) jsonObject.opt("Aceept");
		city = (String) jsonObject.opt("City");
		country = (String) jsonObject.opt("Country");
		datee = (String) jsonObject.opt("datee");
		dateeC = (String) jsonObject.opt("datee_c");
		department = (String) jsonObject.opt("Department");
		des = (String) jsonObject.opt("Des");
		device = (String) jsonObject.opt("device");
		email = (String) jsonObject.opt("Email");
		idMember = (String) jsonObject.opt("IdMember");
		image = (String) jsonObject.opt("Image");
		image2 = (String) jsonObject.opt("Image_2");
		image3 = (String) jsonObject.opt("Image_3");
		image4 = (String) jsonObject.opt("Image_4");
		image5 = (String) jsonObject.opt("Image_5");
		image6 = (String) jsonObject.opt("Image_6");
		image7 = (String) jsonObject.opt("Image_7");
		image8 = (String) jsonObject.opt("Image_8");
		imageMember = (String) jsonObject.opt("ImageMember");
		nameMember = (String) jsonObject.opt("NameMember");
		phone = (String) jsonObject.opt("Phone");
		price = (String) jsonObject.opt("Price");
		sort = (String) jsonObject.opt("sort");
		subDep = (String) jsonObject.opt("SubDep");
		title = (String) jsonObject.opt("Title");
		uRL = (String) jsonObject.opt("URL");
		uRLMember = (String) jsonObject.opt("URLMember");
		id = jsonObject.optInt("Id");
	}

	/**
	 * Returns all the available property values in the form of JSONObject instance where the key is the approperiate json key and the value is the value of the corresponding field
	 */
	public JSONObject toJsonObject()
	{
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("Aceept", aceept);
			jsonObject.put("City", city);
			jsonObject.put("Country", country);
			jsonObject.put("datee", datee);
			jsonObject.put("datee_c", dateeC);
			jsonObject.put("Department", department);
			jsonObject.put("Des", des);
			jsonObject.put("device", device);
			jsonObject.put("Email", email);
			jsonObject.put("Id", id);
			jsonObject.put("IdMember", idMember);
			jsonObject.put("Image", image);
			jsonObject.put("Image_2", image2);
			jsonObject.put("Image_3", image3);
			jsonObject.put("Image_4", image4);
			jsonObject.put("Image_5", image5);
			jsonObject.put("Image_6", image6);
			jsonObject.put("Image_7", image7);
			jsonObject.put("Image_8", image8);
			jsonObject.put("ImageMember", imageMember);
			jsonObject.put("NameMember", nameMember);
			jsonObject.put("Phone", phone);
			jsonObject.put("Price", price);
			jsonObject.put("sort", sort);
			jsonObject.put("SubDep", subDep);
			jsonObject.put("Title", title);
			jsonObject.put("URL", uRL);
			jsonObject.put("URLMember", uRLMember);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}

}