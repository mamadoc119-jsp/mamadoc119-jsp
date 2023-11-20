package com.mama.doc.dao;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.AdminDTO;
import com.mybatis.config.MyBatisConfig;

public class AdminDAO {

	
	public SqlSession sqlSession;
	
	public AdminDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	관리자 로그인
	public AdminDTO logIn(AdminDTO adminDTO) {
		AdminDTO admin = sqlSession.selectOne("admin.logIn", adminDTO);
		return admin;
		
	}
}

