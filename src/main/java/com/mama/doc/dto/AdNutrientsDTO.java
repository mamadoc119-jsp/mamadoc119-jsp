package com.mama.doc.dto;

public class AdNutrientsDTO {
	
	//필드
	private int nutrientsNumber;
	private int adminNumber;
	private String nutrientsName;
	private String nutrientsEffect;
	private String nutrientsInfo;
	private String nutrientsDate;
	
//	getter, setter
	public int getNutrientsNumber() {
		return nutrientsNumber;
	}
	public void setNutrientsNumber(int nutrientsNumber) {
		this.nutrientsNumber = nutrientsNumber;
	}
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getNutrientsName() {
		return nutrientsName;
	}
	public void setNutrientsName(String nutrientsName) {
		this.nutrientsName = nutrientsName;
	}
	public String getNutrientsEffect() {
		return nutrientsEffect;
	}
	public void setNutrientsEffect(String nutrientsEffect) {
		this.nutrientsEffect = nutrientsEffect;
	}
	public String getNutrientsInfo() {
		return nutrientsInfo;
	}
	public void setNutrientsInfo(String nutrientsInfo) {
		this.nutrientsInfo = nutrientsInfo;
	}
	public String getNutrientsDate() {
		return nutrientsDate;
	}
	public void setNutrientsDate(String nutrientsDate) {
		this.nutrientsDate = nutrientsDate;
	}
	
	@Override
	public String toString() {
		return "AdNutrientsDTO [nutrientsNumber=" + nutrientsNumber + ", adminNumber=" + adminNumber
				+ ", nutrientsName=" + nutrientsName + ", nutrientsEffect=" + nutrientsEffect + ", nutrientsInfo="
				+ nutrientsInfo + ", nutrientsDate=" + nutrientsDate + "]";
	}
	
	
	

}
