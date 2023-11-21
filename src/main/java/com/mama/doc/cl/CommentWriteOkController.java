package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.CommentDAO;
import com.mama.doc.dto.CommentDTO;

public class CommentWriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("*******들어오와아아ㅗㅘㅇ");
		CommentDTO commentDTO = new CommentDTO();
		CommentDAO commentDAO = new CommentDAO();
		
    	System.out.println("*******들어오와아아ㅗㅘㅇ2222222");
		int clinicNumber =  Integer.parseInt(request.getParameter("clinicNumber"));
		String commentContent = request.getParameter("commentContent");
		
		if(request.getSession().getAttribute("doctorStatus") == null) {
			System.out.println("닥터로 댓글작성 완료");
			String memberNickname = (String) request.getSession().getAttribute("memberNickname");
			int memberNumber = (int) request.getSession().getAttribute("memberNumber");
			
			commentDTO.setClinicNumber(clinicNumber);
			commentDTO.setMemberNumber(memberNumber);
			commentDTO.setCommentContent(commentContent);
		    commentDTO.setMemberNickname(memberNickname);
		    
		    commentDAO.insertComment(commentDTO);
		}else {

			System.out.println("닥터로 댓글작성 완료");
			int doctorNumber = (int)request.getSession().getAttribute("doctorNumber") ;
			String doctorNickname = (String)request.getSession().getAttribute("doctorNickname");
			
			commentDTO.setClinicNumber(clinicNumber);
			commentDTO.setDoctorNumber(doctorNumber);
			commentDTO.setCommentContent(commentContent);
			commentDTO.setDoctorNickname(doctorNickname);
			
			commentDAO.insertCommentDo(commentDTO);
		}
		


		
		
		System.out.println("오니마니!!!!");
	
		
		System.out.println("*******들어오와아아ㅗㅘㅇ444444444");
		

	       
		
		
		System.out.println("*******들어오와아아ㅗㅘㅇ55555555555");
		
		return null;
	}

}
