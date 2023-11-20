package com.mama.doc.ad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class AdminFrontController
 */
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFrontController() {
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
//		doGet(request, response);
		doProcess(request, response);
	}
	
	// jsp프로젝트에서는 get과 post를 구분하지 않고 사용
		protected void doProcess(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("admin 서블릿이 실행");
			
			//request.getContextPath()는 URL루트 경로를 의미한다
			System.out.println(request.getContextPath());
			
			//request.getRequestURI는 현재 요청의 URI를 보여준다		
			System.out.println(request.getRequestURI());
			
			//전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
			String target = request.getRequestURI().substring(request.getContextPath().length());
			System.out.println(target);
			Result result = null;


			// 단순한 값비교는 if문보다 switch문이 효율성이 좋고 가독성도 좋다
			// break문을 꼭 써야된다!
			switch (target) {
//			관리자 로그인 페이지 이동
			case "/adminLogin.ad":
				System.out.println("adminLogin!!");
				request.getRequestDispatcher("/admin/adminLogin.jsp").forward(request, response);
				break;
//			관리자 로그인
			case "/adminLoginOk.ad":
				System.out.println("adminLoginOk!!");
				result = new AdLoginOkController().execute(request, response);
				break;
//			관리자 부모회원 페이지 이동
			case "/adminMain.ad":
				System.out.println("adminMain!!");
				request.getRequestDispatcher("/admin/adminMain.jsp").forward(request, response);
				break;
				
//			관리자 로그아웃
			case "/adminLogoutOk.ad":
				System.out.println("adminLogoutOk!!");
				result = new AdLogoutOkController().execute(request, response);
				break;
			}
			
			if(result != null) {
				if(result.isRedirect()) {
					response.sendRedirect(result.getPath());
					//리다이렉션을 필요로 한다면 리다이렉션을 수행한다
				}else {
					request.getRequestDispatcher(result.getPath()).forward(request, response);
					//포워딩을 필요로 하면 result객체의 경로로 포워딩을 수행한다
				}
			}
			
			
		}
		


}
