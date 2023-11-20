package com.mama.doc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.AdMemberDTO;
import com.mybatis.config.MyBatisConfig;

public class AdMemberDAO {
	
	public SqlSession sqlSession;
	
	public AdMemberDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	관리자 일반회원 리스트
	public List<AdMemberDTO> selectMeAll(){
		return sqlSession.selectList("adme.selectMeAll");
	}
	
//	관리자 일반회원 정보 삭제
	public void delete(int memberNumber) {
		sqlSession.delete("adme.delete", memberNumber);
	}

}
