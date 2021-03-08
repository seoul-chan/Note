package music.play.list.model;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music_Backup extends Thread{
	public void run() {
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("\n===== 재생 목록 =====");
				System.out.println("1. test");
				System.out.println("2. test2");
				System.out.println("3. test3");
				System.out.println("4. test4");
				System.out.println("5. SG Wannabe Brown Eyed Girls - Must Have Love");
				System.out.println("9. 종료");
				System.out.print("재생하려는 음악 파일을 선택하세요 : ");
				int input = sc.nextInt();
				String fileName="";
				
				switch(input) {
					case 1 : fileName= "test"; break;
					case 2 : fileName= "test2"; break;
					case 3 : fileName= "test3"; break;
					case 4 : fileName= "test4"; break;
					case 5 : fileName= "SG Wannabe Brown Eyed Girls - Must Have Love"; break;
					case 9 : System.out.println("프로그램을 종료합니다."); return;
				}
				
				String path = "C:\\Users\\Chan\\Desktop\\"+fileName+".wav";
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				Thread.sleep((clip.getMicrosecondLength()/1000));				
				clip.close();
				
			} catch(Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
			}
		}
	}
}
