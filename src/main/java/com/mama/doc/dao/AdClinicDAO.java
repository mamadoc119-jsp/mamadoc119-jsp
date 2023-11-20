package com.mama.doc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.vo.AdClinicVo;
import com.mybatis.config.MyBatisConfig;

public class AdClinicDAO {
	 public SqlSession sqlSession;
	   
	   public AdClinicDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   //관리자 공지사항 조회(관리)
	   public List<AdClinicVo> adClinicList() {
	      return sqlSession.selectList("adcl.adClinicList");
	   }
	   

	   // 관리자 공지사항 삭제 
	   public void adClinicDelete(Long clinicNumber) {
	      sqlSession.delete("adcl.adClinicDelete", clinicNumber);
	   }   
}
