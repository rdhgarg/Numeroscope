package com.numeroscop.ApiCall.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GetNumberResBean implements Serializable {

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private boolean status;


   @SerializedName("report_id")
	private int reportId;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	@SerializedName("message")
	private String message;



	public Data getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}

	public String isMessage(){
		return message;
	}

	public class Data implements Serializable{

		@SerializedName("calculation")
		private List<Integer> calculation;

		@SerializedName("mobile_total")
		private int mobileTotal;

		@SerializedName("strength")
		private List<StrengthItem> strength;

		@SerializedName("personalmonth")
		private int personalmonth;

		@SerializedName("mobile")
		private int mobile;

		@SerializedName("friend_no")
		private String friendNo;

		@SerializedName("conductor")
		private int conductor;

		@SerializedName("kuwa_no")
		private int kuwaNo;

		@SerializedName("personal_date")
		private int personalDate;

		@SerializedName("driver")
		private int driver;

		@SerializedName("name_total")
		private int nameTotal;

		@SerializedName("name_no")
		private int nameNo;

		@SerializedName("personalyear")
		private int personalyear;

		@SerializedName("missing")
		private List<Integer> missing;

		@SerializedName("avoid_no")
		private String avoidNo;

		@SerializedName("lucky_no")
		private String luckyNo;

		@SerializedName("present")
		private List<Integer> present;

		public List<Integer> getCalculation(){
			return calculation;
		}

		public int getMobileTotal(){
			return mobileTotal;
		}

		public List<StrengthItem> getStrength(){
			return strength;
		}

		public int getPersonalmonth(){
			return personalmonth;
		}

		public int getMobile(){
			return mobile;
		}

		public String getFriendNo(){
			return friendNo;
		}

		public int getConductor(){
			return conductor;
		}

		public int getKuwaNo(){
			return kuwaNo;
		}

		public int getPersonalDate(){
			return personalDate;
		}

		public int getDriver(){
			return driver;
		}

		public int getNameTotal(){
			return nameTotal;
		}

		public int getNameNo(){
			return nameNo;
		}

		public int getPersonalyear(){
			return personalyear;
		}

		public List<Integer> getMissing(){
			return missing;
		}

		public String getAvoidNo(){
			return avoidNo;
		}

		public String getLuckyNo(){
			return luckyNo;
		}

		public List<Integer> getPresent(){
			return present;
		}


		public class StrengthItem implements Serializable{

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
	}
}