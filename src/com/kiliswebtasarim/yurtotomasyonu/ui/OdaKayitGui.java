package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.OdaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.OdaIslemleriDomain;

public class OdaKayitGui extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public OdaKayitGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Oda Ýþlemleri");
		setSize(930, 600);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

	}

	private JPanel initPanel() {
		JPanel anaJPanel = new JPanel(new BorderLayout());

		ImageIcon kaydetIcon = new ImageIcon("images/kaydet1.png");

		ImageIcon silIcon = new ImageIcon("images/çöp.png");

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Eski Oda No :");
		lblNewLabel.setBounds(30, 68, 74, 23);
		panel_2.add(lblNewLabel);

		JButton btnOdaEkle = new JButton("De\u011Fi\u015Ftir");
		btnOdaEkle.setBounds(154, 129, 91, 23);
		panel_2.add(btnOdaEkle);

		textField = new JTextField();
		textField.setBounds(104, 68, 141, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		JLabel lblOdaNo = new JLabel("Oda No :");
		lblOdaNo.setBounds(630, 70, 53, 14);
		panel_2.add(lblOdaNo);

		textField_1 = new JTextField();
		textField_1.setBounds(745, 66, 141, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblrenciAdSoyad = new JLabel("\u00D6\u011Frenci Ad\u0131 Soyad\u0131 :");
		lblrenciAdSoyad.setBounds(630, 103, 105, 14);
		panel_2.add(lblrenciAdSoyad);

		textField_2 = new JTextField();
		textField_2.setBounds(745, 97, 141, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblYeniOdaAd = new JLabel("Yeni Oda No :");
		lblYeniOdaAd.setBounds(30, 103, 78, 14);
		panel_2.add(lblYeniOdaAd);

		textField_3 = new JTextField();
		textField_3.setBounds(104, 99, 141, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		JButton btnrenciEkle = new JButton("\u00D6\u011Frenci Ekle");
		btnrenciEkle.setBounds(795, 129, 91, 23);
		panel_2.add(btnrenciEkle);

		String dizi[] = { "ID", "ODA NO", "ADI SOYADI" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(256, 68, 369, 336);
		panel_2.add(listePane);

		for (OdaIslemleriDomain list : OdaIslemleriDao.listele()) {

			model.addRow(list.getObjects());
		}

		JButton btnNewButton_1 = new JButton("113");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(80, 466, 60, 20);
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("114");
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setBounds(150, 466, 60, 20);
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("115");
		btnNewButton_3.setBackground(Color.GREEN);
		btnNewButton_3.setBounds(220, 466, 60, 20);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("116");
		btnNewButton_4.setBackground(Color.RED);
		btnNewButton_4.setBounds(290, 466, 60, 20);
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("117");
		btnNewButton_5.setBackground(Color.GREEN);
		btnNewButton_5.setBounds(360, 466, 60, 20);
		panel_2.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("118");
		btnNewButton_6.setBackground(Color.RED);
		btnNewButton_6.setBounds(430, 466, 60, 20);
		panel_2.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("119");
		btnNewButton_7.setBackground(Color.RED);
		btnNewButton_7.setBounds(500, 466, 60, 20);
		panel_2.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("120");
		btnNewButton_8.setBackground(Color.RED);
		btnNewButton_8.setBounds(570, 466, 60, 20);
		panel_2.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("121");
		btnNewButton_9.setBackground(Color.RED);
		btnNewButton_9.setBounds(640, 466, 60, 20);
		panel_2.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("122");
		btnNewButton_10.setBackground(Color.RED);
		btnNewButton_10.setBounds(710, 466, 60, 20);
		panel_2.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("123");
		btnNewButton_11.setBackground(Color.GREEN);
		btnNewButton_11.setBounds(780, 466, 60, 20);
		panel_2.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("124");
		btnNewButton_12.setBackground(Color.RED);
		btnNewButton_12.setBounds(80, 512, 60, 20);
		panel_2.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("125");
		btnNewButton_13.setBackground(Color.GREEN);
		btnNewButton_13.setBounds(150, 512, 60, 20);
		panel_2.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("126");
		btnNewButton_14.setBackground(Color.RED);
		btnNewButton_14.setBounds(220, 512, 60, 20);
		panel_2.add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("127");
		btnNewButton_15.setBackground(Color.GREEN);
		btnNewButton_15.setBounds(290, 512, 60, 20);
		panel_2.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("128");
		btnNewButton_16.setBackground(Color.GREEN);
		btnNewButton_16.setBounds(360, 512, 60, 20);
		panel_2.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("129");
		btnNewButton_17.setBackground(Color.GREEN);
		btnNewButton_17.setBounds(430, 512, 60, 20);
		panel_2.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("130");
		btnNewButton_18.setBackground(Color.RED);
		btnNewButton_18.setBounds(500, 512, 60, 20);
		panel_2.add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("131");
		btnNewButton_19.setBackground(Color.GREEN);
		btnNewButton_19.setBounds(570, 512, 60, 20);
		panel_2.add(btnNewButton_19);

		JButton btnNewButton_20 = new JButton("132");
		btnNewButton_20.setBackground(Color.RED);
		btnNewButton_20.setBounds(640, 512, 60, 20);
		panel_2.add(btnNewButton_20);

		JButton btnNewButton_21 = new JButton("133");
		btnNewButton_21.setBackground(Color.GREEN);
		btnNewButton_21.setBounds(710, 512, 60, 20);
		panel_2.add(btnNewButton_21);

		JButton btnNewButton_22 = new JButton("134");
		btnNewButton_22.setBackground(Color.GREEN);
		btnNewButton_22.setBounds(780, 512, 60, 20);
		panel_2.add(btnNewButton_22);

		JButton btnNewButton_23 = new JButton("102");
		btnNewButton_23.setBackground(Color.RED);
		btnNewButton_23.setBounds(80, 419, 60, 20);
		panel_2.add(btnNewButton_23);

		JButton btnNewButton_24 = new JButton("103");
		btnNewButton_24.setBackground(Color.GREEN);
		btnNewButton_24.setBounds(150, 419, 60, 20);
		panel_2.add(btnNewButton_24);

		JButton btnNewButton_25 = new JButton("104");
		btnNewButton_25.setBackground(Color.RED);
		btnNewButton_25.setBounds(220, 419, 60, 20);
		panel_2.add(btnNewButton_25);

		JButton btnNewButton_26 = new JButton("105");
		btnNewButton_26.setBackground(Color.GREEN);
		btnNewButton_26.setBounds(290, 419, 60, 20);
		panel_2.add(btnNewButton_26);

		JButton btnNewButton_27 = new JButton("106");
		btnNewButton_27.setBackground(Color.GREEN);
		btnNewButton_27.setBounds(360, 419, 60, 20);
		panel_2.add(btnNewButton_27);

		JButton btnNewButton_28 = new JButton("107");
		btnNewButton_28.setBackground(Color.GREEN);
		btnNewButton_28.setBounds(430, 419, 60, 20);
		panel_2.add(btnNewButton_28);

		JButton btnNewButton_29 = new JButton("108");
		btnNewButton_29.setBackground(Color.RED);
		btnNewButton_29.setBounds(500, 419, 60, 20);
		panel_2.add(btnNewButton_29);

		JButton btnNewButton_30 = new JButton("109");
		btnNewButton_30.setBackground(Color.GREEN);
		btnNewButton_30.setBounds(570, 419, 60, 20);
		panel_2.add(btnNewButton_30);

		JButton btnNewButton_31 = new JButton("110");
		btnNewButton_31.setBackground(Color.RED);
		btnNewButton_31.setBounds(640, 419, 60, 20);
		panel_2.add(btnNewButton_31);

		JButton btnNewButton_32 = new JButton("111");
		btnNewButton_32.setBackground(Color.GREEN);
		btnNewButton_32.setBounds(710, 419, 60, 20);
		panel_2.add(btnNewButton_32);

		JButton btnNewButton_33 = new JButton("112");
		btnNewButton_33.setBackground(Color.GREEN);
		btnNewButton_33.setBounds(780, 419, 60, 20);
		panel_2.add(btnNewButton_33);

		btnrenciEkle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OdaIslemleriDomain kisiDomain = new OdaIslemleriDomain();

				kisiDomain.setOdano(textField_1.getText());
				kisiDomain.setAdisoyadi(textField_2.getText());

				OdaIslemleriDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");
				dispose();
				new OdaKayitGui();
				

			}
		});
		return anaJPanel;
	}
}