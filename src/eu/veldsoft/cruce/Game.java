package eu.veldsoft.cruce;

class Game {
	int numberPlayers;
	int pointsNumber;
	Round round;
	Player players[] = new Player[Constants.MAX_GAME_PLAYERS];
	Team teams[] = new Team[Constants.MAX_GAME_TEAMS];
	Deck deck;

	/**
	 * @author INFM032 F___05 Georgi Krumov Hristov
	 * @author INFM032 F___98 Simona Ilkova Boneva
	 * @author INFM042 F___80 Spas Kostov Hristov
	 */
	Game game_createGame(final int pointsNumber) {
		if (pointsNumber != 11 && pointsNumber != 15 && pointsNumber != 21) {
			return null;
		}

		Game newGame = new Game();

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			newGame.players[i] = null;
		}

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			newGame.teams[i] = null;
		}

		newGame.pointsNumber = pointsNumber;
		newGame.numberPlayers = 0;
		newGame.round = null;
		newGame.deck = null;

		return newGame;
	}

	/**
	 * @author INFM032 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM042 F___80 Boris Kirilov Kafaliev
	 * @author INFM032 F___25 Kalina Zhivkova Momkova
	 */
	int game_deleteGame(Game game) {

		// check whether the game is already deleted
		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}

		// delete game
		game = null;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM032 F___06 Milen Tsvetanov Pankov
	 * @author INFM032 F___62 Viktor Georgiev Petrov
	 * @author INFM042 F___21 Trifon Zhivkov Trifonov
	 */
	int game_addPlayer(Player player, Game game) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) { // run validation
																// for already
																// existing
																// player
			if (game.players != null && i < game.players.length
					&& game.players[i].equals(player)) { // Player.java must
															// override equals
															// method
				return Errors.ERROR_CODE.DUPLICATE.getIndex();
			}

			if (game.players != null && i < game.players.length
					&& game.players[i].name.equals(player.name)) {
				return Errors.ERROR_CODE.DUPLICATE_NAME.getIndex();
			}
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) { // find empty
																// slot and put
																// the player
																// there
			if (game.players[i] == null) {
				game.players[i] = player;
				game.numberPlayers++;
				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}

		return Errors.ERROR_CODE.FULL.getIndex();
	}

	/**
	 * @param player
	 * @param game
	 * @author INFM032 F___24 Rosen Ivanov Videv
	 * @author INFM042 F___77 Yosif Rumenov Enev
	 * @author INFM042 F___30 Kristina Ivanova Dineva
	 */
	int game_removePlayer(final Player player, Game game) {
		if (player == null)
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		if (game == null)
			return Errors.ERROR_CODE.GAME_NULL.getIndex();

		int i = 0;
		while (i < Constants.MAX_GAME_PLAYERS && game.players[i] != player)
			i++;

		if (i == Constants.MAX_GAME_PLAYERS)
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();

		game.players[i] = null;
		game.numberPlayers--;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @param team
	 * @param game
	 * @author INFM032 F___83 Gabriel Valentinov Grigorov
	 * @author INFM042 F___94 Stefan Lyudmilov Urumov
	 * @author INFM042 F___77 Yosif Rumenov Enev
	 */
	static int game_addTeam(Team team, Game game) {
		if (team == null)
			return Errors.ERROR_CODE.TEAM_NULL.getIndex();
		if (game == null)
			return Errors.ERROR_CODE.GAME_NULL.getIndex();

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			if (game.teams[i] == team)
				return Errors.ERROR_CODE.DUPLICATE.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			if (game.teams[i] == null) {
				game.teams[i] = team;
				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}

		return Errors.ERROR_CODE.FULL.getIndex();
	}

	/**
	 * @author INFM032 F___24 Rosen Ivanov Videv
	 * @author INFM042 F___12 Nikolay Todorov Hristov
	 * @author INFM032 F___33 Veselka Penkova Peycheva
	 */
	int game_removeTeam(final Team team, Game game) {
		if (team == null) {
			return Errors.ERROR_CODE.TEAM_NULL.getIndex();
		}
		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}

		int i = 0;
		while (i < Constants.MAX_GAME_TEAMS && game.teams[i] != team) {
			i++;
		}

		if (i == Constants.MAX_GAME_TEAMS) {
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		}

		game.teams[i] = null;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___21 Mariya Asenova Shindarova
	 * @author INFM032 F___83 Gabriel Valentinov Grigorov
	 * @author INFM042 F___24 Rosen Ivanov Videv
	 */
	Team game_winningTeam(Game game) {
		return (null);
	}

	/**
	 * @author INFM042 F___32 Boris Stefanov Karastanev
	 * @author INFM042 F___80 Boris Kirilov Kafaliev
	 * @author INFM042 F___24 Rosen Ivanov Videv
	 */
	static int maximumValue(Card cards[], final int length, final Suit suit) {

		int maxValue = -1;
		for (int i = 0; i < length; i++)
			if (cards[i] != null && cards[i].suit == suit
					&& cards[i].value > maxValue)
				maxValue = cards[i].value;

		return maxValue;
	}

	/**
	 * Function checks if the player can put a card down.
	 * 
	 * @param player
	 *            The player who wants to put the card down.
	 * @param game
	 *            The game where the player is located.
	 * @param hand
	 *            The hand in which should put the card.
	 * @param idCard
	 *            The id of the card.
	 *            
	 * @return 1 if the player may to put the card down 0 if the player can't to
	 *         put the card down other value on failure.
	 *         
	 * @author INFM042 F___29 Diana Ilieva Dyulgerova
	 * @author INFM032 F___43 Stefan Mitkov Nenchev
	 * @author INFM032 F___75 Mihail Genov Knebel
	 */
	static int game_checkCard(Player player, final Game game, Hand hand,
			final int idCard) {
		if (player == null)
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		if (game == null)
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		if (hand == null)
			return Errors.ERROR_CODE.HAND_NULL.getIndex();
		if (game.numberPlayers == 0)
			return Errors.ERROR_CODE.GAME_EMPTY.getIndex();
		if (game.numberPlayers * Constants.MAX_CARDS > Constants.DECK_SIZE
				&& (idCard < 0 || idCard > Constants.DECK_SIZE
						/ game.numberPlayers - 1))
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		if (idCard < 0 || idCard > Constants.MAX_CARDS - 1)
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		if (player.hand[idCard] == null)
			return Errors.ERROR_CODE.CARD_NULL.getIndex();
		if (hand.cards[0] == null)
			return 1;

		int maxFirstCardValuePlayer = maximumValue(player.hand,
				Constants.MAX_CARDS, hand.cards[0].suit);
		int maxTrumpValuePlayer = maximumValue(player.hand,
				Constants.MAX_CARDS, game.round.trump);
		int maxFirstCardValue = maximumValue(hand.cards,
				Constants.MAX_GAME_PLAYERS, hand.cards[0].suit);
		int maxTrumpValue = maximumValue(hand.cards,
				Constants.MAX_GAME_PLAYERS, game.round.trump);

		Card chosenCard = player.hand[idCard];
		Card firstCard = hand.cards[0];
		Suit trump = game.round.trump;

		if ((maxFirstCardValuePlayer == -1 && maxTrumpValuePlayer == -1)
				|| (chosenCard.suit == firstCard.suit && (chosenCard.value > maxFirstCardValue
						|| maxFirstCardValuePlayer < maxFirstCardValue || (maxTrumpValue > -1 && (firstCard.suit != trump || chosenCard.value > maxTrumpValue))))
				|| (maxFirstCardValuePlayer == -1 && chosenCard.suit == trump && (chosenCard.value > maxTrumpValue || maxTrumpValue > maxTrumpValuePlayer)))
			return 1;

		return 0;
	}

	/**
	 * @author INFM042 F___30 Kristina Ivanova Dineva
	 * @author INFM042 F___12 Nikolay Todorov Hristov
	 * @author INFM032 F___79 Viktor Georgiev Chanev
	 */
	int findAllowedCard(final Player player, final Game game, Hand hand,
			int currentCard, final int searchPattern) {
		if (player == null)
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
			
		if (game == null)
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
			
		if (hand == null)
			return Errors.ERROR_CODE.HAND_NULL.getIndex();
			
		if (searchPattern != 1 && searchPattern != -1)
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
			
		if (game.numberPlayers * Constants.MAX_CARDS > Constants.DECK_SIZE &&
			(currentCard < 0 || currentCard > Constants.DECK_SIZE / game.numberPlayers - 1))
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
			
		while (true) {
			currentCard += searchPattern;
			
			if (currentCard < 0)
				currentCard += Constants.MAX_CARDS;
			
			while (player.hand[currentCard % Constants.MAX_CARDS] == null && Math.abs(currentCard) <= 15)
				currentCard += searchPattern;
			
			if (game_checkCard(player, game, hand, currentCard % Constants.MAX_CARDS) == 1)
				return currentCard % Constants.MAX_CARDS;
			
			if (Math.abs(currentCard) > 15)
				return Errors.ERROR_CODE.NOT_FOUND.getIndex();
			}
	}

	/**
	 * @author INFM042 F___75 Mihail Genov Knebel
	 * @author INFM042 F___79 Viktor Georgiev Chanev
	 * @author INFM032 F___12 Nikolay Todorov Hristov
	 */
	int game_findNextAllowedCard(Player player, Game game, Hand hand,
			int currentCard) {
		return (0);
	}

	/**
	 * @author INFM042 F___80 Boris Kirilov Kafaliev
	 * @author INFM032 F___31 Danail Nedkov Rusev
	 * @author INFM042 F___76 Venelin Lyulinov Lozanov
	 */
	int game_findPreviousAllowedCard(Player player, Game game, Hand hand,
			int currentCard) {
		return (0);
	}

	/**
	 * @param game
	 * @param player
	 * 
	 * @return
	 * 
	 * @author INFM032 F___05 Georgi Krumov Hristov
	 * @author INFM032 F___80 Goritsa Ivanova Yanakieva
	 * @author INFM032 F___76 Venelin Lyulinov Lozanov
	 */
	Team game_findTeam(final Game game, Player player) {
		if (player == null)
			return null;
		if (game == null)
			return null;

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			if (game.teams[i] != null) {
				for (int j = 0; j < Constants.MAX_TEAM_PLAYERS; j++)
					if (game.teams[i].players[j] == player)
						return game.teams[i];
			}
		}

		return null;
	}

	/**
	 * @author INFM032 F___30 Kristina Ivanova Dineva
	 * @author INFM032 F___21 Mariya Asenova Shindarova
	 * @author INFM042 F___33 Veselka Penkova Peycheva
	 */
	int game_updateScore(final Game game, Player bidWinner) {
		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}
		if (bidWinner == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		Team bidWinnerTeam = game_findTeam(game, bidWinner);
		int bidWinnerTeamId = -1;
		int[] teamScores = new int[Constants.MAX_GAME_TEAMS];

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			teamScores[i] = 0;
			if (game.teams[i] == bidWinnerTeam) {
				bidWinnerTeamId = i;
			}
		}

		if (bidWinnerTeamId == -1 || bidWinnerTeam == null) {
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (game.round.players[i] != null) {
				Team team = game_findTeam(game, game.round.players[i]);
				if (team == null) {
					return Errors.ERROR_CODE.NOT_FOUND.getIndex();
				}
				for (int j = 0; j < Constants.MAX_GAME_TEAMS; j++) {
					if (game.teams[j] == team) {
						teamScores[j] += game.round.pointsNumber[i];
					}
				}
			}
		}

		int bidWinnerId = Round.round_findPlayerIndexRound(bidWinner,
				game.round);
		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			if (game.teams[i] != null) {
				if (game.teams[i] != bidWinnerTeam) {
					game.teams[i].score += teamScores[i] / 33;
				} else if (game.round.bids[bidWinnerId] <= teamScores[bidWinnerTeamId] / 33) {
					bidWinnerTeam.score += teamScores[bidWinnerTeamId] / 33;
				} else {
					bidWinnerTeam.score -= game.round.bids[bidWinnerId];
				}
			}
			Team.team_updatePlayersScore(game.teams[i]);
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___83 Gabriel Valentinov Grigorov
	 * @author INFM042 F___62 Viktor Georgiev Petrov
	 * @author INFM042 F___94 Stefan Lyudmilov Urumov
	 */
	int game_arrangePlayersRound(Game game, final int i) {
		return (0);
	}
}
