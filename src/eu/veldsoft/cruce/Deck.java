package eu.veldsoft.cruce;

class Deck {
	private static final Suit SuitEnd = null;
	final int VALUES[] = { 2, 3, 4, 0, 10, 11, -1 };
	Card cards[] = new Card[Constants.DECK_SIZE];

	/**
	 * @author INFM032 F___25 Kalina Zhivkova Momkova
	 * @author INFM032 F___76 Venelin Lyulinov Lozanov
	 * @author INFM032 F___32 Boris Stefanov Karastanev
	 */
	Card deck_createCard(final Suit suit, final int value) {
		Card Card = new Card();

		if (Card == null)
			return null;

		if (suit == SuitEnd)
			return null;

		int count = 0;
		for (int i = 0; VALUES[i] != -1; i++)
			if (value == VALUES[i])
				count++;
		if (count != 1)
			return null;

		Card.value = value;
		Card.suit = suit;

		return Card;
	}

	/**
	 * @author INFM032 F___25 Kalina Zhivkova Momkova
	 * @author INFM032 F___04 Petar Aleksandrov Vorotnikov
	 * @author INFM032 F___79 Viktor Georgiev Chanev
	 */
	int deck_deleteCard(Card card) {

		// check whether the card is already deleted
		if (card == null) {
			return Errors.ERROR_CODE.CARD_NULL.getIndex();
		}

		// delete card
		card = null;

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___05 Georgi Krumov Hristov
	 * @author INFM032 F___21 Trifon Zhivkov Trifonov
	 * @author INFM032 F___80 Spas Kostov Hristov
	 */
	Deck deck_createDeck() {
		Deck deck = new Deck();
		if (deck == null) {
			return null;
		}

		int k = 0;
		for (int i = 0; Suit.values()[i] != Suit.SuitEnd; i++) {
			Suit suit = Suit.values()[i];
			for (int j = 0; VALUES[j] != -1; j++) {
				Card card = deck_createCard(suit, VALUES[j]);
				deck.cards[k] = card;
				k++;
			}
		}

		return deck;
	}

	/**
	 * @brief Frees the memory of a deck and sets the pointer to NULL.
	 *
	 * @param deck Pointer to the pointer to be freed.
	 *
	 * @return NO_ERROR on success, other value on failure.
	 * 
	 * @author INFM042 F___33 Veselka Penkova Peycheva
	 * @author INFM042 F___21 Mariya Asenova Shindarova
	 * @author INFM032 F___75 Mihail Genov Knebel
	 */
	int deck_deleteDeck(Deck deck) {
		if (deck == null) {
			return Errors.ERROR_CODE.POINTER_NULL.getIndex();
		}

		if (deck.cards == null) {
			return Errors.ERROR_CODE.DECK_NULL.getIndex();
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM032 F___12 Nikolay Todorov Hristov
	 * @author INFM032 F___80 Spas Kostov Hristov
	 * @author INFM042 F___62 Viktor Georgiev Petrov
	 */
	void deck_swap(Card a, Card b) {
		Card c = a;
		a = b;
		b = c;
	}

	/**
	 * @author INFM042 F___80 Spas Kostov Hristov
	 * @author INFM032 F___24 Rosen Ivanov Videv
	 * @author INFM032 F___21 Mariya Asenova Shindarova
	 */
	int deck_deckShuffle(Deck deck) {
		int swapInterval = Constants.SWAP_MAX - Constants.SWAP_MIN;
		int noOfSwaps = (int) Math.random() % swapInterval + Constants.SWAP_MIN;

		for (int i = 0; i < noOfSwaps; i++) {
			int swapA = (int) Math.random() % Constants.DECK_SIZE;
			int swapB = (int) Math.random() % Constants.DECK_SIZE;
			if (swapA != swapB) {
				Card cardA = deck.cards[swapA];
				Card cardB = deck.cards[swapB];
				deck_swap(cardA, cardB);
			}
		}

		return Errors.ERROR_CODE.NO_ERROR.getIndex();
	}

	/**
	 * @author INFM042 F___21 Mariya Asenova Shindarova
	 * @author INFM042 F___12 Nikolay Todorov Hristov
	 * @author INFM042 F___75 Mihail Genov Knebel
	 */
	static int deck_compareCards(final Card card1, final Card card2,
			final Suit trump) {
		return (0);
	}

	/**
	 * @brief The function counts the cards from deck.
	 *
	 * @param deck Pointer to the deck from which it counts.
	 *
	 * @return The cards number from deck.
	 * 
	 * @author INFM032 F___33 Veselka Penkova Peycheva
	 * @author INFM042 F___29 Diana Ilieva Dyulgerova
	 * @author INFM032 F___43 Stefan Mitkov Nenchev
	 */
	int deck_cardsNumber(final Deck deck) {
		if (deck == null) {
			return Errors.ERROR_CODE.DECK_NULL.getIndex();
		}

		int cardsNumber = 0;
		for (int i = 0; i < Constants.DECK_SIZE; i++) {
			if (deck.cards[i] != null) {
				cardsNumber++;
			}
		}

		return cardsNumber;
	}

}
