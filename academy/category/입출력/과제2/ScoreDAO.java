package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScoreDAO{
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("Student.dao",true))){
			dos.writeUTF(name);
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(math);
			dos.writeInt(sum);
			dos.writeDouble(avg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public DataInputStream readScore() throws FileNotFoundException{
		DataInputStream dis = null;
		
		try {
			dis = new DataInputStream(new FileInputStream("Student.dao"));
			
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}
		return dis;
	}
}
