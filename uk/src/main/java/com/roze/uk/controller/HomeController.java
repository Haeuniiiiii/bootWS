package com.roze.uk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping
	public String home() {
		return "home";	// view resolver에 의해서 /WEB-INF/views/ + home + .jsp
	}
	
}
