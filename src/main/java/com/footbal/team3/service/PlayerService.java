package com.footbal.team3.service;

import com.footbal.team3.repository.PlayerRepository;

public class PlayerService {

    public final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
       List<Player> players = playerRepository.findAll();
       return players;
    }

    public Player findByName(String id) {
        Player player = playerRepository.findById(id).orElseThrow();
        return player;
    }
}
