package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.ChallengeNotFoundExepction;
import com.capgemini.chess.exceptions.ChallengesOutOfLimitException;
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
	void sendChallange(long id, long senderId, long recipientId) throws ChallengesOutOfLimitException, UserNotFoundException;
	/**
	 * @param challengeId - id challenge that need to be accepted
	 */
	void acceptChallange(long challengeId) throws UserNotFoundException, ChallengeNotFoundExepction;
	/**
	 * @param challengeId - id challenge that need to by declined
	 */
	void rejectChallange(long challengeId) throws ChallengeNotFoundExepction;
	/**
	 * @param id challenge to cancel when challenge is already send
	 */
	void cancleSendChallenge(long challengeId) throws ChallengeNotFoundExepction;
	/**
	 * Update challenges list from database
	 */
	void updateChallengeList();
	/**
	 * @param userId
	 * @return
	 */
	int howManyActiveChallenges(long userId) throws UserNotFoundException;
	
	
}
