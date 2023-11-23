package com.mama.doc.pr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.PrecautionDAO;
import com.mama.doc.dto.PrecautionDTO;
import com.mama.doc.vo.SearchVO;

public class PrecautionListController implements Execute{
	
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
//		 HttpSession session = request.getSession();
//	        session.setAttribute("doctor_number", 1);
//	        session.setAttribute("doctor_nickname", "소아과의사입니다");
//	        int doctorNumber = (int) session.getAttribute("doctor_number");

	        PrecautionDTO precautionDTO = new PrecautionDTO();
//	        precautionDTO.setDoctorNumber(doctorNumber);

	        Result result = new Result();
	        PrecautionDAO precautionDAO = new PrecautionDAO();
			SearchVO searchVO = new SearchVO();


	        System.out.println("listOK컨트롤러 들어왔음");

//	        // 페이징 처리
//	        String temp = request.getParameter("page");
//			int page = temp == null ? 1 : Integer.parseInt(temp);
//			int pageSize = 10;
//			int totalCount = precautionDAO.getTotal();
//			
//			int endRow = page * pageSize;
//			int startRow = endRow - (pageSize - 1);
//			
//			int startPage = ((page - 1) / pageSize) * pageSize + 1;
//			int endPage = startPage + 9;
//			int realEndPage = (int)(Math.ceil((double)totalCount / pageSize));
//			
//			endPage = endPage > realEndPage ? realEndPage : endPage;
//	        
//			request.setAttribute("totalCount", totalCount);
//			request.setAttribute("realEndPage", realEndPage);
//			request.setAttribute("startPage", startPage);
//			request.setAttribute("endPage", endPage);
//			request.setAttribute("nowPage", page);
//			request.setAttribute("precautionList", precautionDAO.getPrecautionListPaging(startRow, endRow));


	        
	        
	        String temp = request.getParameter("page");
			int page = temp == null ? 1 : Integer.parseInt(temp);
			int pageSize = 10;
			int totalCount = precautionDAO.getTotal();
			
			int endRow = page * pageSize;
			int startRow = endRow - (pageSize - 1);
			
			int startPage = ((page - 1) / pageSize) * pageSize + 1;
			int endPage = startPage + 9;
			int realEndPage = (int)(Math.ceil((double)totalCount / pageSize));
			
			//검색		
			String cate = request.getParameter("cate");
			cate = cate == null? "" : cate;
			String keyword = request.getParameter("keyword");
			keyword = keyword == null?"":keyword;
			
			searchVO.setCate(cate);
			searchVO.setKeyword(keyword);
			
			endPage = endPage > realEndPage ? realEndPage : endPage;
			
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("realEndPage", realEndPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("nowPage", page);
			request.setAttribute("precautionList", precautionDAO.selectList(startRow, endRow, searchVO));
			request.setAttribute("cate", cate);
			request.setAttribute("keyword", keyword);
			
			// 글 작성 후 목록 페이지 이동
	        result.setRedirect(false);
	        result.setPath("/precaution/precautionList.jsp");

	        return result;
	    	
		}
		
	}



