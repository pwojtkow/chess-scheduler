package com.capgemini.chess.dataaccess.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class ChallengeEntity {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private ChallengeStatus challengeStatus;
	@Column(nullable = false)
	private long userSenderId;
	@Column(nullable = false)
	private long userRecipientId;
	@Column(nullable = false)
	private DateTime challengeCreatingDate;
	@Column(nullable = false)
	private DateTime challengeExpirationDate;
	
}
