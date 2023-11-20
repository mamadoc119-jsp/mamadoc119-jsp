package com.mama.doc.dao;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	
	public SqlSession sqlSession;
	
	public MemberDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join",memberDTO);
	}

}
