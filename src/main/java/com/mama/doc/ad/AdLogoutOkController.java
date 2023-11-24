package com.mama.doc.ad;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;

public class AdLogoutOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		Result result = new Result();
		
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("실행");
		
		result.setRedirect(false);
		result.setPath("/adminLogin.ad");
			
		return result;
		
	}

	
	
}
