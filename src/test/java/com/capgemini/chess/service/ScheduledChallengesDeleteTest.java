package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.batch.ScheduledChallengesDelete;
import com.capgemini.chess.dao.ChallengeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ChessApplication.class)
public class ScheduledChallengesDeleteTest {

	@Autowired
	private ChallengeDao challengeDao;
	@Autowired
	private ScheduledChallengesDelete scheduledDelete;

	@Test
	public void shouldDeleteAllChallenges() {
		// when
		scheduledDelete.deleteChallenges();
		// then
		// TODO: create proper method in interface
		// assertEquals(0, challengeDao.getFakeDatabase().size());
	}

	/*
	 * 1. Wstrzykniecie implementacji zamiast interfejsu 
	 * 2. Dodatkowy blok <dependencies> w pomie 
	 * 3.  annotacja @Repository na interfejsie zamiast na implementacji
	 * 
	 */
}
