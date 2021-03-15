package music.play.list.model;

public class Timer extends Thread{
	boolean interruptFlag = false;
	
	@Override
	public void run() {
		while(true) {
			try {
				if(MusicDao.getClip().getMicrosecondPosition()==MusicDao.getClip().getMicrosecondLength()) {
					MusicDao.nextPlay();
				}
				if(interruptFlag==true) return;
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				MusicDao.getTimer().interrupt();
			}
		}
	}
	
	public void finish() {
		this.interruptFlag = true;
	}
}
