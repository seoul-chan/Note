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

import com.io.model.vo.Person;


public class IOSubTest {
	public static void main(String[] args) {
		stringChangeOutput();
		stringChangeInput();
		bufferedWriterTest();
		bufferedReaderTest();
		dataOutputStreamTest();
		dataInputStreamTest();
		personOutputStream();
		personInputStream();
		
	}
	
	public static void stringChangeOutput(){
		try(BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(System.out));) {
			fw.write("문자열 전송");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stringChangeInput() {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			System.out.println(br.readLine());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferedWriterTest() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("IOSubTest.txt"));){
			bw.write("English\n");
			bw.write("한글");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void bufferedReaderTest() {
		try(BufferedReader br = new BufferedReader(new FileReader("IOSubTest.txt"));){
			String data="";
			while((data=br.readLine())!=null)
				System.out.println(data);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void dataOutputStreamTest() {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("IOSubTest.txt"));){
			dos.writeInt(2);
			dos.writeUTF("hihihi");
			dos.writeDouble(11.2);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void dataInputStreamTest() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("IOSubTest.txt"));){
			int i = dis.readInt();
			String s = dis.readUTF();
			double d = dis.readDouble();
			
			System.out.println(i+" "+s+" "+d);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void personOutputStream() {
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("IOSubTest.txt"));){
			Person[] person = new Person[3];
			person[0] = new Person("chan",19,'m',178);
			person[1] = new Person("chan3",50,'m',174);
			person[2] = new Person("chan2",34,'f',180);
			
			for(Person p : person) {
				dos.writeUTF(p.getName());
				dos.writeInt(p.getAge());
				dos.writeChar(p.getGender());
				dos.writeDouble(p.getHeight());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void personInputStream() {
		try(DataInputStream dis = new DataInputStream(new FileInputStream("IOSubTest.txt"));){
			Person[] person = new Person[] {new Person(),new Person(),new Person()};
			
			for(Person p : person) {
				p.setName(dis.readUTF());
				p.setAge(dis.readInt());
				p.setGender(dis.readChar());
				p.setHeight(dis.readDouble());
			}
			
			for(Person p : person)
				System.out.println(p);	
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
