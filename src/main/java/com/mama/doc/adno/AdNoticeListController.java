package com.mama.doc.adno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.NoticeDAO;

public class AdNoticeListController implements Execute{
	 @Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 NoticeDAO noticeDAO = new NoticeDAO();
		 System.out.println("AdNoticeListController 실행");
	      
	      request.setAttribute("adNoticeList", noticeDAO.adNoticeList());
	     
	      
	      return null;
	   }
}
