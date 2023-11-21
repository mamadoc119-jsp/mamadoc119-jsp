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

		
		CommentDAO commentDAO = new CommentDAO();
		//게시글 번호를 받는다 
		int clinicNumber = Integer.parseInt(request.getParameter("clinicNumber"));
		
		//list를 받는다
		List<CommentDTO> commentList = commentDAO.getCommentList(clinicNumber);
		
		response.setCharacterEncoding("UTF-8");
		//바디테크 안에서 쓸수 있음
		PrintWriter out = response.getWriter();
		
		JSONArray comments = new JSONArray();
		
		for(CommentDTO comment : commentList) {
			JSONObject obj = new JSONObject();
			obj.put("commentNumber", comment.getCommentNumber());
			obj.put("memberNickname", comment.getMemberNickname());
			obj.put("doctorNickname", comment.getDoctorNickname());
			obj.put("commentContent", comment.getCommentContent());
			comments.add(obj);
		}
		
		//System.out.println("comments는!!!!! "+comments);
		out.println(comments.toJSONString()); 
		out.close();
		
		
		
		return null;
	}

}
