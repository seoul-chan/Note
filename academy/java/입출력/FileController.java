package com.io.controller;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class FileController {
	public static void main(String[] args) {
		/*	
		 * File클래스를 이용해서 파일 생성 및 제거 하기
		 * File객체를 이용해 보는 예제이다. 클래스로 생성해서 사용하며 생성자의 매개변수로 
		 * ‘경로+파일명’을 대입한다. 파일명만 작성할 경우 디폴트 경로인 프로젝트 폴더에 파일이 저장된다. 
		 * (단, C드라이브에 파일 생성 시 윈도우 자체에서 막기에 엑세스가 거부된다.)
		*/
		
		

		// ***상대경로 파일생성 : 프로젝트 폴더에 저장된다.
		/*
		 * createNewFile() - 파일 생성 메소드 
		 * 같은 이름의 파일이 있는 경우 덮어 쓰기 X -> 파일 생성 X
		 * boolean의 반환 값이 있음, 파일이 생성되면 true, 생성되지않으면 false
		 */
		File f = new File("test.txt"); //heap영역에 File객체가 생성된 상태. 
		try {
			f.createNewFile();
			System.out.println(f.createNewFile()); //false, 이전에 같은이름의 파일을 이미 생성했기에
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		// *** 프로젝트 기준으로 절대경로 찾기
		// 절대 경로 사용 시 리눅스, 윈도우 경로가 다르기에 일일이 변경해주어야 한다.
		System.out.println(FileController.class.getResource("/").getPath()); //bin 폴더까지 경로 출력
		System.out.println(FileController.class.getResource("").getPath()); //실제(패키지)경로 까지 출력

		
		//bin이전의 경로까지만 출력 후 파일 생성
		String path = FileController.class.getResource("/").getPath();
		path=path.substring(0,path.lastIndexOf("bin"));
		System.out.println(path);

//		File f2= new File("C:\\Users\\Chan\\eclipse-workspace\\13_io.controller\\test2.txt"); //경로를 지정해서도 사용 가능하다.
//		File f2 = new File(path+"/a/FileTest2.txt"); a처럼 중간에 존재하지 않는 경로 입력 시 IOException 발생
		File f2 = new File(path+"testPath.txt");
		try {
			f2.createNewFile();
		} catch(IOException e) {
			e.printStackTrace();
		}
			
		
		// *** 디렉토리 생성(mkdir) - (디폴트 경로)하나의 하위 디렉토리만 생성 가능
		/*
		 * 마지막 하나의 폴더만 생성하기에 작성한 경로 중 없는 경로가 있으면 생성하지 않는다.
		 * 생성에 성공하면 true, 실패하면 false를 반환한다.
		 * (작성한 경로 중 없는 경로가 있어 생성이 실패하면 false)
		*/
		File dir = new File("some");
		dir.mkdir(); //현재 프로젝트 폴더에 some폴더 생성
		
		
		// *** 디렉토리(경로, mkdirs) 생성 - 경로로 나열된 모든 디렉토리 생성 가능
		/*
		 * 파일 사이의 구분자는 OS환경에 따라 다르다. File.separator를 사용하면 환경에 맞게 구분자를 넣어준다.
		 * new File("a\\b\\c\\d\\e");
		 * new File("a"+File.separator+"b"+File.separator+"c"+File.separator+"e");
		 * new File("a/b/c/d/e");
		 * 이런 식으로 파일 경로를 작성하여 사용할 수 있다.
		 * 생성에 성공하면 true, 실패하면 false를 반환한다.
		 * (기존 경로가 있어 생성이 불가능하면 false)
		 */
		File dir2= new File("a/b/c/d/e");
		dir2.mkdirs(); //현재 프로젝트 폴더를 기준으로 작성한 경로대로 폴더를 생성
		
		
		
		// *** 파일 제거, 폴더를 지울때는 맨 마지막 폴더 하나만 제거 가능
		File del = new File("test.txt");
		del.delete();
		dir2.delete(); // 마지막 폴더 e만 제거됨(반복 수행해도 동일)
		
		
		
		//createFile 메소드를 만들어
		//default경로에 test폴더를 만들고 test폴더 안에 rclass파일을 생성하는 기능구현
		createFile(); // 아래 메소드 생성
		
		
		
		// *** file에 대한 정보를 출력해주는 메소드
		System.out.println(f2.getName()); //파일 또는 폴더 이름 출력
		System.out.println(dir.getName());
		System.out.println(f2.canExecute());//true, 실행파일 인지 확인, 클릭해서 열리면 실행 파일
		System.out.println(dir.canExecute()); // 폴더도 클릭 시 열리기에 true
		System.out.println(f2.canRead()); //읽을 수 있는 파일인지
		System.out.println(f2.canWrite());//수정할 수 있는지
		System.out.println(f2.getParent());//상위 경로가 무엇인지
		
		File pa=f2.getParentFile();//부모폴더 파일객체로 반환
		System.out.println(pa.getName());
		System.out.println(f2.getAbsolutePath());//전체 절대경로
		System.out.println(f2.isHidden());//숨김 파일인지 확인
		System.out.println(f2.length()); //파일 크기
		System.out.println(new Date(f2.lastModified()));//수정날짜
		System.out.println(f2.exists());//존재하는지
		if(f2.exists()) {
			System.out.println("파일있네");
		}else {
			System.out.println("파일없네!");
		}
		System.out.println(f2.isFile());//파일인지
		System.out.println(f2.isDirectory());//폴더인지
		
		
		
		// *** [File f].list() -  지정 폴더의 전체 파일/폴더 목록을 문자열 배열로 가져옴
		File rootDir = new File("C:\\User\\Chan");
		String[] fileNames=rootDir.list(); //해당 폴더의 파일/폴더 목록을 문자열 배열로 출력
		
		//리스트의 파일/폴더를 구분해서 출력
		for(String name : fileNames) {
			// root.getAbsolutePath() = C:\Users\Chan
			// new File(rootDir.getAbsoluteFile()+"/"+name);-> 경로 + 파일 이름을 File객체로 생성해서 해서 해당 파일/폴더가 폴더인지 파일인지 출력
			
			File temp=new File(rootDir.getAbsoluteFile(),name); //(경로, 파일 이름)
			if(temp.isFile()) System.out.println(temp.getName());
		}

		
		// *** [File f].listFiles() -  지정 폴더의 전체 파일&폴더를 목록으로 가져옴
		File[] files=rootDir.listFiles();
		for(File temp : files) {
			//System.out.println(temp); 폴더&파일 하나당 경로+이름 형식으로 출력
			if(temp.isFile()) System.out.println(temp.getName());
		}
		
		
		
		//**************************************************************************//
		FilenameFilter file12;
		System.out.println("==================Lamda==================");
		files=rootDir.listFiles((File f12, String name) -> new File(f12,name).isFile());
		for(File temp : files) {
			System.out.println(temp.getName());
		}
		
		files=rootDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir,name).isFile();
			}
		});
		
	}
	
	public static void createFile() {
		File dir=new File("test");
		dir.mkdir();
		File f = new File(dir.getName()+"rclass");
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}