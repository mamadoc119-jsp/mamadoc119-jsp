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

public class CommentModifyOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CommentDAO commentDAO = new CommentDAO();
		CommentDTO commentDTO = new CommentDTO();
		
		int commentNumber = Integer.parseInt(request.getParameter("commentNumber"));
		String commentContent = request.getParameter("commentContent");
		
		commentDTO.setCommentNumber(commentNumber);
		commentDTO.setCommentContent(commentContent);
		
		commentDAO.updateComment(commentDTO);
		
	
		return null;
	}

}
