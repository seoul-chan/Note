package music.play.list.model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicDao {
	private static Clip clip = null;	//음악 파일 컨트롤
	private static boolean privius = false; //이전에 재생되고 있는 곡 여부
	private static int current = 0;	//현재 재생중인 노래 정보
	private static boolean playState = false; // 현재 재생 중인지 확인
	private static boolean loop = false; //현재 한곡 반복 재생 중인지 확인
	private static String[] musicList=null;	//파일 목록
	private static Timer timer = null;	//다음 곡 재생 용도 쓰레드
	
	public MusicDao() {}
	
	public static Clip getClip() {return clip;}
	public static Timer getTimer() {return timer;}

	//파일 전체목록 가져오기
	public String[] musicList(){
		File path = new File("Music\\");
		musicList = path.list();
		return musicList;
	}
	
	// 파일 재생
	public static  void play(int input) {
		try {
			if(input<0||input>=musicList.length){
				System.out.println("잘못 입력하였습니다.");
				return;
			}
			
			stop();		// 기존 노래 정지 후 노래 재생
			current=input;
			privius=true;		
			playState=true;
			
			String path = "Music\\"+musicList[input];
			//지정된 오디오 입력 스트림을 변환해 오디오 입력 스트림을 취득한다.
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));	
			clip = AudioSystem.getClip();	// 오디오 스트림을 재생하는데 사용할 수 있는 지정된 믹서에서 클립을 가져온다.
			clip.open(audioInputStream);	// 지정한 오디오 입력 스트림내에 제시되고 있는 형식 및 오디오 데이터로 클립을 연다. 
			clip.start();
			
			if(loop) {	// 이전 노래에서 한곡 반복 옵션이 설정되어 있는 경우 옵션 유지를 위해 사용, clip.loop는 stop시 자동 해제되기 때문.
				loop=false;
				loop();
			}
			
			timer = new Timer();	// 다음 곡으로 넘어가기 위한 스레드 (데몬 쓰레드)
			timer.start();
			
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
	
	// 이전 곡 재생
	public void priviusPlay() {
		stop();
		if(!privius||current==0) {	//재생중이던 곡이 없거나 재생중이던 곡이 처음 곡일 경우 마지막 곡 재생
			play(musicList.length-1);
		} else {		//재생중이던 곡이 있는 경우 이전 곡 재생
			play(--current);
		}
	}
	
	// 다음 곡 재생
	public static void nextPlay() {
		stop();
		if(!privius||current==musicList.length-1) {	//이전에 재생중이던 곡이 없거나 재생중이던 곡이 마지막 곡일 경우 마지막 첫 재생
			play(0);
		} else {		//이전에 재생중이던 곡이 있는 경우 다음 곡 재생
			play(++current);
		}
	}
	
	// 노래 정지
	public static void stop() {	
		try {
			playState = false;
			clip.close();
			timer.finish();
		} catch(NullPointerException e) {	// 재생 중이 아닐때 stop호출 시 예외처리
			
		}	
	}
	
	// 일시 정지 / 재생
	public void pause() {
		if(playState) {	//현재 재생 중이면 stop
			playState = false;
			clip.stop();
		}
		else { //현재 stop 중이면 재생
			playState = true;
			clip.start();	
		}
	}
	
	// 한곡 반복 재생
	public static  void loop() {
		try {
			if(loop) {
				clip.stop();	// clip이 중지되면 loop는 자동 해제된다.
				if(playState)	// 재생 중 이였을 경우 start() 호출 (이어서 재생)
					clip.start();
				loop=false;
				System.out.println("한곡 반복 재생 해제");
			} else {
				clip.loop(Clip.LOOP_CONTINUOUSLY);	 //현재의 위치로부터 루프 재생을 개시한다.
				loop=true;							//clip.loop는 루프 실행 중 다른 loop조건이 들어오면 무시된다.
				if(!playState)		//재생 중이 아니였을 경우 stop 호출
					clip.stop();	// 노래 재생 중이 아닐 때 loop호출 시 노래가 재생 됨
				System.out.println("한곡 반복 재생 실행 중");
			}	
		} catch(NullPointerException e) {
			
		}
	}	
}