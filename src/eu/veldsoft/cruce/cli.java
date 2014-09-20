package eu.veldsoft.cruce;

class cli {
	final int MAX_CARDS_PER_LINE = 8;

	final int MAX_NAME_SIZE = 20;

	final int ROUND_DIALOG_SCORE_SIZE = 5;

	final int SLEEP_TIME = 2;

	void welcomeMessage() {
	}

	void gameEndingMessage(Team team) {
	}

	int printCard(final Card card, final int frameColor, WINDOW win) {
		return (0);
	}

	int printPlayerCards(final Game game, Player player, final int selected,
			WINDOW win) {
		return (0);
	}

	int getNoOfPlayers() {
		return (0);
	}

	Player newPlayer(final int i) {
		return (null);
	}

	int printScore(final Game game, final Round round, WINDOW win) {
		return (0);
	}

	void createEmptyTeams(Game game) {
	}

	int formTeams(Game game) {
		return (0);
	}

	int displayCardsAndPickCard(Game game, final int playerId) {
		return (0);
	}

	int printBids(int selected, Round round, WINDOW win) {
		return (0);
	}

	int getBid(final Game game, final int playerId) {
		return (0);
	}

	int processingScore(final char score) {
		return (0);
	}

	int getScoreLimit() {
		return (0);
	}

	int getScoreDialogLineSize(final Team currentTeam) {
		return (0);
	}

	int getBiggestScoreDialogLineSize(final Game currentGame) {
		return (0);
	}

	int printRoundTerminationMessage(final Game currentGame, final int oldScore) {
		return (0);
	}

	int displayBids(final Game game, final int currentPlayer) {
		return (0);
	}
}
