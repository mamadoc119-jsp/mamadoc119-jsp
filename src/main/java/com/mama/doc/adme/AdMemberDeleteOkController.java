package com.mama.doc.adme;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdMemberDAO;

public class AdMemberDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		AdMemberDAO adMemberDAO = new AdMemberDAO();
		
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
		
		adMemberDAO.delete(memberNumber);
		
		return null;
	}
	
	

}
