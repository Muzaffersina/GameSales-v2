package com.steamlike.steamlike.business.requests.create;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGameRequest {
	@NotNull
	@Size(min = 1)
	private String gameName;
	
	@NotNull
	@Positive
	private BigInteger price;
}
