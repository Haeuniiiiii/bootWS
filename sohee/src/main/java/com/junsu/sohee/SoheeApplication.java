package com.junsu.sohee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoheeApplication extends SpringBootServletInitializer {
	
	// 서블릿 초기화 루틴 추가!
	// war 파일 안에 추가 되어야함
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SoheeApplication.class);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SoheeApplication.class, args);
	}
 
}
