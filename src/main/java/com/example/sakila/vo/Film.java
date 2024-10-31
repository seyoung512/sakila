package com.example.sakila.vo;

import lombok.Data;

@Data
public class Film {
	private int filmId; // pk
	private String title; // k
	private String description;
	private String releaseYear;
	private int lauguageId; // k, fk
	private int originalLanguageId; // k, fk
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String lastUpdate;
}
