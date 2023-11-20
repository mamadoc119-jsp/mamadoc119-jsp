package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;

public class ClinicDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
	
		Result result = new Result();
		ClinicDAO clinicDAO =new ClinicDAO();
		
		try {
			int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
			clinicDAO.clinicDelete(clinicNumber);
		
			result.setRedirect(false);
			result.setPath("/clinic/clinicListOk.cl");
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		return result;
	}

}
