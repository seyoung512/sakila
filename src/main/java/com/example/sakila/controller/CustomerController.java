package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.AddressService;
import com.example.sakila.service.CustomerService;
import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Address;
import com.example.sakila.vo.Customer;
import com.example.sakila.vo.Store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	@Autowired CustomerService customerService;
	@Autowired StoreService storeService;
	@Autowired AddressService addressService;
	
	// 고객 상세 정보를 보여주는 페이지로 이동하는 메서드
	@GetMapping("/on/customerOne")
	public String customerOne(@RequestParam Integer customerId) {
		
		// 고객 상세 페이지로 이동
		return "on/customerOne";
	}
	
	// 고객 목록을 페이징 처리하여 출력하는 메서드
	@GetMapping("/on/customerList")
	public String customerList(Model model
							, @RequestParam(defaultValue = "1") Integer currentPage
							, @RequestParam(defaultValue = "10") Integer rowPerPage) {
		// customerService에서 고객 목록과 페이징 정보를 가져옴
		Map<String, Object> resultMap = customerService.getCustomerList(currentPage, rowPerPage);
		
		// 디버깅
		log.debug(resultMap.toString());
		
		// Model에 고객 목록과 페이징 정보를 추가하여 뷰로 전달
		// resultMap 풀어서.... 이동(통으로 넘기면 View코드 복잡...)
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startPagingNum", resultMap.get("startPagingNum"));
		model.addAttribute("endPagingNum", resultMap.get("endPagingNum"));
		model.addAttribute("customerList", resultMap.get("customerList"));
		
		// 고객 목록 페이지로 이동
		return "on/customerList";
	}
	
	// 고객을 추가하는 폼 페이지로 이동하는 메서드
	@GetMapping("/on/addCustomer")
	public String addCustomer(Model model
							, @RequestParam(required = false) String searchAddress) {
		// sotreList 데이터를 가져와서 뷰에 전달
		List<Store> storeList = storeService.getStoreList();
		model.addAttribute("storeList", storeList);
		
		// 검색어가 존재하면 addressList를 가져와서 뷰에 전달
		if(searchAddress != null && !searchAddress.equals("")) {
			// 주소 검색어에 맞는 주소 목록을 addressService에서 조회
			List<Address> addressesList = addressService.getAddressListByWord(searchAddress);
			model.addAttribute("addressesList", addressesList);
		}
		
		// 고객 추가 폼 페이지로 이동
		return "on/addCustomer";
	}
	
	// 고객 추가 폼에서 전달된 데이터를 처리하고, 고객을 추가하는 메서드
	@PostMapping
	public String addCustomer(Customer customer) {
		// 고객 추가 서비스 호출
		Integer row = customerService.addCustomer(customer);
		
		// 고객 목록 페이지로 리다이렉션
		return "redirect:/on/customerList";
	}
}