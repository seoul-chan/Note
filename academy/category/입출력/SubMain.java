package com.io.model.vo;

import com.io.controller.FileSubStreamTest;

public class SubMain {
	public static void main(String[] args) {
		FileSubStreamTest fss = new FileSubStreamTest();
//		fss.stringChangeOutPut();
//		fss.stringChangeInput();
//		fss.bufferedWriterTest();
//		fss.bufferedReaderTest();
//		fss.dataOutputStreamTest();
//		fss.dataInputStreamTest();
		fss.personOutputStream();
		fss.personInputStream();
		
	}
}
