package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.exceptions.ChallengeNotFoundException;
import com.capgemini.chess.exceptions.ChallengeWithIdExistException;
import com.capgemini.chess.exceptions.UserNotFoundException;
import com.capgemini.chess.service.enums.ChallengeStatus;

/**
 * Interface which gives CRUD operations on challenges in database
 * @author PWOJTKOW
 */
public interface ChallengeDao {
	
	/**
	 * Method return all challenge entities from database
	 * @return all challenge entities from database
	 */
	List<ChallengeEntity> getAllChallenges();
	
	/**
	 * Method for tests only - all logic on database side
	 * @return all expired challenges from database
	 */
	List<ChallengeEntity> getExpiredChallenges();
	
	/**
	 * Method update all challenges for user mapped with id as param
	 * @param userId - id mapped to user 
	 * @throws UserNotFoundException when user with this id do not exist in database
	 */
	void updateChallengesStateForUser(Long userId) throws UserNotFoundException;
	
	/**
	 * Method delete all expired challenges from local database
	 */
	void deleteExpiredChallengesFromLocalList();
	
	/**
	 * Method finds in database and returns all challenges mapped to user
	 * @param userId - id mapped to suer
	 * @return list of challenges that are mapped to user
	 * @throws UserNotFoundException when user with this id do not exist in database
	 */
	List<ChallengeEntity> getUserChallenges(Long userId) throws UserNotFoundException;

	/**
	 * Method add new challenge to database
	 * Add new challenges to database
	 * @param challengeList - list of challenges that need to be add to database
	 * @throws ChallengeWithIdExistException when challenge with this id already exist in database
	 */
	void addNewChallenge(ChallengeEntity challengeEntity) throws ChallengeWithIdExistException;
	
	/**
	 * Method gets challenge by id
	 * @param challengeId - id mapped to challenge
	 * @return challenge entity mapped with id in param
	 * @throws ChallengeNotFoundException when challenge with this id do not exist in database
	 */
	ChallengeEntity getChallengeById(Long challengeId) throws ChallengeNotFoundException;
	
	/**
	 * Method delete challenge by id
	 * @param challengesId - id mapped to challenge
	 * @throws ChallengeNotFoundException when challenge with this id do not exist in database
	 */
	void deleteChallenge(Long challengeId) throws ChallengeNotFoundException;
	
	/**
	 * Method change challenge state
	 * @param challengeId - id mapped to challenge to change
	 * @param status - new status of challenge
	 * @throws ChallengeNotFoundException when challenge with this id do not exist in database
	 */
	void changeChallengeState(Long challengeId, ChallengeStatus status) throws ChallengeNotFoundException;
}
