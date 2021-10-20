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
        return playerService.findAll();
    }

    @GetMapping("/players/{playerName}")
    public Player getPlayerByName(@PathVariable(value = "playerName") String name) {
        return playerService.findByName(name);
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
        return playerService.update(playerReq, name);
    }

}
