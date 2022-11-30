package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YantraBraceletResBean {

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public Data getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}

	public class Data{

		@SerializedName("yantra")
		private List<YantraItem> yantra;

		@SerializedName("bracelet")
		private List<BraceletItem> bracelet;

		public List<YantraItem> getYantra(){
			return yantra;
		}

		public List<BraceletItem> getBracelet(){
			return bracelet;
		}

		public class BraceletItem{

			@SerializedName("image")
			private String image;

			@SerializedName("id")
			private int id;

			@SerializedName("title")
			private String title;

			@SerializedName("type")
			private String type;

			@SerializedName("status")
			private String status;

			@SerializedName("is_selected")
			private boolean isSelected;

			public String getImage(){
				return image;
			}

			public int getId(){
				return id;
			}

			public String getTitle(){
				return title;
			}

			public String getType(){
				return type;
			}

			public String getStatus(){
				return status;
			}

			public boolean getIsSelected(){
				return isSelected;
			}

			public void setSelected(boolean isSelected){
				this.isSelected = isSelected;
			}
		}

		public class YantraItem{

			@SerializedName("image")
			private String image;

			@SerializedName("id")
			private int id;

			@SerializedName("title")
			private String title;

			@SerializedName("type")
			private String type;

			@SerializedName("status")
			private String status;

			@SerializedName("is_selected")
			private boolean isSelected;

			public String getImage(){
				return image;
			}

			public int getId(){
				return id;
			}

			public String getTitle(){
				return title;
			}

			public String getType(){
				return type;
			}

			public String getStatus(){
				return status;
			}

			public boolean getIsSelected(){
				return isSelected;
			}

			public void setSelected(boolean isSelected){
				this.isSelected = isSelected;
			}
		}
	}
}