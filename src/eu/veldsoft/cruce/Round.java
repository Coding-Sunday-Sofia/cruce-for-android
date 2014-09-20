package eu.veldsoft.cruce;

class Round {
	Suit trump;
	Hand hands[] = new Hand[constants.MAX_HANDS];
	int bids[] = new int[constants.MAX_GAME_PLAYERS];
	Player players[] = new Player[constants.MAX_GAME_PLAYERS];
	int pointsNumber[] = new int[constants.MAX_GAME_PLAYERS];
}
