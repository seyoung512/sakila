package com.example.sakila.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.mapper.ActorFileMapper;
import com.example.sakila.mapper.ActorMapper;
import com.example.sakila.mapper.FilmActorMapper;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ActorService {
	@Autowired ActorMapper actorMapper;
	@Autowired ActorFileMapper actorFileMapper;
	@Autowired FilmActorMapper filmActorMapper;  
	
	// 배우 이름으로 배우 목록을 조회하는 메소드
	public List<Actor> getActorListByActor(String searchName) {
		return actorMapper.selectActorListByActor(searchName);
	}
	
	// /on/removeActor
	// 배우 삭제 기능: 배우와 관련된 모든 정보(영화, 파일 등) 삭제
	public void removeActor(int actorId, String path) {
		
		// 1) film_actor 삭제 : 배우와 관련된 영화 정보 삭제
		filmActorMapper.deleteFilmByActor(actorId);
		
		// 2) actor_file 삭제 : 배우 파일 목록 조회 후 파일 정보 삭제
		List<ActorFile> list = actorFileMapper.selectActorFileListByActor(actorId);
		actorFileMapper.deleteActorFileByActor(actorId);
		
		// 3) actor 삭제 : 배우 정보 삭제
		Integer row = actorMapper.deleteActor(actorId);
		
		// 4) 물리적 파일 삭제: 배우 삭제가 완료되었고 파일이 존재하는 경우 파일을 삭제
		if(row == 1 && list != null && list.size() > 0) { // actor 삭제했고 물리적파일 존재한다면
			for(ActorFile af : list) {
				String fullName = path + af.getFilename() + "." + af.getExt();
				File f = new File(fullName);f.delete();
			}
		}
		
	}
	
	// /on/modifyActor
	// 배우 정보 수정 기능
	public Integer modifyActor(Actor actor) {
		return actorMapper.updateActor(actor);
	}
	
	// /on/filmOne
	// 영화 ID로 배우 목록을 조회하는 메소드
	public List<Actor> getActorListByFilm(int filmId) {
		return actorMapper.selectActorListByFilm(filmId);
	}
	
	// 전체 배우 목록의 마지막 페이지 번호 계산
	public Integer getLastPage(Integer rowPerPage, String searchWord) {
		Integer count = actorMapper.totalCount(searchWord);
		Integer lastPage = count / rowPerPage;
		if (count % rowPerPage != 0) lastPage++;
		return lastPage;
	}
	
	// /on/actorOne
	// 특정 배우의 정보를 조회하는 메소드
	public Actor getActorOne(int actorId) {
		return actorMapper.selectActorOne(actorId);
	}
	
	// 특정 페이지에 해당하는 배우 목록 조회
	public Map<String, Object> getActorList(Integer currentPage, Integer rowPerPage, String searchWord) {
		Integer beginRow = (currentPage -1) * rowPerPage;
		
		// 파라미터 맵을 만들어 beginRow와 rowPerPage 값을 담음
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("beginRow", beginRow);
		paramMap.put("rowPerPage", rowPerPage);
		paramMap.put("searchWord", searchWord);
		
		// 한페이지당 페이징개수는 10개씩이라고 가정
		Integer numPerPage = 10;
		// 페이징 첫번째 페이지 넘버
		Integer startPagingNum = (currentPage-1)/10*10+1; 
		// 페이징 마지막 페이지 넘버
		Integer endPagingNum = startPagingNum + (numPerPage - 1); 
		
		// DB에서 고객 리스트 정보를 가져옴
		List<Actor> actorList = actorMapper.selectActorList(paramMap);
		
		// 페이징 정보와 배우 리스트를 resultMap에 담아서 리턴
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("startPagingNum", startPagingNum);
		resultMap.put("endPagingNum", endPagingNum);
		resultMap.put("actorList", actorList);
		
		return resultMap;
	}
	
	// 새로운 배우 추가 및 배우 파일 추가 기능
	public void addActor(ActorForm actorForm, String path) {
		Actor actor = new Actor();
		actor.setFirstName(actorForm.getFirstName());
		actor.setLastName(actorForm.getLastName());
		
		// actorId = 0
		Integer row1 = actorMapper.insertActor(actor);
		// mybatis selectKey의 값
		Integer actorId = actor.getActorId();
		
		if(row1 == 1 && actorForm.getActorFile() != null) {
			// 파일 입력, ActorFile 입력
			List<MultipartFile> list = actorForm.getActorFile();
			for(MultipartFile mf : list) {
				ActorFile actorFile = new ActorFile();
				
				actorFile.setActorId(actorId);
				actorFile.setType(mf.getContentType());
				actorFile.setSize(mf.getSize());
				
				// 파일 이름을 UUID로 설정하여 중복을 방지
				String filename = UUID.randomUUID().toString().replace("-","");
				actorFile.setFilename(filename);
				
				// 원본 파일명에서 확장자 추출
				Integer dotIdx = mf.getOriginalFilename().lastIndexOf(".");
				String originname = mf.getOriginalFilename().substring(0, dotIdx);
				String ext = mf.getOriginalFilename().substring(dotIdx+1);
				actorFile.setOriginname(originname);
				actorFile.setExt(ext);
				
				// 파일 정보 데이터베이스에 입력
				Integer row2 = actorFileMapper.insertActorFile(actorFile);
				if(row2 == 1) {
					// 물리적 파일 저장
					try {
						mf.transferTo(new File(path + filename + "." + ext));
					} catch (Exception e) {
						e.printStackTrace();
						// 예외 발생하고 예외처지 하지 않아야지 @Transactional 작동한다
						// so.. RuntimeException을 인위적으로 발생
						throw new RuntimeException();
					}
				}
			}
		}
	}
}
