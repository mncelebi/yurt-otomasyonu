package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.OnKayitDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.OnKayitDomain;

public class OnKayitGui extends JDialog {

	public OnKayitGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Ön Kayýt");
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

		panel_2.setBorder(BorderFactory.createTitledBorder("Öðrenci Bilgileri"));

		JLabel tcNoLabel = new JLabel("Tc No :");
		tcNoLabel.setBounds(43, 61, 84, 28);
		panel_2.add(tcNoLabel);

		JTextField tcNoField = new JTextField();
		tcNoField.setBounds(137, 61, 220, 28);
		panel_2.add(tcNoField);
		tcNoField.setColumns(10);

		JLabel adiLabel = new JLabel("Ad :");
		adiLabel.setBounds(43, 103, 84, 28);
		panel_2.add(adiLabel);

		JTextField adiField = new JTextField();
		adiField.setBounds(137, 103, 220, 28);
		panel_2.add(adiField);
		adiField.setColumns(10);

		JLabel soyadiLabel = new JLabel("Soyad :");
		soyadiLabel.setBounds(43, 142, 84, 28);
		panel_2.add(soyadiLabel);

		JTextField soyadiField = new JTextField();
		soyadiField.setBounds(137, 142, 220, 28);
		panel_2.add(soyadiField);
		soyadiField.setColumns(10);

		JLabel telefonLabel = new JLabel("Telefon :");
		telefonLabel.setBounds(43, 181, 84, 28);
		panel_2.add(telefonLabel);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(137, 181, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		String dizi[] = { "ID", "TC NO", "ADI", "SOYADI", "TELEFON" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(387, 45, 497, 243);
		panel_2.add(listePane);

		for (OnKayitDomain list : OnKayitDao.listele()) {

			model.addRow(list.getObjects());
		}

		JLabel lblnKaytListesi = new JLabel("\u00D6n Kay\u0131t Listesi");
		lblnKaytListesi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnKaytListesi.setBounds(575, 11, 115, 28);
		panel_2.add(lblnKaytListesi);

		kaydetButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				OnKayitDomain kisiDomain = new OnKayitDomain();

				kisiDomain.setTcNo(tcNoField.getText());
				kisiDomain.setAdi(adiField.getText());
				kisiDomain.setSoyadi(soyadiField.getText());
				kisiDomain.setTelefon(telefonField.getText());

				OnKayitDao.ekle(kisiDomain);
				JOptionPane.showMessageDialog(null, "kayýt baþarýlý");

				dispose();
				new OnKayitGui();

			}
		});

		silButon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				OnKayitDomain silinecekDomain = new OnKayitDomain();

				int secilenSatir = table.getSelectedRow();
				int id = (Integer) model.getValueAt(secilenSatir, 0);
				silinecekDomain.setId(id);

				OnKayitDao.sil(silinecekDomain);

				int satirSayisi = model.getRowCount();

				for (int i = 0; i < satirSayisi; i++) {
					model.removeRow(0);
				}

				List<OnKayitDomain> listele2 = OnKayitDao.listele();
				for (OnKayitDomain yenilistDomain : listele2) {
					model.addRow(yenilistDomain.getObjects());
				}
				JOptionPane.showMessageDialog(null, "silme iþlemi baþarýlý");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		
		return anaJPanel;
	}
}