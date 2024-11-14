package com.example.sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	// 메인 페이지 요청을 처리하는 메서드
	@GetMapping("/on/main") 
	public String main() {
		
		// main으로 이동
		return "on/main";
	}
}
