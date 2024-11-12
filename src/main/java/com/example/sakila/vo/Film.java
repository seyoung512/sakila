package com.example.sakila.vo;

import lombok.Data;

// vo에서 기본타입보다는 랩핑타입을 고려(RDBMS, mybatis)

@Data
public class Film {
	private Integer filmId; // pk
	private String title; // k
	private String description; // 기본값 NULL
	private Integer releaseYear; // 기본값 NULL // 숫자인데 null값을 받고 싶을 때는 integer로 하자
	private Integer languageId; // k, fk
	private Integer originalLanguageId; // k, fk
	private Integer rentalDuration;
	private Double rentalRate;
	private Integer length; // 기본값 NULL
	private Double replacementCost;
	private String rating;
	private String specialFeatures; // 기본값 NULL
	private String lastUpdate;
}
