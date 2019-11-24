package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {
	
	private static String surucu ="org.apache.derby.jdbc.EmbeddedDriver";
	private static String yol = "jdbc:derby:yurt;create=true";
	private static String kullaniciAdi = "";
	private static String parola = "";

static{
		
		try {
			Class.forName(surucu);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

public static Connection getConnection(){
	
	Connection con = null;
	
	try {
		con = DriverManager.getConnection(yol, kullaniciAdi, parola);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return con;
}
}
