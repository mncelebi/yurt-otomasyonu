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

import com.kiliswebtasarim.yurtotomasyonu.db.YemekIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.YemekIslemleriDomain;
import com.toedter.calendar.JDateChooser;

public class YemekEkleGui extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	public YemekEkleGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Yemek Listesi");
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

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Yemek Ekle"));

		JLabel adiLabel = new JLabel("Tarih :");
		adiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adiLabel);

		JDateChooser tarih = new JDateChooser();
		tarih.setBounds(137, 103, 220, 28);
		panel_2.add(tarih);

		JLabel telefonLabel = new JLabel("Yemek 1 :");
		telefonLabel.setBounds(43, 142, 84, 28);
		panel_2.add(telefonLabel);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(137, 142, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		textField = new JTextField();
		textField.setBounds(137, 181, 220, 28);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(137, 220, 220, 28);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblGsm = new JLabel("Yemek 2 :");
		lblGsm.setBounds(43, 188, 56, 14);
		panel_2.add(lblGsm);

		JLabel lblGsm_1 = new JLabel("Yemek 3 :");
		lblGsm_1.setBounds(43, 227, 56, 14);
		panel_2.add(lblGsm_1);

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				YemekIslemleriDomain kisiDomain = new YemekIslemleriDomain();
				kisiDomain.setTarih(tarih.getDate().toString());
				kisiDomain.setYemek1(telefonField.getText());
				kisiDomain.setYemek2(textField.getText());
				kisiDomain.setYemek3(textField_1.getText());
				;

				YemekIslemleriDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");
			}
		});
		
		

		return anaJPanel;
	}
}
