package com.mama.doc;

public class Result {
	
	   //field
	   private String path;
	   private boolean isRedirect;
	   
	   //constructor
	   public Result() {
	      
	   }
	   
	   //getter, setter
	   public String getPath() {
	      return path;
	   }

	   public void setPath(String path) {
	      this.path = path;
	   }

	   public boolean isRedirect() {
	      return isRedirect;
	   }

	   public void setRedirect(boolean isRedirect) {
	      this.isRedirect = isRedirect;
	   }

}
