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
		setTitle("Yardým");
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

		JLabel bolumLabel = new JLabel("Bu Program MNCSOFT Yazýlým Þirketi tarafýndan yazýlmýþtýr");
		bolumLabel.setBounds(10, 23, 874, 20);
		panel_2.add(bolumLabel);

		JLabel label = new JLabel(
				"Program bir yurt otomasyonu olup yurtlar için gerekli bir çok iþlevi yerine getirmek üzere tasarlanmýþtýr.");
		label.setBounds(10, 49, 874, 20);
		panel_2.add(label);

		JLabel label_1 = new JLabel(
				"Programda öðrenci kayýt bölümü ön kayýt bölümü personel bölümleri kasa iþlevleri gibi bir çok iþlev yer almaktadýr.");
		label_1.setBounds(10, 72, 874, 20);
		panel_2.add(label_1);

		JLabel label_2 = new JLabel(
				"Ön kayýt bölümünde gerekli yerler doldurulduktan sonra kaydet butonuna basýlarak öðrenc için ön kayýt iþlevi yapýlýr.");
		label_2.setBounds(10, 98, 874, 20);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel(
				"Ön kayýt iþlevi yapýlan öðrenciler öðrenci kayýt bölümünde kesinleþtirilir Eðer ön kayýt iþlvi olmayan bir öðrenci var ise direk kayýtta yapýlabilir.");
		label_3.setBounds(10, 123, 874, 20);
		panel_2.add(label_3);

		JLabel label_4 = new JLabel(
				"Kaydý yapýlan öðenciler oda iþlemleri bölümünde odalara yerleþtirilir.Ayrýca öðrencilerin taksit iþlemleri bölümünde taksitlerle ilgili iþlemleri yapýlýp listelettirilebilir");
		label_4.setBounds(10, 149, 874, 20);
		panel_2.add(label_4);

		JLabel label_5 = new JLabel(
				"Personel iþlemleri bölümü altýnda yurt için personel eklettirilip düzenlettirilebilinir.Personel Listesinde personel listesi görünür ayrýca arattýrýlabilinir.");
		label_5.setBounds(10, 172, 874, 20);
		panel_2.add(label_5);

		JLabel label_6 = new JLabel(
				"Yurt için gerekli olan yemek listesi  bu bölüm baþlýðý altýnda listelenir ve ekleme iþlemleri yapýlýr.");
		label_6.setBounds(10, 198, 874, 20);
		panel_2.add(label_6);

		JLabel label_7 = new JLabel(
				"Rehber bölümü baþlýðý altýnda gerekli alanlar doldurularak ekleme silme iþlemleri yapýlarak iletiþim adreslerini ekletilebilir veya sildirilebilinir.");
		label_7.setBounds(10, 321, 874, 20);
		panel_2.add(label_7);

		JLabel label_8 = new JLabel(
				"Kasa Ýþlemleri bölümünde gerekli harcacmalar kasaya para girdisi çýktýsý iþlemleri gerekli yerleri doldurarak yapýlýr bakiye bölümünde kasadaki para miktarý listelenir");
		label_8.setBounds(10, 347, 874, 20);
		panel_2.add(label_8);

		JLabel label_9 = new JLabel("Çýkýþ butonu ile programdan çýkýþ yapýlmaktadýr.");
		label_9.setBounds(10, 370, 874, 20);
		panel_2.add(label_9);

		JLabel label_11 = new JLabel(
				"Raporlar bölümü baþlýðý altýnda gerekli olan raporlama iþlemleri yapýlýr ve listelenir");
		label_11.setBounds(10, 296, 874, 20);
		panel_2.add(label_11);

		JLabel label_12 = new JLabel("Yardým butonuna basarak gerekli bilgilere ulaþýlmaktadýr.");
		label_12.setBounds(10, 270, 874, 20);
		panel_2.add(label_12);

		JLabel label_13 = new JLabel(
				"Kullanýcý iþlemleri baþlýðý altýnda ana pencerede bulunan resim ve yazzý deðiþtirlebilinir hgale getirilmiþtir.");
		label_13.setBounds(10, 247, 874, 20);
		panel_2.add(label_13);

		JLabel label_14 = new JLabel(
				"Cari iþlemleri baþlýðý altýnda eklemeler yapýlarak harcama bölümü için cari eklettirilir.Harcamalar bölümünde kasadan para çýkarýlýr. ");
		label_14.setBounds(10, 221, 874, 20);
		panel_2.add(label_14);

		JLabel label_30 = new JLabel("Daha fazla bilgi için muhammednurullahcelebi@gmail.com a mail atabilirsiniz");
		label_30.setBounds(10, 421, 874, 20);
		panel_2.add(label_30);

		panel_2.setBackground(Color.WHITE);

		return anaJPanel;
	}
}