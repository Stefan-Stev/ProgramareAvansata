package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    public List<Player> getAllPlayers()
    {
        List<Player> players=new ArrayList<>();
        playerRepository.findAll().forEach(player1 -> players.add(player1));
        return players;
    }
    public  Player getPlayerById(int id){
        return playerRepository.findById(id).get();
    }
    public void savePlayer(Player player)
    {
        playerRepository.save(player);
    }
    public void updatePlayer(Player player,String name)
    {
        playerRepository.save(player);
    }
    public void delete(int id)
    {
        playerRepository.deleteById(id);
    }

}
