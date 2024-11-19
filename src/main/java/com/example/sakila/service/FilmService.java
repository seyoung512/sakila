package com.example.sakila.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmActorMapper;
import com.example.sakila.mapper.FilmCategoryMapper;
import com.example.sakila.mapper.FilmMapper;
import com.example.sakila.vo.Customer;
import com.example.sakila.vo.Film;
import com.example.sakila.vo.FilmForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FilmService {
	@Autowired FilmMapper filmMapper;
	@Autowired FilmActorMapper filmActorMapper;
	@Autowired FilmCategoryMapper filmCategoryMapper;
	
	public Integer modifyFilm(FilmForm filmForm) {
		Film film = new Film();
		// FilmForm --> Film
		film.setTitle(filmForm.getTitle());
		if(filmForm.getDescription().equals("")) {
			 film.setDescription(null);
		} else {
			film.setDescription(filmForm.getDescription());
		}
		
		film.setReleaseYear(filmForm.getReleaseYear());
		film.setLanguageId(filmForm.getLanguageId());
		film.setOriginalLanguageId(filmForm.getOriginalLanguageId());
		film.setRentalDuration(filmForm.getRentalDuration());
		film.setRentalRate(filmForm.getRentalRate());
		film.setLength(filmForm.getLength());
		film.setReplacementCost(filmForm.getReplacementCost());
		film.setRating(filmForm.getRating());
		
		if(filmForm.getSpecialFeatures() == null) {
			film.setSpecialFeatures(null);
		} else {
			// specialFeatures 배열 -> ,문자열
			String specialFeatures = filmForm.getSpecialFeatures().get(0);
			
			for(int i=1; i < filmForm.getSpecialFeatures().size(); i++) {
				specialFeatures += "," + filmForm.getSpecialFeatures().get(i);
			}
			
			film.setSpecialFeatures(specialFeatures);
		}
		log.debug(film.toString());
		return filmMapper.updateFilm(film);
	}
	
	public void removeFilmByKey(Integer filmId) {
		// 필름_카테고리 삭제
		filmCategoryMapper.deleteFilmCategoryByFilm(filmId);
		
		// 필름_배우 삭제
		filmActorMapper.deleteActorByFilm(filmId);
		
		// 필름 삭제
		filmMapper.deleteFilmByKey(filmId);
	}
	
	public List<Map<String, Object>> getFilmList(Integer categoryId, Integer currentPage, Integer rowPerPage) {
		Map<String, Object> paramMap = new HashMap<>();
		if(categoryId == null || categoryId == 0) {
			paramMap.put("categoryId", null);
		} else {
			paramMap.put("categoryId", categoryId);
		}
		Integer beginRow = (currentPage - 1) * rowPerPage;
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		
		// 한페이지당 페이징개수는 10개씩이라고 가정
		Integer numPerPage = 10;
		// 페이징 첫번째 페이지 넘버
		Integer startPagingNum = (currentPage-1)/10*10+1; 
		// 페이징 마지막 페이지 넘버
		Integer endPagingNum = startPagingNum + (numPerPage - 1); 
		
		// DB에서 고객 리스트 정보를 가져옴
		List<Map<String, Object>> customerList = filmMapper.selectFilmList(paramMap);
		
		// 페이징 정보와 고객 리스트를 resultMap에 담아서 리턴
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startPagingNum", startPagingNum);
		resultMap.put("endPagingNum", endPagingNum);
		resultMap.put("customerList", customerList);
		
		if(paramMap.get("categoryId") == null) {
			return filmMapper.selectFilmList(paramMap);
		} else {
			return filmMapper.selectFilmListByCategory(paramMap);
		}
	}
	
	public List<Film> getFilmListByTitle(String searchWord) {
		return filmMapper.selectFilmListByTitle(searchWord);
	}
	
	public int addFilm(FilmForm filmForm) {
		Film film = new Film();
		// FilmForm --> Film
		film.setTitle(filmForm.getTitle());
		
		if(filmForm.getDescription().equals("")) {
			 film.setDescription(null);
		} else {
			film.setDescription(filmForm.getDescription());
		}
		// 삼항연산자 사용하면
		// film.setDescription(filmForm.getDescription().equals("") ? null : filmForm.getDescription());
		
		film.setReleaseYear(filmForm.getReleaseYear());
		film.setLanguageId(filmForm.getLanguageId());
		film.setOriginalLanguageId(filmForm.getOriginalLanguageId());
		film.setRentalDuration(filmForm.getRentalDuration());
		film.setRentalRate(filmForm.getRentalRate());
		film.setLength(filmForm.getLength());
		film.setReplacementCost(filmForm.getReplacementCost());
		film.setRating(filmForm.getRating());
		
		if(filmForm.getSpecialFeatures() == null) {
			film.setSpecialFeatures(null);
		} else {
			// specialFeatures 배열 -> ,문자열
			String specialFeatures = filmForm.getSpecialFeatures().get(0);
			
			for(int i=1; i < filmForm.getSpecialFeatures().size(); i++) {
				specialFeatures += "," + filmForm.getSpecialFeatures().get(i);
			}
			
			film.setSpecialFeatures(specialFeatures);
		}
		
		return filmMapper.insertFilm(film);
	}
	
	public Map<String, Object> getFilmOne(Integer filmId) {
		return filmMapper.selectFilmOne(filmId);
	}
	
	// /on/actorOne
	public List<Film> getFilmTitleListByActor(Integer actorId) {
		return filmMapper.selectFilmTitleListByActor(actorId);
	}
}