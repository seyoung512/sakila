package com.example.sakila.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.sakila.service.ActorFileService;
import com.example.sakila.vo.ActorForm;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ActorFileController {
	@Autowired ActorFileService actorFileService; // 배우 파일 관련 비즈니스 로직을 처리하는 서비스
	
	// 배우 파일 삭제 요청 처리
	@GetMapping("/on/removeActorFile")
	public String removeActorFile(HttpSession session
								, @RequestParam int actorId
								, @RequestParam int actorFileId) {
		String path = session.getServletContext().getRealPath("/upload/"); // 파일 업로드 경로 가져오기
		actorFileService.removeActorFile(actorFileId, path); // 배우 파일 삭제 서비스 호출
		return "redirect:/on/actorOne?actorId=" + actorId; // 파일 삭제 후 해당 배우의 상세페이지로 리다이렉트
	}
	
	// 배우 파일 추가 요청 처리
	@PostMapping("/on/addActorFile")
	public String addActorFile(HttpSession session, Model model, ActorForm actorForm) {
		List<MultipartFile> list = actorForm.getActorFile(); // 첨부된 파일 목록을 가져옴
		for(MultipartFile f : list) { // 각 파일에 대해 검증, 이미지 파일 형식이 JPG나 PNG인지 확인
			if(f.getContentType().equals("lmage/jpeg") == false 
					&& f.getContentType().equals("image/png") == false) {
				model.addAttribute("msg", "이미지 파일만 입력이 가능합니다"); // 이미지 파일이 아닌 경우 오류 메시지
		
				return "on/addActorFile"; // 오류 발생 시 파일 추가 페이지로 돌아감
			}
		}
		 
		String path = session.getServletContext().getRealPath("/upload/"); // 업로드 경로 가져오기
		actorFileService.addActorFile(actorForm, path); // 배우 파일 추가 서비스 호출
		
		return "redirect:/on/actorOne?actorId="+actorForm.getActorId(); // 배우 파일 추가 후 해당 배우의 상세 페이지로 리다이렉트
	}
	
	// 배우 파일 추가 페이지 요청 처리(GET)
	@GetMapping("/on/addActorFile") // actorId는 actorOne.jsp에서 전달됨
	public String addActorFile(Model model, @RequestParam int actorId) {
		model.addAttribute("actorId", actorId); // 모델에 actorId를 추가 (파일 추가 페이지에서 사용할 데이터)
		
		return "on/addActorFile"; // 배우 파일 추가 페이지로 이동
	}
}
