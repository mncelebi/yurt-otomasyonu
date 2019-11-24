package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.YemekIslemleriDomain;

public class YemekIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE yemek(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , tarih VARCHAR(50),yemek1 VARCHAR(50),yemek2 VARCHAR(50),yemek3 VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Yemek Tablosu Zaten var");
		}

	}

	public static void ekle(YemekIslemleriDomain eklenecekYemekDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con
					.prepareStatement("INSERT INTO yemek(tarih,yemek1,yemek2,yemek3) VALUES(?,?,?,?)");

			sorgu.setString(1, eklenecekYemekDomain.getTarih());
			sorgu.setString(2, eklenecekYemekDomain.getYemek1());
			sorgu.setString(3, eklenecekYemekDomain.getYemek2());
			sorgu.setString(4, eklenecekYemekDomain.getYemek3());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(YemekIslemleriDomain silinecekYemekDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM yemek WHERE id = ?");

			sorgu.setInt(1, silinecekYemekDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<YemekIslemleriDomain> listele() {

		List<YemekIslemleriDomain> liste = new ArrayList<YemekIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM yemek");

			while (veriler.next()) {
				YemekIslemleriDomain siradakiYemekDomain = new YemekIslemleriDomain();

				siradakiYemekDomain.setId(veriler.getInt("id"));
				siradakiYemekDomain.setTarih(veriler.getString("tarih"));
				siradakiYemekDomain.setYemek1(veriler.getString("yemek1"));
				siradakiYemekDomain.setYemek2(veriler.getString("yemek2"));
				siradakiYemekDomain.setYemek3(veriler.getString("yemek3"));

				liste.add(siradakiYemekDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static List<YemekIslemleriDomain> bul(String tarih) {

		List<YemekIslemleriDomain> liste = new ArrayList<YemekIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM yemek WHERE tarih LIKE ?");

			sorgu.setString(1, tarih);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				YemekIslemleriDomain siradakiYemekDomain = new YemekIslemleriDomain();

				siradakiYemekDomain.setId(rs.getInt("id"));
				siradakiYemekDomain.setTarih(rs.getString("tarih"));
				siradakiYemekDomain.setYemek1(rs.getString("yemek1"));
				siradakiYemekDomain.setYemek2(rs.getString("yemek2"));
				siradakiYemekDomain.setYemek3(rs.getString("yemek3"));

				liste.add(siradakiYemekDomain);

			}

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

}
