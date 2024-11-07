package com.example.sakila.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sakila.mapper.FilmMapper;
import com.example.sakila.vo.Film;
import com.example.sakila.vo.FilmForm;

@Service
@Transactional
public class FilmService {
	@Autowired FilmMapper filmMapper;
	
	public int addFilm(FilmForm filmForm) {
		Film film = new Film();
		// FilmForm --> Film
		film.setTitle(filmForm.getTitle());
		// 가져온 값이 공백이면 null이고 값을 가져오면 그대로 셋한다
		film.setDescription(filmForm.getDescription().equals("") ? null : filmForm.getDescription());
		film.setReleaseYear(filmForm.getReleaseYear());
		film.setLauguageId(filmForm.getLauguageId());
		film.setOriginalLanguageId(film.getOriginalLanguageId());
		film.setRentalDuration(film.getRentalDuration());
		film.setRentalRate(film.getRentalRate());
		film.setLength(filmForm.getLength());
		film.setReplacementCost(filmForm.getReplacementCost());
		film.setRating(filmForm.getRating());
		
		if(filmForm.getSpecialFeatures() == null) {
			film.setSpecialFeatures(null);
		} else {
		
		// specialFeatures 배열 --> ,문자열
		String specialFeatures = filmForm.getSpecialFeatures().get(0);
		
		for(int i=1; i < filmForm.getSpecialFeatures().size(); i++) {
			specialFeatures += ", " + filmForm.getSpecialFeatures().get(i);
			}
		
			film.setSpecialFeatures(specialFeatures);
		}
		
		return filmMapper.insertFilm(film);
	}
	
	// /on/filmOne
	public Map<String, Object> getFilmOne(int filmId) {
		return filmMapper.selectFilmOne(filmId);
	}

	// /on/actorOne
	public List<Film> getFilmTitleListByActor(int actorId) {
		return filmMapper.selectFilmTitleListByActor(actorId);
	}
}
