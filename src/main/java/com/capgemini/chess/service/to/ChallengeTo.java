package com.capgemini.chess.service.to;

import static com.capgemini.chess.ApplicationProperties.VALIDATION_PERIOD_NUMER_OF_DAYS;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ChallengeTo {

	private long id;
	private ChallengeStatus challengeStatus;
	private long userSenderId;
	private long userRecipientId;
	private DateTime challengeCreatingDate;
	private DateTime challengeExpirationDate;

	public void setChallengeExpirationDate(DateTime date) {
		this.challengeExpirationDate = date.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}

	public ChallengeTo(long id, long userSenderId, long userRecipientId) {
		this.id = id;
		this.challengeStatus = ChallengeStatus.SEND;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = DateTime.now();
		this.challengeExpirationDate = this.challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
	
	public ChallengeTo(long id, ChallengeStatus challengeStatus, long userSenderId, long userRecipientId,
			DateTime challengeCreatingDate, DateTime challengeExpirationDate) {
		this.id = id;
		this.challengeStatus = challengeStatus;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = challengeCreatingDate;
		this.challengeExpirationDate = challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
}
