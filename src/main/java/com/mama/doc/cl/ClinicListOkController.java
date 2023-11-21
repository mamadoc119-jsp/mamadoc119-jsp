package com.mama.doc.cl;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.cl.dao.ClinicDAO;
import com.mama.doc.cl.vo.ClinicVO;
import com.mama.doc.dto.ClinicDTO;
import com.mama.doc.vo.SearchVO;

public class ClinicListOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, ServerException {

    	// test용 임의로 지정///////
    	HttpSession session = request.getSession();
    	session.setAttribute("member_number", 2);
    	session.setAttribute("member_nickname", "비이이");
        int memberNumber = (int) session.getAttribute("member_number");

//        ClinicDTO clinicDTO = new ClinicDTO();
//        clinicDTO.setMemberNumber(memberNumber);

        Result result = new Result();
        ClinicDAO clinicDAO = new ClinicDAO();
    	SearchVO searchVO = new SearchVO();

        System.out.println("listOK컨트롤러 들어왔음");

        // 페이징 처리
        
        String temp = request.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);
		int pageSize = 10;
		int totalCount = clinicDAO.getTotal();
		
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
		request.setAttribute("clinicList", clinicDAO.getClinicListPaging(startRow, endRow, searchVO));
		request.setAttribute("cate", cate);
		request.setAttribute("keyword", keyword);

        // 글 작성 후 목록 페이지 이동
        result.setRedirect(false);
        result.setPath("/clinic/clinicList.jsp");

       
        return result;
    	
    }
	

}
