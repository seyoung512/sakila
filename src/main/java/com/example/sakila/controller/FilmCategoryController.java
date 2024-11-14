package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.FilmCategoryService;
import com.example.sakila.vo.FilmCategory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilmCategoryController {
	
	@Autowired FilmCategoryService filmCategoryService; // 영화 카테고리 관련 비즈니스 로직을 처리하는 서비스
	
	// 영화에서 카테고리 제거 요청 처리
	@GetMapping("/on/removeFilmCategory")
	public String reomoveFilmCategory(FilmCategory filmCategory) {
		log.debug("==========filmCategory======"+filmCategory.toString()); // filmCategory 객체 디버깅
		
		// 영화에서 카테고리 제거하는 서비스 호출
		int row = filmCategoryService.removeFilmCategory(filmCategory);
			
		// 영화 상세 페이지로 리다이렉트 
		return "redirect:/on/filmOne?filmId=" + filmCategory.getFilmId();
	}
	
	// 영화에 카테고리 추가 요청 처리
	@PostMapping("/on/addFilmCategory")
	public String addFilmCategory(FilmCategory filmCategory) {
		log.debug("==========filmCategory======"+filmCategory.toString()); // filmCategory 객체 디버깅
		
		// 영화에 카테고리를 추가하는 서비스 호출
		int row = filmCategoryService.addFilmCategory(filmCategory); 
		log.debug("row--->" + row);
		
		// 영화 상세 페이지로 리다이렉트
		return "redirect:/on/filmOne?filmId=" + filmCategory.getFilmId();
	}
}
