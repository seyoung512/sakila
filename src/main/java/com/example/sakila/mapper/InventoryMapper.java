package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InventoryMapper {
	
	// /on/inventoryList - 특정 storeID에 해당하는 재고 목록을 확인
	List<Map<String, Object>> selectInventoryListByStore(Map<String, Object> paramMap);
		
	// /on/removeFilm - 특정 영화에 대한 재고 수량을 조회
	Integer selectCountInventoryByFilm(Integer filmId);
}
