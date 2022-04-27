package com.steamlike.steamlike.business.dtos;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSale {
	
	private long id;
	
	private BigInteger price;
	
	private long campaignId;
	
	private long gameId;
	
	private long gamerGamerId;

}
