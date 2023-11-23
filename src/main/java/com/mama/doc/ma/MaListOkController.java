package com.mama.doc.ma;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.vo.ClinicVO;
import com.mama.doc.dao.MainPageDAO;
import com.mama.doc.vo.AdNutrientsVO;
import com.mama.doc.vo.PrecautionVO;


public class MaListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		// TODO Auto-generated method stub
		
		Result result = new Result();

	
		MainPageDAO mainPageDAO = new MainPageDAO();
//		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		List<AdNutrientsVO> nuList = mainPageDAO.selectNutrientsList();
		List<PrecautionVO> prList = mainPageDAO.selectPrecautionList();
		List<ClinicVO> clList = mainPageDAO.selectClinicList();
		
		
		request.setAttribute("nuList", nuList);
		request.setAttribute("prList", prList);
		request.setAttribute("clList", clList);
		result.setRedirect(false);
		result.setPath("/mainPage.jsp");	
		
		return result;
		
	}
	
	

}
