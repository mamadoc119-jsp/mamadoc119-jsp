package com.mama.doc.adno;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.NoticeDAO;

public class AdNoticeDeleteController implements Execute{
	@Override
	   public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException, ServletException {
			Result result = null;
			System.out.println("AdNoticeDeleteController 실행");
	
			NoticeDAO noticeDao = new NoticeDAO();
			
			long noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
			noticeDao.adNoticeDelete(noticeNumber); 
			
			return null;
	   }

}
