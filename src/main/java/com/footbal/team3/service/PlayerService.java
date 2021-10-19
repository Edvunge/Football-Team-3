package com.footbal.team3.service;

import com.footbal.team3.controller.request.PlayerCreationRequest;
import com.footbal.team3.exception.PlayerNotFound;
import com.footbal.team3.model.Player;
import com.footbal.team3.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    public final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
       List<Player> players = playerRepository.findAll();
       return players;
    }

    public Player findById(String id) {
        Player player = playerRepository.findById(id).orElseThrow(PlayerNotFound::new);
        return player;
    }

    public void save(Player newPlayer) {
        playerRepository.save(newPlayer);
    }

    public Player update(PlayerCreationRequest playerReq, String id) {
        Player player = this.findById(id);
        player.setPlayerNumber(playerReq.getPlayerNumber());
        player.setPlayerPosition(playerReq.getPlayerPosition());
        return playerRepository.save(player);
    }
}
