package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.InventoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class InventoryController {
	
	@Autowired InventoryService inventoryService; // 재고 목록을 처리하는 서비스
	
	// storeId에 해당하는 매장의 재고 목록을 가져오는 요청을 처리하는 메서드
	@GetMapping("/on/inventoryList")
	public String inventoryList(Model model
								, @RequestParam Integer storeId
								, @RequestParam(defaultValue = "1") int currentPage
								, @RequestParam(defaultValue = "10") int rowPerPage) {
		
		// InventoryService의 메서드를 호출하여 해당 매장의 재고 목록을 페이징 처리하여 가져옴
		List<Map<String, Object>> inventoryList = 
				inventoryService.getInventoryListByStore(storeId, currentPage, rowPerPage);
		
		// 재고 목록을 모델에 추가하여 뷰에서 사용할 수 있도록 전달
		model.addAttribute("inventoryList", inventoryList);
		// storeId를 모델에 추가하여 재고 목록 페이지에서 매장 ID를 알 수 있도록 전달
		model.addAttribute("storeId", storeId);
		
		// 재고 목록 페이지로 이동
		return "on/inventoryList";
	}
}