package com.capgemini.chess.service;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;


public interface ChallangeService {

	void sendChallange(UserProfileTO user);
	void acceptChallange(ChallengeTO challenge);
	void declineChallange(ChallengeTO challenge);
	/**
	 * @param id_challenge to cancel when challenge is already send
	 */
	void cancleSendChallenge(long id_challenge);
	void updateChallengeList();
	int howManyActiveChallenges(long userId);
}
