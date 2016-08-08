package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.ChallengeNotFoundException;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Challenge services for user
 * 
 * @author PWOJTKOW
 */
public interface ChallengeService {

	/**
	 * Method delete expired challenges from database
	 */
	void deleteExpiredChallenges();

	/**
	 * Method create challenge with actual date and send challenge to opponent
	 * 
	 * @param challengeTo
	 *            - challenge transfer object to send
	 */
	void sendChallenge(ChallengeTo challengeTo);

	/**
	 * Method gets all challenges from database
	 * 
	 * @return list of all challenges in database
	 */
	List<ChallengeTo> getAllChallenges();

	/**
	 * Method send challenge to user
	 * 
	 * @param id
	 *            - id mapped to challenge
	 * @param senderId
	 *            - id mapped to sender of challenge
	 * @param recipientId
	 *            - id mapped to recipient of challenge
	 */
	void sendChallange(Long id, Long senderId, Long recipientId);

	/**
	 * Method set status of challenge as "ACCEPT"
	 * 
	 * @param challengeId
	 *            - id challenge that need to by accept
	 * @throws ChallengeNotFoundException
	 *             when challenge do not exist in database
	 */
	void acceptChallange(Long challengeId) throws ChallengeNotFoundException;

	/**
	 * Method set status of challenge as "REJECTED"
	 * 
	 * @param challengeId
	 *            - id challenge that need to by declined
	 * @throws ChallengeNotFoundException
	 *             when challenge do not exist in database
	 */
	void rejectChallange(Long challengeId) throws ChallengeNotFoundException;

	/**
	 * Method set status of challenge as "CANCLED"
	 * 
	 * @param challengeId
	 *            - challenge to cancel when challenge is already send
	 * @throws ChallengeNotFoundException
	 *             when challenge do not exist in database
	 */
	void cancleSendChallenge(Long challengeId) throws ChallengeNotFoundException;

	/**
	 * Update challenges list from database
	 */
	void updateChallengeList();

	/**
	 * Method returns how many challenges is mapped to user
	 * 
	 * @param userId
	 *            - id mapped to user to check
	 * @return number of active challenges
	 * @throws UserNotFoundException
	 *             when user do not exist in database
	 */
	int howManyActiveChallenges(Long userId) throws UserNotFoundException;

	/**
	 * Method delete challenge by id
	 * 
	 * @param challengeId
	 *            - id mapped to challenge to delete
	 */
	void deleteChallenge(Long challengeId);

	/**
	 * Method return challenge by id
	 * 
	 * @param challengeId
	 *            - id mapped to challenge
	 * @return challenge with specific id
	 */
	ChallengeTo getChallengeById(Long challengeId);
}
