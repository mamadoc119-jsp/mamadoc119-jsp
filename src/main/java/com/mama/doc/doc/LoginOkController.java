package com.mama.doc.doc;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;
import com.mama.doc.dto.DoctorDTO;

public class LoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO doctorDTO = new DoctorDTO();
		DoctorDTO doctor = null;
		
		doctorDTO.setDoctorEmail(request.getParameter("doctorEmail"));
		doctorDTO.setDoctorPassword(request.getParameter("doctorPassword"));
		
		response.setContentType("text/html; charset=utf-8");
		
		try {
			doctor = doctorDAO.login(doctorDTO);
			
			if (doctor == null) {
				String scriptId = "<script>alert('이메일과 비밀번호가 일치하지 않습니다.'); location.href='" + request.getContextPath() + "/login/doctorLogin.jsp';</script>";
				response.getWriter().println(scriptId);
				return null;
			}
			
			// 회원 정보를 세션에 저장
			HttpSession session = request.getSession();
			session.setAttribute("doctorNumber", doctor.getDoctorNumber());
			response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			// 예외 처리 로직 추가
			e.printStackTrace();
			// 에러 메시지를 클라이언트에 전달하는 방법 추가
			response.getWriter().println("로그인 중 오류가 발생했습니다.");
		}
		
		return null;
	}

}
