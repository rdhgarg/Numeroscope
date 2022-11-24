package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class RepeatNoItem{

	@SerializedName("number")
	private String number;

	@SerializedName("strength")
	private Object strength;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("counts")
	private String counts;

	@SerializedName("remedies")
	private Object remedies;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private String id;

	public String getNumber(){
		return number;
	}

	public Object getStrength(){
		return strength;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getCounts(){
		return counts;
	}

	public Object getRemedies(){
		return remedies;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getId(){
		return id;
	}
}