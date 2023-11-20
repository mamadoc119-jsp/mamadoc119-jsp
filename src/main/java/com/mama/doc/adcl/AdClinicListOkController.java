package com.mama.doc.adcl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdClinicDAO;

public class AdClinicListOkController implements Execute{
	@Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 AdClinicDAO adClinicDAO = new AdClinicDAO();
		 System.out.println("AdClinicListOkController 실행");
	      
	      request.setAttribute("adClinicList", adClinicDAO.adClinicList());
	      
	      return null;
	   }
}
