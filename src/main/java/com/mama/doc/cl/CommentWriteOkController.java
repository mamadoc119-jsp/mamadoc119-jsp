package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int clinicNumber =  Integer.parseInt(request.getParameter("clinicNumber"));
		int memberNumber = Integer.parseInt(request.getSession().getAttribute("memberNumber").toString());
		int doctorNumber = Integer.parseInt(request.getSession().getAttribute("doctorNumber").toString());
		String commentContent = request.getParameter("commentContent");
		String doctorNickname = request.getSession().getAttribute("doctorNickname").toString();
	    String memberNickname = request.getSession().getAttribute("memberNickname").toString();

		
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
