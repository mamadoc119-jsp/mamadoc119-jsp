package com.mama.doc.pr;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.vo.ClinicVO;
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.vo.PrecautionVO;

public class PrecautionDetailController implements Execute{
	
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Result result = new Result();
		
		PrecautionDAO precautionDAO = new PrecautionDAO();
		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		PrecautionVO precautionVO = precautionDAO.selectOne(precautionNumber);

		System.out.println(precautionVO);
		
		request.setAttribute("precaution", precautionVO);
		result.setRedirect(false);
		result.setPath("/precaution/precautionDetail.jsp");	
		
		return result;
		
		
//		request.setAttribute("precautionVO", precautionVO);
//	
//		// 상세페이지로 이동
//        String forwardPath = "/precaution/precautionDetail.jsp";
//        result.setRedirect(false);
//        result.setPath(forwardPath);
//
//        return result;
		
	}


}
