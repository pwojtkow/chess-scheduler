package com.capgemini.chess.service;

import com.capgemini.chess.service.enums.MatchStatus;

/**
 * Service that gives settings for matches
 * @author PWOJTKOW
 */
public interface MatchService {
	
	void createNewMatch();
	
	void deleteMatch(long matchId);
	
	/**
	 * @param matchId - match id mapped with match to edit
	 * @param matchStatus - match status to set
	 */
	void setMatchStatus(long matchId, MatchStatus matchStatus);
	
	/**
	 * @param matchId - match id from who should get loser
	 * @return - user id who lose 
	 */
	long getMatchLoser(long matchId);
	
	/**
	 * @param matchId - match id from who should get winner
	 * @return - user id who win
	 */
	long getMatchWinner(long matchId);
	
	/**
	 * @param matchId - match id where should set winner
	 */
	void setWinner(long matchId);
	
	/**
	 * @param matchId - match id where should set loser
	 */
	void setLoser(long matchId);
	
	/**
	 * @param matchId - match id to get match status
	 * @return match status
	 */
	MatchStatus getMatchStatus(long matchId);
	
}
