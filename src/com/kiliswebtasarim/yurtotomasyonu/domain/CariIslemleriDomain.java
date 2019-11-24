package com.kiliswebtasarim.yurtotomasyonu.domain;

import java.sql.Timestamp;

public class CariIslemleriDomain {

	private int id;
	private String numara;
	private String adisoyadi;
	private String unvani;
	private String telefon;
	private String aciklama;
	private Timestamp tarih;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return numara;
	}

	public void setNo(String no) {
		this.numara = no;
	}

	public String getAdisoyadi() {
		return adisoyadi;
	}

	public void setAdisoyadi(String adisoyadi) {
		this.adisoyadi = adisoyadi;
	}

	public String getUnvani() {
		return unvani;
	}

	public void setUnvani(String unvani) {
		this.unvani = unvani;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
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
		// TODO Auto-generated method stub
		return adisoyadi;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, numara, adisoyadi, unvani, telefon, aciklama, tarih };

		return listveriler;
	}

}
