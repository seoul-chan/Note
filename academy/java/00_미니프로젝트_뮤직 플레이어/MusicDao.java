package music.play.list.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao {
	private static Clip clip = null;
	private static boolean privius = false; //이전에 재생되고 있는 곡 여부
	private static int current = 0;	//현재 재생중인 노래 정보
	private static boolean playState = false; // 현재 재생 중인지 확인
	private static String[] musicList=null;
	private static Timer timer = null;
	
	public MusicDao() {}
	
	public static Clip getClip() {return clip;}
	public static Timer getTimer() {return timer;}

	public String[] musicList(){
		//파일 전체목록 가져오기
		File path = new File("C:\\Users\\Chan\\Desktop\\Music\\");
		musicList = path.list();
		for(int i=0;i<musicList.length;i++) {
			System.out.println(musicList[i]);
		}
		return musicList;
	}
	
	public static void play(int input) {
		try {
			current=input;
			privius=true;
			
			if(playState) stop();
			playState=true;
			
			if(input<0||input>=musicList.length){
				System.out.println("잘못 입력하였습니다.");
				return;
			}	
			
			String path = "C:\\Users\\Chan\\Desktop\\Music\\"+musicList[input];
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();	
			clip.open(audioInputStream);
//			clip.loop(Clip.LOOP_CONTINUOUSLY); // 추후 한곡 반복 재생 시 구현 예정
			clip.start();
			
			timer = new Timer();
			timer.start();
			
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	public void priviusPlay() {
		stop();
		if(!privius||current==0) {	//재생중이던 곡이 없거나 재생중이던 곡이 처음 곡일 경우 마지막 곡 재생
			play(musicList.length-1);
		} else {		//재생중이던 곡이 있는 경우 이전 곡 재생
			play(--current);
		}
	}
	
	public static void nextPlay() {
		stop();
		if(!privius||current==musicList.length-1) {	//이전에 재생중이던 곡이 없거나 재생중이던 곡이 마지막 곡일 경우 마지막 첫 재생
			play(0);
		} else {		//이전에 재생중이던 곡이 있는 경우 다음 곡 재생
			play(++current);
		}
	}
	
	public static void stop() {	
		try {
			playState = false;
			clip.close();
			timer.finish();
		} catch(NullPointerException e) {
			
		}
		
	}
	
	// 이전에 재생중이던 곡이 없을때 첫곡 재생 구현하기
	public void pause() {
		if(playState) {
			playState = false;
			clip.stop();
		}
		else {
			playState = true;
			clip.start();	
		}
	}
}