package com.mama.doc.addo;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdDoctorDAO;
import com.mama.doc.vo.AdDoctorVO;

public class AdDoctorSelectOneController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		AdDoctorVO adDoctorVO = new AdDoctorVO();
		AdDoctorDAO adDoctorDAO = new AdDoctorDAO();
		Result result = new Result();
		
		int doctorNumber = Integer.parseInt(request.getParameter("doctorNumber"));
		int doctorStauts = Integer.parseInt(request.getParameter("doctorStauts"));
		System.out.println("doctorNumber : "+doctorNumber);
		System.out.println("doctorStauts : "+doctorStauts);
		
		adDoctorVO = adDoctorDAO.selectOne(doctorNumber, doctorStauts);
		
		System.out.println(adDoctorVO);
		
		request.setAttribute("doctor", adDoctorVO);
		
		
		result.setRedirect(false);
		result.setPath("/admin/adminDoctorDetail.jsp");
		
		return result;
	}
	
	

}
