package com.mama.doc.me;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.MemberDAO;

public class CheckNicknameOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		MemberDAO memberDAO = new MemberDAO();
		
		int count = memberDAO.checkNickname(request.getParameter("memberNickname"));
		System.out.println(count);
		
		JSONObject jObj = new JSONObject();
		jObj.put("count", count);
		
		response.setContentType("application/x-json; charset=utf-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
