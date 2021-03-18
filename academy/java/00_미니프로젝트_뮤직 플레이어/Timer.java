package music.play.list.model;

public class Timer extends Thread{
	boolean interruptFlag = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				//현재 클립 위치, 총 클립 길이(위치) 비교하여 같을 경우 다음 곡 재생
				if(MusicDao.getClip().getMicrosecondPosition()==MusicDao.getClip().getMicrosecondLength()) {
					MusicDao.nextPlay();
				}
				if(interruptFlag==true) return;		//쓰레드 종료
				Thread.sleep(2000);	//1000ms : 1초 단위 
			} catch (InterruptedException e) {
				MusicDao.getTimer().interrupt();
			}
		}
	}
	
	public void finish() {
		this.interruptFlag = true;
	}
}
