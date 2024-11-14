package com.example.sakila.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sakila.vo.ActorFile;

@Mapper
public interface ActorFileMapper {
	
	// /on/removeActor - 배우에 관련된 모든 파일을 삭제
	Integer deleteActorFileByActor(Integer actorId);
	
	// /on/removeActorFile - 특정 배우 파일을 ID로 조회
	ActorFile selectActorFileOne(Integer actorFileId);
	
	// /on/removeActorFile - 특정 배우 파일을 삭제 
	Integer deleteActorFile(Integer actorFileId);
	
	// /on/actorOne - 특정 배우에 해당하는 파일 목록을 조회
	List<ActorFile> selectActorFileListByActor(Integer actorId);
	
	// 배우 파일을 삽입
	Integer insertActorFile(ActorFile actorFile);
}
