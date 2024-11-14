package com.example.sakila.vo;

import lombok.Data;

@Data
public class City {
	private Integer cityId; //pk
	private String city;
	private String countryId; //k, fk
	private String lastUpdate;
}
