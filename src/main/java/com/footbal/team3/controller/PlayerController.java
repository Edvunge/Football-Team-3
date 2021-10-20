package com.footbal.team3.controller;

import com.footbal.team3.controller.request.PlayerCreationRequest;
import com.footbal.team3.model.Player;
import com.footbal.team3.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/players/{playerName}")
    public Player getPlayerByName(@PathVariable(value = "playerName") String name) {
        Player player = playerService.findByName(name);
        return player;
    }

    @PostMapping(value = "/players", consumes = "application/json", produces = "application/json")
    public Player createPlayer(@RequestBody PlayerCreationRequest playerReq) {
        Player newPlayer = Player
                .builder()
                .playerNumber(playerReq.getPlayerNumber())
                .playerPosition(playerReq.getPlayerPosition())
                .playerName(playerReq.getName())
                .build();
        playerService.save(newPlayer);
        return newPlayer;
    }

    @PutMapping(value = "/player/{name}")
    public Player updatePlayer(@PathVariable(value = "name") String name, @RequestBody PlayerCreationRequest playerReq) {
        Player player = playerService.update(playerReq, name);
        return player;
    }

}
