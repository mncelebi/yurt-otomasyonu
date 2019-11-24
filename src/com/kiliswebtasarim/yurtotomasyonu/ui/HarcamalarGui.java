package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.CariIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.HarcamalarDao;
import com.kiliswebtasarim.yurtotomasyonu.db.KasaIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.HarcamalarDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.KasaIslemleriDomain;

public class HarcamalarGui extends JDialog {

	public HarcamalarGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Harcamalar");
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

		ImageIcon kaydetIcon = new ImageIcon("images/kaydet1.png");
		JButton kaydetButon = new JButton("KAYDET", kaydetIcon);
		panel_1.add(kaydetButon);

		ImageIcon silIcon = new ImageIcon("images/çöp.png");
		JButton silButon = new JButton("    SÝL    ", silIcon);
		panel_1.add(silButon);

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");
		JButton btnNewButton_1 = new JButton("  ÝPTAL  ", iptalIcon);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Bilgiler"));

		JLabel tcNoLabel = new JLabel("Cari Ad\u0131 :");
		tcNoLabel.setBounds(43, 61, 84, 28);
		panel_2.add(tcNoLabel);

		JLabel adiLabel = new JLabel("Cari \u00DCnvan\u0131 :");
		adiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adiLabel);

		JTextField adiField = new JTextField();
		adiField.setBounds(137, 103, 220, 28);
		panel_2.add(adiField);
		adiField.setColumns(10);

		JLabel soyadiLabel = new JLabel("\u0130\u015Flem T\u00FCr\u00FC :");
		soyadiLabel.setBounds(43, 142, 84, 28);
		panel_2.add(soyadiLabel);

		JTextField soyadiField = new JTextField();
		soyadiField.setBounds(137, 142, 220, 28);
		panel_2.add(soyadiField);
		soyadiField.setColumns(10);

		JLabel telefonLabel = new JLabel("Miktar :");
		telefonLabel.setBounds(43, 181, 84, 28);
		panel_2.add(telefonLabel);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(137, 181, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		String dizi[] = { "ID", "CARÝ ADI", "ÜNVAN", "ÝÞLEM TÜRÜ", "MÝKTAR", "AÇIKLAMA" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(387, 45, 497, 256);
		panel_2.add(listePane);

		for (HarcamalarDomain list : HarcamalarDao.listele()) {

			model.addRow(list.getObjects());
		}

		JLabel lblnKaytListesi = new JLabel("Harcama Listesi");
		lblnKaytListesi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnKaytListesi.setBounds(575, 11, 115, 28);
		panel_2.add(lblnKaytListesi);

		JLabel lblAklama = new JLabel("A\u00E7\u0131klama :");
		lblAklama.setBounds(43, 220, 70, 22);
		panel_2.add(lblAklama);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(137, 220, 220, 81);
		panel_2.add(scrollPane);

		JComboBox comboBox = new JComboBox(CariIslemleriDao.listele().toArray());
		comboBox.setBounds(137, 61, 220, 28);
		panel_2.add(comboBox);

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}
		});

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HarcamalarDomain kisiDomain = new HarcamalarDomain();

				kisiDomain.setAdi(comboBox.getSelectedItem().toString());
				kisiDomain.setUnvani(adiField.getText());
				kisiDomain.setIslemturu(soyadiField.getText());
				kisiDomain.setMiktar(Double.parseDouble(telefonField.getText()));
				kisiDomain.setAciklama(textPane.getText());

				HarcamalarDao.ekle(kisiDomain);

				KasaIslemleriDomain kisiDomain1 = new KasaIslemleriDomain();

				kisiDomain1.setBilgi(comboBox.getSelectedItem().toString());
				kisiDomain1.setAciklama(textPane.getText());
				kisiDomain1.setMiktar(-Double.parseDouble(telefonField.getText()));

				KasaIslemleriDao.ekle(kisiDomain1);

				JOptionPane.showMessageDialog(null, "kasadan çýkarýldý");
				dispose();
				new HarcamalarGui();

			}
		});

		silButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HarcamalarDomain silinecekDomain = new HarcamalarDomain();

				int secilenSatir = table.getSelectedRow();
				int id = (Integer) model.getValueAt(secilenSatir, 0);
				silinecekDomain.setId(id);

				HarcamalarDao.sil(silinecekDomain);

				int satirSayisi = model.getRowCount();

				for (int i = 0; i < satirSayisi; i++) {
					model.removeRow(0);
				}

				List<HarcamalarDomain> listele2 = HarcamalarDao.listele();
				for (HarcamalarDomain yenilistDomain : listele2) {
					model.addRow(yenilistDomain.getObjects());
				}
				JOptionPane.showMessageDialog(null, "silme iþlemi baþarýlý");

			}
		});

		return anaJPanel;
	}
}
