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

public class NoticeUpdateController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServerException, ServletException {
		NoticeDAO noticeDAO = new NoticeDAO();
		int noticeNumber = Integer.parseInt(request.getParameter("noticeNumber"));
		NoticeDto noticeDto = noticeDAO.noticeDetail(noticeNumber);

		request.setAttribute("noticeDetail", noticeDto);
			return null;
	
			
	}
}
