package eu.veldsoft.cruce;

import eu.veldsoft.cruce.Team;

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
	 *            reference to the round to be deleted
	 * 
	 * @return error code
	 * 
	 * @author INFM042 F___76 Venelin Lyulinov Lozanov
	 * @author INFM042 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM042 F___83 Gabriel Valentinov Grigorov
	 */
	int round_deleteRound(Round round) {
		// Check whether the round is already null.
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		// Delete round.
		round = null;

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
	 *            reference to the player to be added in the round
	 * 
	 * @param round
	 *            reference to the round where the player will be added
	 * 
	 * @return error code
	 * 
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
	 * The function remove player in a game.
	 * 
	 * @param player
	 * @param round
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 10 Nov 2014
	 */
	int round_removePlayer(final Player player, Round round) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		int index = round_findPlayerIndexRound(player, round);

		if (index < 0) {
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		}

		round.players[index] = null;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * The function remove Player's hand of cards.
	 * 
	 * @param player
	 * @param hand
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 10 Nov 2014
	 */
	int round_removePlayerHand(final Player player, Hand hand) {
		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}
		if (hand == null) {
			return Errors.ERROR_CODE.NOT_FOUND.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (hand.players[i] == player) {
				hand.players[i] = null;
				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}

		return Errors.ERROR_CODE.NOT_FOUND.getIndex();
	}

	/**
	 * 
	 * 
	 * @param player
	 * @param cardId
	 * @param handId
	 * @param round
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 10 Nov 2014
	 */
	int round_putCard(Player player, final int cardId, final int handId,
			Round round) {

		if (player == null) {
			return Errors.ERROR_CODE.PLAYER_NULL.getIndex();
		}
		if (player.hand[cardId] == null) {
			return Errors.ERROR_CODE.CARD_NULL.getIndex();
		}
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}
		if (round.hands[handId] == null) {
			return Errors.ERROR_CODE.HAND_NULL.getIndex();
		}

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (round.hands[handId].players[i] == player) {
				round.hands[handId].cards[i] = player.hand[cardId];
				Suit suit = player.hand[cardId].suit;
				int value = player.hand[cardId].value;
				player.hand[cardId] = null;
				if (i == 0 && (value == 3 || value == 4)) {
					int check = 0;
					for (int j = 0; j < Constants.MAX_CARDS; j++) {
						if (player.hand[j] != null
								&& (player.hand[j].value == 3 || player.hand[j].value == 4)
								&& suit == player.hand[j].suit) {
							check = 1;
						}
					}
					if (check == 1) {
						int position = round_findPlayerIndexRound(player, round);
						if (suit == round.trump) {
							round.pointsNumber[position] += 40;
						} else {
							round.pointsNumber[position] += 20;
						}
					}
				}

				return Errors.ERROR_CODE.NO_ERROR.getIndex();
			}
		}

		return Errors.ERROR_CODE.NOT_FOUND.getIndex();
	}

	/**
	 * The function calculate points in a Player's hand of cards.
	 * 
	 * @param hand
	 *            The hand where to compute the number of points.
	 * 
	 * @return The number of points in hand on succes, negative otherwise.
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 17 Nov 2014
	 * 
	 */
	int totalPointsNumber(final Hand hand) {
		if (hand == null) {
			return Errors.ERROR_CODE.HAND_NULL.getIndex();
		}
		int points = 0;
		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (hand.players[i] != null && hand.cards[i] != null) {
				points += hand.cards[i].value;
			}
		}
		return points;
	}

	/**
	 * The funciton show player who is win the round.
	 * 
	 * @param hand
	 * @param round
	 * 
	 * @return Player
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 17 Nov 2014
	 * 
	 */
	Player round_handWinner(final Hand hand, Round round) {
		if (hand == null || round == null || round.trump == Suit.SuitEnd) {
			return null;
		}

		Suit trump = round.trump;
		int playerWinner = -1;
		int numberPlayers = 0;

		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if ((hand.players[i] != null && hand.cards[i] == null)
					|| (hand.players[i] == null && hand.cards[i] != null)) {
				return null;
			}

			if (hand.players[i] != null && hand.cards[i] != null) {
				numberPlayers++;
				if (playerWinner == -1) {
					playerWinner = i;
				}
			}
		}

		if (playerWinner == -1 || numberPlayers == 1) {
			return null;
		}
		int cardWinner;

		for (int i = playerWinner + 1; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (hand.players[i] != null && hand.cards[i] != null) {
				cardWinner = Deck.deck_compareCards(hand.cards[playerWinner],
						hand.cards[i], trump);

				if (cardWinner == 2) {
					playerWinner = i;
				}
				if (cardWinner <= 0) {
					return null;
				}
			}
		}
		int playerWinner_inRound = round_findPlayerIndexRound(
				hand.players[playerWinner], round);
		round.pointsNumber[playerWinner_inRound] += totalPointsNumber(hand);
		return hand.players[playerWinner];
	}

	/**
	 * The method distribute a card.
	 * 
	 * @param deck
	 * @param round
	 * 
	 * @return Error message.
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 17 Nov 2014
	 * 
	 */
	int round_distributeCard(Deck deck, final Round round) {
		if (deck == null) {
			return Errors.ERROR_CODE.DECK_NULL.getIndex();
		}
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		int i, j;
		int distributedCards = 0;

		for (i = 0, j = 0; i < Constants.MAX_GAME_PLAYERS
				&& j < Constants.DECK_SIZE; i++, j++) {
			// do not change while's order

			while (deck.cards[j] == null && j < Constants.DECK_SIZE) {
				j++;
			}
			while (round.players[i] == null && i < Constants.MAX_GAME_PLAYERS) {
				i++;
			}

			if (i < Constants.MAX_GAME_PLAYERS && j < Constants.DECK_SIZE) {
				int checkError = Team.team_addCard(round.players[i],
						deck.cards[j]);
				if (checkError != Errors.ERROR_CODE.NO_ERROR.getIndex()) {
					return checkError;
				}
				deck.cards[j] = null;
				distributedCards++;
			}
		}

		if (distributedCards == 0 && j == Constants.DECK_SIZE + 1) {
			return Errors.ERROR_CODE.DECK_EMPTY.getIndex();
		}
		if (distributedCards == 0 && i == Constants.MAX_GAME_PLAYERS + 1) {
			return Errors.ERROR_CODE.ROUND_EMPTY.getIndex();
		}
		if (distributedCards == 1 && i == Constants.MAX_GAME_PLAYERS + 1) {
			return Errors.ERROR_CODE.INSUFFICIENT_PLAYERS.getIndex();
		}
		if (distributedCards == 1 && j == Constants.DECK_SIZE + 1) {
			return Errors.ERROR_CODE.LESS_CARDS.getIndex();
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * The function distribute deck.
	 * 
	 * @param deck
	 * @param round
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 17 Nov 2014
	 * 
	 */
	int round_distributeDeck(Deck deck, final Round round) {
		if (deck == null) {
			return Errors.ERROR_CODE.DECK_NULL.getIndex();
		}

		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}

		int numberPlayers = 0;
		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++) {
			if (round.players[i] != null) {
				numberPlayers++;
			}
		}
		if (numberPlayers == 1) {
			return Errors.ERROR_CODE.INSUFFICIENT_PLAYERS.getIndex();
		}
		if (numberPlayers == 0) {
			return Errors.ERROR_CODE.ROUND_EMPTY.getIndex();
		}

		for (int i = 0; i < Constants.MAX_CARDS
				&& i < Constants.DECK_SIZE / numberPlayers; i++) {
			int distributeCard = round_distributeCard(deck, round);
			if (distributeCard != Errors.ERROR_CODE.NO_ERROR.getIndex()) {
				return distributeCard;
			}
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * The function check is there hand, rounds or not.
	 * 
	 * @param round
	 * 
	 * @return
	 * 
	 * @authors Yani Tonev
	 * @email k_o_r_g@abv.bg
	 * @date 15 Nov 2014
	 * 
	 */
	int round_arrangePlayersHand(Round round, int i) {

		if (round == null)
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		if (i < 0 || i >= Constants.MAX_GAME_PLAYERS)
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();

		int handId = 0;
		while (round.hands[handId] != null)
			handId++;

		if (handId >= Constants.MAX_HANDS)
			return Errors.ERROR_CODE.FULL.getIndex();

		Hand hand = round_createHand();
		for (int j = i; j < i + Constants.MAX_GAME_PLAYERS; j++)
			if (round.players[j % Constants.MAX_GAME_PLAYERS] != null)
				round_addPlayerHand(round.players[j
						% Constants.MAX_GAME_PLAYERS], hand);

		round.hands[handId] = hand;

		return (Errors.ERROR_CODE.NO_ERROR.getIndex());
	}

	/**
	 * The function check is there team_players, rounds or not and increment
	 * points.
	 * 
	 * @param team
	 *            , round
	 * 
	 * @return
	 * 
	 * @authors Yani Tonev
	 * @email k_o_r_g@abv.bg
	 * @date 17 Nov 2014
	 * 
	 */
	int round_computePoints(final Team team, final Round round) {

		if (team == null)
			return Errors.ERROR_CODE.TEAM_NULL.getIndex();
		if (round == null)
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();

		int playersNumber = 0;
		int points = 0;
		for (int i = 0; i < Constants.MAX_TEAM_PLAYERS; i++)
			if (team.players[i] != null) {
				playersNumber++;
				int j = round_findPlayerIndexRound(team.players[i], round);
				if (j < 0)
					return j;
				points += round.pointsNumber[j];
			}

		if (playersNumber == 0)
			return Errors.ERROR_CODE.TEAM_EMPTY.getIndex();

		return points;
	}

	/**
	 * The function check is there a round and return maximimBid.
	 * 
	 * @param round
	 * 
	 * @return maximimBid
	 * 
	 * @authors Yani Tonev
	 * @email k_o_r_g@abv.bg
	 * @date 17 Nov 2014
	 */
	int round_getMaximumBid(Round round) {
		if (round == null)
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();

		int maximumBid = 0;
		for (int i = 0; i < Constants.MAX_GAME_PLAYERS; i++)
			if (round.players[i] != null)
				if (round.bids[i] > maximumBid)
					maximumBid = round.bids[i];

		return maximumBid;
	}

	/**
	 * The function check bid according to some conditions.
	 * 
	 * @param currentBid
	 * @param maximumBid
	 * 
	 * @return 0 or 1 (number)
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 18 Nov 2014
	 */
	int checkBid(int currentBid, int maximumBid) {
		if (currentBid > maximumBid || currentBid == 0) {
			return 1;
		}

		return 0;
	}

	/**
	 * The function search allowed bid for a round.
	 * 
	 * @param round
	 * @param currentBid
	 * @param searchPattern
	 * 
	 * @return Error code (number) or current bid
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 18 Nov 2014
	 */
	int findAllowedBid(Round round, int currentBid, int searchPattern) {
		if (round == null) {
			return Errors.ERROR_CODE.ROUND_NULL.getIndex();
		}
		if (currentBid < 0 || currentBid > 6) {
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}
		if (searchPattern != 1 && searchPattern != -1) {
			return Errors.ERROR_CODE.ILLEGAL_VALUE.getIndex();
		}

		currentBid += searchPattern;
		if (currentBid == -1) {
			currentBid = 6;
		}
		if (currentBid == 7) {
			currentBid = 0;
		}

		while (checkBid(currentBid, round_getMaximumBid(round)) == 1) {
			currentBid += searchPattern;
			if (currentBid == -1) {
				currentBid = 6;
			}
			if (currentBid == 7) {
				currentBid = 0;
			}
		}

		return currentBid;
	}

	/**
	 * The function search next allowed bid.
	 * 
	 * @param round
	 * @param currentBid
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 18 Nov 2014
	 */
	int round_findNextAllowedBid(Round round, int currentBid) {
		return findAllowedBid(round, currentBid, 1);
	}

	/**
	 * The method is created for find preveous allowed bid.
	 * 
	 * @param round
	 * @param currentBid
	 * 
	 * @return int
	 * 
	 * @author Alexandar Jelin
	 * @email aleksandarjelin@gmail.com
	 * @date 18 Nov 2014
	 */
	int round_findPreviousAllowedBid(Round round, int currentBid) {
		return findAllowedBid(round, currentBid, -1);
	}
}
