package com.kiliswebtasarim.yurtotomasyonu.domain;

import java.sql.Timestamp;

public class KasaIslemleriDomain {

	private int id;
	private String bilgi;
	private String aciklama;
	private double miktar;
	private Timestamp zaman;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBilgi() {
		return bilgi;
	}

	public void setBilgi(String bilgi) {
		this.bilgi = bilgi;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public double getMiktar() {
		return miktar;
	}

	public void setMiktar(double miktar) {
		this.miktar = miktar;
	}

	public Timestamp getZaman() {
		return zaman;
	}

	public void setZaman(Timestamp zaman) {
		this.zaman = zaman;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return aciklama;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, bilgi, aciklama, miktar, zaman };

		return listveriler;
	}

}
