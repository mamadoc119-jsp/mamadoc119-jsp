package com.mama.doc.cl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.cl.vo.ClinicVO;
import com.mama.doc.dto.ClinicDTO;
import com.mybatis.config.MyBatisConfig;

public class ClinicDAO {
	public SqlSession sqlSession;
	
	public ClinicDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//게시글 작성
	public boolean clinicWrite(ClinicDTO clinicDTO) {
		
		boolean result = sqlSession.insert("clinic.clinicWrite", clinicDTO) > 0;
		return result; //1이상이면 true, 0 이하면 false;
	}
	

	//페이징 처리
	public List<ClinicVO> getClinicListPaging(int startRow, int endRow) {
	    Map<String, Integer> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    return sqlSession.selectList("clinic.getClinicListPaging", pageMap);
	}

	public int getTotal() {
	    return sqlSession.selectOne("clinic.getTotal");
	}
	
	

	
	//게시글 목록
	public List<ClinicVO> getClinicList(){
		System.out.println("게시글 목록dao입니다.");
	   return sqlSession.selectList("clinic.getClinicList");
		
		
	}
	
	//상세페이지
	public ClinicVO getClinicDetail(int clinicNumber) {
		ClinicVO clinicDetail = null;
		clinicDetail = sqlSession.selectOne("clinic.getClinicDetail", clinicNumber);
		
		return clinicDetail;
		
	}
	

	//수정하기
	public void clinicUpdate(ClinicDTO clinicDTO) {
		sqlSession.update("clinic.modifyClinic", clinicDTO);
	}
	
	//삭게하기
	public void clinicDelete(int clinicNumber) {
		sqlSession.delete("clinic.deleteClinic", clinicNumber);
	
	}

	
}
