package com.mama.doc.adnu;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.AdNutrientsDAO;
import com.mama.doc.vo.AdNutrientsVO;

public class AdNutrientsSelectUserAllController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		AdNutrientsDAO adNutrientsDAO = new AdNutrientsDAO();
		
//		영양제 리스트 불러오기(파일 포함)
		List<AdNutrientsVO> list = adNutrientsDAO.selectUserAll();
		
		System.out.println(list);
		
		request.setAttribute("nuList", list);
		request.getRequestDispatcher("/nutrients/nutrientsList.jsp").forward(request, response);
		
		
		return null;
	}
	
	

}
