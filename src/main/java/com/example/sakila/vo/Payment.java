package com.example.sakila.vo;

import lombok.Data;

@Data
public class Payment {
	private int paymentId; //pk
	private int customerId; //k, fk
	private int staffId; //k, fk
	private int rentalId; //k, fk
	private double amount;
	private String paymentDate;
	private String lastUpdate;
}
