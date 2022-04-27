package com.steamlike.steamlike.business.requests.update;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateGameRequest {
	
	private long id;

	private String gameName;
	

	private BigInteger price;


}
