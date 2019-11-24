package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.CariIslemleriDomain;

public class CariIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE cari(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , numara VARCHAR(50),adisoyadi VARCHAR(50),unvani VARCHAR(50),telefon VARCHAR(50),aciklama VARCHAR(150),tarih TIMESTAMP)");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Cari Tablosu Zaten var");
		}

	}

	public static void ekle(CariIslemleriDomain eklenecekCariDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement(
					"INSERT INTO cari(numara,adisoyadi,unvani,telefon,aciklama,tarih) VALUES(?,?,?,?,?,CURRENT_TIMESTAMP)");
			sorgu.setString(1, eklenecekCariDomain.getNo());
			sorgu.setString(2, eklenecekCariDomain.getAdisoyadi());
			sorgu.setString(3, eklenecekCariDomain.getUnvani());
			sorgu.setString(4, eklenecekCariDomain.getTelefon());
			sorgu.setString(5, eklenecekCariDomain.getAciklama());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(CariIslemleriDomain silinecekCariDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM cari WHERE id = ?");

			sorgu.setInt(1, silinecekCariDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<CariIslemleriDomain> listele() {

		List<CariIslemleriDomain> liste = new ArrayList<CariIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM cari");

			while (veriler.next()) {
				CariIslemleriDomain siradakiCariDomain = new CariIslemleriDomain();

				siradakiCariDomain.setId(veriler.getInt("id"));
				siradakiCariDomain.setNo(veriler.getString("numara"));
				siradakiCariDomain.setAdisoyadi(veriler.getString("adisoyadi"));
				siradakiCariDomain.setUnvani(veriler.getString("unvani"));
				siradakiCariDomain.setTelefon(veriler.getString("telefon"));
				siradakiCariDomain.setAciklama(veriler.getString("aciklama"));
				siradakiCariDomain.setTarih(veriler.getTimestamp("tarih"));

				liste.add(siradakiCariDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}
	
	

}
