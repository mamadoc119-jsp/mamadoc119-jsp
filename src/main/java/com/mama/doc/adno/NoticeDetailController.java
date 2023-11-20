package com.mama.doc.adno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.NoticeDAO;

public class NoticeDetailController implements Execute{
	  @Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      NoticeDAO noticeDAO = new NoticeDAO();
	      
	      int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
	      request.setAttribute("noticeDetail", noticeDAO.noticeDetail(noticeNumber));
	      
	      System.out.println("얘 되나>?");
	      return null;
	   }
}
