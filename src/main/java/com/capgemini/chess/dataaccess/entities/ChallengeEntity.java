package com.capgemini.chess.dataaccess.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.joda.time.DateTime;

import com.capgemini.chess.service.enums.ChallengeStatus;
import com.capgemini.chess.service.to.UserProfileTO;


@Entity //needed only when database ready
public class ChallengeEntity {
	
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private ChallengeStatus challengeStatus;
	@Column(nullable = false)
	private UserProfileTO userSender;
	@Column(nullable = false)
	private UserProfileTO userRecipient;
	@Column(nullable = false)
	private DateTime challengeCreatingDate;
	@Column(nullable = false)
	private DateTime challengeExpirationDate;
	
}
