package com.footbal.team3.service;

import com.footbal.team3.model.Match;
import com.footbal.team3.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match save(Match newMatch) {
        return matchRepository.save(newMatch);
    }

    public List<Match> matchList() {
        List<Match> matchList;
        matchList = matchRepository.findAll();
        return matchList;
    }
}
