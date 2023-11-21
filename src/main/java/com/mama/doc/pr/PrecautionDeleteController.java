package com.mama.doc.pr;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.dao.PrecautionDAO;

public class PrecautionDeleteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
//		PrecautionDAO precautionDAO = new PrecautionDAO();
//		
//		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
//		
//		precautionDAO.delete(precautionNumber);
//		request.getRequestDispatcher("/precaution/precautionListOk.pr").forward(request, response);
//		
//		return null;
//	}
	
		Result result = new Result();
		PrecautionDAO precautionDAO =new PrecautionDAO();
		

		
		try {
			int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
			precautionDAO.delete(precautionNumber);
		
			result.setRedirect(false);
			result.setPath("/precaution/precautionListOk.pr");
			
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		
		
		
		return result;

	}
}
