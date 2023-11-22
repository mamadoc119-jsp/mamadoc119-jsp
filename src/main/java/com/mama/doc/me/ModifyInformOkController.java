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

public class ModifyInformOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		HttpSession session = request.getSession();
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMemberNumber((Integer)session.getAttribute("memberNumber"));
		memberDTO.setMemberNickname(request.getParameter("memberNickname"));
		memberDTO.setMemberPostCode(request.getParameter("memberPostCode"));
		memberDTO.setMemberAddress(request.getParameter("memberAddress"));
		memberDTO.setMemberExtraAddress(request.getParameter("memberExtraAddress"));
		memberDTO.setMemberDetailAddress(request.getParameter("memberDetailAddress"));
		
		memberDAO.modifyInform(memberDTO);
		
		return null;
	}

}
