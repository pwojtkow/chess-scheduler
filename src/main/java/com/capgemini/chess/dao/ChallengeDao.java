package com.capgemini.chess.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.exceptions.ChallengeNotFoundExepction;
import com.capgemini.chess.exceptions.UserNotFoundException;

/**
 * Interface which gives CRUD operations on challenges in database
 * @author PWOJTKOW
 */
@Repository
public interface ChallengeDao {
	/**
	 * Method for tests only - all logic on database side
	 * @return
	 */
	List<ChallengeEntity> getExpiredChallenges();
	
	/**
	 * Method update all challenges for user mapped with id as param
	 * @param userId
	 */
	void updateChallengesStateForUser(int userId) throws UserNotFoundException;
	
	/**
	 * Connect with database and delete all expired challenges
	 */
	void deleteExpiredChallenges(List<ChallengeEntity> list);
	
	/**
	 * Method for tests only - all logic on database side
	 * @param list - local list of challenge entity
	 */
	void deleteExpiredChallengesFromLocalList(List<ChallengeEntity> list);
	
	/**
	 * @param userId
	 * @return list of challenges that are mapped to user
	 */
	List<ChallengeEntity> getUserChallenges(int userId) throws UserNotFoundException;

	/**
	 * Add new challenges to database
	 * @param challengeList - list of challenges that need to be add to database
	 */
	void addNewChallenges(List<ChallengeEntity> challengeList);
	
	/**
	 * @param id_challenges
	 * @return challenge entity mapped with id in param
	 */
	ChallengeEntity findChallengeById(long id_challenges) throws ChallengeNotFoundExepction;
}
