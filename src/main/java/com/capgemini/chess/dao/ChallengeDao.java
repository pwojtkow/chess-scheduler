package com.capgemini.chess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface ChallengeDao {
//TODO CRUD
	//version to tests
	List<ChallengeEntity> getExpiredChallenges();
	
	void updateChallengesStateForUser(int userId);
	
	/**
	 * Connect with database and delete all expired challenges
	 */
	void deleteExpiredChallenges(List<ChallengeEntity> list);
	
	void deleteExpiredChallengesFromLocalList(List<ChallengeEntity> list);
	
	void getUserChallenges(int userId);

	void addNewChallenges(List<ChallengeEntity> challengeList);
	
	void findChallengeById(long id_challenges);
}
