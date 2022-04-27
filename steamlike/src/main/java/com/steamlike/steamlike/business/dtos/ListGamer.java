package com.steamlike.steamlike.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListGamer {
	
	private String email;
	private String password;
    private long gamerId;
	private String firstName;
	private String lastName;
	private String ssn;
	private int dateOfBirth;

}
