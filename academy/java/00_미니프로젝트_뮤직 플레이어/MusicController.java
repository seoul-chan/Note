package music.play.list.controller;

import music.play.list.model.MusicDao;

public class MusicController {
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
		if(input<0||input>=musicList.length){
				System.out.println("잘못 입력하였습니다.");
				return;
		}
		
		String fileName=musicList[input];
		current=input;		
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
	
	public void priviusPlay() {
		if(!privius||current==0) {	//재생중이던 곡이 없거나 재생중이던 곡이 처음 곡일 경우 마지막 곡 재생
			play(musicList.length-1);
		} else {		//재생중이던 곡이 있는 경우 이전 곡 재생
			play(--current);
		}
	}
	
	public void nextPlay() {
		if(!privius||current==musicList.length-1) {	//이전에 재생중이던 곡이 없거나 재생중이던 곡이 마지막 곡일 경우 마지막 첫 재생
			play(0);
		} else {		//이전에 재생중이던 곡이 있는 경우 다음 곡 재생
			play(++current);
		}
	}	
	
	public void stop() {
		muDao.mStop();
	}
	
	public void pause() {
		muDao.pause();
	}
	
	public void tempPlay() {
		muDao.tempPlay();
	}
}
