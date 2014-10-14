package eu.veldsoft.cruce;

enum Suit {
	DIAMONDS(0), CLUBS(1), SPADES(2), HEARTS(3), SuitEnd(4);

	private int index;

	/**
	 */
	Suit(int index) {
		this.index = index;
	}

	/**
	 */
	public int getIndex() {
		return index;
	}
}
