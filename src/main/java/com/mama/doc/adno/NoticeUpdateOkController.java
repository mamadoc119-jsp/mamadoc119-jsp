package com.mama.doc.adno;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.NoticeDAO;
import com.mama.doc.dto.NoticeDto;

public class NoticeUpdateOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		//글 수정했을때 작성일을 수정일로 설정했는데 얘 바꿔야하는지 마는지?>
		NoticeDAO noticeDAO = new NoticeDAO();
		NoticeDto noticeDto = new NoticeDto();
		
		noticeDto.setNoticeTitle(request.getParameter("noticeTitle"+""));
        noticeDto.setNoticeContent(request.getParameter("noticeContent"+""));
        noticeDto.setNoticeNumber(Long.parseLong(request.getParameter("noticeNumber")));
        noticeDAO.noticeUpdate(noticeDto);
		
		return null;
	
			
	}
}
