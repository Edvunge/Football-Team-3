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

    @GetMapping("/players/{id}")
    public Player getPlayerByName(String id) {
        Player player = playerService.findByName(id);
        return player;
    }

    /*@PostMapping(value = "/players", consumes = "application/json", produces = "application/json")
    public Player createPlayer(@RequestBody PlayerCreationRequest playerReq) {
        Player newPlayer = Player
                .builder()
                .player(playerReq.getPetType())
                .petName(playerReq.getPetName())
                .build();
        petService.save(newPet);
        return newPet;
    }*/
}
