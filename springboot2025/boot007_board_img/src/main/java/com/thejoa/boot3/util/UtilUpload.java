package com.thejoa.boot3.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UtilUpload {
	@Value("${resource.path}")//application.properties 변수
	private String uploadPath;
	
	public String fileUpload(MultipartFile file) throws IOException {
		//1. 파일이름이 중복안되게 설정
		String save=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		//2. 파일 업로드 기능
		File target=new File(uploadPath,save);
		FileCopyUtils.copy(file.getBytes(), target);//실제파일올리기
		return save;
	}
}
