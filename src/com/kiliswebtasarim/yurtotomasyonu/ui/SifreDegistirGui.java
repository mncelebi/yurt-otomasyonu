package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SifreDegistirGui extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public SifreDegistirGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Þifre Ýþlemleri");
		setSize(400, 250);
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
		JButton kaydetButon = new JButton("GÜNCELLE", guncelleIcon);
		panel_1.add(kaydetButon);

		ImageIcon silIcon = new ImageIcon("images/iptal.png");
		JButton silButon = new JButton("   \u0130PTAL   ", silIcon);
		panel_1.add(silButon);
		silButon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Þifre Deðiþikliði"));

		JLabel lblEskiifre = new JLabel("Eski \u015Eifre :");
		lblEskiifre.setBounds(83, 45, 73, 14);
		panel_2.add(lblEskiifre);

		JLabel lblYeniifre = new JLabel("Yeni \u015Eifre :");
		lblYeniifre.setBounds(83, 86, 73, 14);
		panel_2.add(lblYeniifre);

		JLabel lblYeniifretekrar = new JLabel("Yeni \u015Eifre (Tekrar) :");
		lblYeniifretekrar.setBounds(83, 128, 104, 14);
		panel_2.add(lblYeniifretekrar);

		textField = new JTextField();
		textField.setBounds(196, 42, 126, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(196, 83, 126, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(197, 125, 125, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		return anaJPanel;
	}
}
