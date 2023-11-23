package com.mama.doc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.cl.vo.ClinicVO;
import com.mama.doc.vo.AdNutrientsVO;
import com.mama.doc.vo.PrecautionVO;
import com.mybatis.config.MyBatisConfig;

public class MainPageDAO {
	
public SqlSession sqlSession;
	
	public MainPageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
		// 예방알림 글 리스트 불러오기
		public List<PrecautionVO> selectPrecautionList() {
	        // 여기에 데이터베이스 조회 로직을 구현
	        // 조회된 데이터를 YourDataObject에 담아서 반환
			return sqlSession.selectList("mainPage.selectPrecautionList");
	    }
		
		// 상담소 글 리스트 불러오기
		public List<ClinicVO> selectClinicList() {
	        // 여기에 데이터베이스 조회 로직을 구현
	        // 조회된 데이터를 YourDataObject에 담아서 반환
			return sqlSession.selectList("mainPage.selectClinicList");
	    }
		
		// 영양제 글 리스트 불러오기
		public List<AdNutrientsVO> selectNutrientsList() {
	        // 여기에 데이터베이스 조회 로직을 구현
	        // 조회된 데이터를 YourDataObject에 담아서 반환
			return sqlSession.selectList("mainPage.selectNutrientsList");
	    }

}
