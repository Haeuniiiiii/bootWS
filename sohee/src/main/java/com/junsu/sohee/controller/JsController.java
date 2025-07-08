package com.junsu.sohee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class JsController {

	@GetMapping("")
	public String home() {
		return "js"; // /WEB-INF/views/ + js + .jsp
	}
}
