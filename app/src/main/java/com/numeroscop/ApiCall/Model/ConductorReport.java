package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

public class ConductorReport{

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("conductor_no")
	private String conductorNo;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("description_hindi")
	private Object descriptionHindi;

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getConductorNo(){
		return conductorNo;
	}

	public String getDescription(){
		return description;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public Object getDescriptionHindi(){
		return descriptionHindi;
	}
}