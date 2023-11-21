package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.AdDoctorDTO;
import com.mama.doc.vo.AdDoctorVO;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class AdDoctorDAO {
public SqlSession sqlSession;
	
	public AdDoctorDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	가입승인전 의료인 회원 리스트
	public List<AdDoctorDTO> selectApplyAll(int startRow, int endRow, SearchVO searchVO){
		Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchVO", searchVO);
		return sqlSession.selectList("addo.selectApplyAll",pageMap);
	}
	
//	가입승인된 의료인 회원 리스트
	public List<AdDoctorDTO> selectAll(int startRow, int endRow, SearchVO searchVO){
		Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchVO", searchVO);
		return sqlSession.selectList("addo.selectAll",pageMap);
	}
	
//	가입승인전 의료인 회원 인원수 조회
	public int getApplyTotal() {
		return sqlSession.selectOne("addo.getApplyTotal");
	}
	
//	가입승인된 의료인 회원 인원수 조회
	public int getTotal() {
		return sqlSession.selectOne("addo.getTotal");
	}
	
//	의료인 회원 상세보기
	public AdDoctorVO selectOne(int doctorNumber, int doctorStatus) {
		Map<String, Integer> findMap = new HashMap<>();
		findMap.put("doctorNumber", doctorNumber);
		findMap.put("doctorStatus",doctorStatus);
		return sqlSession.selectOne("addo.selectOne", findMap);
	}
	
//	의료인 회원 정보 삭제
	public void delete(int doctorNumber) {
		sqlSession.delete("addo.delete", doctorNumber);
	}
	
//	의료인 회원 승인
	public void approve(int doctorNumber) {
		sqlSession.update("addo.approve", doctorNumber);
	}

}
