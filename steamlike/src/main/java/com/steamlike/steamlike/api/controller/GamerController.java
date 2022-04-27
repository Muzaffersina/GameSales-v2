package com.steamlike.steamlike.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.steamlike.steamlike.business.abstracts.GamerService;
import com.steamlike.steamlike.business.dtos.ListGamer;
import com.steamlike.steamlike.business.requests.create.CreateGamerRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGamerRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGamerRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;


@RestController
@RequestMapping("/api/gamer-controller")
public class GamerController {
	
	private GamerService gamerService;

	@Autowired
	public GamerController(GamerService gamerService) {
		super();
		this.gamerService = gamerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateGamerRequest createGamerRequest) {
		
		return this.gamerService.add(createGamerRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteGamerRequest deleteGamerRequest) {
		
		return this.gamerService.delete(deleteGamerRequest);
	}
	@PutMapping	("/update")
	public Result update(@RequestBody @Valid UpdateGamerRequest updateGamerRequest) {
		
		return this.gamerService.update(updateGamerRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListGamer>> getAll(){ 
		return this.gamerService.getAll();
	}
	
	@GetMapping("/getByIdGamer")
	public DataResult<ListGamer> getById(long gamerId){
		return this.gamerService.getById(gamerId);
	}
	
}	
