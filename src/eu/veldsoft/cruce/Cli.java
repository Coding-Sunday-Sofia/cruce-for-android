package eu.veldsoft.cruce;

import java.util.Scanner;

class Cli {
	final int MAX_CARDS_PER_LINE = 8;

	final int MAX_NAME_SIZE = 20;

	final int ROUND_DIALOG_SCORE_SIZE = 5;

	final int SLEEP_TIME = 2;

	void welcomeMessage() {
	}

	/**
	 * @param team
	 * 
	 * @author INFM042 F___80 Goritsa Ivanova Yanakieva
	 * @author INFM032 F___83 Gabriel Valentinov Grigorov
	 * @author INFM032 F___21 Trifon Zhivkov Trifonov
	 */
	void gameEndingMessage(final Team team) {
		Globals.printw(" ______           _    ____   __    _____    \n"
				+ "|  ____|         | |  / __ \\ / _|  / ____|      \n"
				+ "| |__   _ __   __| | | |  | | |_  | |  __  __ _ _ __ ___   ___ \n"
				+ "|  __| | '_ \\ / _` | | |  | |  _| | | |_ |/ _` | '_ ` _ \\ / _ \\\n"
				+ "| |____| | | | (_| | | |__| | |   | |__| | (_| | | | | | |  __/\n"
				+ "|______|_| |_|\\__,_|  \\____/|_|    \\_____|\\__,_|_| |_| |_|\\___|\n"
				+ "\n\n");

		for (int i = Constants.MAX_TEAM_PLAYERS - 1; i >= 0; --i)
			if (team.players[i] != null) {
				if (i > 0) {
					Globals.printw("%s, ", team.players[i].name);
				} else {
					Globals.printw("%s ", team.players[i].name);
				}
			}
		Globals.printw("won the game.");
	}

