package com.mama.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Execute {
	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException,ServletException, ServerException;
	
}

