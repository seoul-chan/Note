package com.io.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import com.io.model.vo.Person;

public class FileSubStreamTest {
	
	//서브스트림을 이용해보자.
	//기본 스트림을 매개변수로 사용하여 보조 스트림 생성(보조스트림만 생성해서는 사용할 수가 없다)
	
	
	// *** BufferedWriter
	/* 
	 * BufferedReader, BufferedWriter는 입출력 성능의 향상을 목적으로 사용한다.
	 * OutputStreamWriter : byte단위 데이터를 문자열로 변환하여 전송 (보조 스트림)
	 * OutputStreamWriter에 기반 스트림(System.out -> PrintStream)이 있기에 이런 식으로도 사용이 가능하다.
	 * System.out을 인자값으로 주어 write()에 입력한 값이 파일로 저장되는 것이 아닌 콜솔에 출력된다.
	 */
	public void stringChangeOutPut() {
		BufferedWriter fw =null;
		try {//try-with-resource도 가능
			fw = new BufferedWriter(new OutputStreamWriter(System.out)); 
			fw.write("문자열 가능");
			fw.flush(); //버퍼에 기록을 끝냄으로써 버퍼의 내용을 한번에 전송 -> 적어줘야 화면 출력
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	
	
	
	// *** BufferedReader
	/*
	 * fileStream : 키보드로 데이터를 받아오는 로직으로 Scanner와 기능은 비슷하나 문자열 저장만 가능하다. 
	 */
	
	public void stringChangeInput() {
		BufferedReader br =null;
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.print("입력 : ");
			String data=br.readLine(); //키보드로 입력값을 받음(문자열)
			System.out.println(data);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// *** BufferedWriter <-> FileWriter
	public void bufferedWriterTest() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("sample.txt"));){ //파일로 저장
			bw.write("오늘은 목요일 \n");
			bw.write("오늘은 금요일 \n");
			bw.write("오늘은 토요일 \n");
			bw.write("오늘은 일요일 \n");
			bw.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// *** BufferedReader <-> FileReader
	public void bufferedReaderTest() {
		try(BufferedReader br = new BufferedReader(new FileReader("sample.txt"))){
			
			String data="";
			while((data=br.readLine())!=null) {
				System.out.println(data);
			}			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	


	
	// ***DataOutputStream : 데이터의 자료형을 유지한 상태로 파일에 저장
	// DataOutputStream <-> FileOutputStream
	public void dataOutputStreamTest() {
		Scanner sc = new Scanner(System.in);
		try(DataOutputStream dis = new DataOutputStream(new FileOutputStream("member.dat"))){
			System.out.print("아이디 : ");
			dis.writeUTF(sc.nextLine());//문자열 타입 저장
			System.out.print("패스워드 : ");
			dis.writeUTF(sc.nextLine());
			System.out.print("성별 : ");
			dis.writeChar(sc.next().charAt(0));
			System.out.print("나이 : ");
			dis.writeInt(sc.nextInt());
			System.out.print("키 : ");
			dis.writeDouble(sc.nextDouble());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ***DataInputStream : 자료형을 유지한 상태로 가져옴
	/* 
	 * DataInputStream <-> FileInputStream
	 * 자료를 불러올 때 주의 사항으로 불러올 자료형의 저장한 순서와 같은 순서로 읽어와야 한다. 
	 * dataOutputStreamTest()에서 UTF -> UTF -> Char -> Int -> Double 순으로 자료를 저장했다.  
	 * 순서가 맞지 않으면 EOFException 발생하기에 반드시 입력했던 순서를 지켜줘야 한다.
	 */
	public void dataInputStreamTest() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("member.dat"))){
			String id = dis.readUTF();
			String pw = dis.readUTF();
			char gender = dis.readChar();
			int age = dis.readInt();
			double height = dis.readDouble();
			
			System.out.println(id+pw+gender+age+height);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//Person 3개를 입력받아 person.dat에 저장하고 저장된 데이터를 Person배열에 저장하여 출력하기
	public void personOutputStream() {
		Scanner sc = new Scanner(System.in);
		
		try(DataOutputStream dis = new DataOutputStream(new FileOutputStream("person.dat"))){
			for(int i=0;i<3;i++) {
				System.out.println("==== ("+ (i+1)+"/3)입력 ====");
				System.out.print("이름 : ");
				String name=sc.next();
				System.out.print("나이 : ");
				int age=sc.nextInt();
				System.out.print("성별 : ");
				char gender=sc.next().charAt(0);
				System.out.print("키 : ");
				double height = sc.nextDouble();
				
				dis.writeUTF(name);
				dis.writeInt(age);
				dis.writeChar(gender);
				dis.writeDouble(height);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void personInputStream() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("person.dat"))){
			Person[] persons=new Person[3];
			
			for(int i=0;i<persons.length;i++) {	
				persons[i]=new Person();
				persons[i].setName(dis.readUTF());
				persons[i].setAge(dis.readInt());
				persons[i].setGender(dis.readChar());
				persons[i].setHeight(dis.readDouble());	
			}
			for(Person p : persons) {
				System.out.println(p);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
