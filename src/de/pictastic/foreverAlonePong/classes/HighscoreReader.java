package de.pictastic.foreverAlonePong.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.pictastic.foreverAlonePong.frames.Highscore;


public class HighscoreReader {
	static BufferedReader br = null;
	static String line = "";
	
	public static List<Highscore> importScores() throws NumberFormatException, IOException {
		
		List<Highscore> scores = new ArrayList<Highscore>();

		br = new BufferedReader(new FileReader("./AppData/Highscores.csv"));
		while ((line = br.readLine()) != null) {
			String[] score = line.split(";");
			score[1] = score[1].replaceAll(" ", "");
			score[0] = score[0].replaceAll(" ", "");
			
			scores.add(new Highscore(score[0], Integer.parseInt(score[1])));		
		}
		return scores;
	}

}
