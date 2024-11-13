package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmCategoryMapper;
import com.example.sakila.vo.FilmCategory;

@Service
@Transactional
public class FilmCategoryService {
	@Autowired FilmCategoryMapper filmCategoryMapper;
	
	public Integer removeFilmCategory(FilmCategory filmCategory) {
		return filmCategoryMapper.deleteFilmCategory(filmCategory);
	}
	
	public Integer addFilmCategory(FilmCategory filmCategory) {
		return filmCategoryMapper.insertFilmCategory(filmCategory);
	}
	
	public List<Map<String, Object>> getFilmCategoryListByFilm(Integer filmId) {
		return filmCategoryMapper.selectFilmCategoryListByFilm(filmId);
	}
}
