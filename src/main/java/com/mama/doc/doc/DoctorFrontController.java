package com.mama.doc.doc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class DoctorFrontController
 */
//@WebServlet("/DoctorFrontController")
public class DoctorFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("doctor 서블릿이 실행");
		
		//request.getContextPath()는 URL루트 경로를 의미한다
		System.out.println(request.getContextPath());
		
		//request.getRequestURI는 현재 요청의 URI를 보여준다      
		System.out.println(request.getRequestURI());
		
		//전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		Result result = null;
		
		//단순한 값비교는 if문보다 switch문이 효율성이 좋고 가독성도 좋다
		//break문을 꼭 써야된다!
		switch(target) {
		case "/join.do":
			System.out.println("회원가입 페이지");
			request.getRequestDispatcher("/join/doctorJoin.jsp").forward(request, response);
			break;
		case "/checkEmailOk.do":
			System.out.println("이메일 중복검사");
			new CheckEmailOkController().execute(request, response);
			break;
		case "/checkNicknameOk.do":
			System.out.println("닉네임 중복검사");
			break;
		case "/joinOk.do":
			System.out.println("의료인 회원가입 성공");
			result = new JoinOkController().execute(request, response);
			request.getRequestDispatcher("/login/doctorLogin.jsp").forward(request, response);
			break;
		case "/login.do":
			System.out.println("로그인 페이지");
			request.getRequestDispatcher("/login/doctorLogin.jsp").forward(request, response);
			break;
		case "/loginOk.do":
			System.out.println("의료인 로그인 성공");
			result = new LoginOkController().execute(request, response);
			break;
		case "/logoutOk.do":
			System.out.println("의료인 로그아웃 성공");
			result = new LogoutOkController().execute(request, response);
			break;
		case "/informOk.do":
			System.out.println("마이페이지 성공");
			result = new InformOkController().execute(request, response);
			request.getRequestDispatcher("/info/doctorInfo.jsp").forward(request, response);
			break;
		case "/modifyInformOk.do":
			System.out.println("정보수정 성공");
			new ModifyInformOkController().execute(request, response);
			request.getRequestDispatcher("/informOk.do").forward(request, response);
			break;
		case "/quitOk.do":
			System.out.println("회원탈퇴 성공");
			new QuitOkController().execute(request, response);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			break;
		}
		
		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
				//리다이렉션을 필요로 한다면 result객체의 경로로 리다이렉션을 수행한다
            } else {
            	request.getRequestDispatcher(result.getPath()).forward(request, response);
            	//포워딩을 필요로 하면 result객체의 경로로 포워딩을 수행한다
            }
		}
	}

}
