package com.mama.doc.dto;

public class AdDoctorFileDTO {

//	필드
	private int dofileNumber;
	private int doctorNumber;
	private String dofilePath;
	private String dofileUuid;
	private String dofileName;
	private String dofileType;
	
//	getter,setter
	public int getDofileNumber() {
		return dofileNumber;
	}
	public void setDofileNumber(int dofileNumber) {
		this.dofileNumber = dofileNumber;
	}
	public int getDoctorNumber() {
		return doctorNumber;
	}
	public void setDoctorNumber(int doctorNumber) {
		this.doctorNumber = doctorNumber;
	}
	public String getDofilePath() {
		return dofilePath;
	}
	public void setDofilePath(String dofilePath) {
		this.dofilePath = dofilePath;
	}
	public String getDofileUuid() {
		return dofileUuid;
	}
	public void setDofileUuid(String dofileUuid) {
		this.dofileUuid = dofileUuid;
	}
	public String getDofileName() {
		return dofileName;
	}
	public void setDofileName(String dofileName) {
		this.dofileName = dofileName;
	}
	public String getDofileType() {
		return dofileType;
	}
	public void setDofileType(String dofileType) {
		this.dofileType = dofileType;
	}
	
	@Override
	public String toString() {
		return "AdDoctorFileDTO [dofileNumber=" + dofileNumber + ", doctorNumber=" + doctorNumber + ", dofilePath="
				+ dofilePath + ", dofileUuid=" + dofileUuid + ", dofileName=" + dofileName + ", dofileType="
				+ dofileType + "]";
	}
	
	
	
	
}
