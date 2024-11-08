package com.example.sakila.vo;
 
import lombok.Data;

@Data
public class FilmActor {
	private int actorId; // pk, fk
	private int filmId; // pk, fk, k
	private String lastUpdate;
}
