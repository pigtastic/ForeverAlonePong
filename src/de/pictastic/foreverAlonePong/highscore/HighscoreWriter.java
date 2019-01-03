package de.pictastic.foreverAlonePong.highscore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HighscoreWriter {

	/*
	 * Schreibt in eine CSV Dateoi.
	 */
	public static void writeScores(List<Highscore> list) throws IOException {

		makeDir();
		FileWriter fileWriter = new FileWriter("./AppData/highscores.csv");

		for (Highscore score : list) {
			fileWriter.append(score.getPlayerName());
			fileWriter.append(";");
			fileWriter.append(Integer.toString(score.getScore()));
			fileWriter.append("\n");
		}
		fileWriter.flush();
		fileWriter.close();

	}

	private static void makeDir() throws IOException {
		String fileName = "highscores.csv";
		String dirName = "AppData";
		File file = new File("./" + dirName + "/" + fileName);
		File dir = new File("./" + dirName);
		dir.mkdir();
		file.createNewFile();
	}
}
