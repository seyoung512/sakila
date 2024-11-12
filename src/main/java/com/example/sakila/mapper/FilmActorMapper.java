package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.FilmActor;

@Mapper
public interface FilmActorMapper {
	
	// film 삭제시 film_actor들을 삭제
	Integer deleteActoryByFilm(int filmId);
	
	// 배우 삭제시 film_actor들을 삭제
	int deleteFilmByActor(int actorId); // Integer deleteFilmActorByActor(int actorId)
	
	int deleteFilmActor(FilmActor filmActor);
	
	int insertFilmActor(FilmActor filmActor);
}
