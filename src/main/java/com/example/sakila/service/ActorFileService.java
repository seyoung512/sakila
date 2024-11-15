package com.example.sakila.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.mapper.ActorFileMapper;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;

@Service
@Transactional
public class ActorFileService {
	@Autowired ActorFileMapper actorFileMapper;
	
	// /on/removeActorFile
	// 1) actor_file 삭제 2) 물리 파일 삭제(이름이 필요, 경로PATH 필요)
	public void removeActorFile(int actorFileId, String path) {
		// 1) 파일이름 select 
		ActorFile actorFile = actorFileMapper.selectActorFileOne(actorFileId);
		int  row = actorFileMapper.deleteActorFile(actorFileId);
		if(row == 1) { // actor_file정보 삭제가 되었다면 물리적 파일도 삭제
			String fullName = path + actorFile.getFilename() + "." + actorFile.getExt();
			File f = new File(fullName); // 
			f.delete();
		}
	}
	
	// 배우 정보란에 배우 파일 추가 
	// /on/addActorFile
	public void addActorFile(ActorForm actorForm, String path) {
		if(actorForm.getActorFile() != null) {
			// 파일 입력, ActorFile 입력
			List<MultipartFile> list = actorForm.getActorFile();
			for(MultipartFile mf : list) {
				ActorFile actorFile = new ActorFile();
				
				actorFile.setActorId(actorForm.getActorId());
				actorFile.setType(mf.getContentType());
				actorFile.setSize(mf.getSize());
				
				// 파일 이름을 UUID로 설정하여 중복을 피함
				String filename = UUID.randomUUID().toString().replace("-","");
				actorFile.setFilename(filename);
				
				 // 원본 파일명에서 확장자 분리
				int dotIdx = mf.getOriginalFilename().lastIndexOf(".");
				String originname = mf.getOriginalFilename().substring(0, dotIdx);
				String ext = mf.getOriginalFilename().substring(dotIdx+1);
				actorFile.setOriginname(originname);
				actorFile.setExt(ext);
				
				// 데이터베이스에 파일 정보 저장
				int row2 = actorFileMapper.insertActorFile(actorFile);
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
	
	// /on/actorOne
	// 특정 배우의 파일 목록을 조회하는 메소드
	public List<ActorFile> getselectFilmTitleListByActor(int actorId) {
		return actorFileMapper.selectActorFileListByActor(actorId);
	}
}
