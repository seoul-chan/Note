package music.play.list.controller;

import music.play.list.model.MusicDao;

public class MusicController {
	private MusicDao muDao = new MusicDao();	
	private Thread t = null;
	
	public String[] musicList(){
		return muDao.musicList();
	}
	
	public void play(int input) {
		muDao.play(input);
	}
	
	public void priviusPlay() {
		muDao.priviusPlay();
	}
	
	public void nextPlay() {
		muDao.nextPlay();
	}	
	
	public void stop() {
		muDao.stop();
	}
	
	// 일시정시 또는 다시 재생
	public void pause() {
		muDao.pause();
	}
}
