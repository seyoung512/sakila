package com.example.sakila.vo;

import lombok.Data;

@Data
public class Actor {
	private int actorId; //pk
	private String firstName;
	private String lastName; //k
	private String lastUpdate;
}
