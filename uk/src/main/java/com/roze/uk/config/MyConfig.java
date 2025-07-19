package com.roze.uk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MyConfig  implements WebMvcConfigurer{
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.debug("설정파일 동작했낭? 요기가 실행되었는지 check?");
		registry.addResourceHandler("/upload272/**")             // 웹 접근 경로 
		        .addResourceLocations("file:///d:/upload272/");  // 서버내 실제 경로
		
		// 주소표시줄에 /upload272/merong/aaa.jpg 요청이 서버로 오면
		// 			d:/upload272//merong/aaa.jpg 라고 파일경로를 읽어오게 된다.
	}
 
}