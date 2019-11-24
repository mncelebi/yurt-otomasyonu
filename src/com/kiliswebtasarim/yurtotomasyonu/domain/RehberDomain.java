package com.kiliswebtasarim.yurtotomasyonu.domain;

public class RehberDomain {

	private int id;
	private String bolum;
	private String adisoyadi;
	private String telefon;
	private String gsm1;
	private String gsm2;
	private String mail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getAdisoyadi() {
		return adisoyadi;
	}

	public void setAdisoyadi(String adisoyadi) {
		this.adisoyadi = adisoyadi;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getGsm1() {
		return gsm1;
	}

	public void setGsm1(String gsm1) {
		this.gsm1 = gsm1;
	}

	public String getGsm2() {
		return gsm2;
	}

	public void setGsm2(String gsm2) {
		this.gsm2 = gsm2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return gsm2;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, bolum, adisoyadi, telefon, gsm1, gsm2, mail };

		return listveriler;
	}

}
