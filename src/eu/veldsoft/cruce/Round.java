package eu.veldsoft.cruce;

class Round {
	Suit trump;
	Hand hands[] = new Hand[Constants.MAX_HANDS];
	int bids[] = new int[Constants.MAX_GAME_PLAYERS];
	Player players[] = new Player[Constants.MAX_GAME_PLAYERS];
	int pointsNumber[] = new int[Constants.MAX_GAME_PLAYERS];

	/**
	 * @author INFM032 F___94 Stefan Lyudmilov Urumov
	 * @author INFM042 F___98 Simona Ilkova Boneva
	 * @author INFM042 F___77 Yosif Rumenov Enev
	 */
	Round round_createRound() {
		Round round = new Round();

		if (round == null)
			return null;

		for (int a = 0; a < Constants.MAX_HANDS; a++)
			round.hands[a] = null;

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			round.bids[i] = 0;
			round.players[i] = null;
		}

		round.trump = Suit.SuitEnd;

		for (int z = 0; z < Constants.MAX_GAME_PLAYERS; z++)
			round.pointsNumber[z] = 0;

		return round;

	}

	/**
	 * @param round
	 *            - reference to the round to be deleted
	 * @return - error code
	 * @author INFM042 F___76 Venelin Lyulinov Lozanov
	 * @author INFM042 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM042 F___83 Gabriel Valentinov Grigorov
	 */
	int round_deleteRound(Round round) {
		/*
		 * Check whether the round is already null.
		 */
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___05 Georgi Krumov Hristov
	 * @author INFM042 F___76 Venelin Lyulinov Lozanov
	 * @author INFM042 F___24 Rosen Ivanov Videv
	 */
	Hand round_createHand() {
		return (null);
	}

	/**
	 * @author INFM032 F___32 Boris Stefanov Karastanev
	 * @author INFM042 F___75 Mihail Genov Knebel
	 * @author INFM042 F___79 Viktor Georgiev Chanev
	 */
	int round_deleteHand(Hand hand) {
		return (0);
	}

	/**
	 * @author INFM032 F___12 Nikolay Todorov Hristov
	 * @author INFM032 F___79 Viktor Georgiev Chanev
	 * @author INFM032 F___05 Georgi Krumov Hristov
	 */
	Player round_getBidWinner(final Round round) {
		return (null);
	}

	/**
	 * @author INFM042 F___21 Trifon Zhivkov Trifonov
	 * @author INFM032 F___30 Kristina Ivanova Dineva
	 * @author INFM032 F___31 Danail Nedkov Rusev
	 */
	static int round_findPlayerIndexRound(final Player player, final Round round) {
		if (player == null)
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		if (round == null)
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		int i = 0;
		while (i < Constants.MAX_GAME_PLAYERS && round.players[i] != player)
			i++;
		if (i == Constants.MAX_GAME_PLAYERS)
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		return i;
	}

	/**
	 * @author INFM042 F___06 Milen Tsvetanov Pankov
	 * @author INFM032 F___32 Boris Stefanov Karastanev
	 * @author INFM042 F___80 Goritsa Ivanova Yanakieva
	 */
	int round_placeBid(final Player player, final int bid, Round round) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		if (bid < 0 || bid > 6) {
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}

		if (bid > 0) {
			for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
				if (round.bids[i] > bid) {
					return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
				}
			}
		}

		int index = round.round_findPlayerIndexRound(player, round);

		if (index < 0) {
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		}

		round.bids[index] = bid;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @param player
	 *            - reference to the player to be added in the round
	 * @param round
	 *            - reference to the round where the player will be added
	 * @return - error code
	 * @author INFM032 F___76 Venelin Lyulinov Lozanov
	 * @author INFM042 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM042 F___80 Goritsa Ivanova Yanakieva
	 */
	int round_addPlayer(Player player, Round round) {

		// check player
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		// check round
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		int index = round_findPlayerIndexRound(player, round);

		// impossible to add same player multiple time
		if (index >= 0) {
			return Errors.ERROR_CODE.DUPLICATE.getIndex();
		}

		// check for empty slot
		int i = 0;
		while (round.players[i] != null && i < Constants.MAX_GAME_PLAYERS) {
			i++;
		}

		// check players length
		if (i == Constants.MAX_GAME_PLAYERS) {
			return Errors.ERROR_CODE.FULL.getIndex();
		}

		// add player to the slot
		round.players[i] = player;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM032 F___77 Yosif Rumenov Enev
	 * @author INFM032 F___62 Viktor Georgiev Petrov
	 * @author INFM032 F___30 Kristina Ivanova Dineva
	 */
	int round_addPlayerHand(Player player, Hand hand) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}

		if (hand == null) {
			return Errors.ERROR_CODE.HAND_NULL.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (hand.players[i] == player) {
				return Errors.ERROR_CODE.DUPLICATE.getIndex();
			}
		}

		int i = 0;
		while (hand.players[i] != null && i < Constants.MAX_GAME_PLAYERS) {
			i++;
		}

		if (i == Constants.MAX_GAME_PLAYERS) {
			return Errors.ERROR_CODE.FULL.getIndex();
		}

		hand.players[i] = player;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 */
	int round_removePlayer(final Player player, Round round) {
		return (0);
	}

	/**
	 */
	int round_removePlayerHand(final Player player, Hand hand) {
		return (0);
	}

	/**
	 */
	int round_putCard(Player player, final int cardId, final int handId,
			Round round) {
		return (0);
	}

	/**
	 */
	int totalPointsNumber(final Hand hand) {
		return (0);
	}

	/**
	 */
	Player round_handWinner(final Hand hand, Round round) {
		return (null);
	}

	/**
	 */
	int round_distributeCard(Deck deck, final Round round) {
		return (0);
	}

	/**
	 */
	int round_distributeDeck(Deck deck, final Round round) {
		return (0);
	}

	/**
	 */
	int round_arrangePlayersHand(Round round, int i) {
		return (0);
	}

	/**
	 */
	int round_computePoints(final Team team, final Round round) {
		return (0);
	}

	/**
	 */
	int round_getMaximumBid(Round round) {
		return (0);
	}

	/**
	 */
	int checkBid(int currentBid, int maximumBid) {
		return (0);
	}

	/**
	 */
	int findAllowedBid(Round round, int currentBid, int searchPattern) {
		return (0);
	}

	/**
	 * @param round
	 * @param currentBid
	 * 
	 * @return
	 * 
	 * @author Todor Balabanov
	 */
	int round_findNextAllowedBid(Round round, int currentBid) {
		return findAllowedBid(round, currentBid, 1);
	}

	/**
	 * 
	 * @param round
	 * @param currentBid
	 * @return
	 */
	int round_findPreviousAllowedBid(Round round, int currentBid) {
		return findAllowedBid(round, currentBid, -1);
	}
}
