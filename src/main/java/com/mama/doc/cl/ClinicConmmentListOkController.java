package com.mama.doc.cl;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.CommentDAO;
import com.mama.doc.dto.CommentDTO;

public class ClinicConmmentListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		CommentDAO commentDAO = new CommentDAO();
		
		int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
		List<CommentDTO> commentList = commentDAO.getCommentList(clinicNumber);
		
		PrintWriter out = response.getWriter();
		
		JSONArray comments = new JSONArray();
		
		for(CommentDTO comment : commentList) {
			JSONObject obj = new JSONObject();
			obj.put("commentNumber", comment.getCommentNumber());
			obj.put("memberNumber", comment.getMemberNumber());
			obj.put("commentContent", comment.getCommentContent());
			comments.add(obj);
		}
		
		out.println(comments.toJSONString());
		out.close();
		
		
		
		return null;
	}

}
