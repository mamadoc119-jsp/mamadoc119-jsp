package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.vo.AdClinicVo;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class AdClinicDAO {
	 public SqlSession sqlSession;
	   
	   public AdClinicDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   //관리자 상담소게시물 조회(관리)
	   public List<AdClinicVo> adClinicList(int startRow, int endRow, SearchVO searchVO) {
		   Map<String, Object> pageMap = new HashMap<>();
		    pageMap.put("startRow", startRow);
		    pageMap.put("endRow", endRow);
		    pageMap.put("searchVO", searchVO);
	      return sqlSession.selectList("adcl.adClinicList",pageMap);
	   }
	   

	   // 관리자 상담소게시물 삭제 
	   public void adClinicDelete(Long clinicNumber) {
	      sqlSession.delete("adcl.adClinicDelete", clinicNumber);
	   }   
	   
//		상담소 전체 게시글 수 조회
		public int getTotal() {
		    return sqlSession.selectOne("adcl.getTotal");
		}
}
