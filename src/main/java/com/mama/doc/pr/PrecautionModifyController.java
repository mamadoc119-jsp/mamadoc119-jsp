package com.mama.doc.pr;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.PrecautionDAO;

public class PrecautionModifyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		Result result = new Result();
		PrecautionDAO precautionDAO = new PrecautionDAO();
		
		System.out.println(request.getParameter("precautionNumber"));
		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		
		request.setAttribute("precaution", precautionDAO.selectOne(precautionNumber));
		
		result.setRedirect(false);
		result.setPath("/precaution/precautionModify.jsp");	
		
		return result;
	}

}
