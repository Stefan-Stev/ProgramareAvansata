package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @GetMapping("/players")
    private List<Player> getAllPlayers()
    {
        return playerService.getAllPlayers();
    }
    @GetMapping("/players/{playerid}")
    private Player getPlayer(@PathVariable("playerid") int playerId)
    {
        return playerService.getPlayerById(playerId);
    }
    @DeleteMapping("/players/{playerid}")
    private void deletePlayer(@PathVariable ("playerid") int playerId)
    {
        playerService.delete(playerId);
    }
    @PostMapping("/players")
    private int savePlayer(@RequestBody Player player )
    {
        playerService.savePlayer(player);
        return player.getPlayerId();
    }
    @PutMapping("/players/{id}")
    private ResponseEntity updatePlayer(@PathVariable int id,@RequestParam String name)
    {
        Player player=playerService.getPlayerById(id);
        if(player==null)
        {

            return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND); //or
        }
        else
        {
            player.setPlayerName(name);
            return new ResponseEntity<>("Player Name updated successsfully", HttpStatus.OK);
        }


    }
}
