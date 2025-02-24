package com.vo.common;

import lombok.Data;

@Data
public class FileMstVO extends BaseVO{
	
	private String fileCd;		//파일코드 ( 랜덤 20자리 )
	//private String fileUrl;	//파일 경로 /cupos/images/상점코드/apply/파일명
	
	private String originPath;	//원본이미지 저장 경로.	C:/cupos/images/상점코드/menu/origin/파일명
	private String applyPath;	//이미지 저장 경로.	C:/cupos/images/상점코드/menu/apply/파일명 
    private String filePath;	//디비저장시 :      /images/상점코드/menu/apply/파일명
	private String fileNm;		//파일명
	private String fileType;	//IMG, PDF, ...
	private String fileOrdr;	//순위
	private String originFileNm;	//원본 파일명
}
