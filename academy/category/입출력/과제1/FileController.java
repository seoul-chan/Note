package com.kh.practice.file.controller;

import com.kh.practice.file.model.dao.FileDAO;

public class FileController {
	private FileDAO fd = new FileDAO();
	
	public boolean checkName(String file) {
		
		return fd.checkName(file);
	}
	
	public void fileSave(String file, StringBuilder s) {
		fd.fileSave(file, new String(s));	
	}
	
	public StringBuilder fileOpen(String file) {
		
		return fd.fileOpen(file);
	}
	
	public void fileEdit(String file, StringBuilder sb) {
		fd.fileEdit(file, new String(sb));
	}
}
