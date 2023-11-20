package com.mama.doc.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;

public class QuitOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		HttpSession session = request.getSession();
		DoctorDAO doctorDAO = new DoctorDAO();
		
		doctorDAO.quit((Integer)session.getAttribute("doctorNumber"));
		
		session.invalidate();
		
		return null;
	}

}
