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
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.kiliswebtasarim.yurtotomasyonu.db.CariIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.db.RehberDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.CariIslemleriDomain;
import com.kiliswebtasarim.yurtotomasyonu.domain.RehberDomain;

public class CariDuzenleGui extends JDialog {

	public CariDuzenleGui() {
		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Cari Düzenle");
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

		ImageIcon guncelleIcon = new ImageIcon("images/guncelle.png");
		JButton kaydetButon = new JButton("G\u00DCNCELLE", guncelleIcon);
		panel_1.add(kaydetButon);

		ImageIcon silIcon = new ImageIcon("images/çöp.png");
		JButton silButon = new JButton("    SÝL    ", silIcon);
		panel_1.add(silButon);

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
		cariLabel.setBounds(10, 86, 101, 28);
		panel_2.add(cariLabel);

		JLabel miktarLabel = new JLabel("Cari Ünvaný :");
		miktarLabel.setBounds(10, 125, 101, 28);
		panel_2.add(miktarLabel);

		JTextField harcamaMiktariField = new JTextField();
		harcamaMiktariField.setBounds(131, 86, 220, 28);
		panel_2.add(harcamaMiktariField);
		harcamaMiktariField.setColumns(10);

		JLabel telefonLabel = new JLabel("Telefon :");
		telefonLabel.setBounds(10, 164, 84, 25);
		panel_2.add(telefonLabel);

		JTextField bolumuField = new JTextField();
		bolumuField.setBounds(131, 125, 220, 28);
		panel_2.add(bolumuField);
		bolumuField.setColumns(10);

		JTextField telefonField = new JTextField();
		telefonField.setBounds(131, 164, 220, 28);
		panel_2.add(telefonField);
		telefonField.setColumns(10);

		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(131, 203, 220, 86);
		panel_2.add(scrollPane);

		JLabel aciklamaLabel = new JLabel("A\u00E7\u0131klama :");
		aciklamaLabel.setBounds(10, 200, 84, 28);
		panel_2.add(aciklamaLabel);

		JLabel cariNoLabel = new JLabel("Cari No :");
		cariNoLabel.setBounds(10, 52, 56, 14);
		panel_2.add(cariNoLabel);

		JTextField textField_2 = new JTextField();
		textField_2.setBounds(131, 45, 220, 28);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		String dizi[] = { "ID", "CARÝ NO", "ADI SOYADI", "ÜNVAN", "TELEFON", "AÇIKLAMA", "TARÝH" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(387, 45, 497, 243);
		panel_2.add(listePane);
		
		for (CariIslemleriDomain list : CariIslemleriDao.listele()) {

			model.addRow(list.getObjects());
		}

		JLabel lblnKaytListesi = new JLabel("Cari Listesi");
		lblnKaytListesi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnKaytListesi.setBounds(575, 11, 115, 28);
		panel_2.add(lblnKaytListesi);
		
		silButon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CariIslemleriDomain silinecekDomain = new CariIslemleriDomain();

				int secilenSatir = table.getSelectedRow();
				int id = (Integer) model.getValueAt(secilenSatir, 0);
				silinecekDomain.setId(id);

				CariIslemleriDao.sil(silinecekDomain);

				int satirSayisi = model.getRowCount();

				for (int i = 0; i < satirSayisi; i++) {
					model.removeRow(0);
				}

				List<CariIslemleriDomain> listele2 = CariIslemleriDao.listele();
				for (CariIslemleriDomain yenilistDomain : listele2) {
					model.addRow(yenilistDomain.getObjects());
				}
				JOptionPane.showMessageDialog(null, "silme iþlemi baþarýlý");
				
			}
		});

		return anaJPanel;
	}
}
