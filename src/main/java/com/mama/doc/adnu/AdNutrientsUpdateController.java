package com.mama.doc.adnu;

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
import com.mama.doc.dao.AdNutrientsDAO;
import com.mama.doc.dto.AdNutrientsDTO;
import com.mama.doc.dto.AdNutrientsFileDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdNutrientsUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ServerException {
		
		AdNutrientsDTO adNutrientsDTO = new AdNutrientsDTO();
        AdNutrientsFileDTO adNutrientsFileDTO = new AdNutrientsFileDTO();
        AdNutrientsDAO adNutrientsDAO = new AdNutrientsDAO();
        Result result = new Result();

        int nutrientsNumber = Integer.parseInt(request.getParameter("nutrientsNumber"));
        
        System.out.println("nutrientsNumber : " +nutrientsNumber);
        // 파일업로드 경로 설정
        String location = "C:\\mamadoc119\\mamadoc\\src\\main\\webapp\\resources\\upload";
        System.out.println(location);
        int maxSize = 1024 * 1024 * 5;
        MultipartRequest multi = new MultipartRequest(request, location, maxSize, "utf-8",
                new DefaultFileRenamePolicy());

        // 영양제 첨부파일 내용 dto에 담기

        // 파일 이름 불러오기
        try {
        	Enumeration<String> fileNames = multi.getFileNames();
        	System.out.println("fileNames : "+fileNames );
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
                adNutrientsFileDTO.setNutrientsNumber(nutrientsNumber);
                adNutrientsFileDTO.setNufilePath(location);
                adNutrientsFileDTO.setNufileUuid(filesystemName);
                adNutrientsFileDTO.setNufileName(originalFileName);
                adNutrientsFileDTO.setNufileType(fileExtension);

                adNutrientsDAO.updateFile(adNutrientsFileDTO);

                // 실제 파일 저장
                String filePath = location + File.separator + filesystemName + fileExtension;
                File file = new File(filePath);
                multi.getFile(element).renameTo(file);
            }
		} catch (NullPointerException e) {
			System.out.println("파일 첨부 안함");
		}
        
        
     // 영양제 내용 dto에 담기
        
        System.out.println(multi.getParameter("nutrientsName"));
        adNutrientsDTO.setNutrientsNumber(nutrientsNumber);
        adNutrientsDTO.setNutrientsName(multi.getParameter("nutrientsName"));
        adNutrientsDTO.setNutrientsEffect(multi.getParameter("nutrientsEffect"));
        adNutrientsDTO.setNutrientsInfo(multi.getParameter("nutrientsInfo"));

        // 영양제 내용 DB에 보내기
        adNutrientsDAO.update(adNutrientsDTO);

        result.setRedirect(true);
        result.setPath("adminNutrients.adnu");
        return result;
	}
	
}
