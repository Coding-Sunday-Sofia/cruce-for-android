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
		return (0);
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
	 * @author INFM032 F___83 Gabriel Valentinov Grigorov
	 * @author INFM042 F___94 Stefan Lyudmilov Urumov
	 * @author INFM042 F___77 Yosif Rumenov Enev
	 */
	int game_addTeam(Team team, Game game) {
		return (0);
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
	int maximumValue(Card cards[], final int length, final Suit suit) {

		int maxValue = -1;
		for (int i = 0; i < length; i++)
			if (cards[i] != null && cards[i].suit == suit
					&& cards[i].value > maxValue)
				maxValue = cards[i].value;

		return maxValue;
	}

	/**
	 * @author INFM042 F___29 Diana Ilieva Dyulgerova
	 * @author INFM032 F___43 Stefan Mitkov Nenchev
	 * @author INFM032 F___75 Mihail Genov Knebel
	 */
	int game_checkCard(Player player, final Game game, Hand hand,
			final int idCard) {
		return (0);
	}

	/**
	 * @author INFM042 F___30 Kristina Ivanova Dineva
	 * @author INFM042 F___12 Nikolay Todorov Hristov
	 * @author INFM032 F___79 Viktor Georgiev Chanev
	 */
	int findAllowedCard(final Player player, final Game game, Hand hand,
			int currentCard, final int searchPattern) {
		return (0);
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
		return 0;
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
