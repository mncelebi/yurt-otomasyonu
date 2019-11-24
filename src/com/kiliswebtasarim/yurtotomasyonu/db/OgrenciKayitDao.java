package com.kiliswebtasarim.yurtotomasyonu.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kiliswebtasarim.yurtotomasyonu.domain.OgrenciIslemleriDomain;

public class OgrenciKayitDao {

	public static void tabloyuOlustur() {

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"CREATE TABLE ogrenci(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1) ,tcNo VARCHAR(50),adi VARCHAR(50),soyadi VARCHAR(50),tarih VARCHAR(50),veliAdi VARCHAR(50),telefon VARCHAR(50),adres VARCHAR(100),onKayit VARCHAR(50),taksit VARCHAR(50))");

			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("öðrenci tablosu Zaten var");
		}

	}

	public static void ekle(OgrenciIslemleriDomain eklenecekOgrenciDomain) {

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement(
					"INSERT INTO ogrenci(tcNo,adi,soyadi,tarih,veliAdi,telefon,adres,onKayit,taksit) VALUES(?,?,?,?,?,?,?,?,?)");
			sorgu.setString(1, eklenecekOgrenciDomain.getTcNo());
			sorgu.setString(2, eklenecekOgrenciDomain.getAdi());
			sorgu.setString(3, eklenecekOgrenciDomain.getSoyadi());
			sorgu.setString(4, eklenecekOgrenciDomain.getTarih());
			sorgu.setString(5, eklenecekOgrenciDomain.getVeliAdi());
			sorgu.setString(6, eklenecekOgrenciDomain.getTelefon());
			sorgu.setString(7, eklenecekOgrenciDomain.getAdres());
			sorgu.setString(8, eklenecekOgrenciDomain.getOnKayit());
			sorgu.setString(9, eklenecekOgrenciDomain.getTaksit());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void sil(OgrenciIslemleriDomain silinecekOgrenciDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement("DELETE FROM ogrenci WHERE id = ?");

			sorgu.setInt(1, silinecekOgrenciDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<OgrenciIslemleriDomain> listele() {

		List<OgrenciIslemleriDomain> liste = new ArrayList<OgrenciIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			Statement sorgu = con.createStatement();

			ResultSet veriler = sorgu.executeQuery("SELECT * FROM ogrenci");

			while (veriler.next()) {
				OgrenciIslemleriDomain siradakiOgrenciDomain = new OgrenciIslemleriDomain();

				siradakiOgrenciDomain.setId(veriler.getInt("id"));
				siradakiOgrenciDomain.setTcNo(veriler.getString("tcNo"));
				siradakiOgrenciDomain.setAdi(veriler.getString("adi"));
				siradakiOgrenciDomain.setSoyadi(veriler.getString("soyadi"));
				siradakiOgrenciDomain.setTarih(veriler.getString("tarih"));
				siradakiOgrenciDomain.setVeliAdi(veriler.getString("veliAdi"));
				siradakiOgrenciDomain.setTelefon(veriler.getString("telefon"));
				siradakiOgrenciDomain.setAdres(veriler.getString("adres"));
				siradakiOgrenciDomain.setOnKayit(veriler.getString("onKayit"));
				siradakiOgrenciDomain.setTaksit(veriler.getString("taksit"));

				liste.add(siradakiOgrenciDomain);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static List<OgrenciIslemleriDomain> bul(String tcno) {

		List<OgrenciIslemleriDomain> liste = new ArrayList<OgrenciIslemleriDomain>();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM ogrenci WHERE tcno LIKE ?");

			sorgu.setString(1, tcno);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {
				OgrenciIslemleriDomain siradakiOgrenciDomain = new OgrenciIslemleriDomain();

				siradakiOgrenciDomain.setId(rs.getInt("id"));
				siradakiOgrenciDomain.setTcNo(rs.getString("tcno"));
				siradakiOgrenciDomain.setAdi(rs.getString("adi"));
				siradakiOgrenciDomain.setSoyadi(rs.getString("soyadi"));
				siradakiOgrenciDomain.setTarih(rs.getString("tarih"));
				siradakiOgrenciDomain.setVeliAdi(rs.getString("veliAdi"));
				siradakiOgrenciDomain.setTelefon(rs.getString("telefon"));
				siradakiOgrenciDomain.setAdres(rs.getString("adres"));

				liste.add(siradakiOgrenciDomain);

			}

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return liste;
	}

	public static OgrenciIslemleriDomain tcnoyaGoreBul(String tcno) {

		OgrenciIslemleriDomain bulunanUrunDomain = new OgrenciIslemleriDomain();

		Connection con = ConnectionToDb.getConnection();

		try {
			PreparedStatement sorgu = con.prepareStatement("SELECT * FROM ogrenci WHERE tcNo = ?");

			sorgu.setString(1, tcno);

			ResultSet rs = sorgu.executeQuery();

			while (rs.next()) {

				bulunanUrunDomain.setId(rs.getInt("id"));
				bulunanUrunDomain.setAdi(rs.getString("adi"));
				bulunanUrunDomain.setSoyadi(rs.getString("soyadi"));
				bulunanUrunDomain.setTarih(rs.getString("tarih"));
				bulunanUrunDomain.setVeliAdi(rs.getString("veliAdi"));
				bulunanUrunDomain.setTelefon(rs.getString("telefon"));
				bulunanUrunDomain.setAdres(rs.getString("adres"));
				bulunanUrunDomain.setOnKayit(rs.getString("onKayit"));
				bulunanUrunDomain.setTaksit(rs.getString("taksit"));

			}

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bulunanUrunDomain;
	}

	public static void duzenle(OgrenciIslemleriDomain duzenlenecekOgrenciDomain) {

		Connection con = ConnectionToDb.getConnection();
		try {
			PreparedStatement sorgu = con.prepareStatement(
					"UPDATE ogrenci SET tcNo = ?, adi = ?, soyadi = ?, tarih = ?, veliAdi = ?, telefon = ?, adres = ?  WHERE id = ?");

			sorgu.setString(1, duzenlenecekOgrenciDomain.getTcNo());
			sorgu.setString(2, duzenlenecekOgrenciDomain.getAdi());
			sorgu.setString(3, duzenlenecekOgrenciDomain.getSoyadi());
			sorgu.setString(4, duzenlenecekOgrenciDomain.getTarih());
			sorgu.setString(5, duzenlenecekOgrenciDomain.getVeliAdi());
			sorgu.setString(6, duzenlenecekOgrenciDomain.getTelefon());
			sorgu.setString(7, duzenlenecekOgrenciDomain.getAdres());
			sorgu.setInt(8, duzenlenecekOgrenciDomain.getId());

			sorgu.executeUpdate();

			sorgu.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
