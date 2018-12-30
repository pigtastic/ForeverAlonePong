package de.pictastic.foreverAlonePong;

public class Highscore implements Comparable<Highscore> {
	public final String playerName;
	public final int score;

	public Highscore(String playerName, int score) {
		this.playerName = playerName;
		this.score = score;
	}

	@Override
	public int compareTo(Highscore o) {
		return this.score - o.score;
	}

	@Override
	public String toString() {
		return "Highscore [playerName=" + playerName + ", score=" + score + "]";
	}
	
	
}
