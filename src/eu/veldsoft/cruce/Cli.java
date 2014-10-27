package eu.veldsoft.cruce;

class Cli {
	final int MAX_CARDS_PER_LINE = 8;

	final int MAX_NAME_SIZE = 20;

	final int ROUND_DIALOG_SCORE_SIZE = 5;

	final int SLEEP_TIME = 2;
	
	//private static final boolean DEBUG = false;

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
		int colorPair;
	    char suit[] = {0xE2, 0x99, 0x00, 0x00};
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
	            return  Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
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
	    
	   if(Constants.WIN32 == true) {
		    char upLeftCorner[]        = {0xE2, 0x94, 0x8C, 0x00};
		    char upRightCorner[]       = {0xE2, 0x94, 0x90, 0x00};
		    char downLeftCorner[]      = {0xE2, 0x94, 0x94, 0x00};
		    char downRightCorner[]     = {0xE2, 0x94, 0x98, 0x00};
		    char horizontalLine[]      = {0xE2, 0x94, 0x80, 0x00};
		    char verticalLine[]        = {0xE2, 0x94, 0x82, 0x00};
	    } else {
		    char upLeftCorner[]        = {0xE2, 0x95, 0xAD, 0x00};
		    char upRightCorner[]       = {0xE2, 0x95, 0xAE, 0x00};
		    char downLeftCorner[]      = {0xE2, 0x95, 0xB0, 0x00};
		    char downRightCorner[]     = {0xE2, 0x95, 0xAF, 0x00};
		    char horizontalLine[]      = {0xE2, 0x94, 0x80, 0x00};
		    char verticalLine[]        = {0xE2, 0x94, 0x82, 0x00};
	    }

	    int x=0, y=0;
	    Globals.getyx(win, y, x);

/*	    wattron(win, COLOR_PAIR(frameColor));
	    wprintw(win, "%s%s%s%s%s%s", upLeftCorner, horizontalLine, horizontalLine,
	             horizontalLine, horizontalLine, upRightCorner);

	    wmove(win, y + 1, x);
	    wprintw(win, "%s", verticalLine);
	    wattroff(win, COLOR_PAIR(frameColor));
	    wprintw(win, "%c   ", value);
	    wattron(win, COLOR_PAIR(frameColor));
	    wprintw(win, "%s", verticalLine);
	    wmove(win, y + 2, x);

	    wprintw(win, "%s", verticalLine);
	    wattroff(win, COLOR_PAIR(frameColor));
	    wattron(win, COLOR_PAIR(colorPair));
	    wprintw(win, "%s", suit);
	    wattroff(win, COLOR_PAIR(colorPair));
	    wattron(win, COLOR_PAIR(frameColor));
	    wprintw(win, "   %s", verticalLine);
	    wmove(win, y + 3, x);

	    wprintw(win, "%s    %s", verticalLine, verticalLine);
	    wmove(win, y + 4, x);
	    wprintw(win, "%s", verticalLine);
	    wattroff(win, COLOR_PAIR(frameColor));
	    wattron(win, COLOR_PAIR(colorPair));
	    wprintw(win, "  %s", suit);
	    wattroff(win, COLOR_PAIR(colorPair));

	    wattron(win, COLOR_PAIR(frameColor));
	    wprintw(win, " %s", verticalLine);
	    wmove(win, y + 5, x);
	    wprintw(win, "%s   ", verticalLine);
	    wattroff(win, COLOR_PAIR(frameColor));
	    wattroff(win, COLOR_PAIR(frameColor));
	    wprintw(win, "%c", value);
	    wattron(win, COLOR_PAIR(frameColor));
	    wprintw(win, "%s", verticalLine);
	    wmove(win, y + 6, x);

	    wprintw(win, "%s%s%s%s%s%s",downLeftCorner, horizontalLine,horizontalLine, 
	            horizontalLine, horizontalLine, downRightCorner);
	    wattroff(win, COLOR_PAIR(frameColor));
	    
	    wmove(win, y + 9, x);
	    wmove(win, y, x + 6);
	    wrefresh(win);*/

	    return Errors.ERROR_CODE.NO_ERROR.getIndex();
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
	    int biggestLineSize = 0;
	    for(int i = 0; i < Constants.MAX_GAME_TEAMS; i++) {
	        if(currentGame.teams[i] != null) { 
	            int currentLine = getScoreDialogLineSize(currentGame.teams[i]);
	            if(currentLine > biggestLineSize) {
	               biggestLineSize = currentLine;
	            }
	        }
	    }

	    return biggestLineSize;
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
		if (game == null){
	        return Errors.ERROR_CODE.GAME_NULL.getIndex();
		}
	    if (game.round == null){
	        return Errors.ERROR_CODE.ROUND_NULL.getIndex();
	    }
	    if (currentPlayer > game.numberPlayers || currentPlayer < 0){
	        return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
	    }

	    for (int i = 0; i < game.numberPlayers; i++){
	        if (game.round.players[i] != null){
	            if (i < currentPlayer){
	                System.out.format("%s bid %d\n", game.round.players[i].name, game.round.bids[i]);
	            } else {
	            	System.out.format("%s bid -\n", game.round.players[i].name);
	            }
	        }
	    }

	    return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}
}

