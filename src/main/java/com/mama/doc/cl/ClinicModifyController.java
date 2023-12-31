package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;

public class ClinicModifyController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		System.out.println("여기까지 오나?");
	

		ClinicDAO clinicDAO = new ClinicDAO();
		int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
		
		
		request.setAttribute("clinic", clinicDAO.getClinicDetail(clinicNumber));
		request.getRequestDispatcher("/clinic/clinicModify.jsp?clinicNumber="+ clinicNumber).forward(request, response);
		
		
		return null;
	}

}
