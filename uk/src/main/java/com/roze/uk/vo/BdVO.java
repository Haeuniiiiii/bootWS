package com.roze.uk.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class BdVO {

	private int bdId;
	private String bdCont;
	private String bdTitle; 
	private String bdFurl;	// 파일은 넘겨받는게 아니라, 생성하는 것임
	
	private MultipartFile bdFile;	// 파일 받기 위한 것, DB에는 저장하지 않음!
	
}
