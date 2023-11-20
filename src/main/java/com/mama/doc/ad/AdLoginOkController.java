package com.mama.doc.ad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdminDAO;
import com.mama.doc.dto.AdminDTO;

public class AdLoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		AdminDAO adminDAO = new AdminDAO();
		AdminDTO adminDTO = new AdminDTO();
		
		adminDTO.setAdminId(request.getParameter("adminId"));
		adminDTO.setAdminPassWord(request.getParameter("adminPassword"));
		adminDTO = adminDAO.logIn(adminDTO);
		System.out.println(adminDTO);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("adminNumber", adminDTO.getAdminNumber());
		session.setAttribute("adminId", adminDTO.getAdminId());
		
		
		System.out.println("관리자 번호 : "+adminDTO.getAdminNumber());
		System.out.println("관리자 아이디 : "+adminDTO.getAdminId());
		
		response.sendRedirect("/mamadoc/adminMain.adme");
		
		return null;
		
	}
	
	
}
