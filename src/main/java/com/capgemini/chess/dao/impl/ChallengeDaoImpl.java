package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.ChallengeDatabase;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.exceptions.ChallengeNotFoundException;
import com.capgemini.chess.exceptions.ChallengeWithIdExistException;
import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.NonNull;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	private static List<ChallengeEntity> challengesDatabase = new ArrayList<ChallengeEntity>();

	@Override
	public List<ChallengeEntity> getExpiredChallenges() {
		// TODO Auto-generated method stub
		return challengesDatabase;
	}

	@Override
	public void updateChallengesStateForUser(Long userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ChallengeEntity> getUserChallenges(Long userId) {
		List<ChallengeEntity> list = new ArrayList<ChallengeEntity>();
		for (ChallengeEntity challenge : getAllChallenges()) {
			if (challenge.getId() == userId) {
				list.add(challenge);
			}
		}
		return list;
	}

	@Override
	public void addNewChallenge(@NonNull ChallengeEntity challengeEntityToAdd) {
		for (ChallengeEntity challengeInDatabase : getAllChallenges()) {
			if (challengeEntityToAdd.getId() == challengeInDatabase.getId()) {
				throw new ChallengeWithIdExistException("Challenge with this Id alredy exists!");
			}
		}
		challengesDatabase.add(challengeEntityToAdd);
	}

	@Override
	public void deleteExpiredChallengesFromLocalList() {
		Iterator<ChallengeEntity> iterator = getAllChallenges().iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getChallengeExpirationDate().isAfterNow()) {
				iterator.remove();
			}
		}
	}

	@Override
	public ChallengeEntity getChallengeById(Long challengeId) {
		List<ChallengeEntity> challengeList = getAllChallenges();
		for (ChallengeEntity challenge : challengeList) {
			if (challenge.getId() == challengeId) {
				return challenge;
			}
		}
		throw new ChallengeNotFoundException("Challenge has been not found");
	}

	@Override
	public List<ChallengeEntity> getAllChallenges() {
		return challengesDatabase;
	}

	@Override
	public void deleteChallenge(Long challengeId) throws ChallengeNotFoundException {
		ChallengeEntity challengeToDelete = getChallengeById(challengeId);
		if( challengeToDelete == null) {
			throw new ChallengeNotFoundException(
					"Challenge with id: " + challengeId.toString() + " has been not found");
		} else {
			challengesDatabase.remove(challengeToDelete);
		}
		
	}

	@Override
	public void changeChallengeState(Long challengeId, ChallengeStatus status) throws ChallengeNotFoundException {
		if (getChallengeById(challengeId) == null) {
			throw new ChallengeNotFoundException("Challenge with this Id do not exist!");
		} else {
			getChallengeById(challengeId).setChallengeStatus(status);
		}
	}

}
