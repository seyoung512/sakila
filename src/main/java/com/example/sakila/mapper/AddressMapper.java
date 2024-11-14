package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Address;

@Mapper
public interface AddressMapper {
	
	// searchAddress를 사용하여 주소 목록을 조회하여 Address 객체 목록으로 반환
	List<Address> selectAddressListByWord(String searchAddress);
}
