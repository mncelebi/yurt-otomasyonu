package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;

public class PersonelDuzenleGui extends JDialog {

	public PersonelDuzenleGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Personel Düzenle");
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

		ImageIcon guncelleIcon = new ImageIcon("images/guncelle.png");
		JButton btnNewButton = new JButton("GÜNCELLE", guncelleIcon);
		panel_1.add(btnNewButton);

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");
		JButton btnNewButton_1 = new JButton("   ÝPTAL   ", iptalIcon);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Personel Bilgileri"));
		
		ImageIcon araIcon = new ImageIcon("images/ara.png");
		JButton btnNewButton_3 = new JButton("", araIcon);
		btnNewButton_3.setBounds(367, 56, 46, 36);
		panel_2.add(btnNewButton_3);

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

		JLabel lblNewLabel_2 = new JLabel("Maa\u015F\u0131 :");
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

		JLabel lblnKayt = new JLabel("SSK No :");
		lblnKayt.setBounds(43, 413, 84, 28);
		panel_2.add(lblnKayt);

		ImageIcon yeniIcon = new ImageIcon("images/asd.jpg");
		JLabel lblNewLabel_4 = new JLabel(yeniIcon);
		lblNewLabel_4.setBounds(574, 61, 128, 128);
		panel_2.add(lblNewLabel_4);

		JTextField textField_3 = new JTextField();
		textField_3.setBounds(137, 413, 220, 28);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		return anaJPanel;
	}
}
