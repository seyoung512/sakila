package com.example.sakila.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.sakila.mapper.LanguageMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LanguageController {
	@Autowired LanguageMapper languageMapper;
	
	
}
