package com.example.sakila.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.Actor;

@Mapper
public interface ActorMapper {
	
	// /on/filmOne : searchName으로 배우를 검색하여 일치하는 결과를 List<Actor> 형태로 변환
	List<Actor> selectActorListByActor(String searchName);
	
	// actorId에 해당하는 배우 삭제
	Integer deleteActor(Integer actorId);
	
	// 배우 객체를 받아서 해당 배우의 정보를 수정
	Integer updateActor(Actor actor);
	
	// searchWord를 기준으로 배우 수를 세어 총 배우 수를 반환
	Integer totalCount(String seachWord);
	
	// /on/filmOne - filmId에 해당하는 영화에 출연한 배우들을 List<Actor> 형태로 출력
	List<Actor> selectActorListByFilm(Integer filmId); 
	
	// /on/actorOne - actorId에 해당하는 배우의 상세 정보를 조회
	Actor selectActorOne(Integer actorId);
	
	// Map<String, Object> 형태의 파라미터를 받아 다양한 조건을 기반으로 배우 목록을 조회
	List<Actor> selectActorList(Map<String, Object> paramMap);
	
	// Actor 객체를 받아 새로운 배우 정보를 삽입
	Integer insertActor(Actor actor);
}
