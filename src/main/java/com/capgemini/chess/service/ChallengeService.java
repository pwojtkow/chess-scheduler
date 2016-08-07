package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.ChallengeNotFoundException;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Challenge services for user 
 * @author PWOJTKOW
 */
public interface ChallengeService {
	
	List<ChallengeTo> getAllChallenges();
	/**
	 * @param userId - id user who is to be sent challenge
	 */
	void sendChallange(Long id, Long senderId, Long recipientId);
	/**
	 * @param challengeId - id challenge that need to be accepted
	 */
	void acceptChallange(Long challengeId);
	/**
	 * @param challengeId - id challenge that need to by declined
	 */
	void rejectChallange(Long challengeId) throws ChallengeNotFoundException;
	/**
	 * @param id challenge to cancel when challenge is already send
	 */
	void cancleSendChallenge(Long challengeId) throws ChallengeNotFoundException;
	/**
	 * Update challenges list from database
	 */
	void updateChallengeList();
	/**
	 * @param userId
	 * @return
	 */
	int howManyActiveChallenges(Long userId) throws UserNotFoundException;
	
	void deleteChallenge(Long challengeId);
	
	ChallengeTo getChallengeById(Long challengeId);
}
