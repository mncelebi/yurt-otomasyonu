package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.KasaIslemleriDomain;

public class KasaIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE kasa(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , bilgi VARCHAR(150),aciklama VARCHAR(150),miktar double,zaman TIMESTAMP)");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Kasa tablosu Zaten var");
		}

	}

	public static void ekle(KasaIslemleriDomain eklenecekKasaDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con
					.prepareStatement("INSERT INTO kasa(bilgi,aciklama,miktar,zaman) VALUES(?,?,?,CURRENT_TIMESTAMP)");
			sorgu.setString(1, eklenecekKasaDomain.getBilgi());
			sorgu.setString(2, eklenecekKasaDomain.getAciklama());
			sorgu.setDouble(3, eklenecekKasaDomain.getMiktar());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<KasaIslemleriDomain> listele() {

		List<KasaIslemleriDomain> liste = new ArrayList<KasaIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM kasa");

			while (veriler.next()) {
				KasaIslemleriDomain siradakiKasaDomain = new KasaIslemleriDomain();

				siradakiKasaDomain.setId(veriler.getInt("id"));
				siradakiKasaDomain.setBilgi(veriler.getString("bilgi"));
				siradakiKasaDomain.setAciklama(veriler.getString("aciklama"));
				siradakiKasaDomain.setMiktar(veriler.getDouble("miktar"));
				siradakiKasaDomain.setZaman(veriler.getTimestamp("zaman"));

				liste.add(siradakiKasaDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static double kasaDurumu() {

		double miktar = 0;

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT SUM(miktar) FROM kasa");

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {

				miktar = rs.getDouble(1);

			}

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return miktar;
	}

}
