package eu.veldsoft.cruce;

class Round {
	Suit trump;
	Hand hands[] = new Hand[Constants.MAX_HANDS];
	int bids[] = new int[Constants.MAX_GAME_PLAYERS];
	Player players[] = new Player[Constants.MAX_GAME_PLAYERS];
	int pointsNumber[] = new int[Constants.MAX_GAME_PLAYERS];

	/**
	 * @author	INFM032 F___94	 Stefan Lyudmilov Urumov
	 * @author	INFM042 F___98	 Simona Ilkova Boneva
	 * @author	INFM042 F___77	 Yosif Rumenov Enev
	 */
	Round round_createRound() {
		return (null);
	}

	/**
	 * @author	INFM042 F___76	 Venelin Lyulinov Lozanov
	 * @author	INFM042 F___04	 Petar Aleksandrov Vorotnikov
	 * @author	INFM042 F___83	 Gabriel Valentinov Grigorov
	 */
	int round_deleteRound(Round round) {
		if (round.players == null) {
			return Errors.ERROR_CODE.POINTER_NULL.getIndex();
		}
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		round = null;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author	INFM042 F___05	 Georgi Krumov Hristov
	 * @author	INFM042 F___76	 Venelin Lyulinov Lozanov
	 * @author	INFM042 F___24	 Rosen Ivanov Videv
	 */
	Hand round_createHand() {
		return (null);
	}

	/**
	 * @author	INFM032 F___32	 Boris Stefanov Karastanev
	 * @author	INFM042 F___75	 Mihail Genov Knebel
	 * @author	INFM042 F___79	 Viktor Georgiev Chanev
	 */
	int round_deleteHand(Hand hand) {
		return (0);
	}

	/**
	 * @author	INFM032 F___12	 Nikolay Todorov Hristov
	 * @author	INFM032 F___79	 Viktor Georgiev Chanev
	 * @author	INFM032 F___05	 Georgi Krumov Hristov
	 */
	Player round_getBidWinner(final Round round) {
		return (null);
	}

	/**
	 * @author	INFM042 F___21	 Trifon Zhivkov Trifonov
	 * @author	INFM032 F___30	 Kristina Ivanova Dineva
	 * @author	INFM032 F___31	 Danail Nedkov Rusev
	 */
	int round_findPlayerIndexRound(final Player player, final Round round) {
		return (0);
	}

	/**
	 * @author	INFM042 F___06	 Milen Tsvetanov Pankov
	 * @author	INFM032 F___32	 Boris Stefanov Karastanev
	 * @author	INFM042 F___80	 Goritsa Ivanova Yanakieva
	 */
	int round_placeBid(final Player player, final int bid, Round round) {
		return (0);
	}

	/**
	 * @author	INFM032 F___76	 Venelin Lyulinov Lozanov
	 * @author	INFM042 F___04	 Petar Aleksandrov Vorotnikov
	 * @author	INFM042 F___80	 Goritsa Ivanova Yanakieva
	 */
	int round_addPlayer(Player player, Round round) {
		return (0);
	}

	/**
	 * @author	INFM032 F___77	 Yosif Rumenov Enev
	 * @author	INFM032 F___62	 Viktor Georgiev Petrov
	 * @author	INFM032 F___30	 Kristina Ivanova Dineva
	 */
	int round_addPlayerHand(Player player, Hand hand) {
		return (0);
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
	 */
	int round_findNextAllowedBid(Round round, int currentBid) {
		return (0);
	}

	/**
	 */
	int round_findPreviousAllowedBid(Round round, int currentBid) {
		return (0);
	}
}

