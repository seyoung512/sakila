package com.example.sakila.vo;

import lombok.Data;

@Data
public class FilmCategory {
	private Integer filmId; // pk, fk
	private Integer categoryId; // pk, fk, k
	private String lastUpdate;
}
