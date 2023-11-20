package com.mama.doc.vo;

public class AdNutrientsVO {

	//필드
	private int nutrientsNumber;
	private int adminNumber;
	private String nutrientsName;
	private String nutrientsEffect;
	private String nutrientsInfo;
	private String nutrientsDate;
	private int nufileNumber;
	private String nufilePath;
	private String nufileUuid;
	private String nufileName;
	private String nufileType;
	
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
	public int getNufileNumber() {
		return nufileNumber;
	}
	public void setNufileNumber(int nufileNumber) {
		this.nufileNumber = nufileNumber;
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
		return "AdNutrientsVO [nutrientsNumber=" + nutrientsNumber + ", adminNumber=" + adminNumber + ", nutrientsName="
				+ nutrientsName + ", nutrientsEffect=" + nutrientsEffect + ", nutrientsInfo=" + nutrientsInfo
				+ ", nutrientsDate=" + nutrientsDate + ", nufileNumber=" + nufileNumber + ", nufilePath=" + nufilePath
				+ ", nufileUuid=" + nufileUuid + ", nufileName=" + nufileName + ", nufileType=" + nufileType + "]";
	}
	
	
	
	
	
}
