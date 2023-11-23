package com.mama.doc.doc;

import java.io.File;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mama.doc.Execute;
import com.mama.doc.Result;
import com.mama.doc.dao.DoctorDAO;
import com.mama.doc.dto.DoctorDTO;
import com.mama.doc.dto.DofileDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServerException {
		DoctorDAO doctorDAO = new DoctorDAO();
		DoctorDTO doctorDTO = new DoctorDTO();
		DofileDTO dofileDTO = new DofileDTO();
		
		// 파일업로드 경로 설정
		String location = "C:\\mamadoc119\\mamadoc\\src\\main\\webapp\\resources\\upload";
		System.out.println(location);
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest multi = new MultipartRequest(request, location, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 회원정보 dto에 담기
		doctorDTO.setDoctorEmail(multi.getParameter("doctorEmail"));
		doctorDTO.setDoctorPassword(multi.getParameter("doctorPassword"));
		doctorDTO.setDoctorName(multi.getParameter("doctorName"));
		doctorDTO.setDoctorNickname(multi.getParameter("doctorNickname"));
		doctorDTO.setDoctorPostCode(multi.getParameter("doctorPostCode"));
		doctorDTO.setDoctorAddress(multi.getParameter("doctorAddress"));
		doctorDTO.setDoctorExtraAddress(multi.getParameter("doctorExtraAddress"));
		doctorDTO.setDoctorDetailAddress(multi.getParameter("doctorDetailAddress"));
		doctorDTO.setDoctorLicense(multi.getParameter("doctorLicense"));
		doctorDTO.setDoctorMajor(multi.getParameter("doctorMajor"));
		
		// 회원정보 db에 보내기
		doctorDAO.join(doctorDTO);
		
		// 파일 이름 불러오기
		try {
			Enumeration<String> fileNames = multi.getFileNames();
			String element = "";
			String filesystemName = "";
			String originalFileName = "";
			
			System.out.println("fileNames : " + fileNames);
			
			long length = 0;
			
			// 업로드 파일명 중복을 방지하기 위해 임의의 파일명 부여
			UUID uuid = UUID.randomUUID();
			String[] uuids = uuid.toString().split("-");
			filesystemName = uuids[0];
			
			if (fileNames.hasMoreElements()) {
				element = (String) fileNames.nextElement();
				originalFileName = multi.getOriginalFileName(element);
				length = multi.getFile(element).length();
				
				// 확장자 가져오기
				String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				
				// 파일 dto에 파일 정보 저장
				dofileDTO.setDoctorNumber(doctorDTO.getDoctorNumber());
				dofileDTO.setDofilePath(location);
				dofileDTO.setDofileUuid(filesystemName);
				dofileDTO.setDofileName(originalFileName);
				dofileDTO.setDofileType(fileExtension);
				
				doctorDAO.fileInsert(dofileDTO);
				
				// 실제 파일 저장
				String filePath = location + File.separator + filesystemName + fileExtension;
				File file = new File(filePath);
				multi.getFile(element).renameTo(file);
			}
		} catch (NullPointerException e) {
			System.out.println("파일 첨부 안함");
		}
		
		response.sendRedirect("/mamadoc/login.do");
		
		return null;
	}

}
