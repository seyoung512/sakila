package com.example.sakila.vo;

import lombok.Data;

@Data
public class Language {
	private Integer languageId; //pk
	private String name;
	private String lastUpdate;
}
