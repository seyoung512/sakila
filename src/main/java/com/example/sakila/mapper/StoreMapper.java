package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Store;

@Mapper
public interface StoreMapper {
	
   // 사용 가능한 모든 상점 목록을 조회
   List<Store> selectStoreList();
}