package com.example.sakila.vo;

import lombok.Data;

@Data
public class Address {
	private Integer addressId; //pk
	private String address;
	private String address2;
	private String district;
	private Integer cityId; //k,fk
	private String postalCode;
	private String phone;
	private String lastUpdate;
}
