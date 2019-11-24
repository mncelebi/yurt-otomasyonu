package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.kiliswebtasarim.yurtotomasyonu.db.OgrenciKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.db.OnKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.OgrenciIslemleriDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.OnKayitDomain;
import com.toedter.calendar.JDateChooser;

public class OgrenciKayitGui extends JDialog {

	public OgrenciKayitGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Öðrenci Kayýt");
		setSize(800, 600);
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

		ImageIcon kaydetIcon = new ImageIcon("images/kaydet1.png");
		JButton btnNewButton = new JButton("KAYDET", kaydetIcon);
		panel_1.add(btnNewButton);

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");
		JButton btnNewButton_1 = new JButton("  ÝPTAL  ", iptalIcon);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		ImageIcon araIcon = new ImageIcon("images/ara.png");
		JButton btnNewButton_3 = new JButton("", araIcon);
		btnNewButton_3.setBounds(367, 56, 46, 36);
		panel_2.add(btnNewButton_3);

		panel_2.setBorder(BorderFactory.createTitledBorder("Öðrenci Bilgileri"));

		JLabel lblAd = new JLabel("Tc No :");
		lblAd.setBounds(43, 61, 84, 28);
		panel_2.add(lblAd);

		JTextField textField = new JTextField();
		textField.setBounds(137, 61, 220, 28);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel lblSoyad = new JLabel("Ad :");
		lblSoyad.setBounds(43, 103, 84, 28);
		panel_2.add(lblSoyad);

		JTextField textField_1 = new JTextField();
		textField_1.setBounds(137, 103, 220, 28);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Soyad :");
		lblNewLabel.setBounds(43, 142, 84, 28);
		panel_2.add(lblNewLabel);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(137, 142, 220, 28);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Doðum Tarihi :");
		lblNewLabel_1.setBounds(43, 181, 84, 28);
		panel_2.add(lblNewLabel_1);

		JDateChooser tarih = new JDateChooser();
		tarih.setBounds(137, 181, 220, 28);
		panel_2.add(tarih);

		JLabel lblNewLabel_2 = new JLabel("Veli Adý :");
		lblNewLabel_2.setBounds(43, 220, 84, 28);
		panel_2.add(lblNewLabel_2);

		JTextField textField_4 = new JTextField();
		textField_4.setBounds(137, 220, 220, 28);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Telefon :");
		lblNewLabel_3.setBounds(43, 259, 84, 28);
		panel_2.add(lblNewLabel_3);

		JTextField textField_5 = new JTextField();
		textField_5.setBounds(137, 259, 220, 28);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		JButton btnEkle = new JButton("Ekle");
		btnEkle.setBounds(543, 203, 89, 23);
		panel_2.add(btnEkle);

		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.setBounds(655, 203, 89, 23);
		panel_2.add(btnTemizle);

		JLabel lblAdres = new JLabel("Adres :");
		lblAdres.setBounds(43, 331, 46, 28);
		panel_2.add(lblAdres);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(137, 298, 220, 104);
		panel_2.add(scrollPane);

		JLabel lblnKayt = new JLabel("\u00D6n Kay\u0131t :");
		lblnKayt.setBounds(43, 413, 84, 28);
		panel_2.add(lblnKayt);

		JRadioButton rdbtnVar = new JRadioButton("Var");
		rdbtnVar.setBounds(162, 416, 84, 23);
		panel_2.add(rdbtnVar);

		JRadioButton rdbtnYok = new JRadioButton("Yok");
		rdbtnYok.setBounds(268, 416, 89, 23);
		panel_2.add(rdbtnYok);

		rdbtnYok.setSelected(true);

		ButtonGroup butongrup = new ButtonGroup();
		butongrup.add(rdbtnVar);
		butongrup.add(rdbtnYok);

		ImageIcon yeniIcon = new ImageIcon("images/asd.jpg");
		JLabel lblNewLabel_4 = new JLabel(yeniIcon);
		lblNewLabel_4.setBounds(574, 61, 128, 128);
		panel_2.add(lblNewLabel_4);

		JLabel lblTaksit = new JLabel("Taksit :");
		lblTaksit.setBounds(43, 452, 46, 14);
		panel_2.add(lblTaksit);

		String[] ogundizi = new String[10];

		ogundizi[0] = "1";
		ogundizi[1] = "2";
		ogundizi[2] = "3";
		ogundizi[3] = "4";
		ogundizi[4] = "5";
		ogundizi[5] = "6";
		ogundizi[6] = "7";
		ogundizi[7] = "8";
		ogundizi[8] = "9";
		ogundizi[9] = "10";
		JComboBox comboBox = new JComboBox(ogundizi);
		comboBox.setBounds(137, 446, 220, 28);
		panel_2.add(comboBox);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OgrenciIslemleriDomain kisiDomain = new OgrenciIslemleriDomain();

				kisiDomain.setTcNo(textField.getText());
				kisiDomain.setAdi(textField_1.getText());
				kisiDomain.setSoyadi(textField_2.getText());
				kisiDomain.setTarih(tarih.getDate().toString());
				kisiDomain.setVeliAdi(textField_4.getText());
				kisiDomain.setTelefon(textField_5.getText());
				kisiDomain.setAdres(textPane.getText());
				kisiDomain.setTaksit(comboBox.getSelectedItem().toString());

				OgrenciKayitDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");

			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tcno = textField.getText();

				OnKayitDomain bulunanOgrenciDomain = OnKayitDao.tcnoyaGoreBul(tcno);

				if (bulunanOgrenciDomain != null) {
					textField_1.setText(bulunanOgrenciDomain.getAdi());
					textField_2.setText(bulunanOgrenciDomain.getSoyadi());
					textField_5.setText(bulunanOgrenciDomain.getTelefon());
					rdbtnVar.setSelected(true);

				} else {
					JOptionPane.showMessageDialog(null, "Böyle bir kayýt yok");
					rdbtnYok.setSelected(true);
				}

			}
		});

		return anaJPanel;
	}
}
