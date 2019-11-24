package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.HarcamalarDomain;

public class HarcamalarDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE harcamalar(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , adi VARCHAR(150),unvani VARCHAR(150),islemturu VARCHAR(150),miktar double,aciklama VARCHAR(150))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Harcamalar tablosu Zaten var");
		}

	}

	public static void ekle(HarcamalarDomain eklenecekHarcamaDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con
					.prepareStatement("INSERT INTO harcamalar(adi,unvani,islemturu,miktar,aciklama) VALUES(?,?,?,?,?)");
			sorgu.setString(1, eklenecekHarcamaDomain.getAdi());
			sorgu.setString(2, eklenecekHarcamaDomain.getUnvani());
			sorgu.setString(3, eklenecekHarcamaDomain.getIslemturu());
			sorgu.setDouble(4, eklenecekHarcamaDomain.getMiktar());
			sorgu.setString(5, eklenecekHarcamaDomain.getAciklama());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<HarcamalarDomain> listele() {

		List<HarcamalarDomain> liste = new ArrayList<HarcamalarDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM harcamalar");

			while (veriler.next()) {
				HarcamalarDomain siradakiHarcamalarDomain = new HarcamalarDomain();

				siradakiHarcamalarDomain.setId(veriler.getInt("id"));
				siradakiHarcamalarDomain.setAdi(veriler.getString("adi"));
				siradakiHarcamalarDomain.setUnvani(veriler.getString("unvani"));
				siradakiHarcamalarDomain.setIslemturu(veriler.getString("islemturu"));
				siradakiHarcamalarDomain.setMiktar(veriler.getDouble("miktar"));
				siradakiHarcamalarDomain.setAciklama(veriler.getString("aciklama"));

				liste.add(siradakiHarcamalarDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static void sil(HarcamalarDomain silinecekHarcamalarDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM harcamalar WHERE id = ?");

			sorgu.setInt(1, silinecekHarcamalarDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
