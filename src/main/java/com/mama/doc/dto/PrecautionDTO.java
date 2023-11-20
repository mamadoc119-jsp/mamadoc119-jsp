package com.mama.doc.dto;

import java.util.Date;

public class PrecautionDTO {
	
	private int precautionNumber;
    private int doctorNumber;
    private String precautionTitle;
    private String precautionContent;
    private Date precautionDate;
    
    
    // Getter, Setter
    
	public int getPrecautionNumber() {
		return precautionNumber;
	}
	public void setPrecautionNumber(int precautionNumber) {
		this.precautionNumber = precautionNumber;
	}
	public int getDoctorNumber() {
		return doctorNumber;
	}
	public void setDoctorNumber(int doctorNumber) {
		this.doctorNumber = doctorNumber;
	}
	public String getPrecautionTitle() {
		return precautionTitle;
	}
	public void setPrecautionTitle(String precautionTitle) {
		this.precautionTitle = precautionTitle;
	}
	public String getPrecautionContent() {
		return precautionContent;
	}
	public void setPrecautionContent(String precautionContent) {
		this.precautionContent = precautionContent;
	}
	public Date getPrecautionDate() {
		return precautionDate;
	}
	public void setPrecautionDate(Date precautionDate) {
		this.precautionDate = precautionDate;
	}
	
	
	@Override
	public String toString() {
		return "PrecautionVO [precautionNumber=" + precautionNumber + ", doctorNumber=" + doctorNumber
				+ ", precautionTitle=" + precautionTitle + ", precautionContent=" + precautionContent
				+ ", precautionDate=" + precautionDate + "]";
	}

}
