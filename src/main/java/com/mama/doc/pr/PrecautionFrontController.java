package com.mama.doc.pr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;
import com.mama.doc.me.JoinOkController;

/**
 * Servlet implementation class PrecautionFrontController
 */
@WebServlet("/PrecautionFrontController")
public class PrecautionFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrecautionFrontController() {
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
    	
	System.out.println("pr 서블릿이 실행");
	
	//request.getContextPath()는 URL루트 경로를 의미한다
	System.out.println(request.getContextPath());
	
	//request.getRequestURI는 현재 요청의 URI를 보여준다		
	System.out.println(request.getRequestURI());
	
	//전체 URI에서 ContextPath를 제외시킨 부분이 필요하다
	String target = request.getRequestURI().substring(request.getContextPath().length());
	System.out.println(target);
	
	Result result = null;
	
	switch(target) {
	
			// 예방알림 글 작성 페이지 이동
			case "/precaution/precautionWrite.pr":
				System.out.println("precautionWrite!!");
				request.getRequestDispatcher("/precaution/precautionWrite.jsp").forward(request, response);
				break;
				
			// 예방알림 글 작성 기능
			case "/precaution/precautionWriteOk.pr":
				System.out.println("precautionWriteOk!!");
				new PrecautionWriteController().execute(request, response);
				break;
				
			// 예방알림 글 목록 화면 이동
			case "/precaution/precautionList.pr":
				System.out.println("precautionList!!");
				request.getRequestDispatcher("/precaution/precautionList.jsp").forward(request, response);
				break;
				
			// 예방알림 찾기 글 목록 불러오기
			case "/precaution/precautionListOk.pr":
				System.out.println("precautionListOk!!");
				result = new PrecautionSelectAllController().execute(request, response);
				break;
				
			// 예방알림 글 상세 보기 화면 이동
			case "/precaution/precautionDetail.pr" :
				System.out.println("precautionDetail!!");
				new PrecautionSelectOneController().execute(request, response);
				break;
				
			// 예방알림 특정 글 데이터 불러오기
			case "/precaution/precautionDetailOk.pr" :
				System.out.println("precautionDetailOk!!");
				new PrecautionSelectOneController().execute(request, response);
				break;
				
			// 예방알림 글 수정 화면으로 이동
			case "/precaution/precautionModify.pr":
				System.out.println("precautionModify!!");
				new PrecautionModifyController().execute(request, response);
				break;
				
			// 예방알림 글 수정 기능
			case "/precaution/precautionModifyOk.pr":
				System.out.println("precautionModifyOk!!");
				new PrecautionModifyOkController().execute(request, response);
				break;
				
			// 예방알림 글 삭제 기능
			case "/precaution/precautionDeleteOk.pr" :
				System.out.println("precautionDeleteOk!!");
				new PrecautionDeleteController().execute(request, response);
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
