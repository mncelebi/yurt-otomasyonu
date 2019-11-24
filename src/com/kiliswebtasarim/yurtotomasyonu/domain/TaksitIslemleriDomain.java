package com.kiliswebtasarim.yurtotomasyonu.domain;

import java.sql.Timestamp;

public class TaksitIslemleriDomain {

	private int id;
	private String tcno;
	private String adisoyadi;
	private String taksit;
	private double miktar;
	private String aciklama;
	private Timestamp tarih;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getAdisoyadi() {
		return adisoyadi;
	}

	public void setAdisoyadi(String adisoyadi) {
		this.adisoyadi = adisoyadi;
	}

	public String getTaksit() {
		return taksit;
	}

	public void setTaksit(String taksit) {
		this.taksit = taksit;
	}

	public double getMiktar() {
		return miktar;
	}

	public void setMiktar(double miktar) {
		this.miktar = miktar;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public Timestamp getTarih() {
		return tarih;
	}

	public void setTarih(Timestamp tarih) {
		this.tarih = tarih;
	}

	@Override
	public String toString() {
		return adisoyadi;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, tcno, adisoyadi, taksit, miktar, aciklama, tarih };

		return listveriler;
	}

}
