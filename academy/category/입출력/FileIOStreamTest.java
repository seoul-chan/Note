package com.io.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.io.model.vo.Person;

public class FileIOStreamTest {
	/*
	 * FileStream은 파일 생성 시 이미 동일한 파일이 있는 경우 덮어쓰기를 한다. 
	 * FileOutputFile("secretLamda",true); 로 작성하면 기존 파일에 이어서 작성이 가능하다.
	 * Stream은 사용 후 반드시 반환해야 한다 -> close()메소드를 사용
	 * FileStream 생성자에 예외 생성이 있어 반드시 예외처리를 해줘야 함 -> try ~ catch문
	 * close() 또한 예외 생성이 있어 예외 처리를 해줘야 한다.
	*/
	
	
	// *** OutputStream -> FileOutputStream
	public void saveFile() {		
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("secretLamda"); //파일 이름
			String msg = "lamda fight 123"; //파일 내용

			//write() 메소드를 이용해서 파일을 전송
			//byte단위 통신이기에 일반 문자열을 바로 사용할 수 없다.
			out.write((msg+"\n").getBytes());
			out.write("abced\n".getBytes());
			out.write("한글도 가능\n".getBytes()); //알아서 2byte로 보내기에 한글도 가능하다.
			
			/*바이트 배열로 받아 처리 방법
			 byte[] data = msg.getBytes();
			 out.write(data);
			*/
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// *** InputStream -> FileInputStream
	/*
	 * 파일에 있는 데이터를 가져올때 read()메소드를 이용한다. 파일 데이터를 가져올 때 byte로 가져오나 반환은 int로 한다.
	 * inputStream에서 파일에 저장된 내용을 더이상 가져올 것이 없으면 -1을 반환한다.
	 * */
	public void loadFile() {
		FileInputStream fis = null;
		
		try{
			fis = new FileInputStream("secretLamda"); //파일 이름

			int data = -1; //가져온 byte 데이터를 보관하는 변수
			while((data=fis.read())!=-1) { //가져올 내용이 없는 경우 중지
				//바이트 숫자 값을 char로 형변환하여 콘솔에 글자로 출력되도록 한다.(그러나 한글은 깨져서 보인다.)
				System.out.println((char)data); 

				byte[] temp = new byte[(int)new File("secretLamda").length()];
				fis.read(temp);		//알아서 byte배열에 데이터를 넣는다.
				String data1 = new String(temp);
				System.out.println(data1);
			}	
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	// *** 문자처리 기반의 스트림 - Reader / Writer
	// *** Writer -> FileWriter
	public void strSaveFile() {
		// try-with-resource를 적용하여 자동 close() 적용
		try(FileWriter out = new FileWriter("strData")){ //파일 이름		
			
			String str = "오늘은 목요일 ";
			out.write(str);
			out.write("추운 목요일");			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// *** Reader -> FileReader
	public void strLoadFile() {
		try(FileReader fr = new FileReader("strData")){
			
			int data=-1;
			String msg="";
			while((data=fr.read())!=-1) {
				msg+=(char)data; //한 글자씩 문자열에 추가
			}
			System.out.println(msg);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * 간단한 메모장 만들기
	 * 클라이언트한테 값을 입력 받으며 입력 받은 값을 변수에 저장하고 exit라고 입력하면 파일에 저장
	 * (exit입력 전까지는 계속 입력을 받음)   
	 */
	public void strWriter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 메모장 ====");
		System.out.println("저장할 값을 입력해 주세요. 종료를 원하시면 exit를 입력해주세요.");
		String total="";
		
		while(true) {
			String temp=sc.nextLine();
			if(temp.equals("exit")) break;
			total+="\n"+temp;
		}
		
		System.out.print("저장할 파일명을 입력해 주세요 : ");
		String fileName = sc.next(); 
		
		try(FileWriter out = new FileWriter(fileName)){
			out.write(total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void strReader() {
		String path = FileIOStreamTest.class.getResource("/").getPath(); //bin 경로 까지 
		path = path.substring(0,path.lastIndexOf("bin")); //문자열을 잘라 bin이전의 경로 저장
		File f= new File(path);
		String[] fileList=f.list();
		
		System.out.println("==== 저장된 메모장 목록 ====");
		for(String name:fileList) {
			if(name.contains(".bs")) {	//확장자가 .bs인 파일 출력
				System.out.println(name);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("불러올 파일명 : ");
		try(FileReader fr = new FileReader(sc.nextLine())){
			int data=-1;
			String msg="";
			
			while((data=fr.read())!=-1) {
				msg+=(char)data;
			}
			System.out.println(msg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ***데이터를 파일로 저장
	public void dataSave() {
		Person[] person = new Person[3];
		person[0] = new Person("김경찬1",19,'남',180.5);
		person[1] = new Person("김경찬2",29,'여',189.5);
		person[2] = new Person("김경찬3",39,'남',185.5);
		
		try(FileWriter out = new FileWriter("person.dat")){
			for(Person p : person) {
				out.write(p.getName()+",");
				out.write(String.valueOf(p.getAge())+",");
				out.write(p.getGender()+",");
				out.write(String.valueOf(p.getHeight())+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dataLoad() {
		try(FileReader fr = new FileReader("person.dat")){
			int data=-1;
			String person="";

			while((data=fr.read())!=-1) {
				person+=(char)data;
			}
			System.out.println(person);
			String[] strPersons = person.split("\n");
			Person[] persons = new Person[3]; //읽은 데이터를 객체로 생성
			
			for(int i=0;i<persons.length;i++) {
				String[] temp = strPersons[i].split(",");
				persons[i] = new Person(temp[0],Integer.parseInt(temp[1]),temp[2].charAt(0),Double.valueOf(temp[3]));
			}	
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	

	
	
	
	
}

