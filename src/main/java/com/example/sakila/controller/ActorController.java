package com.example.sakila.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.service.ActorFileService;
import com.example.sakila.service.ActorService;
import com.example.sakila.service.FilmService;
import com.example.sakila.vo.Actor;
import com.example.sakila.vo.ActorFile;
import com.example.sakila.vo.ActorForm;
import com.example.sakila.vo.Film;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ActorController {
	@Autowired ActorService actorService; // 배우 관련 비즈니스 로직을 처리하는 서비스
	@Autowired ActorFileService actorFileService; // 배우 파일 데이터를 처리하는 서비스
	@Autowired FilmService filmService; // 영화 관련 데이터를 처리하는 서비스
	
	// 배우 삭제 요청 처리(배우 ID로 삭제)
	@GetMapping("/on/removeActor")
	public String removeActor(HttpSession session, @RequestParam Integer actorId) {
		String path = session.getServletContext().getRealPath("/upload/"); // 파일 업로드 경로 가져오기
		actorService.removeActor(actorId, path); // 배우 삭제 서비스 호출
		return "redirect:/on/actorList"; // 삭제 후 배우 리스트로 리다이렉트
	}
	
	// 배우 정보 수정 요청 처리
	@PostMapping("/on/modifyActor")
	public String modifyActor(Actor actor) {
		log.debug(actor.toString()); // 수정할 배우의 정보를 디버깅
		
		Integer row = actorService.modifyActor(actor); // 배우 정보를 DB에서 수정
		
		
		return "redirect:/on/actorOne?actorId="+actor.getActorId(); // 수정된 배우의 상세 페이지로 리다이렉트
	}
	
	// 배우 수정 페이지를 보여주는 GET 요청 처리
	@GetMapping("/on/modifyActor")
	public String modifyActor(Model model, @RequestParam Integer actorId) {
		Actor actor = actorService.getActorOne(actorId); // 배우 ID로 해당 
		log.debug("actor-->>" + actorId); // 디버깅용으로 배우 ID 출력
		
		model.addAttribute("actor", actor); // 모델에 배우 데이터를 추가
		return "on/modifyActor"; // 배우 수정 페이지로 이동
	}
	
	// 배우 상세 정보 페이지 요청 처리
	@GetMapping("/on/actorOne") 
	public String actorOne(Model model
							, @RequestParam(defaultValue = "") String searchTitle
							, @RequestParam Integer actorId) {
		// 배우의 상세 정보를 가져옴
		Actor actor = actorService.getActorOne(actorId);
		// 해당 배우가 출연한 영화 리스트를 가져옴
		List<ActorFile> actorFileList = actorFileService.getselectFilmTitleListByActor(actorId);
		List<Film> filmList = filmService.getFilmTitleListByActor(actorId);
		
		log.debug(actor.toString()); // 배우 정보 디버깅
		log.debug(actorFileList.toString()); // 배우 파일 리스트 디버깅
		log.debug(filmList.toString()); // 영화 리스트 디버깅
				
		// 영화 제목으로 검색한 결과가 있으면, 그 결과를 모델에 추가
		if(searchTitle.equals("") == false) {
			// film 검색결과 리스트를 추가
			List<Film> searchFilmList = filmService.getFilmListByTitle(searchTitle); // 영화 제목 검색
			model.addAttribute("searchFilmList", searchFilmList); // 검색된 영화 리스트 모델에 추가
		}
		
		// 배우, 배우 파일, 영화 리스트를 모델에 추가
		model.addAttribute("actor", actor);
		model.addAttribute("actorFileList", actorFileList);
		model.addAttribute("filmList", filmList);
		
		// 배우 상세 정보 페이지로 이동
		return "on/actorOne";
	}
	
	// 배우 리스트 페이지를 보여주는 GET 요청 처리 (페이징 처리)
	@GetMapping("/on/actorList")
	public String actorList(Model model
							, @RequestParam(defaultValue = "1") Integer currentPage
							, @RequestParam(defaultValue = "10") Integer rowPerPage
							, @RequestParam(required = false) String searchWord) {
			log.debug("searchWord : "+searchWord); // 검색어 디버깅
			
			// 현재 페이지와 검색어에 맞는 배우 목록을 가져옴
			Map<String, Object> resultMap = actorService.getActorList(currentPage, rowPerPage, searchWord);
			
			// 디버깅
			log.debug(resultMap.toString());
			
			// 전체 배우 수에 맞춰 마지막 페이지 번호를 계산
			Integer lastPage = actorService.getLastPage(rowPerPage, searchWord);
			
			// 페이지네이션 및 검색어 정보를 모델에 추가
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPagingNum", resultMap.get("startPagingNum"));
			model.addAttribute("endPagingNum", resultMap.get("endPagingNum"));
			model.addAttribute("actorList", resultMap.get("actorList"));
			model.addAttribute("searchWord", searchWord);
			
			// 배우 목록 페이지로 이동
			return "on/actorList";
	}
	
	// 새 배우 추가 요청 처리(POST)
	@PostMapping("/on/addActor")
	public String addActor(HttpSession session, Model model, ActorForm actorForm) { //input type="file"
		
		// 디버깅
		/* log.debug(actorForm.getFirstName());
		log.debug(actorForm.getLastName());
		log.debug("actorFile : " + actorForm.getActorFile().size());
		if(actorForm.getActorFile() != null) {
			log.debug("actorFile size : " +actorForm.getActorFile().size());
		} */
		
		// 배우 추가 폼에서 입력된 데이터 확인 및 검증
		List<MultipartFile> list = actorForm.getActorFile();
		if(list != null && list.size() != 0) { // 첨부된 파일이 있다면
			for(MultipartFile f : list) { // 첨부된 파일들이 이미지 파일인지 검증
				if(f.getContentType().equals("image/jpeg") == false
						&& f.getContentType().equals("image/png") == false) {
					model.addAttribute("msg", "이미지 파일만 입력이 가능합니다"); // 이미지 파일 아닌 경우 에러 메시지
					
					return "on/addActor"; // 다시 배우 추가 페이지로 돌아감
				}
			}
		}
		
		// 업로드 경로 가져오기
		String path = session.getServletContext().getRealPath("/upload/");
		log.debug(path); // 업로드 경로 디버깅
		
		// 배우 추가 서비스 호출
		actorService.addActor(actorForm, path);
		
		// 배우 목록 페이지로 리다이렉트
		return "redirect:/on/actorList";
	}
	
	// 배우 추가 페이지를 보여주는 GET 요청 처리
	@GetMapping("/on/addActor")
	public String addActor() {
		
		// 배우 추가 페이지로 이동
		return "on/addActor"; 
	}
}
