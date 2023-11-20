package com.mama.doc.adpr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdPrDAO;

public class AdPrListOkController implements Execute{
	@Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 AdPrDAO adPrDAO = new AdPrDAO();
		 System.out.println("AdPrListController 실행");
	      
	      request.setAttribute("adPrList", adPrDAO.adPrList());
	      
	      return null;
	   }
}
