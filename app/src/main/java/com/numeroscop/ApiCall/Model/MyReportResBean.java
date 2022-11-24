package com.numeroscop.ApiCall.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MyReportResBean {

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public List<DataItem> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}

	public class DataItem{

		@SerializedName("hindipdf")
		private String hindipdf;

		@SerializedName("dob_orignal")
		private String dobOrignal;

		@SerializedName("gender")
		private String gender;

		@SerializedName("solution")
		private Object solution;

		@SerializedName("updated_at")
		private String updatedAt;

		@SerializedName("user_id")
		private String userId;

		@SerializedName("dob")
		private String dob;

		@SerializedName("name")
		private String name;

		@SerializedName("mobile")
		private String mobile;

		@SerializedName("created_at")
		private String createdAt;

		@SerializedName("id")
		private int id;

		@SerializedName("endlishpdf")
		private String endlishpdf;

		public String getHindipdf(){
			return hindipdf;
		}

		public String getDobOrignal(){
			return dobOrignal;
		}

		public String getGender(){
			return gender;
		}

		public Object getSolution(){
			return solution;
		}

		public String getUpdatedAt(){
			return updatedAt;
		}

		public String getUserId(){
			return userId;
		}

		public String getDob(){
			return dob;
		}

		public String getName(){
			return name;
		}

		public String getMobile(){
			return mobile;
		}

		public String getCreatedAt(){
			return createdAt;
		}

		public int getId(){
			return id;
		}

		public String getEndlishpdf(){
			return endlishpdf;
		}
	}
}