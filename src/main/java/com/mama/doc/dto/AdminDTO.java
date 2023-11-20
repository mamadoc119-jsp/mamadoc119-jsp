package com.mama.doc.dto;

public class AdminDTO {

	//필드
	private int adminNumber;
	private String adminId;
	private String adminPassword;
	
	
	//getter
	public int getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassWord() {
		return adminPassword;
	}
	public void setAdminPassWord(String adminPw) {
		this.adminPassword = adminPw;
	}
	
	@Override
	public String toString() {
		return "AdminDTO [adminNumber=" + adminNumber + ", adminId=" + adminId + ", adminPw=" + adminPassword + "]";
	}
}
