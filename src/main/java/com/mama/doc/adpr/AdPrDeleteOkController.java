package com.mama.doc.adpr;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdPrDAO;

public class AdPrDeleteOkController implements Execute{
	@Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException, ServletException {
			Result result = null;
			System.out.println("AdPrDeleteController 실행");
	
			AdPrDAO adPrDao = new AdPrDAO();
			
			long precautionNumber = Long.parseLong(request.getParameter("precautionNumber"));
			adPrDao.adPrDelete(precautionNumber); 
			
			return null;
	   }
}
