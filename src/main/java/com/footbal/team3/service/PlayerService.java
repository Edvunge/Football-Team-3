package com.footbal.team3.service;

import com.footbal.team3.controller.request.PlayerCreationRequest;
import com.footbal.team3.exception.DuplicatedPlayer;
import com.footbal.team3.exception.PlayerNotFound;
import com.footbal.team3.model.Player;
import com.footbal.team3.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    public final PlayerRepository playerRepository;

    public Optional<Player> findByNumber(int number) {
        return playerRepository.findByPlayerNumber(number);
    };

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public void save(Player newPlayer) {
        //Throws exception if the players number already exists
        if (this.findByNumber(newPlayer.getPlayerNumber()).isPresent()) {
            throw new DuplicatedPlayer();}
        else {
            playerRepository.save(newPlayer);
        }
    }

    public Player update(PlayerCreationRequest playerReq, String name) {
        Player player = this.findByName(name);
        int oldnumber = player.getPlayerNumber();
            player.setPlayerNumber(playerReq.getPlayerNumber());
            player.setPlayerPosition(playerReq.getPlayerPosition());
            player.setPlayerName(playerReq.getName());
        //Throws exception if the new number for the player is not either the number he had or a number that does not
        //exist for another player
        if (this.findByNumber(player.getPlayerNumber()).isPresent() && player.getPlayerNumber() != oldnumber) {
            throw new DuplicatedPlayer();
        }
        else {
            return playerRepository.save(player);
        }
    }

    public Player findByName(String name) {
        return playerRepository.findByPlayerNameContaining(name).orElseThrow(PlayerNotFound::new);
    }
}
