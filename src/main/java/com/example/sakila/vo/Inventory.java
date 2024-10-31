package com.example.sakila.vo;

import lombok.Data;

@Data
public class Inventory {
	private int inventoryId; // pk
	private int filmId; // fk, k
	private int storeId; // fk, k
	private String lastUpdate;
}
