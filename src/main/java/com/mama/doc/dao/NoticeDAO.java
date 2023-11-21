package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.NoticeDto;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class NoticeDAO {
	 public SqlSession sqlSession;
	   
	   public NoticeDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   

	   //공지사항 작성
	   public void noticeWrite(NoticeDto noticeDto) {
	      sqlSession.insert("notice.noticeWrite", noticeDto);
	      System.out.println("noticeDao실행");
	      
	   }
	   
	   //관리자 공지사항 조회(관리)
	   public List<NoticeDto> adNoticeList(int startRow, int endRow, SearchVO searchVO) {
		   Map<String, Object> pageMap = new HashMap<>();
		    pageMap.put("startRow", startRow);
		    pageMap.put("endRow", endRow);
		    pageMap.put("searchVO", searchVO);
	      return sqlSession.selectList("notice.noticeList",pageMap);
	   }
	   //메인 공지사항 상세페이지
	   public NoticeDto noticeDetail(int noticeNumber) {
		      return sqlSession.selectOne("notice.noticeDetail", noticeNumber);
		   }
	   
	// 관리자 공지사항 삭제 
	   public void adNoticeDelete(Long noticeNumber) {
	      sqlSession.delete("notice.noticeDelete", noticeNumber);
	   }   
	   //관리자 공지사항 수정
	   public void noticeUpdate(NoticeDto noticeDto) {
			System.out.println("noticeUpdate 확인");
			sqlSession.update("notice.noticeUpdate", noticeDto);
		}
//		공지사항 전체 게시글 수 조회
		public int getTotal() {
		    return sqlSession.selectOne("notice.getTotal");
		}
}
