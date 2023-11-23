package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.cl.vo.ClinicVO;

public class ClinicDetailOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
			Result result = new Result();
			ClinicDAO clinicDAO = new ClinicDAO();
			
//			HttpSession session = request.getSession();
//	    	session.setAttribute("memberNumber", 2);
//	    	session.setAttribute("memberNickname", "비이이");
//	    	
//			session.setAttribute("doctorNumber", 1);
//	    	session.setAttribute("doctorNickname", "난의사야");
//	    	session.setAttribute("doctorStatus", 1);
			
			int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
			
			ClinicVO clinicDetail = clinicDAO.getClinicDetail(clinicNumber);
			
			request.setAttribute("clinicDetail", clinicDetail);
		
			// 상세페이지로 이동
	        String forwardPath = "/clinic/clinicDetail.jsp";
	        result.setRedirect(false);
	        result.setPath(forwardPath);

	        return result;
	}

}
