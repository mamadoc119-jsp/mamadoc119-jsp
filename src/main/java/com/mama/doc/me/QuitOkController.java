package com.mama.doc.me;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.MemberDAO;

public class QuitOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		HttpSession session = request.getSession();
		MemberDAO memberDAO = new MemberDAO();
		
		memberDAO.quit((Integer)session.getAttribute("memberNumber"));
		
		session.invalidate();
		
		return null;
	}

}
