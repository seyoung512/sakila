package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sakila.service.ActorService;
import com.example.sakila.service.CategoryService;
import com.example.sakila.service.FilmCategoryService;
import com.example.sakila.service.FilmService;
import com.example.sakila.service.InventoryService;
import com.example.sakila.service.LanguageService;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.Category;
import com.example.sakila.vo.Film;
import com.example.sakila.vo.FilmCategory;
import com.example.sakila.vo.FilmForm;
import com.example.sakila.vo.Language;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilmController {
	
	@Autowired FilmService filmService;
	@Autowired ActorService actorService;
	@Autowired LanguageService languageService;
	@Autowired CategoryService categoryService;
	@Autowired InventoryService inventoryService;
	@Autowired FilmCategoryService filmCategoryService;
	
	// 영화 수정 페이지 요청 처리
	@GetMapping("/on/modifyFilm")
	public String modifyFilm(Model model, Film film) {
		log.debug(film.toString()); // 수정할 영화 정보 출력
		
		// 영화에 사용될 언어 리스트 가져오기
		List<Language> languageList = languageService.getLanguageList();
		log.debug(languageList.toString());
		model.addAttribute("languageList", languageList);
		
		// 영화 상세 페이지로 리다이렉트
		return "redirect:/on/filmOne?filmOne=" + film.getFilmId();
	}

	// 영화 삭제 요청 처리
	@GetMapping("/on/removeFilm")
	public String removeFilm(Model model, @RequestParam Integer filmId) {
		// 영화가 인벤토리에 존재하는지 확인
		Integer count = inventoryService.getCountInventoryByFilm(filmId);
		if (count != 0) {
			// 영화가 인벤트로에 존재하면 삭제 불가, 메시지와 함께 영화 상세페이지로 리다이렉트
			Map<String, Object> film = filmService.getFilmOne(filmId);
			log.debug(film.toString());
			
			// 해당 영화의 배우 목록 가져오기
			List<Actor> actorList = actorService.getActorListByFilm(filmId);

			model.addAttribute("film", film);
			model.addAttribute("actorList", actorList);
			model.addAttribute("removeFilmMsg", "film이 inventory에 존재합니다");
			return "on/filmOne";
		}
		
		// 영화가 인벤토리에 없다면 삭제
		filmService.removeFilmByKey(filmId);
		
		// 영화 리스트 페이지로 리다이렉트
		return "redirect:/on/filmList";
	}

	// 영화 목록 페이지 요청 처리
	@GetMapping("/on/filmList")
	public String filmList(Model model, @RequestParam(required = false) Integer categoryId,
			@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer rowPerPage) {
		log.debug("categoryId: " + categoryId);
		log.debug("currentPage: " + currentPage);
		log.debug("rowPerPage: " + rowPerPage);
		
		 // 서비스 메서드 호출
        List<Map<String, Object>> filmList = filmService.getFilmList(categoryId, currentPage, rowPerPage);

        // 페이징 정보 계산
        Integer startPagingNum = (currentPage - 1) / 10 * 10 + 1;
        Integer endPagingNum = startPagingNum + 9;
        
        // Model에 catetory List 추가
 		List<Category> categoryList = categoryService.getCategoryList();
 		log.debug("categoryList: "+categoryList);
        
 		// 모델에 데이터 담기
 		model.addAttribute("categoryList", categoryList);
        model.addAttribute("filmList", filmList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("startPagingNum", startPagingNum);
        model.addAttribute("endPagingNum", endPagingNum);
        model.addAttribute("categoryId", categoryId);
        
        return "on/filmList";  // 해당 뷰로 리턴
	}

	// 영화 추가 처리 (POST)
	@PostMapping("/on/addFilm")
	public String addFilm(FilmForm filmForm) {
		log.debug(filmForm.toString()); // 추가할 영화 정보 출력

		// FilmForm Film 객체로 변환하여 영화 추가
		filmService.addFilm(filmForm);

		// 영화 목록 페이지로 리다이렉트
		return "redirect:/on/filmList";
	}
	
	// 영화 추가 페이지로 요청 처리 (GET)
	@GetMapping("/on/addFilm")
	public String addFilm(Model model) {
		// 언어 목록 가져오기
		List<Language> languageList = languageService.getLanguageList();
		log.debug(languageList.toString());
		model.addAttribute("languageList", languageList);
		
		// 영화 추가 페이지로 이동
		return "on/addFilm";
	}
	
	// 영화 상세 페이지 요청 처리
	@GetMapping("/on/filmOne")
	public String filmOne(Model model, @RequestParam Integer filmId, @RequestParam(required = false) String searchName) {

		/*
		 * O 1) 현재 필름 정보 
		 * O 2) 전체 카테고리 
		 * O 3) 현재 필름의 카테고리 
		 * O 4) 검색 배우 리스트(searchName이 null이 아닐 때) 
		 * O 5) 현재 필름의 배우 리스트
		 */

		// 1) 영화 정보 가져오기
		Map<String, Object> film = filmService.getFilmOne(filmId);
		log.debug(film.toString());

		// 2) 전체 카테고리 목록 가져오기
		List<Category> allCategoryList = categoryService.getCategoryList();

		// 3) 현재 영화에 해당하는 카테고리 목록 가져오기
		List<Map<String, Object>> filmCategoryList = filmCategoryService.getFilmCategoryListByFilm(filmId);

		// 4) 검색어가 있을 경우 배우 검색
		if(searchName != null) {
			List<Actor> searchActorList = actorService.getActorListByActor(searchName);
			model.addAttribute("searchActorList", searchActorList);
		}
		
		// 5) 현재 영화에 출연한 배우 목록 가져오기
		List<Actor> actorList = actorService.getActorListByFilm(filmId);

		model.addAttribute("film", film);
		model.addAttribute("allCategoryList", allCategoryList);
		model.addAttribute("filmCategoryList", filmCategoryList);
		model.addAttribute("actorList", actorList);

		// 영화 상세 페이지로 이동
		return "on/filmOne";
	}
}