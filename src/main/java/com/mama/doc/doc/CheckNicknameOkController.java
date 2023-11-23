package com.mama.doc.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;

public class CheckNicknameOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		
		int count = doctorDAO.checkNickname(request.getParameter("doctorNickname"));
		System.out.println(count);
		
		JSONObject jObj = new JSONObject();
		jObj.put("count", count);
		
		response.setContentType("application/x-json; charset=utf-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
