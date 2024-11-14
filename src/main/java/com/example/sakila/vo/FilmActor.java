package com.example.sakila.vo;
 
import lombok.Data;

@Data
public class FilmActor {
	private Integer actorId; // pk, fk
	private Integer filmId; // pk, fk, k
	private String lastUpdate;
}
