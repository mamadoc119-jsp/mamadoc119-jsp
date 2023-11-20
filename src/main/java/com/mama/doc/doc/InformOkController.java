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
import com.mama.doc.dto.DoctorDTO;

public class InformOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		HttpSession session = request.getSession();
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO result = null;
		
		int doctorNumber = (Integer)session.getAttribute("doctorNumber");
		
		result = doctorDAO.inform(doctorNumber);
		
		request.setAttribute("inform", result);
		
		return null;
	}

}
