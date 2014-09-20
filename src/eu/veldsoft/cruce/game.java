package eu.veldsoft.cruce;

class game {

	Game game_createGame(final int pointsNumber) {
		return (null);
	}

	int game_deleteGame(Game game) {
		return (0);
	}

	int game_addPlayer(Player player, Game game) {
		return (0);
	}

	int game_removePlayer(final Player player, Game game) {
		return (0);
	}

	int game_addTeam(Team team, Game game) {
		return (0);
	}

	int game_removeTeam(final Team team, Game game) {
		return (0);
	}

	Team game_winningTeam(Game game) {
		return (null);
	}

	int maximumValue(Card cards[], final int length, final Suit suit) {
		return (0);
	}

	int game_checkCard(Player player, final Game game, Hand hand,
			final int idCard) {
		return (0);
	}

	int findAllowedCard(final Player player, final Game game, Hand hand,
			int currentCard, final int searchPattern) {
		return (0);
	}

	int game_findNextAllowedCard(Player player, Game game, Hand hand,
			int currentCard) {
		return (0);
	}

	int game_findPreviousAllowedCard(Player player, Game game, Hand hand,
			int currentCard) {
		return (0);
	}

	Team game_findTeam(final Game game, Player player) {
		return (null);
	}

	int game_updateScore(final Game game, Player bidWinner) {
		return (0);
	}

	int game_arrangePlayersRound(Game game, final int i) {
		return (0);
	}
}