package com.mama.doc.me;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.MemberDAO;
import com.mama.doc.dto.MemberDTO;

public class ModifyPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		HttpSession session = request.getSession();
		
		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		
		if (session.getAttribute("memberNumber") == null) {
			memberDTO.setMemberNumber(Integer.parseInt(request.getParameter("memberNumber")));
			memberDAO.modifyPw(memberDTO);
			request.getRequestDispatcher("/login.me").forward(request, response);
		} else {
			memberDTO.setMemberNumber((Integer)session.getAttribute("memberNumber"));
			memberDAO.modifyPw(memberDTO);
			request.getRequestDispatcher("/informOk.me").forward(request, response);
		}
		
		return null;
	}

}
