package com.kiliswebtasarim.yurtotomasyonu.domain;

public class PersonelIslemleriDomain {

	private int id;
	private String tcNo;
	private String adi;
	private String soyadi;
	private String tarih;
	private String maas;
	private String telefon;
	private String adres;
	private String sskno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getSoyadi() {
		return soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getMaas() {
		return maas;
	}

	public void setMaas(String maas) {
		this.maas = maas;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getSskno() {
		return sskno;
	}

	public void setSskno(String sskno) {
		this.sskno = sskno;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, tcNo, adi, soyadi, tarih, maas, telefon, adres, sskno };

		return listveriler;
	}

}
