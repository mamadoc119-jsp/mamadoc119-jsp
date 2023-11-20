package com.mama.doc.adnu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Result;

/**
 * Servlet implementation class AdNutrientsFrontController
 */

public class AdNutrientsFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdNutrientsFrontController() {
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
		System.out.println("adminNutrients 서블릿이 실행");
		
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
//					관리자 영양제 관리 페이지이동
		case "/adminNutrients.adnu":
			System.out.println("adminNutrients!!");
			result = new AdNutrientsListController().execute(request, response);
			break;
//		관리자 페이지 영양제 글 수정 페이지 이동
		case "/adminNutrientsUpdate.adnu":
			System.out.println("adminNutrientsUpdate!!");
			result = new AdNutrientsSelectOneController().execute(request, response);
			break;
		
//		관리자 페이지 영양제 글 작성 이동
		case "/adminNutrientsWrite.adnu":
			System.out.println("adminMain!!");
			request.getRequestDispatcher("/admin/adminNutrientsWrite.jsp").forward(request, response);
			break;
		
//		유저페이지 영양제 추천 페이지 이동
		case "/nutrientsList.adnu":
			System.out.println("adminMain!!");
			result = new AdNutrientsSelectUserAllController().execute(request, response);
			break;
			
//		관리자 페이지 영양제 글 작성
		case "/adminNutrientsWriteOk.adnu":
			System.out.println("adminNutrientsWriteOk!!");
			result = new AdNutrientsWriteOkController().execute(request, response);
			break;
			
//		관리자 페이지 영양제 글 삭제
		case "/adminNutrientsDelete.adnu":
			System.out.println("adminNutrientsDelete!!");
			result = new AdNutrientsDeleteController().execute(request, response);
			break;
		
//		관리자 페이지 영양제 글 수정
		case "/adminNutrientsUpdateOk.adnu":
			System.out.println("adminNutrientsUpdateOk!!");
			result = new AdNutrientsUpdateController().execute(request, response);
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
