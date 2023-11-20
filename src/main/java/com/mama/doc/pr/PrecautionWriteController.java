package com.mama.doc.pr;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.dto.PrecautionDTO;

public class PrecautionWriteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrecautionDAO precautionDAO = new PrecautionDAO();
		PrecautionDTO precautionDTO = new PrecautionDTO();
		Date date = new Date();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		Integer doctorNumber = (Integer)session.getAttribute("doctorNumber");
		System.out.println("check DoctorNumber : "+ doctorNumber);
		
		
		precautionDTO.setDoctorNumber(doctorNumber);
		precautionDTO.setPrecautionTitle(request.getParameter("precautionTitle"));
		precautionDTO.setPrecautionContent(request.getParameter("precautionContent"));
		precautionDTO.setPrecautionDate(date);

		
		System.out.println(precautionDTO);
		
		precautionDAO.write(precautionDTO);
		response.sendRedirect("/precaution/precautionListOk.pr");
		return null;
		
	}

}
