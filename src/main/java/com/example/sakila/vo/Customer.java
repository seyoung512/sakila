package com.example.sakila.vo;

import lombok.Data;

@Data
public class Customer {
	private int customerId; // pk
	private int storeId; // k, fk
	private String firstName;
	private String lastName; // k
	private String email;
	private int addressId; // k, fk
	private int active;
	private String createDate;
	private String lastUpdate;
}
