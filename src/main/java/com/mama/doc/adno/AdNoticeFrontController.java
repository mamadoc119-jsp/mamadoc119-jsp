package com.mama.doc.adno;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class AdNoticeFrontController
 */
//@WebServlet("/adno")
public class AdNoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdNoticeFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("adNotice 서블릿이 실행");

		// request.getContextPath()는 URL루트 경로를 의미한다
		System.out.println(request.getContextPath());

		// request.getRequestURI는 현재 요청의 URI를 보여준다
		System.out.println(request.getRequestURI());

		// 전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		Result result = null;
		// 단순한 값비교는 if문보다 switch문이 효율성이 좋고 가독성도 좋다
		// break문을 꼭 써야된다!
		switch (target) {
		case "/admin/noticeWriteOk.adno":
			System.out.println("noticeWriteOk.adno 실행");
			 new NoticeWriteOkController().execute(request, response);
			 request.getRequestDispatcher("adminNoticeWrite.jsp").forward(request, response);
			 break;
		
		//얘는 관리자가 띄우는 공지사항 목록
		case "/admin/adNoticeList.adno":
			System.out.println("adNoticeList.adno 실행");
			new AdNoticeListController().execute(request, response);
			 request.getRequestDispatcher("/admin/adminNotice.jsp").forward(request, response);
			break;
			
		//얘는 메인에서 띄우는 공지사항 목록	
		case "/notice/noticeList.adno":
			System.out.println("NoticeList.adno 실행");
			new AdNoticeListController().execute(request, response);
			 request.getRequestDispatcher("/notice/noticeList.jsp").forward(request, response);
			break;
			
		case "/admin/adNoticeDelete.adno":
			System.out.println("adNoticeDelete.adno 실행");
			new AdNoticeDeleteController().execute(request, response);
			response.sendRedirect("adNoticeList.adno");
			break;
		
		case "/notice/noticeDetail.adno":
			System.out.println("NoticeDetail.adno 실행");
			new NoticeDetailController().execute(request, response);
			request.getRequestDispatcher("/notice/noticeDetail.jsp").forward(request, response);
			break;
			
		case "/notice/noticeUpdate.adno":
			System.out.println("AdNoticeUpdate.adno 실행(경로진입)");
			new NoticeUpdateController().execute(request,response);
			request.getRequestDispatcher("/admin/adminNoticeUpdate.jsp").forward(request, response);
			break;	
			
		case "/notice/AdNoticeUpdateOk.adno":
			System.out.println("AdNoticeUpdate.adno 실행");
			new NoticeUpdateOkController().execute(request,response);
			request.getRequestDispatcher("/admin/adminNoticeUpdate.jsp").forward(request, response);
			break;	
			
			
		
			
//		case "/mamadoc/admin/noticeWrite.adno":
//        	request.getRequestDispatcher("/admin/adminNoticeWrite.jsp").forward(request, response);
//        	break;
	
	        }  
		}

}
