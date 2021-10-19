package com.footbal.team3.repository;


import com.footbal.team3.model.Match;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MatchRepository extends MongoRepository<Match, String> {

}
