package com.io.run;

import com.io.controller.FileIOStreamTest;

public class Main {
	public static void main(String[] args) {
		FileIOStreamTest fio = new FileIOStreamTest();
//		fio.saveFile();
//		fio.loadFile();
//		fio.strSaveFile();
//		fio.strLoadFile();
//		fio.strWriter();
//		fio.strReader();
		fio.dataSave();
		fio.dataLoad();
	}
}
