package com.footbal.team3.service;

import com.footbal.team3.controller.request.MatchCreationRequest;
import com.footbal.team3.exception.MatchNotFound;
import com.footbal.team3.exception.PlayerNotFound;
import com.footbal.team3.model.Match;
import com.footbal.team3.model.Player;
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

    public Match findById(String id) {
        return matchRepository.findById(id).orElseThrow(MatchNotFound::new);
    }

    public Match update(MatchCreationRequest matchReq, String id) {
        Match match = this.findById(id);
        match.setMatchDate(matchReq.getMatchDate());
        match.setDescription(matchReq.getDescription());
        return match;
    }
}
