package de.pigtastic.foreverAlonePong.highscore;

public class Highscore implements Comparable<Highscore> {
	private final String playerName;
	private final int score;

	public Highscore(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}

	@Override
	public int compareTo(Highscore o) {
		return o.score - this.score;
	}

	@Override
	public String toString() {
		return playerName + ": " + score;

	}

	public String getPlayerName() {
		return playerName;
	}

	public int getScore() {
		return score;
	}

}
