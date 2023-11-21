package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.AdMemberDTO;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class AdMemberDAO {
	
	public SqlSession sqlSession;
	
	public AdMemberDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	관리자 일반회원 리스트
	public List<AdMemberDTO> selectMeAll(int startRow, int endRow, SearchVO searchVO){
		Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchVO", searchVO);
		return sqlSession.selectList("adme.selectMeAll",pageMap);
	}
	
//	관리자 일반회원 정보 삭제
	public void delete(int memberNumber) {
		sqlSession.delete("adme.delete", memberNumber);
	}
	
//	관리자 일반회원 총원 조회
	public int getTotal() {
		return sqlSession.selectOne("adme.getTotal");
	}

}
