package com.mama.doc.dao;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	
	public SqlSession sqlSession;
	
	public MemberDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	이메일 중복검사
	public int checkEmail(String memberEmail) {
		int countMember = (Integer)sqlSession.selectOne("member.checkMemberEmail", memberEmail);
		int countDoctor = (Integer)sqlSession.selectOne("member.checkDoctorEmail", memberEmail);
		return countDoctor + countMember;
	}
	
//	닉네임 중복검사
	public int checkNickname(String memberNickname) {
		int countMember = (Integer)sqlSession.selectOne("member.checkMemberNickname", memberNickname);
		int countDoctor = (Integer)sqlSession.selectOne("member.checkDoctorNickname", memberNickname);
		return countDoctor + countMember;
	}
	
//	회원가입
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join",memberDTO);
	}
	
//	로그인
	public MemberDTO login(MemberDTO memberDTO) {
		MemberDTO member = sqlSession.selectOne("member.login", memberDTO);
		return member;
	}
	
//	마이페이지
	public MemberDTO inform(int memberNumber) {
		MemberDTO member = sqlSession.selectOne("member.inform", memberNumber);
		return member;
	}
	
//	정보수정
	public void modifyInform(MemberDTO memberDTO) {
		sqlSession.update("member.modifyInform", memberDTO);
	}
	
//	회원탈퇴
	public void quit(int memberNumber) {
		sqlSession.delete("member.quit", memberNumber);
	}

}
