package com.kyle.milestonegames.entities;

import com.kyle.milestonegames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer>{

}
