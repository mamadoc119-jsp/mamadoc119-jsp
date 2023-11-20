package com.mama.doc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.NoticeDto;
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
	   public List<NoticeDto> adNoticeList() {
	      return sqlSession.selectList("notice.noticeList");
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
}
