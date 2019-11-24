package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YardimGui extends JDialog {

	public YardimGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Yard�m");
		setSize(900, 500);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	private JPanel initPanel() {

		JPanel anaJPanel = new JPanel(new BorderLayout());

		JPanel panel_1 = new JPanel();
		anaJPanel.add(panel_1, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Bilgilendirme"));

		JLabel bolumLabel = new JLabel("Bu Program MNCSOFT Yaz�l�m �irketi taraf�ndan yaz�lm��t�r");
		bolumLabel.setBounds(10, 23, 874, 20);
		panel_2.add(bolumLabel);

		JLabel label = new JLabel(
				"Program bir yurt otomasyonu olup yurtlar i�in gerekli bir �ok i�levi yerine getirmek �zere tasarlanm��t�r.");
		label.setBounds(10, 49, 874, 20);
		panel_2.add(label);

		JLabel label_1 = new JLabel(
				"Programda ��renci kay�t b�l�m� �n kay�t b�l�m� personel b�l�mleri kasa i�levleri gibi bir �ok i�lev yer almaktad�r.");
		label_1.setBounds(10, 72, 874, 20);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel(
				"�n kay�t b�l�m�nde gerekli yerler doldurulduktan sonra kaydet butonuna bas�larak ��renc i�in �n kay�t i�levi yap�l�r.");
		label_2.setBounds(10, 98, 874, 20);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel(
				"�n kay�t i�levi yap�lan ��renciler ��renci kay�t b�l�m�nde kesinle�tirilir E�er �n kay�t i�lvi olmayan bir ��renci var ise direk kay�tta yap�labilir.");
		label_3.setBounds(10, 123, 874, 20);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel(
				"Kayd� yap�lan ��enciler oda i�lemleri b�l�m�nde odalara yerle�tirilir.Ayr�ca ��rencilerin taksit i�lemleri b�l�m�nde taksitlerle ilgili i�lemleri yap�l�p listelettirilebilir");
		label_4.setBounds(10, 149, 874, 20);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel(
				"Personel i�lemleri b�l�m� alt�nda yurt i�in personel eklettirilip d�zenlettirilebilinir.Personel Listesinde personel listesi g�r�n�r ayr�ca aratt�r�labilinir.");
		label_5.setBounds(10, 172, 874, 20);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel(
				"Yurt i�in gerekli olan yemek listesi  bu b�l�m ba�l��� alt�nda listelenir ve ekleme i�lemleri yap�l�r.");
		label_6.setBounds(10, 198, 874, 20);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel(
				"Rehber b�l�m� ba�l��� alt�nda gerekli alanlar doldurularak ekleme silme i�lemleri yap�larak ileti�im adreslerini ekletilebilir veya sildirilebilinir.");
		label_7.setBounds(10, 321, 874, 20);
		panel_2.add(label_7);

		JLabel label_8 = new JLabel(
				"Kasa ��lemleri b�l�m�nde gerekli harcacmalar kasaya para girdisi ��kt�s� i�lemleri gerekli yerleri doldurarak yap�l�r bakiye b�l�m�nde kasadaki para miktar� listelenir");
		label_8.setBounds(10, 347, 874, 20);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel("��k�� butonu ile programdan ��k�� yap�lmaktad�r.");
		label_9.setBounds(10, 370, 874, 20);
		panel_2.add(label_9);

		JLabel label_11 = new JLabel(
				"Raporlar b�l�m� ba�l��� alt�nda gerekli olan raporlama i�lemleri yap�l�r ve listelenir");
		label_11.setBounds(10, 296, 874, 20);
		panel_2.add(label_11);

		JLabel label_12 = new JLabel("Yard�m butonuna basarak gerekli bilgilere ula��lmaktad�r.");
		label_12.setBounds(10, 270, 874, 20);
		panel_2.add(label_12);

		JLabel label_13 = new JLabel(
				"Kullan�c� i�lemleri ba�l��� alt�nda ana pencerede bulunan resim ve yazz� de�i�tirlebilinir hgale getirilmi�tir.");
		label_13.setBounds(10, 247, 874, 20);
		panel_2.add(label_13);

		JLabel label_14 = new JLabel(
				"Cari i�lemleri ba�l��� alt�nda eklemeler yap�larak harcama b�l�m� i�in cari eklettirilir.Harcamalar b�l�m�nde kasadan para ��kar�l�r. ");
		label_14.setBounds(10, 221, 874, 20);
		panel_2.add(label_14);

		JLabel label_30 = new JLabel("Daha fazla bilgi i�in muhammednurullahcelebi@gmail.com a mail atabilirsiniz");
		label_30.setBounds(10, 421, 874, 20);
		panel_2.add(label_30);

		panel_2.setBackground(Color.WHITE);

		return anaJPanel;
	}
}