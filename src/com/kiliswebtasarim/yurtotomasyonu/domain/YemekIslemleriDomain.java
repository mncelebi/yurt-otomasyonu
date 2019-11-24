package com.kiliswebtasarim.yurtotomasyonu.domain;

public class YemekIslemleriDomain {

	private int id;
	private String tarih;
	private String yemek1;
	private String yemek2;
	private String yemek3;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public String getYemek1() {
		return yemek1;
	}

	public void setYemek1(String yemek1) {
		this.yemek1 = yemek1;
	}

	public String getYemek2() {
		return yemek2;
	}

	public void setYemek2(String yemek2) {
		this.yemek2 = yemek2;
	}

	public String getYemek3() {
		return yemek3;
	}

	public void setYemek3(String yemek3) {
		this.yemek3 = yemek3;
	}

	@Override
	public String toString() {

		return yemek1;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id,tarih, yemek1, yemek2, yemek3 };

		return listveriler;
	}

}
