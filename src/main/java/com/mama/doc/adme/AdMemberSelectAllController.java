package com.mama.doc.adme;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdMemberDAO;
import com.mama.doc.dto.AdMemberDTO;

public class AdMemberSelectAllController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		AdMemberDAO adMemberDAO = new AdMemberDAO();
		
		List<AdMemberDTO> list = adMemberDAO.selectMeAll();
		
		request.setAttribute("meList", list);
		
		request.getRequestDispatcher("/admin/adminMain.jsp").forward(request, response);
		
		return null;
	}
	
	

}
