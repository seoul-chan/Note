package com.home.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public static Connection getConnection() {
		Connection conn=null;
		try {
			Properties prop=new Properties();
			prop.load(new FileReader("resource/driver/driver.properties"));
			Class.forName(prop.getProperty("driver"));
			conn=DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("id"),prop.getProperty("pw"));
			conn.setAutoCommit(false);
		}catch(ClassNotFoundException|IOException|SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null&&!stmt.isClosed()) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null&&!rs.isClosed()) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn!=null&&!conn.isClosed()) conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
