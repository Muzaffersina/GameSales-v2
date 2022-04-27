package com.steamlike.steamlike.business.requests.create;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGamerRequest {
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

	@NotNull
	@Size(min = 11 ,max = 12)
	private String ssn;
	@NotNull
	@Positive
	private int dateOfBirth;
}
