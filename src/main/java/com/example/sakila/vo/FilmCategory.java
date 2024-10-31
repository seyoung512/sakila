package com.example.sakila.vo;

import lombok.Data;

@Data
public class FilmCategory {
	private int filmId; // pk, fk
	private int categoryId; // pk, fk, k
	private String lastUpdate;
}
