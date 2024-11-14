package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.mapper.StaffMapper;
import com.example.sakila.service.StaffService;
import com.example.sakila.vo.Staff;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	
	@Autowired StaffService staffService;
	
	// 로그아웃 처리
	@GetMapping("/on/logout")
	public String logout(HttpSession session) {
		// 세션을 무효화하여 로그아웃 처리
		session.invalidate();
		log.debug("로그아웃 성공");
		
		// 로그아웃 후 로그인 페이지로 리다이렉트
		return "redirect:/off/login";
	}
	
	// 로그인 페이지 요청 처리(GET)
	@GetMapping("/off/login")
	public String login() {
		log.debug("/off/login 실행됨.");
		
		// 로그인 페이지로 포워딩
		return "off/login";
	}
	
	// 로그인 처리(POST)
	@PostMapping("/off/login")
	public String login(Model model
						, HttpSession session
						, @RequestParam(name = "staffId") int staffId
						, @RequestParam(name = "password") String password) {			
		
		// 로그인 시도할 Staff 객체 생성 후 staffId와 password 세팅
		Staff paramStaff = new Staff();
		paramStaff.setStaffId(staffId);
		paramStaff.setPassword(password);
		
		// StaffService의 login 메서드를 통해 로그인 시도
		Staff loginStaff = staffService.login(paramStaff);
		
		// 로그인 실패 시 처리
		if(loginStaff == null) {
			log.debug("로그인 실패");
			model.addAttribute("msg", "로그인실패"); // 로그인 실패 메시지 모델에 추가
			
			// 로그인 페이지로 돌아가도록 처리
			return "/off/login"; 
		}
		
		// 로그인 성공시 세션에 loginStaff 속성 추가
		session.setAttribute("loginStaff", loginStaff);
		log.debug("로그인 성공, 세션loginStaff속성 추가");
	
		// 로그인 성공 후 메인 페이지로 리다이렉트
		return "redirect:/on/main";
	}
}
