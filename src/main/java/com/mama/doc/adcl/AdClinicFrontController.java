package com.mama.doc.adcl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class AdNoticeFrontController
 */
//@WebServlet("/adcl")
public class AdClinicFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdClinicFrontController() {
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
		System.out.println("adPrecaution 서블릿이 실행");

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
		case "/admin/adClinicList.adcl":
			System.out.println("AdClinicList.adcl 실행");
			 new AdClinicListOkController().execute(request, response);
			 request.getRequestDispatcher("/admin/adminMC.jsp").forward(request, response);
			 break;
		
		case "/admin/adClinicDelete.adcl":
			System.out.println("adClinicDelete.adcl 실행");
			 new AdClinicDeleteOkController().execute(request, response);
			 response.sendRedirect("adClinicList.adcl");
			 break;
		
	
			
		
			
//		case "/mamadoc/admin/noticeWrite.adno":
//        	request.getRequestDispatcher("/admin/adminNoticeWrite.jsp").forward(request, response);
//        	break;
	
	        }  
		}

}
