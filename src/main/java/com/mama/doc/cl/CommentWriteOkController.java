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
	
		CommentDTO commentDTO = new CommentDTO();
		CommentDAO commentDAO = new CommentDAO();
		
		// test용 임의로 지정///////
    	HttpSession session = request.getSession();
    	session.setAttribute("memberNumber", 2);
    	session.setAttribute("memberNickname", "비이이");
        //여기까지 지우기
		
		int clinicNumber =  Integer.parseInt(request.getParameter("clinicNumber"));
		String commentContent = request.getParameter("commentContent");
		
		String memberNickname = null;
		String doctorNickname = null;
		
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		int doctorNumber = Integer.parseInt(request.getSession().getAttribute("doctorNumber").toString());
		
		// 사용자가 로그인한 경우에만 닉네임 가져오기
		if (request.getSession().getAttribute("memberNumber") != null) {
		    memberNickname = request.getSession().getAttribute("memberNickname").toString();
		} else if (request.getSession().getAttribute("doctorNumber") != null) {
		    doctorNickname = request.getSession().getAttribute("doctorNickname").toString();
		}
		
		commentDTO.setClinicNumber(clinicNumber);
		commentDTO.setMemberNumber(memberNumber);
		commentDTO.setDoctorNumber(doctorNumber);
		commentDTO.setCommentContent(commentContent);
		commentDTO.setDoctorNickname(doctorNickname);
	    commentDTO.setMemberNickname(memberNickname);
	       
		commentDAO.insertComment(commentDTO);
		
		
		
		return null;
	}

}
