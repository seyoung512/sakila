package com.example.sakila.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.FilmActor;

@Mapper
public interface FilmActorMapper {
	
	// 특정 영화 삭제시 해당 영화와 관련된 배우 정보 삭제
	Integer deleteActorByFilm(Integer filmId);
	
	// 특정 배우가 삭제 시 해당 배우가 출연한 영화 정보를 삭제
	Integer deleteFilmByActor(Integer actorId); // Integer deleteFilmActorByActor(int actorId)
	
	// 특정 영화에서 특정 배우를 제거
	Integer deleteFilmActor(FilmActor filmActor);
	
	// 특정 영화에 특정 배우가 출연하는 영화로 추가
	Integer insertFilmActor(FilmActor filmActor);
}
