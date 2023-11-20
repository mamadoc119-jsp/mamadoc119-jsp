package com.mama.doc.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;

public class CheckEmailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		String scriptId = null;
		
		int exist = doctorDAO.checkEmail(request.getParameter("doctorEmail"));
		
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println(exist);
		
		if (exist > 0 ) {
			scriptId = "<script>alert('중복된 이메일입니다.');</script>";
			response.getWriter().println(scriptId);
			return null;
		} else {
			scriptId = "<script>alert('확인중');</script>";
			response.getWriter().println(scriptId);
		}
		
		return null;
	}

}
