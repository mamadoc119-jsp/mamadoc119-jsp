package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.dto.ClinicDTO;

public class ClinicModifyOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		ClinicDTO clinicDTO = new ClinicDTO();
		ClinicDAO clinicDAO = new ClinicDAO();
		try {
			int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
			clinicDTO.setClinicNumber(clinicNumber);
			clinicDTO.setClinicTitle(request.getParameter("clinicTitle"));
			clinicDTO.setClinicContent(request.getParameter("clinicContent"));
			clinicDAO.clinicUpdate(clinicDTO);
		

			result.setRedirect(false);
			result.setPath("/clinic/clinicListOk.cl?");
			
			//result.setPath("/clinic/clinicListOk.cl?clinicNumber=" + clinicNumber);
						
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		return result;

		
	}
	
}
