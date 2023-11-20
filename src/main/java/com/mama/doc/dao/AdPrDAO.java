package com.mama.doc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.vo.AdPrVo;
import com.mybatis.config.MyBatisConfig;

public class AdPrDAO {
	 public SqlSession sqlSession;
	   
	   public AdPrDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   //관리자 공지사항 조회(관리)
	   public List<AdPrVo> adPrList() {
	      return sqlSession.selectList("adpr.adPrList");
	   }
	   

	   // 관리자 공지사항 삭제 
	   public void adPrDelete(Long precautionNumber) {
	      sqlSession.delete("adpr.adPrDelete", precautionNumber);
	   }   
}
