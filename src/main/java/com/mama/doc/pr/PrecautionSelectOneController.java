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
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.vo.PrecautionVO;

public class PrecautionSelectOneController implements Execute{
	
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrecautionDAO precautionDAO = new PrecautionDAO();
		int precautionNumber = Integer.parseInt(request.getParameter("precautionNumber"));
		PrecautionVO precautionVO = precautionDAO.selectOne(precautionNumber);
		
		Map<String, Object> precautionInfo = new HashMap<>();
		precautionInfo.put("precautionNumber", precautionNumber);
		precautionInfo.put("doctorNumber", precautionVO.getDoctorNumber());
		precautionInfo.put("doctorNickName", precautionVO.getDoctorNickname());
		precautionInfo.put("precautionTitle", precautionVO.getPrecautionTitle());
		precautionInfo.put("precautionContent", precautionVO.getPrecautionContent());
		precautionInfo.put("precautionDate", precautionVO.getPrecautionDate());
		
		
		request.setAttribute("precaution", precautionInfo);
		System.out.println(precautionVO);
		request.getRequestDispatcher("/precaution/precautionDetail.jsp?precautionNumber=" + precautionNumber).forward(request, response);
		
		return null;
		
	}


}
