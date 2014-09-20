package eu.veldsoft.cruce;

class Game {
	int numberPlayers;
	int pointsNumber;
	Round round;
	Player players[] = new Player[constants.MAX_GAME_PLAYERS];
	Team teams[] = new Team[constants.MAX_GAME_TEAMS];
	Deck deck;
}