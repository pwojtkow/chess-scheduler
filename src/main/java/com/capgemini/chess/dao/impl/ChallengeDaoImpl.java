package com.capgemini.chess.dao.impl;

import java.util.ArrayList;

import java.util.List;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

public class ChallengeDaoImpl implements ChallengeDao {

	private List<ChallengeEntity> fakeDatabase = new ArrayList<ChallengeEntity>();

	public List<ChallengeEntity> getFakeDatabase() {
		return fakeDatabase;
	}

	@Override
	public List<ChallengeEntity> getExpiredChallenges() {
		createFakeDatabase();
		// connect with database and get all expired challenges, then return
		// them as a ArrayList.
		// TODO Auto-generated method stub
		return fakeDatabase;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewChallenges(List<ChallengeEntity> challengeList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteExpiredChallengesFromLocalList(List<ChallengeEntity> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public ChallengeEntity findChallengeById(long id_challenges) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createFakeDatabase() {
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		ChallengeEntity challenge3 = new ChallengeEntity();
		ChallengeEntity challenge4 = new ChallengeEntity();

		fakeDatabase.add(challenge1);
		fakeDatabase.add(challenge2);
		fakeDatabase.add(challenge3);
		fakeDatabase.add(challenge4);
	}

}
