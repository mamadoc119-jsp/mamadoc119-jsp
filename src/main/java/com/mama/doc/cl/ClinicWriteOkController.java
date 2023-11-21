package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.dto.ClinicDTO;

public class ClinicWriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,ServerException {
		Result result =  new Result();
		
		try {

			//test용 임의로 지정///////
			HttpSession session = request.getSession();
			session.setAttribute("memberNumber", 2);
			session.setAttribute("memberNickname", "비이이");
			
		
			
			
		String clinicTitle = request.getParameter("clinicTitle");
		String clinicContent = request.getParameter("clinicContent");
		
		
		ClinicDTO clinicDTO = new ClinicDTO();
		clinicDTO.setClinicTitle(clinicTitle);
		clinicDTO.setClinicContent(clinicContent);
	
	
	  //  HttpSession session = request.getSession();
      //  int memberNumber = (int) session.getAttribute("member_number");
	  //  String memberNickname = (String) session.getAttribute("member_nickname");
      //  clinicDTO.setMemberNumber(memberNumber);
		//나중에 test용 임의 지우고 여기 주석 풀고 아래도 지우기
	
		int memberNumber = (int) session.getAttribute("memberNumber");
		clinicDTO.setMemberNumber(memberNumber);
		
		ClinicDAO clinicDAO = new ClinicDAO();
		boolean success = clinicDAO.clinicWrite(clinicDTO);
		
		if(success) {
			//저장성공이 되면
			result.setRedirect(true);
			result.setPath("/clinic/clinicListOk.cl");
			 //저장하면 정보를 가지고 목록으로 이동
		} else {
			result.setRedirect(false);
			result.setPath("/clinic/clinicWrite.jsp");
		}
		
		
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		return result;
		
	}

}
