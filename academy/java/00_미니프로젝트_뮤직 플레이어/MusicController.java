package music.play.list.controller;

import java.util.Scanner;

import music.play.list.model.Member;
import music.play.list.model.MusicDao;

public class MusicController {
	private Scanner sc = new Scanner(System.in);
	private MusicDao muDao = new MusicDao();	
	private Thread t = null;
	private boolean privius = false; //이전에 재생되고 있는 곡 여부
	private int current = 0;	//현재 재생중인 노래 정보
	private String[] musicList=null;
	
	public String[] musicList(){
		musicList = muDao.musicList();
		return musicList;
	}
	
	public void play(int input) {
		String fileName=musicList[--input];
		current=input;
		
//		switch(input) {
//			case 1 : fileName= "SG Wannabe Brown Eyed Girls - Must Have Love"; break;
//			case 2 : fileName= "test"; break;
//			case 3 : fileName= "test2"; break;
//			case 4 : fileName= "test3"; break;
//			case 5 : fileName= "test4"; break;
////			case 8 : muDao.mStop(); break;
//			default : System.out.println("잘못 입력하였습니다.");
//		}
		
		/// 범위 이외의 값을 입력받아 다음 이전 곡으로 넘어가는데
		//  범위 제한거 걸려 못하는 버그 있음
		if(input<=0&&input>musicList.length)
			System.out.println("잘못 입력하였습니다.");
		
		if(input!=8){
			if(!privius) {
				t = new Thread(muDao,fileName);
				t.start();
				privius = true;
			} else {
				stop();
				t = new Thread(muDao,fileName);
				t.start();
			}
		}
	}
	
	public void priviusPlay() {
		if(!privius) {	//재생중이던 곡이 없는 경우 마지막 곡 재생
			play(musicList.length);
		} else {		//재생중이던 곡이 있는 경우 이전 곡 재생
			if(current==1) // 재생중이던 곡이 처음 곡일 경우
				play(musicList.length);
			else
				play(++current);
		}
	}
	
	public void nextPlay() {
		if(!privius) {	//이전에 재생중이던 곡이 없는 경우 마지막 첫 재생
			play(1);
		} else {		//이전에 재생중이던 곡이 있는 경우 이전 곡 재생
			if(current==musicList.length) // 재생중이던 곡이 마지막 곡일 경우
				play(1);
			else
				play(++current);
		}
	}	
	
	public void stop() {
		muDao.mStop();
	}
}
