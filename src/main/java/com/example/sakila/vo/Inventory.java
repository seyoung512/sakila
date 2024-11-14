package com.example.sakila.vo;

import lombok.Data;

@Data
public class Inventory {
	private Integer inventoryId; // pk
	private Integer filmId; // fk, k
	private Integer storeId; // fk, k
	private String lastUpdate;
}
