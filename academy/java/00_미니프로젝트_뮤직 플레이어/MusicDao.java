package music.play.list.model;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao implements Runnable{
	private Scanner sc = new Scanner(System.in);
	Clip clip = null;
	
	public MusicDao() {}
	
	@Override
	public void run() {	
		play(Thread.currentThread().getName());
	}
	
	public void play(String fileName) {
		try {
			String path = "C:\\Users\\Chan\\Desktop\\Music\\"+fileName+".wav";
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			Thread.sleep((clip.getMicrosecondLength()/1000));
							
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		} finally {
			clip.stop();				
			clip.close();
			Thread.currentThread().interrupt();
		}
	}
	
	public void mstop() {
		clip.stop();				
		clip.close();
		Thread.currentThread().interrupt();
	}
	
}