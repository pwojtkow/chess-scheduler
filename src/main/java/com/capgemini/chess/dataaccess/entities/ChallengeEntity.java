package com.capgemini.chess.dataaccess.entities;

import static com.capgemini.chess.ApplicationProperties.VALIDATION_PERIOD_NUMER_OF_DAYS;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChallengeEntity {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private ChallengeStatus challengeStatus;
	@Column(nullable = false)
	private Long userSenderId;
	@Column(nullable = false)
	private Long userRecipientId;
	@Column(nullable = false)
	private DateTime challengeCreatingDate;
	@Column(nullable = false)
	private DateTime challengeExpirationDate;

	public ChallengeEntity(Long id, ChallengeStatus challengeStatus, 
			Long userSenderId, Long userRecipientId,
			DateTime challengeCreatingDate) {
		this.id = id;
		this.challengeStatus = challengeStatus;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = challengeCreatingDate;
		this.challengeExpirationDate = challengeExpirationDate
				.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}
	
	public ChallengeEntity(Long id, Long userSenderId, Long userRecipientId) {
		this.id = id;
		this.challengeStatus = ChallengeStatus.SEND;
		this.userSenderId = userSenderId;
		this.userRecipientId = userRecipientId;
		this.challengeCreatingDate = DateTime.now();
		this.challengeExpirationDate = this.challengeCreatingDate.plusDays(VALIDATION_PERIOD_NUMER_OF_DAYS);
	}

}
