package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.OnKayitDomain;

public class OnKayitDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE onkayit(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , tcNo VARCHAR(50),adi VARCHAR(50),soyadi VARCHAR(50),telefon VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Marka Zaten var");
		}

	}

	public static void ekle(OnKayitDomain eklenecekOnKayitDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con
					.prepareStatement("INSERT INTO onkayit(tcNo,adi,soyadi,telefon) VALUES(?,?,?,?)");
			sorgu.setString(1, eklenecekOnKayitDomain.getTcNo());
			sorgu.setString(2, eklenecekOnKayitDomain.getAdi());
			sorgu.setString(3, eklenecekOnKayitDomain.getSoyadi());
			sorgu.setString(4, eklenecekOnKayitDomain.getTelefon());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(OnKayitDomain silinecekOnKayitDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM onkayit WHERE id = ?");

			sorgu.setInt(1, silinecekOnKayitDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<OnKayitDomain> listele() {

		List<OnKayitDomain> liste = new ArrayList<OnKayitDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM onkayit");

			while (veriler.next()) {
				OnKayitDomain siradakiOnKayitDomain = new OnKayitDomain();

				siradakiOnKayitDomain.setId(veriler.getInt("id"));
				siradakiOnKayitDomain.setTcNo(veriler.getString("tcNo"));
				siradakiOnKayitDomain.setAdi(veriler.getString("adi"));
				siradakiOnKayitDomain.setSoyadi(veriler.getString("soyadi"));
				siradakiOnKayitDomain.setTelefon(veriler.getString("telefon"));

				liste.add(siradakiOnKayitDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static OnKayitDomain tcnoyaGoreBul(String tcno) {

		OnKayitDomain bulunanOgrenciDomain = new OnKayitDomain();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM onkayit WHERE tcNo = ?");

			sorgu.setString(1, tcno);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {

				bulunanOgrenciDomain.setId(rs.getInt("id"));
				bulunanOgrenciDomain.setAdi(rs.getString("adi"));
				bulunanOgrenciDomain.setSoyadi(rs.getString("soyadi"));
				bulunanOgrenciDomain.setTelefon(rs.getString("telefon"));

			}

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bulunanOgrenciDomain;
	}

}
