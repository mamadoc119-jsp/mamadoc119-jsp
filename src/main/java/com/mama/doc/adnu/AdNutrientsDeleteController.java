package com.mama.doc.adnu;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdNutrientsDAO;

public class AdNutrientsDeleteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		int nutrientsNumber = Integer.parseInt(request.getParameter("nutrientsNumber"));
		System.out.println("nutrientsNumber : " +nutrientsNumber);
		AdNutrientsDAO adNutrientsDAO = new AdNutrientsDAO();
		
		adNutrientsDAO.delete(nutrientsNumber);
		
		return null;
	}
	
	

}
