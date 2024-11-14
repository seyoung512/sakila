package com.example.sakila.vo;

import lombok.Data;

@Data
public class Rental {
	private Integer rentalId; //pk
	private String rentalDate; //U
	private Integer inventoryId; //U,k,fk
	private Integer customerId; //U,k,fk
	private String returnDate;
	private Integer staffId; //k,fk
	private String lastUpdate;
}