package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Mapper to convert challenge entities to transfer objects and vice versa
 */
public class ChallengeMapper {

	/**
	 * Converter from challenge entity to challenge transfer object (TO)
	 * @param challengeEntity - entity to convert
	 * @return converted entity as transfer object (TO)
	 */
	public static ChallengeTo map(ChallengeEntity challengeEntity) {
		if (challengeEntity != null) {
			ChallengeTo challengeTo = new ChallengeTo();
			challengeTo.setId(challengeEntity.getId());
			challengeTo.setUserSenderId(challengeEntity.getUserSenderId());
			challengeTo.setUserRecipientId(challengeEntity.getUserRecipientId());
			challengeTo.setChallengeCreatingDate(challengeEntity.getChallengeCreatingDate());
			challengeTo.setChallengeExpirationDate(challengeEntity.getChallengeExpirationDate());
			challengeTo.setChallengeStatus(challengeEntity.getChallengeStatus());
			return challengeTo;
		}
		return null;
	}
	
	/**
	 * Converter from challenge transfer object (TO) to challenge entity
	 * @param challengeTo - transfer object to convert
	 * @return converted transfer object as entity
	 */
	public static ChallengeEntity map(ChallengeTo challengeTo) {
		if (challengeTo != null) {
			ChallengeEntity challengeEntity = new ChallengeEntity();
			challengeEntity.setId(challengeTo.getId());
			challengeEntity.setUserSenderId(challengeTo.getUserSenderId());
			challengeEntity.setUserRecipientId(challengeTo.getUserRecipientId());
			challengeEntity.setChallengeCreatingDate(challengeTo.getChallengeCreatingDate());
			challengeEntity.setChallengeExpirationDate(challengeTo.getChallengeExpirationDate());
			challengeEntity.setChallengeStatus(challengeTo.getChallengeStatus());
			return challengeEntity;
		}
		return null;
	}
	
	/**
	 * Updates data from transfer object to entity
	 * @param challengeEntity - entity to update
	 * @param challengeTo - transfer object to update
	 * @return entity updated based on transfer object data
	 */
	public static ChallengeEntity update(ChallengeEntity challengeEntity, ChallengeTo challengeTo) {
		if (challengeTo != null && challengeEntity != null) {
			challengeEntity.setId(challengeTo.getId());
			challengeEntity.setUserSenderId(challengeTo.getUserSenderId());
			challengeEntity.setUserRecipientId(challengeTo.getUserRecipientId());
			challengeEntity.setChallengeCreatingDate(challengeTo.getChallengeCreatingDate());
			challengeEntity.setChallengeExpirationDate(challengeTo.getChallengeExpirationDate());
			challengeEntity.setChallengeStatus(challengeTo.getChallengeStatus());
			return challengeEntity;
		}
		return null;
	}
	
	public static List<ChallengeTo> map2TOs(List<ChallengeEntity> challengeEntity) {
		return challengeEntity.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}

	public static List<ChallengeEntity> map2Entities(List<ChallengeTo> challengeTOs) {
		return challengeTOs.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}
}
