package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.OgrenciIslemleriDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.TaksitIslemleriDomain;

public class TaksitIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE taksitler(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , tcno VARCHAR(50),adisoyadi VARCHAR(150),taksit VARCHAR(150), miktar double,aciklama VARCHAR(150),tarih TIMESTAMP)");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Taksitler tablosu Zaten var");
		}

	}

	public static void ekle(TaksitIslemleriDomain eklenecekTaksitDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement(
					"INSERT INTO taksitler( tcno, adisoyadi, taksit, miktar, aciklama, tarih) VALUES(?,?,?,?,?,CURRENT_TIMESTAMP)");
			sorgu.setString(1, eklenecekTaksitDomain.getTcno());
			sorgu.setString(2, eklenecekTaksitDomain.getAdisoyadi());
			sorgu.setString(3, eklenecekTaksitDomain.getTaksit());
			sorgu.setDouble(4, eklenecekTaksitDomain.getMiktar());
			sorgu.setString(5, eklenecekTaksitDomain.getAciklama());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<TaksitIslemleriDomain> listele() {

		List<TaksitIslemleriDomain> liste = new ArrayList<TaksitIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM taksitler");

			while (veriler.next()) {
				TaksitIslemleriDomain siradakitaksitlerDomain = new TaksitIslemleriDomain();

				siradakitaksitlerDomain.setId(veriler.getInt("id"));
				siradakitaksitlerDomain.setTcno(veriler.getString("tcno"));
				siradakitaksitlerDomain.setAdisoyadi(veriler.getString("adisoyadi"));
				siradakitaksitlerDomain.setTaksit(veriler.getString("taksit"));
				siradakitaksitlerDomain.setMiktar(veriler.getDouble("miktar"));
				siradakitaksitlerDomain.setAciklama(veriler.getString("aciklama"));
				siradakitaksitlerDomain.setTarih(veriler.getTimestamp("tarih"));

				liste.add(siradakitaksitlerDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static void sil(TaksitIslemleriDomain silinecekTaksitlerDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM taksitler WHERE id = ?");

			sorgu.setInt(1, silinecekTaksitlerDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<TaksitIslemleriDomain> bul(String tcno) {

		List<TaksitIslemleriDomain> liste = new ArrayList<TaksitIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM taksitler WHERE tcno LIKE ?");

			sorgu.setString(1, tcno);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				TaksitIslemleriDomain siradakiTaksitlerDomain = new TaksitIslemleriDomain();

				siradakiTaksitlerDomain.setId(rs.getInt("id"));
				siradakiTaksitlerDomain.setTcno(rs.getString("tcno"));
				siradakiTaksitlerDomain.setAdisoyadi(rs.getString("adisoyadi"));
				siradakiTaksitlerDomain.setTaksit(rs.getString("taksit"));
				siradakiTaksitlerDomain.setMiktar(rs.getDouble("miktar"));
				siradakiTaksitlerDomain.setAciklama(rs.getString("aciklama"));
				siradakiTaksitlerDomain.setTarih(rs.getTimestamp("tarih"));

				liste.add(siradakiTaksitlerDomain);

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
