package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AnaPencereGui extends JFrame {

	private JPanel contentPane;

	public AnaPencereGui() {

		setJMenuBar(initMenu());
		setSize(1000, 700);
		setTitle("MNCSOFT YURT OTOMASYONU v1.00");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);

		ImageIcon ekleIcon = new ImageIcon("images/kayýt.png");
		JButton btnNewButton_1 = new JButton("Öðrenci Kayýt", ekleIcon);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new OgrenciKayitGui();

			}
		});

		ImageIcon onKayitIcon = new ImageIcon("images/ekle.png");
		JButton btnNewButton_2 = new JButton("Ön Kayýt", onKayitIcon);
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OnKayitGui();

			}
		});

		ImageIcon senetIcon = new ImageIcon("images/gelen senet.png");
		JButton btnNewButton_3 = new JButton("Taksit Listesi", senetIcon);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TaksitListesiGui();
				
			}
		});

		ImageIcon ogrenciListesiIcon = new ImageIcon("images/ogrenci listesi.png");
		JButton btnNewButton_4 = new JButton("Öðrenci Listesi", ogrenciListesiIcon);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OgrenciListesiGui();

			}
		});

		ImageIcon rehberIcon = new ImageIcon("images/rehber.png");
		JButton btnNewButton_5 = new JButton("Rehber", rehberIcon);
		btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RehberGui();

			}
		});

		ImageIcon yemekIcon = new ImageIcon("images/yemek1.png");
		JButton btnNewButton_6 = new JButton("Yemek Listesi", yemekIcon);
		btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new YemekListesiGui();

			}
		});

		ImageIcon yardimIcon = new ImageIcon("images/yardým.png");
		JButton btnNewButton = new JButton("Yardým", yardimIcon);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new YardimGui();
				
			}
		});

		ImageIcon cikisIcon = new ImageIcon("images/cikis.png");
		JButton btnNewButton_7 = new JButton("Çýkýþ", cikisIcon);
		btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Çýkýþ Yaptýnýz Hoþçakalýn...");
				System.exit(0);
				
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup()

						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_5, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_7, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 131,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(btnNewButton_1)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_2)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_3).addGap(12)
						.addComponent(btnNewButton_4).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton_5).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton_6).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton_7).addContainerGap(30, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JLabel yeniLabel = new JLabel("HOÞGELDÝNÝZ MUHAMMED NURULLAH ÇELEBÝ");
		panel_1.add(yeniLabel);

		ImageIcon icon = new ImageIcon("images/destek.jpg");
		JLabel resimLabel = new JLabel(icon);
		contentPane.add(resimLabel, BorderLayout.CENTER);
	}

	private JMenuBar initMenu() {
		JMenuBar menuBar = new JMenuBar();

		JMenu ogrenciIslemleri = new JMenu("Öðrenci Ýþlemleri");
		JMenuItem yeniogrenci = new JMenuItem("Yeni Öðrenci");
		yeniogrenci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OgrenciKayitGui();

			}
		});

		JMenuItem ogrenciDuzenle = new JMenuItem("Öðrenci Düzenle");
		ogrenciDuzenle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new OgrenciDuzenleGui();

			}
		});

		JMenuItem onkayit = new JMenuItem("Ön Kayýt");
		onkayit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OnKayitGui();

			}
		});

		ogrenciIslemleri.add(yeniogrenci);
		ogrenciIslemleri.add(ogrenciDuzenle);
		ogrenciIslemleri.add(onkayit);
		menuBar.add(ogrenciIslemleri);

		JMenu personelIslemleri = new JMenu("Personel Ýþlemleri");
		JMenuItem yeniPersonel = new JMenuItem("Yeni Personel");
		yeniPersonel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new YeniPersonelGui();

			}
		});

		JMenuItem personelDuzenle = new JMenuItem("Personel Düzenle");
		personelDuzenle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PersonelDuzenleGui();

			}
		});

		JMenuItem personelListesi = new JMenuItem("Personel Listesi");
		personelListesi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new PersoneListesiGui();

			}
		});

		personelIslemleri.add(yeniPersonel);
		personelIslemleri.add(personelDuzenle);
		personelIslemleri.add(personelListesi);
		menuBar.add(personelIslemleri);

		JMenu odaIslemleri = new JMenu("Oda Ýþlemleri");
		JMenuItem odaKayit = new JMenuItem("Oda Ýþlemleri");
		odaIslemleri.add(odaKayit);
		menuBar.add(odaIslemleri);
		odaKayit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OdaKayitGui();
				
			}
		});

		JMenu kasaIslemleri = new JMenu("Kasa Ýþlemleri");
		JMenuItem kasaGiris = new JMenuItem("Kasa Ýþlemleri");
		JMenuItem harcama = new JMenuItem("Harcamalar");
		JMenuItem kasaAnaliz = new JMenuItem("Kasa Analiz Raporu");
		kasaIslemleri.add(harcama);
		harcama.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new HarcamalarGui();
				
			}
		});
		kasaIslemleri.add(kasaGiris);
		kasaIslemleri.add(kasaAnaliz);
		menuBar.add(kasaIslemleri);
		kasaGiris.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new KasaGirisGui();

			}
		});

		JMenu cariIslemler = new JMenu("Cari Ýþlemleri");
		JMenuItem cariEkle = new JMenuItem("Yeni Cari");
		JMenuItem cariDuzenle = new JMenuItem("Cari Düzenle");
		JMenuItem cariHesapRapor = new JMenuItem("Cari Hesap Raporlarý");
		cariIslemler.add(cariEkle);
		cariIslemler.add(cariDuzenle);
		cariIslemler.add(cariHesapRapor);
		menuBar.add(cariIslemler);
		cariEkle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new YeniCariGui();
				
			}
		});
		
		cariDuzenle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CariDuzenleGui();
				
			}
		});

		JMenu kullaniciIslemleri = new JMenu("Kullanýcý iþlemleri");
		JMenuItem sifreDegistir = new JMenuItem("Þifre Deðiþtir");
		JMenuItem programAyarlari = new JMenuItem("Program Ayarlarý");
		kullaniciIslemleri.add(sifreDegistir);
		kullaniciIslemleri.add(programAyarlari);
		menuBar.add(kullaniciIslemleri);
		sifreDegistir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new SifreDegistirGui();
			}
		});
		programAyarlari.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ProgramAyarlariGui();
				
			}
		});
		JMenu raporlar = new JMenu("Raporlar");
		JMenuItem yurtKurallari = new JMenuItem("Yurt Kurallarý");
		JMenuItem yurtSözlesmesi = new JMenuItem("Yurt Sözleþmesi");
		JMenuItem disiplinRaporu = new JMenuItem("Disiplin Raporlarý");
		JMenuItem misafirRaporu = new JMenuItem("Misafir Raporlarý");
		JMenuItem izinRaporu = new JMenuItem("Ýzin Raporlarý");
		raporlar.add(yurtKurallari);
		raporlar.add(yurtSözlesmesi);
		raporlar.add(disiplinRaporu);
		raporlar.add(misafirRaporu);
		raporlar.add(izinRaporu);
		menuBar.add(raporlar);
		return menuBar;
	}
}
