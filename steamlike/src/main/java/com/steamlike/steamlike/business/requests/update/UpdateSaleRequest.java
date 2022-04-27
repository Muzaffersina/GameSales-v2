package com.steamlike.steamlike.business.requests.update;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSaleRequest {
	
	@NotNull
	@Positive
	private long id;
	
	
	@NotNull
	@Positive
	private long gameId;

	
	@NotNull
	@Positive
	private long gamerGamerId;
	
	@NotNull
	@Positive
	private long campaignId;

}
