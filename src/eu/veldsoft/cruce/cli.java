package eu.veldsoft.cruce;

class cli {
	final int MAX_CARDS_PER_LINE = 8;

	final int MAX_NAME_SIZE = 20;

	final int ROUND_DIALOG_SCORE_SIZE = 5;

	final int SLEEP_TIME = 2;

	void welcomeMessage() {
	}

	/**
	 * @author	INFM042 F___80	 Goritsa Ivanova Yanakieva
	 * @author	INFM032 F___83	 Gabriel Valentinov Grigorov
	 * @author	INFM032 F___21	 Trifon Zhivkov Trifonov
	 */
	void gameEndingMessage(Team team) {
	}

	/**
	 * @author	INFM032 F___29	 Diana Ilieva Dyulgerova
	 * @author	INFM042 F___43	 Stefan Mitkov Nenchev
	 * @author	INFM032 F___80	 Spas Kostov Hristov
	 */
	int printCard(final Card card, final int frameColor, WINDOW win) {
		return (0);
	}

	/**
	 * @author	INFM042 F___94	 Stefan Lyudmilov Urumov
	 * @author	INFM042 F___33	 Veselka Penkova Peycheva
	 * @author	INFM032 F___29	 Diana Ilieva Dyulgerova
	 */
	int printPlayerCards(final Game game, Player player, final int selected,
			WINDOW win) {
		return (0);
	}

	/**
	 * @author	INFM032 F___98	 Simona Ilkova Boneva
	 * @author	INFM042 F___43	 Stefan Mitkov Nenchev
	 * @author	INFM032 F___80	 Goritsa Ivanova Yanakieva
	 */
	int getNoOfPlayers() {
		return (0);
	}

	/**
	 * @author	INFM032 F___77	 Yosif Rumenov Enev
	 * @author	INFM032 F___80	 Goritsa Ivanova Yanakieva
	 * @author	INFM032 F___04	 Petar Aleksandrov Vorotnikov
	 */
	Player newPlayer(final int i) {
		return (null);
	}

	/**
	 * @author	INFM032 F___62	 Viktor Georgiev Petrov
	 * @author	INFM032 F___29	 Diana Ilieva Dyulgerova
	 * @author	INFM042 F___31	 Danail Nedkov Rusev
	 */
	int printScore(final Game game, final Round round, WINDOW win) {
		return (0);
	}

	/**
	 * @author	INFM032 F___06	 Milen Tsvetanov Pankov
	 * @author	INFM032 F___33	 Veselka Penkova Peycheva
	 * @author	INFM032 F___94	 Stefan Lyudmilov Urumov
	 */
	void createEmptyTeams(Game game) {
	}

	/**
	 * @author	INFM042 F___05	 Georgi Krumov Hristov
	 * @author	INFM042 F___25	 Kalina Zhivkova Momkova
	 * @author	INFM032 F___06	 Milen Tsvetanov Pankov
	 */
	int formTeams(Game game) {
		return (0);
	}

	/**
	 * @author	INFM042 F___30	 Kristina Ivanova Dineva
	 * @author	INFM042 F___31	 Danail Nedkov Rusev
	 * @author	INFM042 F___06	 Milen Tsvetanov Pankov
	 */
	int displayCardsAndPickCard(Game game, final int playerId) {
		return (0);
	}

	/**
	 * @author	INFM032 F___77	 Yosif Rumenov Enev
	 * @author	INFM032 F___43	 Stefan Mitkov Nenchev
	 * @author	INFM032 F___21	 Mariya Asenova Shindarova
	 */
	int printBids(int selected, Round round, WINDOW win) {
		return (0);
	}

	/**
	 * @author	INFM042 F___79	 Viktor Georgiev Chanev
	 * @author	INFM042 F___31	 Danail Nedkov Rusev
	 * @author	INFM042 F___32	 Boris Stefanov Karastanev
	 */
	int getBid(final Game game, final int playerId) {
		return (0);
	}

	/**
	 * @author	INFM042 F___83	 Gabriel Valentinov Grigorov
	 * @author	INFM032 F___31	 Danail Nedkov Rusev
	 * @author	INFM042 F___29	 Diana Ilieva Dyulgerova
	 */
	int processingScore(final char score) {
		return (0);
	}

	/**
	 * @author	INFM042 F___62	 Viktor Georgiev Petrov
	 * @author	INFM042 F___25	 Kalina Zhivkova Momkova
	 * @author	INFM042 F___21	 Trifon Zhivkov Trifonov
	 */
	int getScoreLimit() {
		return (0);
	}

	/**
	 * @author	INFM042 F___25	 Kalina Zhivkova Momkova
	 * @author	INFM032 F___98	 Simona Ilkova Boneva
	 * @author	INFM032 F___94	 Stefan Lyudmilov Urumov
	 */
	int getScoreDialogLineSize(final Team currentTeam) {
		return (0);
	}

	/**
	 * @author	INFM042 F___06	 Milen Tsvetanov Pankov
	 * @author	INFM042 F___04	 Petar Aleksandrov Vorotnikov
	 * @author	INFM032 F___21	 Trifon Zhivkov Trifonov
	 */
	int getBiggestScoreDialogLineSize(final Game currentGame) {
		return (0);
	}

	/**
	 * @author	INFM042 F___32	 Boris Stefanov Karastanev
	 * @author	INFM042 F___43	 Stefan Mitkov Nenchev
	 * @author	INFM042 F___98	 Simona Ilkova Boneva
	 */
	int printRoundTerminationMessage(final Game currentGame, final int oldScore) {
		return (0);
	}

	/**
	 * @author	INFM042 F___98	 Simona Ilkova Boneva
	 * @author	INFM032 F___75	 Mihail Genov Knebel
	 * @author	INFM042 F___80	 Spas Kostov Hristov
	 */
	int displayBids(final Game game, final int currentPlayer) {
		return (0);
	}
}

