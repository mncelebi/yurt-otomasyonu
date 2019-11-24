package com.kiliswebtasarim.yurtotomasyonu.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GirisGui extends JFrame{
		
		public GirisGui(){
			
			initPencere();
			
		}
		
		private void initPencere(){
			
			add(initJpanel());
			pack();
			setTitle("");
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		private JPanel initJpanel(){
			JFrame yeni = new JFrame();
			JPanel anaPanel = new JPanel(new GridLayout(3, 2, 5, 5));
			JLabel kullaniciLabel = new JLabel("Kullan�c� Ad�   :");
			JTextField kullaniciField = new JTextField(20);
			JLabel sifreLabel = new JLabel("�ifre   :");
			final JPasswordField sifreField = new JPasswordField();
			
			ImageIcon girisIcon = new ImageIcon("images/login.png");
			JButton girisButon = new JButton("G�R��",girisIcon);
			
			getRootPane().setDefaultButton(girisButon);
			girisButon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String user = kullaniciField.getText();
					String pass = String.valueOf(sifreField.getPassword());

					if (user.equalsIgnoreCase("") && pass.equalsIgnoreCase("")) {
							
						JOptionPane.showMessageDialog(null, "Giri� Ba�ar�l� Ho�geldiniz");
						 new AnaPencereGui();
						 dispose();
					} 
					else {
						JOptionPane.showMessageDialog(null, "Giri� Ba�ar�s�z");
					}
				}
			});
				
			ImageIcon cikisIcon = new ImageIcon("images/exit.png");
			JButton cikisButon = new JButton("�IKI�",cikisIcon);
			cikisButon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			
			anaPanel.add(kullaniciLabel);
			anaPanel.add(kullaniciField);
			anaPanel.add(sifreLabel);
			anaPanel.add(sifreField);
			anaPanel.add(girisButon);
			anaPanel.add(cikisButon);
			
			return anaPanel;
					
		}

}
