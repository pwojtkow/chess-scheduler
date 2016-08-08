package com.capgemini.chess.service.to;

import static com.capgemini.chess.ApplicationProperties.VALIDATION_PERIOD_NUMER_OF_DAYS;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Transfer object of challenge
 * @author PWOJTKOW
 */
@Getter
@Setter
@NoArgsConstructor
public class ChallengeTo {

	private Long id;
	private ChallengeStatus challengeStatus;
	private Long userSenderId;
	private Long userRecipientId;
	private DateTime challengeCreatingDate;
	private DateTime challengeExpirationDate;

	public ChallengeTo(Long id, Long userSenderId, Long userRecipientId) {
		this.id = id;
		this.challengeStatus = ChallengeStatus.SEND;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = DateTime.now();
		this.challengeExpirationDate = this.challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
	
	public ChallengeTo(Long id, ChallengeStatus challengeStatus, Long userSenderId, Long userRecipientId,
			DateTime challengeCreatingDate) {
		this.id = id;
		this.challengeStatus = challengeStatus;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = challengeCreatingDate;
		this.challengeExpirationDate = challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
}
