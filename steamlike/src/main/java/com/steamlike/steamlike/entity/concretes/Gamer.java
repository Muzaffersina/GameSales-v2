package com.steamlike.steamlike.entity.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="gamers")
@PrimaryKeyJoinColumn(name = "gamer_id" , referencedColumnName = "id")
public class Gamer extends User {
	
	@Column(name = "gamer_id",insertable = false, updatable = false)
    private long gamerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="ssn")
	private String ssn;
	
	@Column(name="date_of_birth")
	private int dateOfBirth;
	
}
