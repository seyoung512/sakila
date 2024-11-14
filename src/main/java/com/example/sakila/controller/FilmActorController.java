package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.sakila.service.FilmActorService;
import com.example.sakila.vo.FilmActor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FilmActorController {
	
	@Autowired FilmActorService filmActorService; // 영화와 배우를 연결하는 서비스
	
	// 영화 상세 페이지에서 배우 제거 요청 처리
	@GetMapping("/on/removeFilmActorByFilm")
	public String removeFilmActorByFilm(FilmActor filmActor) {
		log.debug("filmId: "+filmActor.getFilmId()); // 영화 ID 디버깅
		log.debug("actorId: "+filmActor.getActorId()); // 배우 ID 디버깅
		// 영화에서 배우를 제거하는 서비스 호출
		int row = filmActorService.removeFilmActor(filmActor);
		
		// 영화 상세 페이지로 리다이렉트
		return "redirect:/on/filmOne?filmId="+filmActor.getFilmId();
	}
	
	// 배우 상세 페이지에서 영화 제거 요청 처리
	@GetMapping("/on/removeFilmActorByActor")
	public String removeFilmActorByActor(FilmActor filmActor) {
		log.debug("filmId: "+filmActor.getFilmId()); // 영화 ID 디버깅
		log.debug("actorId: "+filmActor.getActorId()); // 영화 ID 디버깅
		// 배우에서 영화를 제거하는 서비스 호출
		int row = filmActorService.removeFilmActor(filmActor);
		
		// 배우 상세 페이지로 리다이렉트
		return "redirect:/on/actorOne?actorId="+filmActor.getActorId();
	}
	
	// 영화 상세 페이지에서 배우 추가 요청 처리
	@PostMapping("/on/addFilmActorByFilm")
	public String addFilmActorByFilm(FilmActor filmActor) {
		log.debug("filmId: "+filmActor.getFilmId()); // 영화 ID 디버깅
		log.debug("actorId: "+filmActor.getActorId()); // 영화 ID 디버깅
		// 영화에서 배우를 추가하는 서비스 호출
		int row = filmActorService.addFilmActor(filmActor);

		// 영화 상세 페이지로 리다이렉트
		return "redirect:/on/filmOne?filmId="+filmActor.getFilmId();
	}
	
	// 배우 상세 페이지에서 영화 추가 요청 처리
	@PostMapping("/on/addFilmActorByActor")
	public String addFilmActorByActor(FilmActor filmActor) {
		log.debug("filmId: "+filmActor.getFilmId()); // 영화 ID 디버깅
		log.debug("actorId: "+filmActor.getActorId()); // 영화 ID 디버깅
		// 배우에서 영화를 추가하는 서비스 호출
		int row = filmActorService.addFilmActor(filmActor);

		// 배우 상세 페이지로 리다이렉트
		return "redirect:/on/actorOne?actorId="+filmActor.getActorId();
	}
}
