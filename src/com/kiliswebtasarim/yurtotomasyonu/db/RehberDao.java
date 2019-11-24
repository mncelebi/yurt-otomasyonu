package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.RehberDomain;

public class RehberDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE rehber(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) , bolum VARCHAR(50),adisoyadi VARCHAR(50),telefon VARCHAR(50),gsm1 VARCHAR(50),gsm2 VARCHAR(50),mail VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("rehber Zaten var");
		}

	}

	public static void ekle(RehberDomain eklenecekRehberDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con
					.prepareStatement("INSERT INTO rehber(bolum,adisoyadi,telefon,gsm1,gsm2,mail) VALUES(?,?,?,?,?,?)");
			sorgu.setString(1, eklenecekRehberDomain.getBolum());
			sorgu.setString(2, eklenecekRehberDomain.getAdisoyadi());
			sorgu.setString(3, eklenecekRehberDomain.getTelefon());
			sorgu.setString(4, eklenecekRehberDomain.getGsm1());
			sorgu.setString(5, eklenecekRehberDomain.getGsm2());
			sorgu.setString(6, eklenecekRehberDomain.getMail());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(RehberDomain silinecekRehberDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM rehber WHERE id = ?");

			sorgu.setInt(1, silinecekRehberDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<RehberDomain> listele() {

		List<RehberDomain> liste = new ArrayList<RehberDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM rehber");

			while (veriler.next()) {
				RehberDomain siradakiRehberDomain = new RehberDomain();

				siradakiRehberDomain.setId(veriler.getInt("id"));
				siradakiRehberDomain.setBolum(veriler.getString("bolum"));
				siradakiRehberDomain.setAdisoyadi(veriler.getString("adisoyadi"));
				siradakiRehberDomain.setTelefon(veriler.getString("telefon"));
				siradakiRehberDomain.setGsm1(veriler.getString("gsm1"));
				siradakiRehberDomain.setGsm2(veriler.getString("gsm2"));
				siradakiRehberDomain.setMail(veriler.getString("mail"));

				liste.add(siradakiRehberDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static List<RehberDomain> bul(String adisoyadi) {

		List<RehberDomain> liste = new ArrayList<RehberDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM rehber WHERE adisoyadi LIKE ?");

			sorgu.setString(1, adisoyadi);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				RehberDomain siradakiRehberDomain = new RehberDomain();

				siradakiRehberDomain.setId(rs.getInt("id"));
				siradakiRehberDomain.setBolum(rs.getString("bolum"));
				siradakiRehberDomain.setAdisoyadi(rs.getString("adisoyadi"));
				siradakiRehberDomain.setTelefon(rs.getString("telefon"));
				siradakiRehberDomain.setGsm1(rs.getString("gsm1"));
				siradakiRehberDomain.setGsm2(rs.getString("gsm2"));
				siradakiRehberDomain.setMail(rs.getString("mail"));

				liste.add(siradakiRehberDomain);

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
