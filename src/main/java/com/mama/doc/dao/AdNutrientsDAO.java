package com.mama.doc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mama.doc.dto.AdNutrientsDTO;
import com.mama.doc.dto.AdNutrientsFileDTO;
import com.mama.doc.vo.AdNutrientsVO;
import com.mama.doc.vo.SearchVO;
import com.mybatis.config.MyBatisConfig;

public class AdNutrientsDAO {
	
	public SqlSession sqlSession;
	
	
	public AdNutrientsDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//영양제 정보 db에 넣기
	public void nuInsert(AdNutrientsDTO adNutrientsDTO ) {
		sqlSession.insert("adnu.nuInsert", adNutrientsDTO);
	}
	
	//영양제 첨부파일 db에 넣기
	public void fileInsert(AdNutrientsFileDTO adNutrientsFileDTO ) {
		adNutrientsFileDTO.setNutrientsNumber(sqlSession.selectOne("adnu.findLast"));
		sqlSession.insert("adnuFile.fileInsert", adNutrientsFileDTO);
	}
	
	
//	영양제 삭제
	public void delete(int nutrientsNumber) {
		sqlSession.delete("adnu.delete",nutrientsNumber);
	}
	
//	영양제 수정페이지 이동
	public AdNutrientsDTO selectOne(int nutrientsNumber) {
		return sqlSession.selectOne("adnu.selectOne", nutrientsNumber);
	}
	
//	영양제 수정페이지(기존 이미지 불러오기)
	public AdNutrientsFileDTO selectImg(int nutrientsNumber) {
		return sqlSession.selectOne("adnuFile.selectImg", nutrientsNumber);
	}
	
//	영양제 정보 수정
	public void update(AdNutrientsDTO adNutrientsDTO) {
		sqlSession.update("adnu.updateNu", adNutrientsDTO);
	}
	
//	영양제 첨부파일 수정
	public void updateFile(AdNutrientsFileDTO adNutrientsFileDTO) {
		sqlSession.update("adnuFile.updateNufile",adNutrientsFileDTO);
	}

//	유저페이지 영양제 추천 페이지 이동(파일, 영양제 정보 불러오기)
	public List<AdNutrientsVO> selectUserAll(int startRow, int endRow, SearchVO searchVO) {
		Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchVO", searchVO);
		return sqlSession.selectList("adnu.selectUserAll", pageMap);
	}
	
//	관리자페이지에서 영양제 글 리스트
	public List<AdNutrientsDTO> selectAll(int startRow, int endRow, SearchVO searchVO){
		Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("searchVO", searchVO);
	    return sqlSession.selectList("adnu.selectAll", pageMap);
	}
	
//	영양제 전체 게시글 수 조회
	public int getTotal() {
	    return sqlSession.selectOne("adnu.getTotal");
	}
	
	
	
}
