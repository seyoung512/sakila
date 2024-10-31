package com.example.sakila.vo;

import lombok.Data;

@Data
public class Rental {
	private int rentalId; //pk
	private String rentalDate; //U
	private int inventoryId; //U,k,fk
	private int customerId; //U,k,fk
	private String returnDate;
	private int staffId; //k,fk
	private String lastUpdate;
}