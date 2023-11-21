package com.mama.doc.adnu;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdNutrientsDAO;
import com.mama.doc.dto.AdNutrientsDTO;
import com.mama.doc.dto.AdNutrientsFileDTO;

public class AdNutrientsSelectOneController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		// TODO Auto-generated method stub
		AdNutrientsDTO adNutrientsDTO = new AdNutrientsDTO();
		AdNutrientsFileDTO adNutrientsFileDTO = new AdNutrientsFileDTO();
		AdNutrientsDAO adNutrientsDAO = new AdNutrientsDAO();
		Result result = new Result();
		
		int nutrientsNumber = Integer.parseInt(request.getParameter("nutrientsNumber"));
		
		adNutrientsDTO = adNutrientsDAO.selectOne(nutrientsNumber);
		System.out.println(adNutrientsDTO);
		request.setAttribute("nu", adNutrientsDTO);
		
		
		adNutrientsFileDTO = adNutrientsDAO.selectImg(nutrientsNumber);
		System.out.println(adNutrientsFileDTO);
		request.setAttribute("img", adNutrientsFileDTO);
		
		
		
		result.setRedirect(false);
		result.setPath("/admin/adminNutrientsUpdate.jsp");
		return result;
	}
	
	

}
