package com.example.sakila.vo;

import lombok.Data;

@Data
public class Film {
	private int filmId; // pk
	private String title; // k
	private String description; // 기본값 NULL
	private Integer releaseYear; // 기본값 NULL // 숫자인데 null값을 받고 싶을 때는 integer로 하자
	private int lauguageId; // k, fk
	private Integer originalLanguageId; // k, fk
	private int rentalDuration;
	private double rentalRate;
	private Integer length; // 기본값 NULL
	private double replacementCost;
	private String rating;
	private String specialFeatures; // 기본값 NULL
	private String lastUpdate;
}
