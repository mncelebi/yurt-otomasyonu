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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.kiliswebtasarim.yurtotomasyonu.db.CariIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.CariIslemleriDomain;

public class YeniCariGui extends JDialog {

	public YeniCariGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Cari Ekle");
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
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Cari Bilgileri"));

		JLabel cariLabel = new JLabel("Cari Ad\u0131  ve Soyad\u0131 :");
		cariLabel.setBounds(43, 103, 101, 28);
		panel_2.add(cariLabel);

		JLabel miktarLabel = new JLabel("Cari Ünvaný :");
		miktarLabel.setBounds(43, 145, 101, 28);
		panel_2.add(miktarLabel);

		JTextField harcamaMiktariField = new JTextField();
		harcamaMiktariField.setBounds(154, 103, 220, 28);
		panel_2.add(harcamaMiktariField);
		harcamaMiktariField.setColumns(10);

		JLabel telefonLabel = new JLabel("Telefon :");
		telefonLabel.setBounds(43, 184, 84, 25);
		panel_2.add(telefonLabel);

		JTextField bolumuField = new JTextField();
		bolumuField.setBounds(154, 142, 220, 28);
		panel_2.add(bolumuField);
		bolumuField.setColumns(10);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(154, 181, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(154, 220, 220, 86);
		panel_2.add(scrollPane);

		JLabel aciklamaLabel = new JLabel("A\u00E7\u0131klama :");
		aciklamaLabel.setBounds(43, 223, 84, 28);
		panel_2.add(aciklamaLabel);

		JLabel cariNoLabel = new JLabel("Cari No :");
		cariNoLabel.setBounds(43, 68, 56, 14);
		panel_2.add(cariNoLabel);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(154, 61, 220, 28);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				CariIslemleriDomain kisiDomain = new CariIslemleriDomain();

				kisiDomain.setNo(textField_2.getText());
				kisiDomain.setAdisoyadi(harcamaMiktariField.getText());
				kisiDomain.setUnvani(bolumuField.getText());
				kisiDomain.setTelefon(telefonField.getText());
				kisiDomain.setAciklama(textPane.getText());

				CariIslemleriDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");

			}
		});

		return anaJPanel;
	}
}