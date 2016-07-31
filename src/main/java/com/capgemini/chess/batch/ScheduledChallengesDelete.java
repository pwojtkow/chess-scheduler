package com.capgemini.chess.batch;

import static com.capgemini.chess.ApplicationProperties.DELETING_CHALLENGES_SCHEDULE_PERIOD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

/**
 * Scheduler which role is delete all expired challenges found in the database
 * @author PWOJTKOW
 */
@Component
public class ScheduledChallengesDelete {

	@Autowired
	ChallengeDao challengeDao;
	
	@Scheduled(cron = DELETING_CHALLENGES_SCHEDULE_PERIOD)
	public void deleteChallenges() {
		List<ChallengeEntity> entityList = challengeDao.getExpiredChallenges(); 
		challengeDao.deleteExpiredChallenges(entityList);
	}
}