	/**
	 * @author INFM032 F___29 Diana Ilieva Dyulgerova
	 * @author INFM042 F___43 Stefan Mitkov Nenchev
	 * @author INFM032 F___80 Spas Kostov Hristov
	 */
	int printCard(final Card card, final int frameColor, WINDOW win) {
		int colorPair;
		char suit[] = { 0xE2, 0x99, 0x00, 0x00 };
		switch (card.suit) {
		case DIAMONDS:
			colorPair = 3;
			suit[2] = 0xA6;
			break;
		case CLUBS:
			colorPair = 4;
			suit[2] = 0xA3;
			break;
		case HEARTS:
			colorPair = 1;
			suit[2] = 0xA5;
			break;
		case SPADES:
			colorPair = 2;
			suit[2] = 0xA0;
			break;
		default:
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}

		char value;
		switch (card.value) {
		case 0:
			value = '9';
			break;
		case 2:
		case 3:
		case 4:
			value = (char) ('0' + card.value);
			break;
		case 10:
			value = 'X';
			break;
		case 11:
			value = 'A';
			break;
		default:
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}

		if (Constants.WIN32 == true) {
			char upLeftCorner[] = { 0xE2, 0x94, 0x8C, 0x00 };
			char upRightCorner[] = { 0xE2, 0x94, 0x90, 0x00 };
			char downLeftCorner[] = { 0xE2, 0x94, 0x94, 0x00 };
			char downRightCorner[] = { 0xE2, 0x94, 0x98, 0x00 };
			char horizontalLine[] = { 0xE2, 0x94, 0x80, 0x00 };
			char verticalLine[] = { 0xE2, 0x94, 0x82, 0x00 };
		} else {
			char upLeftCorner[] = { 0xE2, 0x95, 0xAD, 0x00 };
			char upRightCorner[] = { 0xE2, 0x95, 0xAE, 0x00 };
			char downLeftCorner[] = { 0xE2, 0x95, 0xB0, 0x00 };
			char downRightCorner[] = { 0xE2, 0x95, 0xAF, 0x00 };
			char horizontalLine[] = { 0xE2, 0x94, 0x80, 0x00 };
			char verticalLine[] = { 0xE2, 0x94, 0x82, 0x00 };
		}

		int x = 0, y = 0;
		Globals.getyx(win, y, x);

		/*
		 * wattron(win, COLOR_PAIR(frameColor)); wprintw(win, "%s%s%s%s%s%s",
		 * upLeftCorner, horizontalLine, horizontalLine, horizontalLine,
		 * horizontalLine, upRightCorner);
		 * 
		 * wmove(win, y + 1, x); wprintw(win, "%s", verticalLine); wattroff(win,
		 * COLOR_PAIR(frameColor)); wprintw(win, "%c   ", value); wattron(win,
		 * COLOR_PAIR(frameColor)); wprintw(win, "%s", verticalLine); wmove(win,
		 * y + 2, x);
		 * 
		 * wprintw(win, "%s", verticalLine); wattroff(win,
		 * COLOR_PAIR(frameColor)); wattron(win, COLOR_PAIR(colorPair));
		 * wprintw(win, "%s", suit); wattroff(win, COLOR_PAIR(colorPair));
		 * wattron(win, COLOR_PAIR(frameColor)); wprintw(win, "   %s",
		 * verticalLine); wmove(win, y + 3, x);
		 * 
		 * wprintw(win, "%s    %s", verticalLine, verticalLine); wmove(win, y +
		 * 4, x); wprintw(win, "%s", verticalLine); wattroff(win,
		 * COLOR_PAIR(frameColor)); wattron(win, COLOR_PAIR(colorPair));
		 * wprintw(win, "  %s", suit); wattroff(win, COLOR_PAIR(colorPair));
		 * 
		 * wattron(win, COLOR_PAIR(frameColor)); wprintw(win, " %s",
		 * verticalLine); wmove(win, y + 5, x); wprintw(win, "%s   ",
		 * verticalLine); wattroff(win, COLOR_PAIR(frameColor)); wattroff(win,
		 * COLOR_PAIR(frameColor)); wprintw(win, "%c", value); wattron(win,
		 * COLOR_PAIR(frameColor)); wprintw(win, "%s", verticalLine); wmove(win,
		 * y + 6, x);
		 * 
		 * wprintw(win, "%s%s%s%s%s%s",downLeftCorner,
		 * horizontalLine,horizontalLine, horizontalLine, horizontalLine,
		 * downRightCorner); wattroff(win, COLOR_PAIR(frameColor));
		 * 
		 * wmove(win, y + 9, x); wmove(win, y, x + 6); wrefresh(win);
		 */

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * Print player hand.
	 * 
	 * @param game
	 *            Current game reference.
	 * @param player
	 *            Current player reference.
	 * @param selected
	 *            Selected card index.
	 * @param win
	 *            Terminal window reference.
	 * 
	 * @return Error code.
	 * 
	 * @author INFM042 F___94 Stefan Lyudmilov Urumov
	 * @author INFM042 F___33 Veselka Penkova Peycheva
	 * @author INFM032 F___29 Diana Ilieva Dyulgerova
	 */
	int printPlayerCards(final Game game, Player player, final int selected,
			WINDOW win) {
		if (player == null)
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		if (win == null)
			return Errors.ERROR_CODE.POINTER_NULL.getIndex();
		Globals.wprintw(win, "Your cards:\n");
		int handId = 0;
		while (game.round.hands[handId] != null) {
			handId++;
		}
		if (handId > 0)
			handId--;
		for (int i = 0; i < Constants.MAX_CARDS; i++) {
			if (player.hand[i] != null) {
				if (Game.game_checkCard(player, game, game.round.hands[handId],
						i) != 0) {
					if (i == selected)
						printCard(player.hand[i], 3, win);
					else
						printCard(player.hand[i], 7, win);
				} else {
					printCard(player.hand[i], 1, win);
				}
			}
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM032 F___98 Simona Ilkova Boneva
	 * @author INFM042 F___43 Stefan Mitkov Nenchev
	 * @author INFM032 F___80 Goritsa Ivanova Yanakieva
	 */
	int getNoOfPlayers() {
		return (0);
	}

	/**
	 * @param i
	 * 
	 * @return
	 * 
	 * @author INFM032 F___77 Yosif Rumenov Enev
	 * @author INFM032 F___80 Goritsa Ivanova Yanakieva
	 * @author INFM032 F___04 Petar Aleksandrov Vorotnikov
	 */
	Player newPlayer(final int i) {
		/*
		 * Used to store the format string.
		 */
		String format = "";
		String name = "";

		do {
			Globals.printw("Insert player %d name: ", i);
			Globals.sprintf(format, "%%%i[^\n]", MAX_NAME_SIZE);
			Globals.scanw(format, name);
		} while (name.length() == 0);

		Player player = Team.team_createPlayer(name, 1);
		return player;
	}

	/**
	 * @author INFM032 F___62 Viktor Georgiev Petrov
	 * @author INFM032 F___29 Diana Ilieva Dyulgerova
	 * @author INFM042 F___31 Danail Nedkov Rusev
	 */
	int printScore(final Game game, final Round round, WINDOW win) {
		if (game == null)
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		if (round == null)
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();

		char verticalBox[] = { 0xe2, 0x94, 0x82, 0x00 };
		char horizontalBox[] = { 0xe2, 0x94, 0x80, 0x00 };
		char downRightBox[] = { 0xe2, 0x94, 0x8c, 0x00 };
		char downLeftBox[] = { 0xe2, 0x94, 0x90, 0x00 };
		char upRightBox[] = { 0xe2, 0x94, 0x94, 0x00 };
		char upLeftBox[] = { 0xe2, 0x94, 0x98, 0x00 };
		char downHorizontalBox[] = { 0xe2, 0x94, 0xac, 0x00 };
		char upHorizontalBox[] = { 0xe2, 0x94, 0xb4, 0x00 };
		char verticalHorizontalBox[] = { 0xe2, 0x94, 0xbc, 0x00 };
		char verticalRightBox[] = { 0xe2, 0x94, 0x9c, 0x00 };
		char verticalLeftBox[] = { 0xe2, 0x94, 0xa4, 0x00 };

		int maxLength = 0;
		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++)
			if (game.players[i] != null) {
				int length = String.valueOf(game.players[i].name).length();
				if (length > maxLength)
					maxLength = length;
			}
		maxLength++;

		if (maxLength < 4)
			maxLength = 4;

		int x = 0;
		int y = 0;
		int line = 0;
		Globals.getyx(win, y, x);

		Globals.wprintw(win, "%s", downRightBox);
		for (int i = 1; i <= maxLength + 13; i++) {
			if (i == maxLength + 1 || i == maxLength + 8)
				Globals.wprintw(win, "%s", downHorizontalBox);
			else
				Globals.wprintw(win, "%s", horizontalBox);
		}
		Globals.wprintw(win, "%s", downLeftBox);
		line++;

		Globals.wmove(win, y + 1, x);
		Globals.wprintw(win, "%sName", verticalBox);
		Globals.wmove(win, y + 1, x + maxLength + 1);
		Globals.wprintw(win, "%sPoints", verticalBox);
		Globals.wmove(win, y + 1, x + maxLength + 8);
		Globals.wprintw(win, "%sScore%s", verticalBox, verticalBox);
		line++;

		Globals.wmove(win, y + line, x);
		Globals.wprintw(win, "%s", verticalRightBox);
		for (int i = 1; i <= maxLength + 13; i++)
			if (i == maxLength + 1 || i == maxLength + 8)
				Globals.wprintw(win, "%s", verticalHorizontalBox);
			else
				Globals.wprintw(win, "%s", horizontalBox);
		Globals.wprintw(win, "%s", verticalLeftBox);
		line++;

		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++)
			if (game.teams[i] != null) {
				int playersNumber = 0;
				for (int j = 0; j < Constants.MAX_TEAM_PLAYERS; j++)
					if (game.teams[i].players[j] != null) {
						Globals.wmove(win, y + line, x);
						Globals.wprintw(win, "%s%s", verticalBox,
								game.teams[i].players[j].name);
						Globals.wmove(win, y + line, x + maxLength + 1);
						Globals.wprintw(win, "%s", verticalBox);
						Globals.wmove(win, y + line, x + maxLength + 8);
						Globals.wprintw(win, "%s", verticalBox);
						Globals.wmove(win, y + line, x + maxLength + 14);
						Globals.wprintw(win, "%s", verticalBox);
						line++;
						Globals.wmove(win, y + line, x);
						Globals.wprintw(win, "%s", verticalRightBox);
						for (int k = 1; k <= maxLength + 14; k++) {
							if (k <= maxLength)
								Globals.wprintw(win, "%s", horizontalBox);
							if (k == maxLength + 1)
								Globals.wprintw(win, "%s", verticalLeftBox);
							if (k == maxLength + 8 || k == maxLength + 14) {
								Globals.wmove(win, y + line, x + k);
								Globals.wprintw(win, "%s", verticalBox);
							}
						}
						line++;
						playersNumber++;
					}
				--line;
				Globals.wmove(win, y + line, x + maxLength + 1);
				for (int k = maxLength + 1; k < maxLength + 14; k++) {
					if (k == maxLength + 1 || k == maxLength + 8)
						Globals.wprintw(win, "%s", verticalHorizontalBox);
					else
						Globals.wprintw(win, "%s", horizontalBox);
				}
				Globals.wprintw(win, "%s", verticalLeftBox);
				if (playersNumber > 0) {
					Globals.wmove(win, y + line - playersNumber, x + maxLength
							+ 2);
					Globals.wprintw(win, "%*d", 6,
							Round.round_computePoints(game.teams[i], round));
					Globals.wmove(win, y + line - playersNumber, x + maxLength
							+ 9);
					Globals.wprintw(win, "%*d", 5, game.teams[i].score);
				}
				line++;
			}

		Globals.wmove(win, y + line - 1, x);
		Globals.wprintw(win, "%s", upRightBox);
		for (int i = 1; i <= maxLength + 13; i++) {
			if (i == maxLength + 1 || i == maxLength + 8)
				Globals.wprintw(win, "%s", upHorizontalBox);
			else
				Globals.wprintw(win, "%s", horizontalBox);
		}
		Globals.wprintw(win, "%s\n", upLeftBox);
		Globals.wrefresh(win);

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * Create empty teams
	 * 
	 * @param game
	 *            Current game reference. validate if the players array is
	 *            initialized with the correct length
	 * 
	 * @author INFM032 F___06 Milen Tsvetanov Pankov
	 * @author INFM032 F___33 Veselka Penkova Peycheva
	 * @author INFM032 F___94 Stefan Lyudmilov Urumov
	 */
	void createEmptyTeams(Game game) {
		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (game.players != null && i < game.players.length) { // validate
																	// if the
																	// players
																	// array is
																	// initialized
																	// with the
																	// correct
																	// length
				Team team = new Team(); // initialize Team object with default
										// constructor (this should not be
										// needed if the team_createTeam method
										// is static
				team = Team.team_createTeam(); // team_createTeam() should be
												// marked as static
				Team.team_addPlayer(team, game.players[i]);
				Game.game_addTeam(team, game);
			}
		}
	}

	/**
	 * @author INFM042 F___05 Georgi Krumov Hristov
	 * @author INFM042 F___25 Kalina Zhivkova Momkova
	 * @author INFM032 F___06 Milen Tsvetanov Pankov
	 */
	int formTeams(Game game) {
		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}

		if (game.numberPlayers == 0) {
			return Errors.ERROR_CODE.GAME_EMPTY.getIndex();
		}

		if (game.numberPlayers == 1) {
			return Errors.ERROR_CODE.INSUFFICIENT_PLAYERS.getIndex();
		}

		if (game.numberPlayers < 4) {
			createEmptyTeams(game);
			return Errors.ERROR_CODE.NO_ERROR.getIndex();
		}

		System.out.print("Do you want to play on teams? (Y/n) ");
		Scanner scanner = new Scanner(System.in);
		String answer = scanner.nextLine();
		System.out.println(""); // add new line for better readability

		if (answer == null || answer.equalsIgnoreCase("n")) {
			createEmptyTeams(game);
			return Errors.ERROR_CODE.NO_ERROR.getIndex();
		}

		System.out.print("Player 1 (" + game.players[0].name
				+ "): Please insert your teammate's id: ");
		int playerId = 0;

		while (playerId < 2 || playerId > 4) {
			answer = scanner.nextLine();

			try {
				playerId = Integer.valueOf(answer);
			} catch (NumberFormatException nfe) { // incorrect digit entered
				playerId = 0;
			}

			if (playerId < 2 || playerId > 4) {
				System.out.print("\nPlease insert a correct player id. ");
			}
		}

		System.out.println(""); // empty line

		playerId--;

		Player backup = game.players[1];
		game.players[1] = game.players[playerId];
		game.players[playerId] = backup;

		for (int i = 0; i < 2; i++) {
			Team team = new Team();
			team = team.team_createTeam(); // should be static
			team.team_addPlayer(team, game.players[2 * i]);
			team.team_addPlayer(team, game.players[2 * i + 1]);
			game.game_addTeam(team, game);
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___30 Kristina Ivanova Dineva
	 * @author INFM042 F___31 Danail Nedkov Rusev
	 * @author INFM042 F___06 Milen Tsvetanov Pankov
	 */
	int displayCardsAndPickCard(Game game, final int playerId) {
		return (0);
	}

	/**
	 * @author INFM032 F___77 Yosif Rumenov Enev
	 * @author INFM032 F___43 Stefan Mitkov Nenchev
	 * @author INFM032 F___21 Mariya Asenova Shindarova
	 */
	int printBids(int selected, Round round, WINDOW win) {
		return (0);
	}

	/**
	 * @author INFM042 F___79 Viktor Georgiev Chanev
	 * @author INFM042 F___31 Danail Nedkov Rusev
	 * @author INFM042 F___32 Boris Stefanov Karastanev
	 */
	int getBid(final Game game, final int playerId) {
		return (0);
	}

	/**
	 * @author INFM042 F___83 Gabriel Valentinov Grigorov
	 * @author INFM032 F___31 Danail Nedkov Rusev
	 * @author INFM042 F___29 Diana Ilieva Dyulgerova
	 */
	int processingScore(final String score) {
		if (Constants.DEBUG) {
			return Integer.valueOf(score);
		} else {
			if ("11".equals(score) == true)
				return 11;
			if ("15".equals(score) == true)
				return 15;
			if ("21".equals(score) == true)
				return 21;
			if ("q".equals(score) == true) {
				Globals.endwin();
				System.exit(0);
			}

			return -1;
		}
	}

	/**
	 * @return
	 * 
	 * @author INFM042 F___62 Viktor Georgiev Petrov
	 * @author INFM042 F___25 Kalina Zhivkova Momkova
	 * @author INFM042 F___21 Trifon Zhivkov Trifonov
	 */
	int getScoreLimit() {
		String score = "";

		do {
			Globals.printw("Insert the score limit (11-15-21): ");
			Globals.scanw("%s", score);
		} while (score.length() == 0);

		while (processingScore(score) == -1) {
			Globals.printw("Insert the correct score limit (11-15-21): ");
			Globals.scanw("%s", score);
		}

		Globals.printw("\n");

		return processingScore(score);
	}

	/**
	 * Get the line size
	 * 
	 * @param team
	 *            Current team
	 * @param player
	 *            Current player
	 * @return lineSize
	 * 
	 * @author INFM042 F___25 Kalina Zhivkova Momkova
	 * @author INFM032 F___98 Simona Ilkova Boneva
	 * @author INFM032 F___94 Stefan Lyudmilov Urumov
	 */
	int getScoreDialogLineSize(final Team currentTeam) {
		int lineSize = 0;
		int i;
		for (i = 0; i < Constants.MAX_TEAM_PLAYERS; i++) {
			if (currentTeam.players[i] != null) {
				lineSize += (currentTeam.players[i].name).length();
			}
		}
		lineSize += i + i - 1;
		return lineSize;
	}

	/**
	 * @author INFM042 F___06 Milen Tsvetanov Pankov
	 * @author INFM042 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM032 F___21 Trifon Zhivkov Trifonov
	 */
	int getBiggestScoreDialogLineSize(final Game currentGame) {
		int biggestLineSize = 0;
		for (int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
			if (currentGame.teams[i] != null) {
				int currentLine = getScoreDialogLineSize(currentGame.teams[i]);
				if (currentLine > biggestLineSize) {
					biggestLineSize = currentLine;
				}
			}
		}

		return biggestLineSize;
	}

	/**
	 * @author INFM042 F___32 Boris Stefanov Karastanev
	 * @author INFM042 F___43 Stefan Mitkov Nenchev
	 * @author INFM042 F___98 Simona Ilkova Boneva
	 */
	int printRoundTerminationMessage(final Game currentGame, final int oldScore) {
		return (0);
	}

	/**
	 * @author INFM042 F___98 Simona Ilkova Boneva
	 * @author INFM032 F___75 Mihail Genov Knebel
	 * @author INFM042 F___80 Spas Kostov Hristov
	 */
	int displayBids(final Game game, final int currentPlayer) {
		if (game == null) {
			return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}
		if (game.round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}
		if (currentPlayer > game.numberPlayers || currentPlayer < 0) {
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}

		for (int i = 0; i < game.numberPlayers; i++) {
			if (game.round.players[i] != null) {
				if (i < currentPlayer) {
					System.out.format("%s bid %d\n",
							game.round.players[i].name, game.round.bids[i]);
				} else {
					System.out.format("%s bid -\n", game.round.players[i].name);
				}
			}
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}
}
