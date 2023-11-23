package com.mama.doc.dao;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.DoctorDTO;
import com.mama.doc.dto.DofileDTO;
import com.mybatis.config.MyBatisConfig;

public class DoctorDAO {

	public SqlSession sqlSession;
	
	public DoctorDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	이메일 중복검사
	public int checkEmail(String doctorEmail) {
		int countDoctor = (Integer)sqlSession.selectOne("doctor.checkDoctorEmail", doctorEmail);
		int countMember = (Integer)sqlSession.selectOne("doctor.checkMemberEmail", doctorEmail);
		return countDoctor + countMember;
	}
	
//	닉네임 중복검사
	public int checkNickname(String doctorNickname) {
		int countDoctor = (Integer)sqlSession.selectOne("doctor.checkDoctorNickname", doctorNickname);
		int countMember = (Integer)sqlSession.selectOne("doctor.checkMemberNickname", doctorNickname);
		return countDoctor + countMember;
	}
	
//	의사면허번호 중복검사
	public int checkLicense(String doctorLicense) {
		return (Integer)sqlSession.selectOne("doctor.checkLicense", doctorLicense);
	}
	
//	회원가입
	public void join(DoctorDTO doctorDTO) {
		sqlSession.insert("doctor.join", doctorDTO);
	}
	
//	면허증 등록
	public void fileInsert(DofileDTO dofileDTO ) {
		dofileDTO.setDoctorNumber(sqlSession.selectOne("doctor.findLast"));
		sqlSession.insert("dofile.fileInsert", dofileDTO);
	}
	
//	로그인
	public DoctorDTO login(DoctorDTO doctorDTO) {
		DoctorDTO doctor = sqlSession.selectOne("doctor.login", doctorDTO);
		return doctor;
	}
	
//	본인인증
	public int checkDoctor(DoctorDTO doctorDTO) {
		if (sqlSession.selectOne("doctor.checkDoctor", doctorDTO) == null) {
			return 0;
		}
		return (Integer)sqlSession.selectOne("doctor.checkDoctor", doctorDTO);
	}
	
//	마이페이지
	public DoctorDTO inform(int doctorNumber) {
		DoctorDTO doctor = sqlSession.selectOne("doctor.inform", doctorNumber);
		return doctor;
	}
	
//	정보수정
	public void modifyInform(DoctorDTO doctorDTO) {
		sqlSession.update("doctor.modifyInform", doctorDTO);
	}
	
//	비밀번호 변경
	public void modifyPw(DoctorDTO doctorDTO) {
		sqlSession.update("doctor.modifyPw", doctorDTO);
	}
	
//	회원탈퇴
	public void quit(int doctorNumber) {
		sqlSession.delete("doctor.quit", doctorNumber);
	}
}
