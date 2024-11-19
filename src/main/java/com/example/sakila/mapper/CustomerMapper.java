package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Customer;

@Mapper
public interface CustomerMapper {
	
	// 고객 이름으로 고객 목록을 조회하는 메서드
	List<Customer> selectCustomerListByName(String searchName);
	
	// 고객 목록을 페이징 처리하여 조회하는 메서드
	List<Customer> selectCustomerList(Map<String, Object> paramMap);
	
	// 새로운 고객을 추가하는 메서드
	Integer insertCustomer(Customer customer);
}