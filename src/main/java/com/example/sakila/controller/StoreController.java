package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StoreController {
	
	@Autowired StoreService storeService; // StoreService를 자동 주입하여 store 관련 비즈니스 로직을 처리
	
	// storeList 요청 처리(GET)
	@GetMapping("/on/storeList")
	public String storeList(Model model) {
		
		// StoreService를 사용하여 상점 목록을 가져옵니다.
		List<Store> storeList = storeService.getStoreList();
		
		// 가져온 상점 목록을 모델에 담아서 뷰로 전달
		model.addAttribute("storeList", storeList);
		
		// 스토어 목록 페이지로 이동
		return "on/storeList";
	}
}