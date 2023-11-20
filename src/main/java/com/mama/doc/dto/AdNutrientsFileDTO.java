package com.mama.doc.dto;

public class AdNutrientsFileDTO {
	
//	필드
	private int nufileNumber;
	private int nutrientsNumber;
	private int adminNumber;
	private String nufilePath;
	private String nufileUuid;
	private String nufileName;
	private String nufileType;
	
//	getter, setter
	public int getNufileNumber() {
		return nufileNumber;
	}
	public void setNufileNumber(int nufileNumber) {
		this.nufileNumber = nufileNumber;
	}
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
	public String getNufilePath() {
		return nufilePath;
	}
	public void setNufilePath(String nufilePath) {
		this.nufilePath = nufilePath;
	}
	public String getNufileUuid() {
		return nufileUuid;
	}
	public void setNufileUuid(String nufileUuid) {
		this.nufileUuid = nufileUuid;
	}
	public String getNufileName() {
		return nufileName;
	}
	public void setNufileName(String nufileName) {
		this.nufileName = nufileName;
	}
	public String getNufileType() {
		return nufileType;
	}
	public void setNufileType(String nufileType) {
		this.nufileType = nufileType;
	}
	
	@Override
	public String toString() {
		return "AdNutrientsFileDTO [nufileNumber=" + nufileNumber + ", nutrientsNumber=" + nutrientsNumber
				+ ", adminNumber=" + adminNumber + ", nufilePath=" + nufilePath + ", nufileUuid=" + nufileUuid
				+ ", nufileName=" + nufileName + ", nufileType=" + nufileType + "]";
	}
	
	
	
	
	

}
