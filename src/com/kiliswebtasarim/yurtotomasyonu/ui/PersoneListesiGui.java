package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.BorderLayout;
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

import com.kiliswebtasarim.yurtotomasyonu.db.PersonelIslemleriDao;
import com.kiliswebtasarim.yurtotomasyonu.domain.PersonelIslemleriDomain;

public class PersoneListesiGui extends JDialog {

	public PersoneListesiGui() {

		initPencere();
	}

	private void initPencere() {
		JPanel panel = initPanel();
		getContentPane().add(panel);
		setTitle("Personel Listesi");
		setSize(950, 400);
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

		ImageIcon silIcon = new ImageIcon("images/çöp.png");
		JButton btnNewButton_1 = new JButton("    SÝL    ", silIcon);
		panel_1.add(btnNewButton_1);

		ImageIcon iptalIcon = new ImageIcon("images/iptal.png");
		JButton btnNewButton_2 = new JButton("  ÝPTAL  ", iptalIcon);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panel_2 = new JPanel();
		anaJPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		panel_2.setBorder(BorderFactory.createTitledBorder("Personel Listesi"));

		String dizi[] = { "ID", "TC NO", "ADI", "SOYADI", "DOÐUM TARÝHÝ", "MAAÞI", "TELEFON", "ADRES", "SSK NO" };
		DefaultTableModel model = new DefaultTableModel(dizi, 0);
		JTable table = new JTable(model);
		JScrollPane listePane = new JScrollPane(table);
		listePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listePane.setBounds(10, 55, 924, 272);
		panel_2.add(listePane);
		for (PersonelIslemleriDomain list : PersonelIslemleriDao.listele()) {

			model.addRow(list.getObjects());
		}

		JLabel lblAra = new JLabel("TC No :");
		lblAra.setBounds(677, 20, 46, 14);
		panel_2.add(lblAra);

		JTextField textField = new JTextField();
		textField.setBounds(718, 17, 148, 20);
		panel_2.add(textField);
		textField.setColumns(10);

		ImageIcon araIcon = new ImageIcon("images/ara.png");
		JButton btnNewButton_3 = new JButton("", araIcon);
		btnNewButton_3.setBounds(876, 11, 46, 34);
		panel_2.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				String aranacakIsimString = textField.getText();
				for (PersonelIslemleriDomain list : PersonelIslemleriDao.bul(aranacakIsimString)) {

					model.addRow(list.getObjects());
				}

			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PersonelIslemleriDomain silinecekDomain = new PersonelIslemleriDomain();

				int secilenSatir = table.getSelectedRow();
				int id = (Integer) model.getValueAt(secilenSatir, 0);
				silinecekDomain.setId(id);

				PersonelIslemleriDao.sil(silinecekDomain);

				int satirSayisi = model.getRowCount();

				for (int i = 0; i < satirSayisi; i++) {
					model.removeRow(0);
				}

				List<PersonelIslemleriDomain> listele2 = PersonelIslemleriDao.listele();
				for (PersonelIslemleriDomain yenilistDomain : listele2) {
					model.addRow(yenilistDomain.getObjects());
				}
				JOptionPane.showMessageDialog(null, "silme iþlemi baþarýlý");

			}
		});

		return anaJPanel;
	}
}
