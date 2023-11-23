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
		

        // 세션에서 사용자의 닉네임 가져오기
        HttpSession session = request.getSession();
    
    	System.out.println("*******들어오와아아ㅗㅘㅇ2222222");
		int clinicNumber =  Integer.parseInt(request.getParameter("clinicNumber"));
		
		
		//게시글번호 들어옴 확인
		System.out.println("clinicNumber******-----::: " + clinicNumber);
		
		String commentContent = request.getParameter("commentContent");
		
		if(request.getSession().getAttribute("doctorNumber") == null) {
			System.out.println("회원 댓글작성 완료");
			int memberNumber = (int) request.getSession().getAttribute("memberNumber");
			
			commentDTO.setClinicNumber(clinicNumber);
			commentDTO.setMemberNumber(memberNumber);
			commentDTO.setCommentContent(commentContent);
		    
		    commentDAO.insertComment(commentDTO);
		}else {

			System.out.println("닥터로 댓글작성 완료");
			int doctorNumber = (int)request.getSession().getAttribute("doctorNumber") ;
			String doctorNickname = (String)request.getSession().getAttribute("doctorNickname");
			
			commentDTO.setClinicNumber(clinicNumber);
			commentDTO.setDoctorNumber(doctorNumber);
			commentDTO.setCommentContent(commentContent);
			
			commentDAO.insertCommentDo(commentDTO);
		}
		


		
		
		System.out.println("오니마니!!!!");
	
		
		return null;
	}

}
