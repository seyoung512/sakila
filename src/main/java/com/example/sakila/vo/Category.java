package com.example.sakila.vo;

import lombok.Data;

@Data
public class Category {
	private int categoryId; //pk
	private String name;
	private String lastUpdate;
}
