package eu.veldsoft.cruce;

class round {

	Round round_createRound() {
		return (null);
	}

	int round_deleteRound(Round round) {
		return (0);
	}

	Hand round_createHand() {
		return (null);
	}

	int round_deleteHand(Hand hand) {
		return (0);
	}

	Player round_getBidWinner(final Round round) {
		return (null);
	}

	int round_findPlayerIndexRound(final Player player, final Round round) {
		return (0);
	}

	int round_placeBid(final Player player, final int bid, Round round) {
		return (0);
	}

	int round_addPlayer(Player player, Round round) {
		return (0);
	}

	int round_addPlayerHand(Player player, Hand hand) {
		return (0);
	}

	int round_removePlayer(final Player player, Round round) {
		return (0);
	}

	int round_removePlayerHand(final Player player, Hand hand) {
		return (0);
	}

	int round_putCard(Player player, final int cardId, final int handId,
			Round round) {
		return (0);
	}

	int totalPointsNumber(final Hand hand) {
		return (0);
	}

	Player round_handWinner(final Hand hand, Round round) {
		return (null);
	}

	int round_distributeCard(Deck deck, final Round round) {
		return (0);
	}

	int round_distributeDeck(Deck deck, final Round round) {
		return (0);
	}

	int round_arrangePlayersHand(Round round, int i) {
		return (0);
	}

	int round_computePoints(final Team team, final Round round) {
		return (0);
	}

	int round_getMaximumBid(Round round) {
		return (0);
	}

	int checkBid(int currentBid, int maximumBid) {
		return (0);
	}

	int findAllowedBid(Round round, int currentBid, int searchPattern) {
		return (0);
	}

	int round_findNextAllowedBid(Round round, int currentBid) {
		return (0);
	}

	int round_findPreviousAllowedBid(Round round, int currentBid) {
		return (0);
	}
}