package com.mama.doc.pr;

import java.io.IOException;
import java.rmi.ServerException;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.dto.ClinicDTO;
import com.mama.doc.dto.PrecautionDTO;

public class PrecautionModifyOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

//		PrecautionDAO precautionDAO = new PrecautionDAO();
//		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
//		
//		PrecautionDTO precautionDTO = new PrecautionDTO();
////	      Date date = new Date(); precautionDate Date가 아닌 String으로 수정
//	      HttpSession session = request.getSession();
//	      
//	      precautionDTO.setPrecautionNumber(precautionNumber);
//	      precautionDTO.setDoctorNumber((Integer)session.getAttribute("doctorNumber"));
//	      precautionDTO.setPrecautionTitle(request.getParameter("precautionTitle"));
//	      precautionDTO.setPrecautionContent(request.getParameter("precautionContent"));
//	      precautionDTO.setPrecautionDate("precautionDate");
//	      
//	      
//	      System.out.println(precautionDTO);
//	      precautionDAO.update(precautionDTO);
//	      response.sendRedirect("/precaution/precautionModifyOk.pr?precautionNumber="+ precautionNumber);
		
//	      return null;
		
		Result result = new Result();
		
		PrecautionDTO precautionDTO = new PrecautionDTO();
		PrecautionDAO precautionDAO = new PrecautionDAO();
		
		
		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		
		System.out.println("check precautionNumber = " + precautionNumber );
		
		precautionDTO.setPrecautionNumber(precautionNumber);
		precautionDTO.setPrecautionTitle(request.getParameter("precautionTitle"));
		precautionDTO.setPrecautionContent(request.getParameter("precautionContent"));
		precautionDTO.setPrecautionDate(request.getParameter("precautionDate"));
		precautionDAO.update(precautionDTO);
		
	

		result.setRedirect(false);
		result.setPath("/precaution/precautionDetailOk.pr?precautionNumber=" + precautionNumber);
						
		
		
		return result;

		
	}
	      
	}


