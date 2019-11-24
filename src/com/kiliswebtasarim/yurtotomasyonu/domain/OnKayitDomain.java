package com.kiliswebtasarim.yurtotomasyonu.domain;

public class OnKayitDomain {
	
	private int id;
	private String tcNo;
	private String adi;
	private String soyadi;
	private String telefon;
	
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
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return adi;
	}
	
	public Object [] getObjects(){
        
        Object [] listveriler = {id,tcNo,adi,soyadi,telefon};
       
        return listveriler;
  }
	

}
