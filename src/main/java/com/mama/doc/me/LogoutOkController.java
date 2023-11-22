package com.mama.doc.me;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;

public class LogoutOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("로그아웃 실행");
		
		try {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
