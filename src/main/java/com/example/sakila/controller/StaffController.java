package com.example.sakila.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.mapper.AddressMapper;
import com.example.sakila.mapper.StaffMapper;
import com.example.sakila.mapper.StoreMapper;
import com.example.sakila.service.AddressService;
import com.example.sakila.service.StaffService;
import com.example.sakila.service.StoreService;
import com.example.sakila.vo.Address;
import com.example.sakila.vo.Staff;
import com.example.sakila.vo.Store;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller	
public class StaffController {
	@Autowired StaffService staffService;
	@Autowired StoreService storeService;
	@Autowired AddressService addressService;
	
	// 직원의 active 상태를 전환하는 메서드
	@GetMapping("/on/modifyStaffActive")
	public String modifyStaffActive(Staff staff) {
		
		// active 값이 1이면 2로, 2이면 1로 변경
		if(staff.getActive() == 1) {
			staff.setActive(2);			
		} else {
			staff.setActive(1);
		}
		
		// 직원의 상태 변경
		int row = staffService.modifyStaff(staff); //어떤 컬럼값을 수정하던 mapper 메서드는 하나다.(my batis의 장점)
		
		// 상태 변경 후 직원 목록으로 리다이렉션
		return "redirect:/on/staffList";
	}
	
	// 직원 등록 페이지로 이동하며, 주소 검색 기능을 제공하는 메서드
	@GetMapping("/on/addStaff")
	public String addStaff(Model model
							, @RequestParam(defaultValue="") String searchAddress) {
		
		// 스토어 목록을 모델에 추가
		log.debug("searchAddress: ", searchAddress);
		List<Store> storeList = storeService.getStoreList();
		model.addAttribute("storeList", storeList);
		
		// 검색 주소가 있다면, 해당 주소 목록을 추가
		if(searchAddress.equals("") == false) {
				List<Address> addressList = addressService.getAddressListByWord(searchAddress);
				log.debug(addressList.toString());
				model.addAttribute("addressList", addressList);
		}
		
		// 직원 등록 페이지로 이동
		return "on/addStaff";
	}
	
	// 직원 등록 처리 메서드(POST)
	@PostMapping("/on/addStaff")
	public String addStaff(Staff staff) { // 커맨드 객체 생성 -> 커맨드객체.set(request.getParameter())
		
		// 직원 정보 출력
		log.debug(staff.toString());
		// 직원 등록 서비스 호출
		int row = staffService.addStaff(staff);
		
		// 직원 등록 실패 시 다시 등록 페이지로 이동
		if(row == 0) { 
			return "on/addStaff";
		}
		
		// 등록 성공 시 직원 목록 페이지로 리다이렉션
		return "redirect:/on/staffList";
	}
	
	// 직원 목록 페이지로 이동하며, 페이징 처리된 직원 리스트를 전달하는 메서드
	@GetMapping("/on/staffList")
	public String staffList(Model model
							, @RequestParam(defaultValue = "1") int currentPage
							, @RequestParam(defaultValue = "10") int rowPerPage) {
		// 페이징 처리된 직원 목록을 가져오기 위한 map 생성
		Map<String, Object> map = new HashMap<>();
		int beginRow = (currentPage-1) * rowPerPage;
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		log.debug(map.toString());
		
		// 직원 목록 조회
		List<Staff> staffList = staffService.getStaffList(map);
		log.debug(staffList.toString());
		
		// 전체 페이지 수 계산
		int lastPage = staffService.getLastPage(rowPerPage);
		
		// 모델에 직원 목록과 페이지 정보 추가
		model.addAttribute("staffList", staffList);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		
		// 직원 목록 페이지로 이동
		return "on/staffList";
	}
	
	// 로그인한 직원의 상세 정보를 가져와서 해당 페이지에 보여주는 메서드
	@GetMapping("/on/staffOne")
	public String staffOne(HttpSession session, Model model) {
		
		// 세션에서 로그인된 직원 정보 가져오기
		int staffId = ((Staff)(session.getAttribute("loginStaff"))).getStaffId();
		// 직원 상세 정보 조회
		Map<String, Object> staff = staffService.getStaffOne(staffId);
		model.addAttribute("staff", staff);
		log.debug(staff.toString());
		
		// 직원 상세 페이지로 이동
		return "on/staffOne";
	}
	
}
