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

public class ModifyPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO doctorDTO = new DoctorDTO();
		HttpSession session = request.getSession();
		
		doctorDTO.setDoctorPassword(request.getParameter("doctorPassword"));
		
		if (session.getAttribute("doctorNumber") == null) {
			doctorDTO.setDoctorNumber(Integer.parseInt(request.getParameter("doctorNumber")));
			doctorDAO.modifyPw(doctorDTO);
			request.getRequestDispatcher("/login.do").forward(request, response);
		} else {
			doctorDTO.setDoctorNumber((Integer)session.getAttribute("doctorNumber"));
			doctorDAO.modifyPw(doctorDTO);
			request.getRequestDispatcher("/informOk.do").forward(request, response);
		}
		
		return null;
	}

}
