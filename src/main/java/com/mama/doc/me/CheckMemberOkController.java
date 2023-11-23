package com.mama.doc.me;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.MemberDAO;
import com.mama.doc.dto.MemberDTO;

public class CheckMemberOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		int memberNumber = 0;
		
		memberDTO.setMemberEmail(request.getParameter("memberEmail"));
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberNumber = memberDAO.checkMember(memberDTO);
		
		request.setAttribute("memberNumber", memberNumber);
		
		return null;
	}

}
