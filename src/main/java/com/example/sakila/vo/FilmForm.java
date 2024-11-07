package com.example.sakila.vo;

import java.util.List;

import lombok.Data;

@Data
public class FilmForm {
	private String title; // k
	private String description; // NULL
	private Integer releaseYear;	// NULL
	private int lauguageId; // k, fk
	private Integer originalLanguageId; // k, fk
	private int rentalDuration;
	private double rentalRate;
	private Integer length; // NULL
	private double replacementCost;
	private String rating;

	private List<String> specialFeatures; // 기본값 NULL
	// private String[] specialFeatures;
	// 둘이 같지만 Spring에선 List를 더 많이 쓴다
}
