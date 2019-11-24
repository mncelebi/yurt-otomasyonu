package com.kiliswebtasarim.yurtotomasyonu.domain;

public class OdaIslemleriDomain {
	
	private int id;
	private String odano;
	private String adisoyadi;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOdano() {
		return odano;
	}
	public void setOdano(String odano) {
		this.odano = odano;
	}
	public String getAdisoyadi() {
		return adisoyadi;
	}
	public void setAdisoyadi(String adisoyadi) {
		this.adisoyadi = adisoyadi;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adisoyadi;
	}
	
	public Object[] getObjects() {

		Object[] listveriler = { id, odano, adisoyadi };

		return listveriler;
	}

}
