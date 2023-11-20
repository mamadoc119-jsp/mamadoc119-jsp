package com.mama.doc.pr;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.dto.PrecautionDTO;

public class PrecautionModifyOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {

		PrecautionDAO precautionDAO = new PrecautionDAO();
		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		
		PrecautionDTO precautionDTO = new PrecautionDTO();
	      Date date = new Date();
	      HttpSession session = request.getSession();
	      
	      precautionDTO.setPrecautionNumber(precautionNumber);
	      precautionDTO.setDoctorNumber((Integer)session.getAttribute("doctorNumber"));
	      precautionDTO.setPrecautionTitle(request.getParameter("precautionTitle"));
	      precautionDTO.setPrecautionContent(request.getParameter("precautionContent"));
	      precautionDTO.setPrecautionDate(date);
	      
	      
	      System.out.println(precautionDTO);
	      precautionDAO.update(precautionDTO);
	      response.sendRedirect("/precaution/precautionDetailOk.fr?freeboardNum="+ precautionNumber);
	      return null;
	}

}
