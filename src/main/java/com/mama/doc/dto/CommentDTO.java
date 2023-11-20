package com.mama.doc.dto;

public class CommentDTO {
//    comment_number NUMBER NOT NULL,
//    doctor_number NUMBER,
//    member_number NUMBER,
//    clinic_number NUMBER NOT NULL,
//    comment_content VARCHAR2(1000),
//    comment_date DATE DEFAULT SYSDATE,
	
	
	private int commentNumber;
	private int doctorNumber;
	private int memberNumber;
	private int clinicNumber;
	private String doctorNickname;
	private String memberNickname;
	private String commentContent;
	private String commentDate;

	
	public CommentDTO() {;}


	public int getCommentNumber() {
		return commentNumber;
	}


	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}


	public int getDoctorNumber() {
		return doctorNumber;
	}


	public void setDoctorNumber(int doctorNumber) {
		this.doctorNumber = doctorNumber;
	}


	public int getMemberNumber() {
		return memberNumber;
	}


	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}


	public int getClinicNumber() {
		return clinicNumber;
	}


	public void setClinicNumber(int clinicNumber) {
		this.clinicNumber = clinicNumber;
	}


	public String getDoctorNickname() {
		return doctorNickname;
	}


	public void setDoctorNickname(String doctorNickname) {
		this.doctorNickname = doctorNickname;
	}


	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	public String getCommentContent() {
		return commentContent;
	}


	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}


	public String getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}



}
