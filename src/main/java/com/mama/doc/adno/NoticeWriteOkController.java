package com.mama.doc.adno;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.NoticeDAO;
import com.mama.doc.dto.NoticeDto;

public class NoticeWriteOkController implements Execute{
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServerException{
	      request.setCharacterEncoding("UTF-8");
	      NoticeDAO noticeDao = new NoticeDAO();
	      NoticeDto noticeDto = new NoticeDto();
	        Result result = new Result();
	        
	        
	        System.out.println("GymWrite Call!!");
	        
	        
	        

	        noticeDto.setNoticeTitle(request.getParameter("noticeTitle"+""));
	        noticeDto.setNoticeContent(request.getParameter("noticeContent"+""));
	        System.out.println("noticeWrite : "+noticeDto.toString());
	        
	        noticeDao.noticeWrite(noticeDto);

	    
	        return result;
	  
	   }
}
