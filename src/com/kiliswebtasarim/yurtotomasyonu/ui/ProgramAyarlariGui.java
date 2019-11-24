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

public class ProgramAyarlariGui extends JDialog {
	private JTextField textField;

	public ProgramAyarlariGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Program Ayarlarý");
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

		ImageIcon kaydetIcon = new ImageIcon("images/arkaplan.png");
		JButton resimButon = new JButton("ARKAPLAN", kaydetIcon);
		panel_1.add(resimButon);

		ImageIcon kaydetIcon1 = new ImageIcon("images/guncelle.png");
		JButton kaydetButon = new JButton("GÜNCELLE", kaydetIcon1);
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

		panel_2.setBorder(BorderFactory.createTitledBorder("Ayarlar"));

		JLabel lblEskiifre = new JLabel("Ana Pencere Yaz\u0131s\u0131 :");
		lblEskiifre.setBounds(83, 78, 103, 14);
		panel_2.add(lblEskiifre);

		textField = new JTextField();
		textField.setBounds(196, 75, 126, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		return anaJPanel;
	}
}