package com.example.sakila.vo;

import lombok.Data;

@Data
public class Store {
	private int storeId; //pk
	private int managerStaffId; //U,fk
	private int addressId; //k,fk
	private String lastUpdate;
}
