package de.pictastic.foreverAlonePong.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class MusicPlayer {


	private static InputStream input;

	public static void playMusic(String path) {
		try {
			input = new FileInputStream(new File(path));
			AudioStream audios = new AudioStream(input);
			AudioPlayer.player.start(audios);

		} catch (Exception e) { 
			e.printStackTrace();
			System.out.println("Wiedergabe fehlgeschlagen");
			
		}
	}
}