package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Language;

@Mapper
public interface LanguageMapper {
	
	// /on/addFilm - 사용 가능한 모든 언어 목록을 조회하는 메서드
	List<Language> selectLanguageList();
}