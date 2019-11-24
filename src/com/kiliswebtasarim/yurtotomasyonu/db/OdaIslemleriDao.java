package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.OdaIslemleriDomain;

public class OdaIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE oda(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , odano VARCHAR(50),adisoyadi VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Oda Tablosu Zaten var");
		}

	}

	public static void ekle(OdaIslemleriDomain eklenecekOdaDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("INSERT INTO oda(odano,adisoyadi) VALUES(?,?)");
			sorgu.setString(1, eklenecekOdaDomain.getOdano());
			sorgu.setString(2, eklenecekOdaDomain.getAdisoyadi());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<OdaIslemleriDomain> listele() {

		List<OdaIslemleriDomain> liste = new ArrayList<OdaIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM oda");

			while (veriler.next()) {
				OdaIslemleriDomain siradakiOdaDomain = new OdaIslemleriDomain();

				siradakiOdaDomain.setId(veriler.getInt("id"));
				siradakiOdaDomain.setOdano(veriler.getString("odano"));
				siradakiOdaDomain.setAdisoyadi(veriler.getString("adisoyadi"));

				liste.add(siradakiOdaDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

}
