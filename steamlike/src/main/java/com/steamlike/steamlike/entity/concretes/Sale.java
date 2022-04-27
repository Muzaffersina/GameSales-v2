package com.steamlike.steamlike.entity.concretes;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="price")
	private BigInteger price;
	
	@ManyToOne
	@JoinColumn(name = "game_name")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "gamer_id")
	private Gamer gamer;
	
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;
}
