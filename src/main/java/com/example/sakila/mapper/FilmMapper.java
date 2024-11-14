package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Film;

@Mapper
public interface FilmMapper {
	
	// 영화 정보 수정
	Integer updateFilm(Film film);
	
	// 영화 삭제
	Integer deleteFilmByKey(Integer filmId); 
	
	// 카테고리에 속한 영화 목록을 조회하는 메서드
	List<Map<String, Object>> selectFilmListByCategory(Map<String, Object> paramMap);
	
	// 카테고리와 관계없이 영화 목록을 조회
	List<Map<String, Object>> selectFilmList(Map<String, Object> paramMap);
	
	// 특정 배우가 출연한 모든 영화를 조회
	List<Film> selectFilmListByTitle(String searchTitle);
	
	// 새로운 영화를 추가
	Integer insertFilm(Film film);
	
	// 특정 영화의 상세 정보를 조회
	Map<String, Object> selectFilmOne(Integer filmId);
	
	// 특정 배우가 출연한 영화 목록을 조회
	List<Film> selectFilmTitleListByActor(Integer actorId);
}