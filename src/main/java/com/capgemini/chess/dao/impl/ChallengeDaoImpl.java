package com.capgemini.chess.dao.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

import lombok.NonNull;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	private List<ChallengeEntity> challengesDatabase = new ArrayList<ChallengeEntity>();

	@Override
	public List<ChallengeEntity> getExpiredChallenges() {
		createChallengesDatabase();
		// connect with database and get all expired challenges, then return
		// them as a ArrayList.
		// TODO Auto-generated method stub
		return challengesDatabase;
	}

	@Override
	public void updateChallengesStateForUser(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExpiredChallenges(List<ChallengeEntity> list) {
		// to delete after tests
		list.clear();
	}

	@Override
	public List<ChallengeEntity> getUserChallenges(int userId) {
		List<ChallengeEntity> list = new ArrayList<ChallengeEntity>();
		for(ChallengeEntity challenge : getAllChallenges()) {
			if(challenge.getId() == userId) {
				list.add(challenge);
			}
		}
		return list;
	}

	@Override
	public void addNewChallenge(@NonNull ChallengeEntity challengeEntity) {
		challengesDatabase.add(challengeEntity);
	}

	@Override
	public void deleteExpiredChallengesFromLocalList(List<ChallengeEntity> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public ChallengeEntity getChallengeById(long id_challenges) {
		// TODO Auto-generated method stub
		return null;
	}

	private void createChallengesDatabase() {
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		ChallengeEntity challenge3 = new ChallengeEntity();
		ChallengeEntity challenge4 = new ChallengeEntity();

		challengesDatabase.add(challenge1);
		challengesDatabase.add(challenge2);
		challengesDatabase.add(challenge3);
		challengesDatabase.add(challenge4);
	}

	@Override
	public List<ChallengeEntity> getAllChallenges() {
		return challengesDatabase;
	}

}
