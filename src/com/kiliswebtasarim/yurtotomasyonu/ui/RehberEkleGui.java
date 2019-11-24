package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.RehberDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.RehberDomain;

public class RehberEkleGui extends JDialog {

	public RehberEkleGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Rehber Kayýt");
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

		panel_2.setBorder(BorderFactory.createTitledBorder("Ýletiþim Bilgileri"));

		JLabel bolumLabel = new JLabel("B\u00F6l\u00FCm :");
		bolumLabel.setBounds(43, 61, 84, 28);
		panel_2.add(bolumLabel);

		JTextField bolumField = new JTextField();
		bolumField.setBounds(137, 61, 220, 28);
		panel_2.add(bolumField);
		bolumField.setColumns(10);

		JLabel adisoyadiLabel = new JLabel("Ad Soyad:");
		adisoyadiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adisoyadiLabel);

		JTextField adisoyadiField = new JTextField();
		adisoyadiField.setBounds(137, 103, 220, 28);
		panel_2.add(adisoyadiField);
		adisoyadiField.setColumns(10);

		JLabel telefonLabel = new JLabel("Telefon :");
		telefonLabel.setBounds(43, 142, 84, 28);
		panel_2.add(telefonLabel);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(137, 142, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		JTextField gsm1Field = new JTextField();
		gsm1Field.setBounds(137, 181, 220, 28);
		panel_2.add(gsm1Field);
		gsm1Field.setColumns(10);

		JTextField gsm2Field = new JTextField();
		gsm2Field.setBounds(137, 220, 220, 28);
		panel_2.add(gsm2Field);
		gsm2Field.setColumns(10);

		JTextField eMailField = new JTextField();
		eMailField.setBounds(137, 259, 220, 28);
		panel_2.add(eMailField);
		eMailField.setColumns(10);

		JLabel lblGsm = new JLabel("Gsm 1 :");
		lblGsm.setBounds(43, 188, 46, 14);
		panel_2.add(lblGsm);

		JLabel lblGsm_1 = new JLabel("Gsm 2 :");
		lblGsm_1.setBounds(43, 227, 46, 14);
		panel_2.add(lblGsm_1);

		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setBounds(43, 266, 46, 14);
		panel_2.add(lblEmail);

		String dizi[] = { "ID", "TC NO", "ADI", "SOYADI", "TELEFON" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				RehberDomain kisiDomain = new RehberDomain();

				kisiDomain.setBolum(bolumField.getText());
				kisiDomain.setAdisoyadi(adisoyadiField.getText());
				kisiDomain.setTelefon(telefonField.getText());
				kisiDomain.setGsm1(gsm1Field.getText());
				kisiDomain.setGsm2(gsm2Field.getText());
				kisiDomain.setMail(eMailField.getText());

				RehberDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");
				
				dispose();

			}
		});

		return anaJPanel;
	}
}