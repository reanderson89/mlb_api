package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.entities.Player;
import com.mlb.mlb_api.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {


    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @PostMapping("/add")
    public Player createPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @GetMapping
    public Iterable<Player> getPlayer(){
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable("id") Integer playerId){
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if(optionalPlayer.isEmpty()){
            return null;
        }
        Player player = optionalPlayer.get();
        return player;
    }

}
