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

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO doctorDTO = new DoctorDTO();
		Result result = new Result();
		
		doctorDTO.setDoctorEmail(request.getParameter("doctorEmail"));
		doctorDTO.setDoctorPassword(request.getParameter("doctorPassword"));
		doctorDTO.setDoctorName(request.getParameter("doctorName"));
		doctorDTO.setDoctorNickname(request.getParameter("doctorNickname"));
		doctorDTO.setDoctorPostCode(request.getParameter("doctorPostCode"));
		doctorDTO.setDoctorAddress(request.getParameter("doctorAddress"));
		doctorDTO.setDoctorExtraAddress(request.getParameter("doctorExtraAddress"));
		doctorDTO.setDoctorDetailAddress(request.getParameter("doctorDetailAddress"));
		doctorDTO.setDoctorLicense(request.getParameter("doctorLicense"));
		doctorDTO.setDoctorMajor(request.getParameter("doctorMajor"));
		
		doctorDAO.join(doctorDTO);
		
		result.setRedirect(true);
		result.setPath(request.getContextPath());
		
		return result;
	}

}
