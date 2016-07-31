package com.capgemini.chess.service.to;

import static com.capgemini.chess.ApplicationProperties.VALIDATION_PERIOD_NUMER_OF_DAYS;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ChallengeTO {

	//ASK id should by Object or primitive? think about connection to database.
	private long id;
	private ChallengeStatus challengeStatus;
	private UserProfileTO userSender;
	private UserProfileTO userRecipient;
	private DateTime challengeCreatingDate;
	private DateTime challengeExpirationDate;

	public void setChallengeExpirationDate(DateTime date) {
		this.challengeExpirationDate = date.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}

	public ChallengeTO(long id, UserProfileTO sender, UserProfileTO recipient) {
		this.id = id;
		this.userSender = sender;
		this.userRecipient = recipient;
		this.challengeCreatingDate = new DateTime(2016,1,10,8,30);
		this.challengeExpirationDate = challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
	
}
