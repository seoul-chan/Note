package com.io.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.io.model.vo.Person;

public class IOStreamTest {
	public static void main(String[] args) {
		saveFile();
		loadFile();
		strSaveFile();
		strLoadFile();
		dataSave();
		dataLoad();
		
	}
	
	public static void saveFile() {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("IOStreamTest.txt");
			String msg = "String Input";
			
			out.write((msg+"\n").getBytes());
			out.write("Hi\n".getBytes());
			out.write("Chan\n".getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void loadFile() {
		FileInputStream in = null;
		try {
			in = new FileInputStream("IOStreamTest.txt");
			
			int data = -1;
			String str="";
			
//			byte[] temp = new byte[(int)new File("IOStreamTest.txt").length()];
//			in.read(temp);
//			String data1 = new String(temp);
//			System.out.println(data1);
			
			while((data=in.read())!=-1) {
//				System.out.print((char)data);
				str+=(char)data;				
			}		
			System.out.println(str);				
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void strSaveFile() {
		try(FileWriter out =  new FileWriter("IOStreamTest.txt",true);){
			out.write("Hello\n");
			out.write("JAVA");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void strLoadFile() {
		try(FileReader rd = new FileReader("IOStreamTest.txt");){
			int data=-1;
			String str="";
			
			while((data=rd.read())!=-1) {
				str+=(char)data;
			}
			System.out.println(str);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void dataSave() {
		Person[] person = new Person[3];
		person[0] = new Person("±è°æÂù1",19,'³²',180.5);
		person[1] = new Person("±è°æÂù2",29,'¿©',189.5);
		person[2] = new Person("±è°æÂù3",39,'³²',185.5);
		
		try(FileWriter out = new FileWriter("IOStreamTest.txt")){
			for(Person p : person) {
				out.write(p.getName()+",");
				out.write(String.valueOf(p.getAge())+",");
				out.write(p.getGender()+",");
				out.write(String.valueOf(p.getHeight())+"\n");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void dataLoad() {
		try(FileReader rd = new FileReader("IOStreamTest.txt");){
			int data =-1;
			String str = "";
			
			while((data=rd.read())!=-1)
				str+=(char)data;
			System.out.println(str);
			
			String[] strPerson = str.split("\n");
			for(int i=0;i<strPerson.length;i++) {
				
				String[] temp = strPerson[i].split(",");
				Person[] person = new Person[3];
				person[i] = new Person(temp[0],Integer.parseInt(temp[1]),temp[2].charAt(0),Double.valueOf(temp[3]));
				
				System.out.println(person[i]);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}










