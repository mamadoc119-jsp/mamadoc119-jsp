package com.mama.doc.cl.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.CommentDTO;
import com.mybatis.config.MyBatisConfig;

public class CommentDAO {
	public SqlSession sqlSession;
	
	public CommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//댓글 목록
	public List<CommentDTO> getCommentList(int clinicNumber) {
		return sqlSession.selectList("clinic.getCommentList", clinicNumber);
		}
		
	
	//댓글 쓰기
	public void insertComment(CommentDTO commentDTO) {
			sqlSession.insert("clinic.insertComment", commentDTO);
		}
	
}
