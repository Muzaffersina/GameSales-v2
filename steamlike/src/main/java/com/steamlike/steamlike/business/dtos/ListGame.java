package com.steamlike.steamlike.business.dtos;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListGame {
	
	private long id;

	private String gameName;
	

	private BigInteger price;
	
}

