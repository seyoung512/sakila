package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.FilmCategory;

@Mapper
public interface FilmCategoryMapper {
	
	// 특정 영화에서 특정 카테고리를 제거
	Integer deleteFilmCategory(FilmCategory filmcategory);
	
	// 특정 영화에 새로운 카테고리를 추가
	Integer insertFilmCategory(FilmCategory filmCateogory);
	
	// 특정 영화가 어떤 카테고리에 속하는지 확인
	List<Map<String, Object>> selectFilmCategoryListByFilm(Integer filmId);
	
	// 영화 삭제 시 그 영화에 연결된 모든 카테고리를 제거
	Integer deleteFilmCategoryByFilm(Integer filmId);

	// ?
	// 특정 카테고리가 삭제될 때 해당 카테고리에 속한 모든 영화-카테고리 관계를 제거
	Integer deleteFilmCategoryByCategory(Integer categoryId);
}
