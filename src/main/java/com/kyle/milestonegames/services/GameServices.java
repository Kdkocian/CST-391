package com.kyle.milestonegames.services;

import com.kyle.milestonegames.entities.Game;
import com.kyle.milestonegames.entities.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServices {
	
	@Autowired
	private GameRepository gameRepository;
	
	public GameServices(GameRepository gr)
	{
		this.gameRepository = gr;
	}
	
	public Game createGame(Game game) //creates game in db
	{
		return gameRepository.save(game);
	}
	
	public List<Game> createGameList(List<Game> list)
	{
		return gameRepository.saveAll(list); //creates gamelist 
	}
	
	public List<Game> getGameList()
	{
		return gameRepository.findAll(); //returns games list
	}
	
	public Game getGamebyId(int id)
	{
		return gameRepository.findById(id).orElse(null); //returns game by specific id
	}
	
	public Game updateGameById(Game game)
	{
		Optional<Game> gameFound = gameRepository.findById(game.getId()); //updates games in database based on ID
		
		if(gameFound.isPresent())
		{
			Game gameUpdate = gameFound.get();
			gameUpdate.setTitle(game.getTitle());
			gameUpdate.setType(game.getType());
			gameUpdate.setPrice(game.getPrice());
			
			return gameRepository.save(game); //may need to pass in the gameUpdate
		} else {
			return null;
		}
	}
	
	public String deleteGamebyId(int id) //Deletes game by ID
	{
		gameRepository.deleteById(id);
		
		return "Game " + id + " Deleted";
	}
	
}
