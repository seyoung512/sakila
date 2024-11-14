package com.example.sakila.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Category;

@Mapper
public interface CategoryMapper {
	
	// 모든 카테고리 목록을 조회하여 List<Category> 형태로 반환
	List<Category> selectCategoryList();
}
