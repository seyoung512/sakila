package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.StaffMapper;
import com.example.sakila.vo.Customer;
import com.example.sakila.vo.Staff;

@Service 
@Transactional
public class StaffService {
	@Autowired StaffMapper staffMapper;
	
	public Map<String, Object> getStaffOne(Integer staffId) {
		return staffMapper.selectStaffOne(staffId);
	}
	
	public int getLastPage(Integer rowPerPage) {
		Integer count = staffMapper.selectStaffCount();
		Integer lastPage = count / rowPerPage;
		if(count % rowPerPage != 0) {
				lastPage += 1;
		}
		return lastPage;
	}
	
	public Map<String, Object> getStaffList(Integer currentPage, Integer rowPerPage) {
		
		// 현재 페이지를 기준으로 조회하고 시작 행 번호 계산
		Integer beginRow = (currentPage - 1) * rowPerPage;
		
		// 파라미터 맵을 만들어 beginRow와 rowPerPage 값을 담음
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		// 한페이지당 페이징개수는 10개씩이라고 가정
		Integer numPerPage = 5;
		// 페이징 첫번째 페이지 넘버
		Integer startPagingNum = (currentPage-1)/10*10+1; 
		// 페이징 마지막 페이지 넘버
		Integer endPagingNum = startPagingNum + (numPerPage - 1); 
			
		// DB에서 고객 리스트 정보를 가져옴
		List<Staff> staffList = staffMapper.selectStaffList(paramMap);
		
		// 페이징 정보와 고객 리스트를 resultMap에 담아서 리턴
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startPagingNum", startPagingNum);
		resultMap.put("endPagingNum", endPagingNum);
		resultMap.put("staffList", staffList);
		
		return resultMap;
	}
	
	public int addStaff(Staff paramStaff) {
		return staffMapper.insertStaff(paramStaff);
	}
	
	public int modifyStaff(Staff paramStaff) {
		return staffMapper.updateStaff(paramStaff);
	}
	
	public Staff login(Staff paramStaff) {
		return staffMapper.login(paramStaff);
	}
}