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

public class LoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		MemberDTO member = null;
		
		memberDTO.setMemberEmail(request.getParameter("memberEmail"));
		memberDTO.setMemberPassword(request.getParameter("memberPassword"));
		
		response.setContentType("text/html; charset=utf-8");
		
		try {
			member = memberDAO.login(memberDTO);
			
			if (member == null) {
				String scriptId = "<script>alert('이메일과 비밀번호가 일치하지 않습니다.); location.href='" + request.getContextPath() + "/login/memberLogin.jsp';</script>";
				response.getWriter().println(scriptId);
				return null;
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("memberNumber", member.getMemberNumber());
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("로그인 중 오류가 발생했습니다.");
		}
		
		return null;
	}

}
