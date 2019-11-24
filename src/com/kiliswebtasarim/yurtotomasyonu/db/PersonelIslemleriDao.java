package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.PersonelIslemleriDomain;

public class PersonelIslemleriDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE personel(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) ,tcNo VARCHAR(50),adi VARCHAR(50),soyadi VARCHAR(50),tarih VARCHAR(50),maas VARCHAR(50),telefon VARCHAR(50),adres VARCHAR(100),sskno VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Personel tablosu Zaten var");
		}

	}

	public static void ekle(PersonelIslemleriDomain eklenecekPersonelDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement(
					"INSERT INTO personel(tcNo,adi,soyadi,tarih,maas,telefon,adres,sskno) VALUES(?,?,?,?,?,?,?,?)");
			sorgu.setString(1, eklenecekPersonelDomain.getTcNo());
			sorgu.setString(2, eklenecekPersonelDomain.getAdi());
			sorgu.setString(3, eklenecekPersonelDomain.getSoyadi());
			sorgu.setString(4, eklenecekPersonelDomain.getTarih());
			sorgu.setString(5, eklenecekPersonelDomain.getMaas());
			sorgu.setString(6, eklenecekPersonelDomain.getTelefon());
			sorgu.setString(7, eklenecekPersonelDomain.getAdres());
			sorgu.setString(8, eklenecekPersonelDomain.getSskno());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(PersonelIslemleriDomain silinecekPersonelDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM personel WHERE id = ?");

			sorgu.setInt(1, silinecekPersonelDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<PersonelIslemleriDomain> listele() {

		List<PersonelIslemleriDomain> liste = new ArrayList<PersonelIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM personel");

			while (veriler.next()) {
				PersonelIslemleriDomain siradakiPersonelDomain = new PersonelIslemleriDomain();

				siradakiPersonelDomain.setId(veriler.getInt("id"));
				siradakiPersonelDomain.setTcNo(veriler.getString("tcNo"));
				siradakiPersonelDomain.setAdi(veriler.getString("adi"));
				siradakiPersonelDomain.setSoyadi(veriler.getString("soyadi"));
				siradakiPersonelDomain.setTarih(veriler.getString("tarih"));
				siradakiPersonelDomain.setMaas(veriler.getString("maas"));
				siradakiPersonelDomain.setTelefon(veriler.getString("telefon"));
				siradakiPersonelDomain.setAdres(veriler.getString("adres"));
				siradakiPersonelDomain.setSskno(veriler.getString("sskno"));

				liste.add(siradakiPersonelDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static List<PersonelIslemleriDomain> bul(String tcNo) {

		List<PersonelIslemleriDomain> liste = new ArrayList<PersonelIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM personel WHERE tcNo LIKE ?");

			sorgu.setString(1, tcNo);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				PersonelIslemleriDomain siradakiPersonelDomain = new PersonelIslemleriDomain();

				siradakiPersonelDomain.setId(rs.getInt("id"));
				siradakiPersonelDomain.setTcNo(rs.getString("tcNo"));
				siradakiPersonelDomain.setAdi(rs.getString("adi"));
				siradakiPersonelDomain.setSoyadi(rs.getString("soyadi"));
				siradakiPersonelDomain.setTarih(rs.getString("tarih"));
				siradakiPersonelDomain.setMaas(rs.getString("maas"));
				siradakiPersonelDomain.setTelefon(rs.getString("telefon"));
				siradakiPersonelDomain.setAdres(rs.getString("adres"));
				siradakiPersonelDomain.setSskno(rs.getString("sskno"));

				liste.add(siradakiPersonelDomain);

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
