package com.footbal.team3.repository;

import com.footbal.team3.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findByPlayerNameContaining(String name);

    Optional<Player> findByPlayerNumber(int number);
}
