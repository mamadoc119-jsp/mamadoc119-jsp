package com.mama.doc.adcl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdClinicDAO;

public class AdClinicDeleteOkController implements Execute{
	@Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException, ServletException {
			Result result = null;
			System.out.println("AdClinicDeleteController 실행");
	
			AdClinicDAO adClinicDao = new AdClinicDAO();
			
			long clinicNumber = Long.parseLong(request.getParameter("clinicNumber"));
			adClinicDao.adClinicDelete(clinicNumber); 
			
			return null;
	   }

}
