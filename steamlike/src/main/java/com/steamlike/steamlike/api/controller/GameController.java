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

import com.steamlike.steamlike.business.abstracts.GameService;
import com.steamlike.steamlike.business.dtos.ListGame;
import com.steamlike.steamlike.business.requests.create.CreateGameRequest;
import com.steamlike.steamlike.business.requests.delete.DeleteGameRequest;
import com.steamlike.steamlike.business.requests.update.UpdateGameRequest;
import com.steamlike.steamlike.core.results.DataResult;
import com.steamlike.steamlike.core.results.Result;

@RestController
@RequestMapping("/api/game-controller")
public class GameController {
	
	private GameService gameService;
	
	@Autowired
	public GameController(GameService gameService) {
	
		this.gameService = gameService;
	} 
	
	
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateGameRequest createGameRequest) {
		
		return this.gameService.add(createGameRequest);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestBody @Valid DeleteGameRequest deleteGameRequest) {
		
		return this.gameService.delete(deleteGameRequest);
	}
	@PutMapping	("/update")
	public Result update(@RequestBody @Valid UpdateGameRequest updateGameRequest) {
		
		return this.gameService.update(updateGameRequest);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<ListGame>> getAll(){ 
		return this.gameService.getAll();
	}
	
	

}
