package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.KasaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.KasaIslemleriDomain;

public class KasaGirisGui extends JDialog {

	public KasaGirisGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Kasa");
		setSize(900, 400);
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

		ImageIcon kaydetIcon = new ImageIcon("images/kasaekle.png");
		JButton kaydetButon = new JButton("  KASAYA EKLE  ", kaydetIcon);
		panel_1.add(kaydetButon);

		ImageIcon silIcon = new ImageIcon("images/kasacikar.png");
		JButton silButon = new JButton("KASADAN \u00C7IKAR", silIcon);
		panel_1.add(silButon);

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Kasa Ýþlemleri"));

		JLabel tcNoLabel = new JLabel("Bilgi :");
		tcNoLabel.setBounds(43, 61, 84, 28);
		panel_2.add(tcNoLabel);

		JTextField tcNoField = new JTextField();
		tcNoField.setBounds(137, 61, 220, 28);
		panel_2.add(tcNoField);
		tcNoField.setColumns(10);

		JLabel adiLabel = new JLabel("A\u00E7\u0131klama :");
		adiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adiLabel);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(137, 103, 220, 67);
		panel_2.add(scrollPane);

		JLabel telefonLabel = new JLabel("Miktar (TL) :");
		telefonLabel.setBounds(43, 181, 84, 28);
		panel_2.add(telefonLabel);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(137, 181, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		String dizi[] = { "ID", "BÝLGÝ", "AÇIKLAMA", "MÝKTAR", "TARÝH" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(387, 45, 497, 243);
		panel_2.add(listePane);

		for (KasaIslemleriDomain list : KasaIslemleriDao.listele()) {

			model.addRow(list.getObjects());
		}

		JLabel lblnKaytListesi = new JLabel("\u0130\u015Flem Listesi");
		lblnKaytListesi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnKaytListesi.setBounds(575, 11, 115, 28);
		panel_2.add(lblnKaytListesi);

		JLabel lblBakiye = new JLabel("BAK\u0130YE");
		lblBakiye.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBakiye.setBounds(189, 230, 101, 28);
		panel_2.add(lblBakiye);

		JLabel kasaDurumuJLabel = new JLabel("0 TL");
		kasaDurumuJLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		kasaDurumuJLabel.setBounds(199, 260, 89, 28);
		panel_2.add(kasaDurumuJLabel);
		kasaDurumuJLabel.setText(Double.toString(KasaIslemleriDao.kasaDurumu())+" TL");

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KasaIslemleriDomain kisiDomain = new KasaIslemleriDomain();

				kisiDomain.setBilgi(tcNoField.getText());
				kisiDomain.setAciklama(textPane.getText());
				kisiDomain.setMiktar(Double.parseDouble(telefonField.getText()));

				KasaIslemleriDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kasaya eklendi");

				kasaDurumuJLabel.setText(Double.toString(KasaIslemleriDao.kasaDurumu())+" TL");

				dispose();
				new KasaGirisGui();

			}
		});

		silButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KasaIslemleriDomain kisiDomain = new KasaIslemleriDomain();

				kisiDomain.setBilgi(tcNoField.getText());
				kisiDomain.setAciklama(textPane.getText());
				kisiDomain.setMiktar(-Double.parseDouble(telefonField.getText()));

				KasaIslemleriDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kasadan çýkarýldý");

				kasaDurumuJLabel.setText(Double.toString(KasaIslemleriDao.kasaDurumu())+" TL");

				dispose();
				new KasaGirisGui();

			}
		});

		return anaJPanel;
	}
}