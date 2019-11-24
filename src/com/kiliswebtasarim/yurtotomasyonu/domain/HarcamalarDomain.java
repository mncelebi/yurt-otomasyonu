package com.kiliswebtasarim.yurtotomasyonu.domain;

public class HarcamalarDomain {

	private int id;
	private String adi;
	private String unvani;
	private String islemturu;
	private double miktar;
	private String aciklama;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getUnvani() {
		return unvani;
	}

	public void setUnvani(String unvani) {
		this.unvani = unvani;
	}

	public String getIslemturu() {
		return islemturu;
	}

	public void setIslemturu(String islemturu) {
		this.islemturu = islemturu;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi;
	}

	public Object[] getObjects() {

		Object[] listveriler = { id, adi, unvani, islemturu, miktar, aciklama };

		return listveriler;
	}

}
