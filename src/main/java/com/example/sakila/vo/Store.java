package com.example.sakila.vo;

import lombok.Data;

@Data
public class Store {
	private Integer storeId; //pk
	private Integer managerStaffId; //U,fk
	private Integer addressId; //k,fk
	private String lastUpdate;
}
