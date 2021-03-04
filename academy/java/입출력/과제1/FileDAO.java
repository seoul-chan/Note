package com.kh.practice.file.model.dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDAO {

	public boolean checkName(String file) {
		File ckeck = new File(file);
		
		return ckeck.exists();
	}
	
	public void fileSave(String file, String s) {
		try(FileWriter save = new FileWriter(file);) {
			save.write(s);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public StringBuilder fileOpen(String file) {
		StringBuilder str = new StringBuilder(); 
		
		try(FileReader open = new FileReader(file)){
			int data=-1;
			
			while((data=open.read())!=-1) {
				str.append((char)data);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public void fileEdit(String file, String s) {
		try(FileWriter edit = new FileWriter(file,true)){
			edit.write(s);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
