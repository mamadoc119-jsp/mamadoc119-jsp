package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.vo.AdPrVo;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class AdPrDAO {
	 public SqlSession sqlSession;
	   
	   public AdPrDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   //관리자 예방상담 조회(관리)
	   public List<AdPrVo> adPrList(int startRow, int endRow, SearchVO searchVO) {
		   Map<String, Object> pageMap = new HashMap<>();
		    pageMap.put("startRow", startRow);
		    pageMap.put("endRow", endRow);
		    pageMap.put("searchVO", searchVO);
	      return sqlSession.selectList("adpr.adPrList",pageMap);
	   }
	   

	   // 관리자 예방상담 삭제 
	   public void adPrDelete(Long precautionNumber) {
	      sqlSession.delete("adpr.adPrDelete", precautionNumber);
	   }   
	   
//		예방상담 전체 게시글 수 조회
		public int getTotal(SearchVO searchVO) {
		    return sqlSession.selectOne("adpr.getTotal",searchVO);
		}
}
