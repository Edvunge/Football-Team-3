package com.footbal.team3.controller;


import com.footbal.team3.controller.request.MatchCreationRequest;
import com.footbal.team3.model.Match;
import com.footbal.team3.service.MatchService;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/api")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    @GetMapping(value = "/match", consumes = "application/json", produces = "application/json")
    public List<Match> matchList() {
        return matchService.matchList();
    }
    @GetMapping(value = "/match/{id}", consumes = "application/json", produces = "application/json")
    public Match findById(String id) {
        return matchService.findById(id);
    }
    @PostMapping(value = "/match", consumes = "application/json", produces = "application/json")
    public Match createMatch(@RequestBody MatchCreationRequest matchReq) {
        Match newMatch = Match
                    .builder()
                    .description(matchReq.getDescription())
                    .matchDate(matchReq.getMatchDate())
                    .build();
            matchService.save(newMatch);
            return newMatch;
        }

    @PutMapping(value = "/match/{id}")
    public Match updateMatch(@PathVariable(value = "id") String id, @RequestBody MatchCreationRequest matchReq) {
        return matchService.update(matchReq, id);
    }
}







