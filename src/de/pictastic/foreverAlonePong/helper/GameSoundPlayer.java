package de.pictastic.foreverAlonePong.helper;

public class GameSoundPlayer {

	private static String path = "../AppData/Sounds/";
	private static String note;

	/**
	 * Starts specific soundeffect. -1 for Bottom, 0 for Wall and 1 for Top.
	 * 
	 * @param score
	 * @param place
	 */
	public static void playSound(int score, int place) {

		if (score < 3) {
			switch (place) {
			case -1:
				note = "C";
				break;
			case 0:
				note = "E";
				break;
			case 1:
				note = "G";
				break;
			}
		} else if (score < 5) {
			switch (place) {
			case -1:
				note = "D";
				break;
			case 0:
				note = "F";
				break;
			case 1:
				note = "A";
				break;
			}

		} else if (score < 8) {
			switch (place) {
			case -1:
				note = "E";
				break;
			case 0:
				note = "G";
				break;
			case 1:
				note = "H";
				break;
			}
		} else if (score < 11) {
			switch (place) {
			case -1:
				note = "F";
				break;
			case 0:
				note = "A";
				break;
			case 1:
				note = "C3";
				break;
			}

		} else if (score < 13) {
			switch (place) {
			case -1:
				note = "G";
				break;
			case 0:
				note = "H";
				break;
			case 1:
				note = "D3";
				break;
			}

		} else if (score < 15) {
			switch (place) {
			case -1:
				note = "A";
				break;
			case 0:
				note = "C3";
				break;
			case 1:
				note = "E3";
				break;
			}

		} else if (score < 18) {
			switch (place) {
			case -1:
				note = "H";
				break;
			case 0:
				note = "C3";
				break;
			case 1:
				note = "F3";
				break;
			}

		} else if (score < 20) {
			switch (place) {
			case -1:
				note = "C3";
				break;
			case 0:
				note = "E3";
				break;
			case 1:
				note = "G3";
				break;
			}

		}
		MusicPlayer.playMusic(path + note + ".wav");

	}
}
