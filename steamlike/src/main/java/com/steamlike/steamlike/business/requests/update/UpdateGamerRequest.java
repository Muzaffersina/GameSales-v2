package com.steamlike.steamlike.business.requests.update;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGamerRequest {
	
	@NotNull
	@Positive
	private long gamerId;
	
	@NotNull
	@Size(min = 3)
	private String email;
	
	@NotNull
	@Size(min = 3)
	private String password;
	
	@NotNull
	@Size(min = 3)
	private String firstName;

	@NotNull
	@Size(min = 3)
	private String lastName;
}
