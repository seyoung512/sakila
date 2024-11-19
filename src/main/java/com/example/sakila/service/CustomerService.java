package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.CustomerMapper;
import com.example.sakila.vo.Customer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class CustomerService {
	@Autowired CustomerMapper customerMapper;
	
	// 고객 이름을 기준으로 고객 리스트를 조회하는 메서드
	public List<Customer> getCustomerListByName(String searchName) {
		return customerMapper.selectCustomerListByName(searchName);
	}
	
	// 마지막 페이지 번호를 구하는 메서드
	public Integer getLastPage(Integer rowPerPage) {
		return 0;
	}
	
	// 고객 리스트를 페이징 처리하여 조회하는 메서드
	public Map<String, Object> getCustomerList(Integer currentPage, Integer rowPerPage) {
		// 현재 페이지를 기준으로 조회하고 시작 행 번호 계산
		Integer beginRow = (currentPage - 1) * rowPerPage;
		
		// 파라미터 맵을 만들어 beginRow와 rowPerPage 값을 담음
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		// 한페이지당 페이징개수는 10개씩이라고 가정
		Integer numPerPage = 10;
		// 페이징 첫번째 페이지 넘버
		Integer startPagingNum = (currentPage-1)/10*10+1; 
		// 페이징 마지막 페이지 넘버
		Integer endPagingNum = startPagingNum + (numPerPage - 1); 
		
		
		// 현재페이지가 95다 91~100출력인데 마지막 페이지가 98이면 91 ~ 98
		/*
		Integer lastPage = this.getLastPage(rowPerPage);
		if(lastPage < endPagingNum) {
			endPagingNum = lastPage;
		}
		*/
		
		// DB에서 고객 리스트 정보를 가져옴
		List<Customer> customerList = customerMapper.selectCustomerList(paramMap);
		
		// 페이징 정보와 고객 리스트를 resultMap에 담아서 리턴
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startPagingNum", startPagingNum);
		resultMap.put("endPagingNum", endPagingNum);
		resultMap.put("customerList", customerList);
		
		// 페이징 정보와 고객 리스트가 담긴 맵을 리턴
		return resultMap;
	}
	
	// 새로운 고객을 추가하는 메서드
	public Integer addCustomer(Customer customer) {
		return customerMapper.insertCustomer(customer);
	}
}