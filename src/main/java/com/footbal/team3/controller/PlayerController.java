package com.footbal.team3.controller;

import com.footbal.team3.service.PlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        List<Player> players = playerService.findAll();
        return players;
    }

    @GetMapping("/players/{id}")
    public Player getPlayerByName(String id) {
        Player player = playerService.findByName(id);
        return player;
    }
}
