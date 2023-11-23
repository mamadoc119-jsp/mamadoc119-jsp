package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.CommentDAO;

public class CommentDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		CommentDAO commentDAO = new CommentDAO();
		int commentNumber = Integer.parseInt(request.getParameter("commentNumber"));
		
		commentDAO.deleteComment(commentNumber);
		
		
		return null;
	}

}
