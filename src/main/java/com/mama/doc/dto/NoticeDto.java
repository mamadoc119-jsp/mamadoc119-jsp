package com.mama.doc.dto;

public class NoticeDto {
	private Long noticeNumber;
	private Long adminNumber;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Long getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(Long noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	
	public Long getAdminNumber() {
		return adminNumber;
	}
	public void setAdminNumber(Long adminNumber) {
		this.adminNumber = adminNumber;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	@Override
	public String toString() {
		return "NoticeDto [noticeNumber=" + noticeNumber + ", adminNumber=" + adminNumber + ", noticeTitle="
				+ noticeTitle + ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + "]";
	}
	
}
