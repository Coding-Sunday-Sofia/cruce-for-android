package eu.veldsoft.cruce;

import eu.veldsoft.cruce.Errors;
import eu.veldsoft.cruce.Constants;

/**
 * 
 * @author Vencislav Medarov
 */
class Team {

	/**
	 * 
	 */
	int score;

	/**
	 * 
	 */
	Player players[] = new Player[Constants.MAX_TEAM_PLAYERS];

	/**
	 * The function create a object from class Player.
	 * 
	 * @param name
	 * @param isHuman
	 * 
	 * @return Player
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 04 Nov 2014
	 * 
	 */
	static Player team_createPlayer(final String name, final int isHuman) {
		if (name == null) {
			return null;
		}

		Player newPlayer = new Player();
		newPlayer.name = name;
		newPlayer.score = 0;
		newPlayer.isHuman = isHuman;

		/*
		 * There aren't cards when player is created.
		 */
		for (int i = 0; i < Constants.MAX_CARDS; i++) {
			newPlayer.hand[i] = null;
		}

		return newPlayer;
	}

	/**
	 * The function create a object from class Team.
	 * 
	 * @return Team
	 * 
	 * @authors Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 04 Nov 2014
	 * 
	 */
	Team team_createTeam() {
		Team newTeam = new Team();
		
		if (newTeam == null) {
			return null;
		}

		newTeam.score = 0;
		newTeam.players[0] = null;
		newTeam.players[1] = null;
		
		return newTeam;
	}

	/**
	 * 
	 * @param team
	 * @param player
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 04 Nov 2014
	 * 
	 */
	int team_addPlayer(Team team, Player player) {
		if (team == null) {
			return Errors.ERROR_CODE.TEAM_NULL.getIndex();
		}
		
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		for (int i = 0; i < Constants.MAX_TEAM_PLAYERS; i++) {
			if (team.players[i] == player) {
				return Errors.ERROR_CODE.DUPLICATE.getIndex();
			}
		}
		
		for (int i = 0; i < Constants.MAX_TEAM_PLAYERS; i++) {
			if (team.players[i] == null) {
				team.players[i] = player;
				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}

		return Errors.ERROR_CODE.TEAM_FULL.getIndex();
	}

	// TODO be done by ALEX
	/**
	 */
	int team_removePlayer(Team team, final Player player) {
		return (0);
	}

	// TODO be done bt Alex
	/**
	 */
	int team_deleteTeam(Team team) {
		return (0);
	}

	// TODO be done by ALex
	/**
	 */
	int team_deletePlayer(Player player) {
		return (0);
	}

	/**
	 * The function add card in player hand.
	 * 
	 * @return FULL
	 * 
	 * @authors Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 06 Nov 2014
	 * 
	 */
	int team_addCard(Player player, Card card) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}
		
		if (card == null) {
			return Errors.ERROR_CODE.CARD_NULL.getIndex();
		}
		
		for (int i = 0; i < Constants.MAX_CARDS; i++) {
			if (player.hand[i] == card) {
				return Errors.ERROR_CODE.DUPLICATE.getIndex();
			}
		}
		
		for (int i = 0; i < Constants.MAX_CARDS; i++) {
			if (player.hand[i] == null) {
				player.hand[i] = card;
				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}
		
		return (Errors.ERROR_CODE.FULL.getIndex());
	}

	// TODO To be done by Yani.
	/**
	 */
	int team_hasCards(final Player player) {
		return (0);
	}

	/**
	 */
	int team_updatePlayersScore(Team team) {
		return (0);
	}
}
