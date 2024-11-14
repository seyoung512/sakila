package com.example.sakila.vo;

import lombok.Data;

@Data
public class Payment {
	private Integer paymentId; //pk
	private Integer customerId; //k, fk
	private Integer staffId; //k, fk
	private Integer rentalId; //k, fk
	private double amount;
	private String paymentDate;
	private String lastUpdate;
}
