package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.kiliswebtasarim.yurtotomasyonu.db.KasaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.OgrenciKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.db.TaksitIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.KasaIslemleriDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.OgrenciIslemleriDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.TaksitIslemleriDomain;

public class TaksitEkleGui extends JDialog {

	public TaksitEkleGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Taksit Ekle");
		setSize(486, 447);
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
		JButton kaydetButon = new JButton("KAYDET", kaydetIcon);
		panel_1.add(kaydetButon);

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");
		JButton btnNewButton_1 = new JButton("  ÝPTAL  ", iptalIcon);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Bilgiler"));

		JLabel bolumLabel = new JLabel("Tc No :");
		bolumLabel.setBounds(43, 61, 84, 28);
		panel_2.add(bolumLabel);

		JTextField bolumField = new JTextField();
		bolumField.setBounds(137, 61, 220, 28);
		panel_2.add(bolumField);
		bolumField.setColumns(10);

		JLabel adisoyadiLabel = new JLabel("Ad Soyad :");
		adisoyadiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adisoyadiLabel);

		JTextField adisoyadiField = new JTextField();
		adisoyadiField.setBounds(137, 103, 220, 28);
		panel_2.add(adisoyadiField);
		adisoyadiField.setColumns(10);

		JLabel telefonLabel = new JLabel("Taksit :");
		telefonLabel.setBounds(43, 142, 84, 28);
		panel_2.add(telefonLabel);

		JTextField gsm1Field = new JTextField();
		gsm1Field.setBounds(137, 181, 220, 28);
		panel_2.add(gsm1Field);
		gsm1Field.setColumns(10);

		JLabel lblGsm = new JLabel("Miktar :");
		lblGsm.setBounds(43, 188, 46, 14);
		panel_2.add(lblGsm);

		JLabel lblGsm_1 = new JLabel("A\u00E7\u0131klama :");
		lblGsm_1.setBounds(43, 227, 69, 14);
		panel_2.add(lblGsm_1);

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
		comboBox.setBounds(137, 142, 220, 28);
		panel_2.add(comboBox);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(137, 220, 220, 104);
		panel_2.add(scrollPane);

		ImageIcon araIcon = new ImageIcon("images/ara.png");
		JButton btnNewButton_3 = new JButton("", araIcon);
		btnNewButton_3.setBounds(367, 56, 46, 36);
		panel_2.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tcno = bolumField.getText();

				OgrenciIslemleriDomain bulunanOgrenciDomain = OgrenciKayitDao.tcnoyaGoreBul(tcno);

				if (bulunanOgrenciDomain != null) {
					adisoyadiField.setText(bulunanOgrenciDomain.getAdi() + " " + bulunanOgrenciDomain.getSoyadi());

				} else {
					JOptionPane.showMessageDialog(null, "Böyle bir kayýt yok");
				}

			}
		});

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				TaksitIslemleriDomain kisiDomain = new TaksitIslemleriDomain();

				kisiDomain.setTcno(bolumField.getText());
				kisiDomain.setAdisoyadi(adisoyadiField.getText());
				kisiDomain.setTaksit(comboBox.getSelectedItem().toString());
				kisiDomain.setMiktar(Double.parseDouble(gsm1Field.getText()));
				kisiDomain.setAciklama(textPane.getText());

				TaksitIslemleriDao.ekle(kisiDomain);

				KasaIslemleriDomain kisiDomain1 = new KasaIslemleriDomain();

				kisiDomain1.setBilgi(adisoyadiField.getText());
				kisiDomain1.setAciklama(textPane.getText());
				kisiDomain1.setMiktar(Double.parseDouble(gsm1Field.getText()));

				KasaIslemleriDao.ekle(kisiDomain1);
				JOptionPane.showMessageDialog(null, "kasaya eklendý ve kayýt gerçekleþti");

			}
		});

		return anaJPanel;
	}
}
