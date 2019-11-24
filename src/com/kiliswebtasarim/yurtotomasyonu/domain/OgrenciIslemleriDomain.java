package com.kiliswebtasarim.yurtotomasyonu.domain;

public class OgrenciIslemleriDomain {

	private int id;
	private String tcNo;
	private String adi;
	private String soyadi;
	private String tarih;
	private String veliAdi;
	private String telefon;
	private String adres;
	private String onKayit;
	private String taksit;

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

	public String getVeliAdi() {
		return veliAdi;
	}

	public void setVeliAdi(String veliAdi) {
		this.veliAdi = veliAdi;
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

	public String getOnKayit() {
		return onKayit;
	}

	public void setOnKayit(String onKayit) {
		this.onKayit = onKayit;
	}

	public String getTaksit() {
		return taksit;
	}

	public void setTaksit(String taksit) {
		this.taksit = taksit;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi + " " + soyadi;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, tcNo, adi, soyadi, tarih, veliAdi, telefon, adres, onKayit, taksit };

		return listveriler;
	}

}
