package com.mama.doc.me;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.MemberDAO;
import com.mama.doc.dto.MemberDTO;

public class JoinOkController implements Execute{
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		Date date = new Date();
		
		System.out.println("컨트롤러");
		
		memberDTO.setMemberName(request.getParameter("memberName"));
		memberDTO.setMemberEmail(request.getParameter("memberEmail"));
		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		memberDTO.setMemberNickname(request.getParameter("memberNickname"));
		memberDTO.setMemberPostCode(request.getParameter("memberPostCode"));
		memberDTO.setMemberAddress(request.getParameter("memberAddress"));
		memberDTO.setMemberDetailAddress(request.getParameter("memberDetailAddress"));
		memberDTO.setMemberExtraAddress(request.getParameter("memberExtraAddress"));
		memberDTO.setUserJoindate(date);
		
		System.out.println(memberDTO);
		
		memberDAO.join(memberDTO);
		response.sendRedirect("/mamadoc/login/login.me");
		return null;
	}
}
