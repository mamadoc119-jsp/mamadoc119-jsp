package com.mama.doc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.PrecautionDTO;
import com.mama.doc.vo.PrecautionVO;
import com.mybatis.config.MyBatisConfig;

public class PrecautionDAO {

	public SqlSession sqlSession;
	
	public PrecautionDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 예방알림 글 작성
	public void write(PrecautionDTO precautionDTO) {
		sqlSession.insert("precaution.write", precautionDTO);
	}
	
	// 예방알림 글 수정
	   public int update(PrecautionDTO precautionDTO) {
	       return sqlSession.update("precaution.edit", precautionDTO);
	   }
	
	// 예방알림 글 수정 불러오기
	public PrecautionDTO selectWrite(int precautionNumber) {
		Map<String, Integer> params = new HashMap<>();
		params.put("precautionNumber", precautionNumber);
		return sqlSession.selectOne("precaution.selectWrite", params);
	}
	
	// 예방알림 글 삭제
	public void delete(int precautionNumber) {
		Map<String, Integer> params = new HashMap<>();
		params.put("precautionNumber", precautionNumber);
		sqlSession.delete("precaution.delete", params);
	}
	
	// 예방알림 글 상세보기
	public PrecautionVO selectOne(int precautionNumber) {
		Map<String, Integer> params = new HashMap<>();
		params.put("precautionNumber", precautionNumber);
		return sqlSession.selectOne("precaution.selectOne", params);
	}
		
	// 예방알림 글 리스트 불러오기
	public List<PrecautionVO> selectAll(){
		return sqlSession.selectList("precaution.selectAll");
	}

	public int countprecautionNumber(){
			return sqlSession.selectOne("precaution.countprecautionNumber");
		}
		
		public List<PrecautionDTO> bringPrecautionList(int firstList) {
			List<PrecautionDTO> list = new ArrayList<>();
			list = sqlSession.selectList("precaution.bringPrecautionList",firstList);
			return list;
		}
		
		
		public PrecautionDTO getPrevView(int listNum) {
			return sqlSession.selectOne("freeboard.getPrevView",listNum);
		}
		
			
		public PrecautionDTO bringContent(int listNum) {
			return sqlSession.selectOne("freeboard.bringContent",listNum);
		}
		
}
