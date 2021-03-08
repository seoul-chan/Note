package music.play.list.controller;

import java.util.Scanner;

import music.play.list.model.Member;
import music.play.list.model.MusicDao;

public class MusicController {
	Scanner sc = new Scanner(System.in);
	MusicDao muDao = new MusicDao();	
	Thread t = null;
	
	public void play(int input) {
		String fileName="";
		boolean privius = false;

		switch(input) {
			case 1 : fileName= "test"; break;
			case 2 : fileName= "test2"; break;
			case 3 : fileName= "test3"; break;
			case 4 : fileName= "test4"; break;
			case 5 : fileName= "SG Wannabe Brown Eyed Girls - Must Have Love"; break;
			case 8 : muDao.mstop(); break;
//			case 9 : System.out.println("이전 메뉴로 돌아갑니다."); return;
			default : System.out.println("잘못 입력하였습니다.");
		}
		
		if(input!=8){
			if(!privius) {
				t = new Thread(muDao,fileName);
				t.start();
				privius = true;
			} else {
				muDao.mstop();
				t = new Thread(muDao,fileName);
				t.start();
			}
		}
	}
	
	public void stop() {
		
	}
}
