package com.mama.doc.cl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Result;
import com.mama.doc.dto.ClinicDTO;


/**
 * Servlet implementation class ClinicFrontController
 */
//@WebServlet("/ClinicFrontController")
public class ClinicFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("board 서블릿이 실행");

		// request.getContextPath()는 URL루트 경로를 의미한다
		System.out.println(request.getContextPath());

		// request.getRequestURI는 현재 요청의 URI를 보여준다
		System.out.println(request.getRequestURI());

		// 전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		
		Result result = null;
		
		switch(target) {
		
		case "/clinic/clinicWriteOk.cl" :
			System.out.println("글등록 성공");
			result = new ClinicWriteOkController().execute(request, response);
			break;
		
			
		case "/clinic/clinicListOk.cl" :
			System.out.println("리스트 이동");
			result = new ClinicListOkController().execute(request, response);
			break;
	
		case "/clinic/clinicDetail.cl":
         	System.out.println("상세페이지 이동중");
         	request.getRequestDispatcher("/clinic/clinicDetail.jsp").forward(request, response);
         	break;
         	
		case "/clinic/clinicDetailOk.cl" :
			System.out.println("디테일컨트롤러로 가는중");
			result = new ClinicDetailOkController().execute(request, response);
			break;
		
		case "/clinic/clinicModify.cl" :
			result = new ClinicModifyController().execute(request, response);
			break;
			
		case "/clinic/clinicModifyOk.cl" : 
			result = new ClinicModifyOkController().execute(request, response);
			break;
		
		case "/clinic/clinicDeleteOk.cl":
			System.out.println("삭제 컨트롤러입니다.");
			result = new ClinicDeleteOkController().execute(request, response);
			break;
			
		/******************댓글 부분*****************************************************/
			
		case "/clinic/ClinicConmmentListOk.cl" :
			System.out.println("댓글리스트로 갑니다");
			result = new ClinicConmmentListOkController().execute(request, response);
			break;
			
			
		case "/clinic/CommentWriteOk.cl" :
			System.out.println("댓글쓰기 컨트롤러로 갑니다");
			result = new CommentWriteOkController().execute(request, response);
			break;
		
		
		case "/clinic/CommentModifyOk.cl" :
				System.out.println("댓글 수정 컨트롤러로 갑니다");
				result = new CommentModifyOkController().execute(request, response);
				break;
				
		case "/clinic/CommentDeleteOk.cl" :
			System.out.println("댓글 수정 컨트롤러로 갑니다");
			result = new CommentDeleteOkController().execute(request, response);
			break;
		}		
				
				
			
			
	
		
		
		
	    // forward 처리
	    if (result != null && !result.isRedirect()) {
	        // forward
	        request.getRequestDispatcher(result.getPath()).forward(request, response);
	    } else if (result != null && result.isRedirect()) {
	        // redirect
	        response.sendRedirect(request.getContextPath() + result.getPath());
	    }
		
	}

}
