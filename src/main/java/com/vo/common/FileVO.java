package com.vo.common;

import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vo.common.FileMstVO;

import lombok.Data;

@Data
public class FileVO extends FileMstVO {

	@JsonIgnore
	private MultipartFile file;
	
	private int width=600;
	private int height=600;
	private String position = "H";  // W:넓이중심, H:높이중심, X:설정한 수치로(비율무시)
	private String format="jpg";	//파일 유형
}
