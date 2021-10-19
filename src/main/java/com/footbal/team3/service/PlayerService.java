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
       List<Player> players = playerRepository.findAll();
       return players;
    }

    public Player findById(String id) {
        Player player = playerRepository.findById(id).orElseThrow(PlayerNotFound::new);
        return player;
    }

    public void save(Player newPlayer) {
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
        if (this.findByNumber(player.getPlayerNumber()).isPresent() && player.getPlayerNumber() != oldnumber) {
            throw new DuplicatedPlayer();
        }
        else {
            return playerRepository.save(player);
        }
    }

    public Player findByName(String name) {
        return playerRepository.findByPlayerName(name).orElseThrow(PlayerNotFound::new);
    }
}
