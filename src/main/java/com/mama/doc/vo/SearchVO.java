package com.mama.doc.vo;

public class SearchVO {

	private String cate;
    private String keyword;

    public SearchVO() {
        this.cate = "";
        this.keyword = "";
    }

//  getter,setter
	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
    
}
