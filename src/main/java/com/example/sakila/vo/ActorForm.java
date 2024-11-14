package com.example.sakila.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ActorForm {
	private Integer actorId; // addActorFile 때문에 id 입력
	private String firstName;
	private String lastName;
	private List<MultipartFile> actorFile;
	
}
