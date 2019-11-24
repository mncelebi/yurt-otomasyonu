package com.kiliswebtasarim.yurtotomasyonu.test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.kiliswebtasarim.yurtotomasyonu.db.CariIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.HarcamalarDao;
import com.kiliswebtasarim.yurtotomasyonu.db.KasaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.OdaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.OgrenciKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.db.OnKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.db.PersonelIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.RehberDao;
import com.kiliswebtasarim.yurtotomasyonu.db.TaksitIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.YemekIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.ui.GirisGui;

public class Test {

	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		OnKayitDao.tabloyuOlustur();
		RehberDao.tabloyuOlustur();
		OgrenciKayitDao.tabloyuOlustur();
		KasaIslemleriDao.tabloyuOlustur();
		CariIslemleriDao.tabloyuOlustur();
		PersonelIslemleriDao.tabloyuOlustur();
		YemekIslemleriDao.tabloyuOlustur();
		HarcamalarDao.tabloyuOlustur();
		TaksitIslemleriDao.tabloyuOlustur();
		OdaIslemleriDao.tabloyuOlustur();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				new GirisGui();

			}
		});

	}

}
