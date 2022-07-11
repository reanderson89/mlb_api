package com.mlb.mlb_api.controllers;


import com.mlb.mlb_api.entities.Player;
import com.mlb.mlb_api.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private final PlayerRepository playerRepository;


    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @PostMapping("/addPlayer")
    public Player createPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @GetMapping("/all")
    public Iterable<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping
    public Player getPlayerByName(@RequestParam String name, @RequestParam Integer age){
       return playerRepository.findByNameAndAge(name, age);
    }

}
