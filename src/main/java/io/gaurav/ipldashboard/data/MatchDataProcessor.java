package io.gaurav.ipldashboard.data;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import io.gaurav.ipldashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Override
  public Match process(final MatchInput matchInput) throws Exception {
    
    Match match = new Match();
    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());

    match.setDate(LocalDate.parse(matchInput.getDate()));

    match.setPlayerOfMatch(matchInput.getPlayer_of_Match());
    match.setVenue(matchInput.getVenue());

    String firstInningsTeam, secondInningsTeam;

    if("bat".equals(matchInput.getTossDecision())) {
        firstInningsTeam = matchInput.getTossWinner();
        secondInningsTeam = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
    } else {
        secondInningsTeam = matchInput.getTossWinner();
        firstInningsTeam = matchInput.getTossWinner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);
    match.setTossWinner(matchInput.getTossWinner());
    match.setTossDecision(matchInput.getTossDecision());
    match.setMatchWinner(matchInput.getWinningTeam());
    match.setResult(matchInput.getWonBy());
    match.setResultMargin(matchInput.getMargin());
    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());
    
    return match;
  }

}

