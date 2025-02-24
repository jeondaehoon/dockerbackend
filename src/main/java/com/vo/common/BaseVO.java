package com.vo.common;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Data;


@Data
public class BaseVO {
	
	private String regDt;		//등록일 ( Timestamp : 년월일 시분초 )
	private String updDt;		//수정일 ( Timestamp : 년월일 시분초 )
	private String delYn="N";
	
	private int shopHh;		//UTC 세션시간
	private int shopMm;		//UTC 세션분
	
	
}
