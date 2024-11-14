package com.example.sakila.vo;

import lombok.Data;

@Data
public class Actor {
	private Integer actorId; //pk
	private String firstName;
	private String lastName; //k
	private String lastUpdate;
}
