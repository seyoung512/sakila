package com.example.sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 이 클래스에서 log라는 변수를 사용 가능
@Controller
public class Hello {
   @GetMapping("/hello")
   public String hello() {
      log.debug("ㅎㅎ"); 
      return "hello";
   }
}
