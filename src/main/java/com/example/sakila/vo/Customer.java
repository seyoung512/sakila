package com.example.sakila.vo;

import lombok.Data;

@Data
public class Customer {
	private Integer customerId; // pk
	private Integer storeId; // k, fk
	private String firstName;
	private String lastName; // k
	private String email;
	private Integer addressId; // k, fk
	private Integer active;
	private String createDate;
	private String lastUpdate;
}
