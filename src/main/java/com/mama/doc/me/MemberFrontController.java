package com.mama.doc.me;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
	
    response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
    	
	System.out.println("me 서블릿이 실행");
	
	//request.getContextPath()는 URL루트 경로를 의미한다
	System.out.println(request.getContextPath());
	
	//request.getRequestURI는 현재 요청의 URI를 보여준다		
	System.out.println(request.getRequestURI());
	
	//전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
	String target = request.getRequestURI().substring(request.getContextPath().length());
	System.out.println(target);
	
	Result result = null;
	
	switch(target) {
	case "/join/memberJoin.me":
		System.out.println("join!!");
		request.getRequestDispatcher("/join/memberJoin.jsp").forward(request, response);
		break;
		
	case "/join/joinOk.me":
		System.out.println("joinOk!!");
		new JoinOkController().execute(request, response);
	}
   }
}
