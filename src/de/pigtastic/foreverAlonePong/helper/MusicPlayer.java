package de.pigtastic.foreverAlonePong.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer {

	private static AudioInputStream audioInputStream;
	private static Clip clip;
	private static boolean mute = false;

	public static void playMusicContinously(URL path) {
		if (!mute) {
			try {
				audioInputStream = AudioSystem.getAudioInputStream(loadFile(path));
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				clip.start();

			} catch (Exception e) {
				System.out.println("Wiedergabe fehlgeschlagen");

			}

		}
	}

	public static void playMusic(URL path) {
		if (!mute) {

			try {
				audioInputStream = AudioSystem.getAudioInputStream(loadFile(path));
				clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();

			} catch (Exception e) {
				System.out.println("Wiedergabe fehlgeschlagen");

			}
		}
	}

	public static void stopMusic() {
		try {
			clip.close();
		} catch (Exception e) {
			System.err.println("music bug^^");
		}
	}

	public static void disableSound() {
		try {
			clip.close();
		} catch (Exception e) {
			System.err.println("music bug^^");
		}
		mute = true;
	}

	public static void enableSound() {
		mute = false;
	}

	private static File loadFile(URL url) {
		File tempF = null;
		try {
			tempF = File.createTempFile("temp", ".wav");
			try (InputStream is = url.openStream(); OutputStream os = new FileOutputStream(tempF)) {
				byte[] buffer = new byte[2048];
				int bytesRead;

				while ((bytesRead = is.read(buffer)) != -1) {
					os.write(buffer, 0, bytesRead);
				}
			}
		} catch (Exception e) {
			System.out.println("Load music file failed!");

		}
		return tempF;
	}
}
