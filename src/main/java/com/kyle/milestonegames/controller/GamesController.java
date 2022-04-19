package com.kyle.milestonegames.controller;

import com.kyle.milestonegames.entities.Game;
import com.kyle.milestonegames.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1") 
public class GamesController {
	
	@Autowired
	private GameServices services;
	
	@GetMapping("/game")
	public ResponseEntity<List<Game>> getAllGames()
	{
		return ResponseEntity.ok(services.getGameList()); //calls getAllGames from GameServices
	}
	
	@GetMapping("/game/{id}")
	public ResponseEntity<Game> getGamebyId(@PathVariable int id)
	{
		return ResponseEntity.ok().body(this.services.getGamebyId(id)); //Calls getGamebyId from GameServices
	}

	@PostMapping("/addGame")
	public ResponseEntity<Game> addGame(@RequestBody Game game)
	{
		return ResponseEntity.ok(this.services.createGame(game)); //calls addGame from GameServices
	}
	
	@PostMapping("/addGames")
	public ResponseEntity<List<Game>> addGames(@RequestBody List<Game> list)
	{
		return ResponseEntity.ok(this.services.createGameList(list)); //calls addGames from GameServices
	}
	
	@PutMapping("/updateGames/")
	public ResponseEntity<Game> updateGame(@RequestBody Game game)
	{
		return ResponseEntity.ok().body(this.services.updateGameById(game)); //calls updateGame from GameServices
	}
	
	@DeleteMapping("/deleteGames/{id}")
	public HttpStatus deleteGame(@PathVariable int id) //calls Delete from GameServices
	{
		this.services.deleteGamebyId(id);
		return HttpStatus.OK;
	}
}
