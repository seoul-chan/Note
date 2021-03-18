package music.play.list.controller;

import music.play.list.model.MusicDao;

public class MusicController {
	private MusicDao muDao = new MusicDao();	
	
	public String[] musicList(){
		return muDao.musicList();
	}
	
	// 노래 재생
	public void play(int input) {
		muDao.play(input);
	}
	
	// 이전 곡 재생
	public void priviusPlay() {
		muDao.priviusPlay();
	}
	
	// 다음 곡 재생
	public void nextPlay() {
		muDao.nextPlay();
	}	
	
	// 음악 중지
	public void stop() {
		muDao.stop();
	}
	
	// 일시정시 또는 다시 재생
	public void pause() {
		muDao.pause();
	}
	
	// 한곡 반복 재생
	public void loop() {
		muDao.loop();
	}
}
