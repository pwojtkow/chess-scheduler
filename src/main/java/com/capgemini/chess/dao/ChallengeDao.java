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
	 * @return
	 */
	List<ChallengeEntity> getExpiredChallenges();
	
	/**
	 * Method update all challenges for user mapped with id as param
	 * @param userId
	 */
	void updateChallengesStateForUser(Long userId) throws UserNotFoundException;
	
	/**
	 * Method delete all expired challenges from local database
	 */
	void deleteExpiredChallengesFromLocalList();
	
	/**
	 * @param userId
	 * @return list of challenges that are mapped to user
	 */
	List<ChallengeEntity> getUserChallenges(Long userId) throws UserNotFoundException;

	/**
	 * Add new challenges to database
	 * @param challengeList - list of challenges that need to be add to database
	 */
	void addNewChallenge(ChallengeEntity challengeEntity) throws ChallengeWithIdExistException;
	
	/**
	 * @param id_challenges
	 * @return challenge entity mapped with id in param
	 */
	ChallengeEntity getChallengeById(Long id_challenges) throws ChallengeNotFoundException;
	
	/**
	 * @param challengesId
	 * @throws ChallengeNotFoundException
	 */
	void deleteChallenge(Long challengeId) throws ChallengeNotFoundException;
	
	void changeChallengeState(Long challengeId, ChallengeStatus status) throws ChallengeNotFoundException;
}
