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
	static Team team_createTeam() {
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
	static int team_addPlayer(Team team, Player player) {
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

	/**
	 * Method remove a player in a game.
	 * 
	 * @param team
	 * @param player
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 06 Nov 2014
	 */
	int team_removePlayer(Team team, final Player player) {
		if (team == null) {
			return (Errors.ERROR_CODE.TEAM_NULL.getIndex());
		}
		if (player == null) {
			return (Errors.ERROR_CODE.PLAYER_NULL.getIndex());
		}
		for (int i = 0; i < Constants.MAX_TEAM_PLAYERS; i++) {
			if (team.players[i] == player) {
				team.players[i] = null;
				return (Errors.ERROR_CODE.NO_ERROR.getIndex());
			}
		}

		return (Errors.ERROR_CODE.NOT_FOUND.getIndex());
	}

	/**
	 * Function delete a team in a game.
	 * 
	 * @param team
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 06 Nov 2014
	 */
	int team_deleteTeam(Team team) {
		if (team == null) {
			return (Errors.ERROR_CODE.TEAM_NULL.getIndex());
		}
		team = null;

		return (Errors.ERROR_CODE.NO_ERROR.getIndex());
	}

	/**
	 * Function for delete the player from game;
	 * 
	 * @param player
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 06 Nov 2014
	 */
	int team_deletePlayer(Player player) {
		if (player == null) {
			return (Errors.ERROR_CODE.PLAYER_NULL.getIndex());
		}

		player = null;
		return (Errors.ERROR_CODE.NO_ERROR.getIndex());
	}

	/**
	 * The function add card in player hand.
	 * 
	 * @return Error if the player and card are null.Return no error if they are
	 *         not null.
	 * 
	 * @authors Vencislav Medarov
	 * @email venci932@gmail.com
	 * @date 06 Nov 2014
	 * 
	 */
	static int team_addCard(Player player, Card card) {
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

	/**
	 * The function check if the player has cards.
	 * 
	 * @param player
	 * 
	 * @return null
	 * 
	 * @authors Yani Tonev
	 * @email k_o_r_g@abv.bg
	 * @date 15 Nov 2014
	 * 
	 */
	int team_hasCards(final Player player) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}
		for (int i = 0; i < Constants.MAX_CARDS; i++) {
			if (player.hand[i] != null) {
				return 1;
			}
		}

		return 0;
	}

	/**
	 * Function for update a score of the team in game.
	 * 
	 * @param team
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 06 Nov 2014
	 */
	static int team_updatePlayersScore(Team team) {
		if (team == null) {
			return (Errors.ERROR_CODE.TEAM_NULL.getIndex());
		}

		for (int i = 0; i < Constants.MAX_TEAM_PLAYERS; i++) {
			if (team.players[i] != null) {
				team.players[i].score = team.score;
			}
		}

		return (Errors.ERROR_CODE.NO_ERROR.getIndex());
	}
}