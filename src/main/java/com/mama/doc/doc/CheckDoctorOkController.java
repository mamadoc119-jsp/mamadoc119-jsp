package com.mama.doc.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;
import com.mama.doc.dto.DoctorDTO;

public class CheckDoctorOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO doctorDTO = new DoctorDTO();
		int doctorNumber = 0;
		
		doctorDTO.setDoctorEmail(request.getParameter("doctorEmail"));
		doctorDTO.setDoctorName(request.getParameter("doctorName"));
		doctorNumber = doctorDAO.checkDoctor(doctorDTO);
		
		request.setAttribute("doctorNumber", doctorNumber);
		
		return null;
	}

}
