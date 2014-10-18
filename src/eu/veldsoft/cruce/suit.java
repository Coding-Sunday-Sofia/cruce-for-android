package eu.veldsoft.cruce;

enum suit {
	DIAMONDS(0), CLUBS(1), SPADES(2), HEARTS(3), SuitEnd(4);

	private int index;

	/**
	 */
	suit(int index) {
		this.index = index;
	}

	/**
	 */
	public int getIndex() {
		return index;
	}
}
