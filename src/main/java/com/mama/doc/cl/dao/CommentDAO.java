package com.mama.doc.cl.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.cl.vo.CommentVO;
import com.mama.doc.dto.CommentDTO;
import com.mybatis.config.MyBatisConfig;

public class CommentDAO {
	public SqlSession sqlSession;
	
	public CommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//댓글 목록
	public List<CommentVO> getCommentList(int clinicNumber) {
		return sqlSession.selectList("clinic.getCommentList", clinicNumber);
		}
		
	
	//댓글 쓰기 - 일반회원
	public void insertComment(CommentDTO commentDTO) {
			sqlSession.insert("clinic.insertComment", commentDTO);
		}
	
	//댓글쓰기 - 의료인 회원
	public void insertCommentDo(CommentDTO commentDTO) {
		sqlSession.insert("clinic.insertCommentDo", commentDTO);
	}
	
	//댓글 수정
	public void updateComment(CommentDTO commentDTO) {
		sqlSession.update("clinic.updateComment", commentDTO);
	}
	
	//댓글 삭제
	public void deleteComment(int commentNumber) {
		sqlSession.delete("clinic.deleteComment", commentNumber);
	}
	
}
