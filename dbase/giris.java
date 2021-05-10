package dbase;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ad;
	private JTextField txt_sifre;
	static String ad;
	static String sifre;
	static String tur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public giris() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Kullan\u0131c\u0131 ad\u0131");
		lblNewLabel.setBounds(42, 55, 70, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setBounds(42, 90, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(124, 52, 116, 22);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		txt_sifre = new JTextField();
		txt_sifre.setBounds(124, 87, 116, 22);
		contentPane.add(txt_sifre);
		txt_sifre.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"admin", "normal", "premium"}));
		comboBox.setBounds(124, 120, 116, 22);
		contentPane.add(comboBox);
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = txt_ad.getText();
				sifre = txt_sifre.getText();
				tur=(String) comboBox.getSelectedItem();
				
	
				String sql_sorgu = "select count(idkull) as giris from kull where kull_ad='"+ad+
						"' and sifre='"+sifre+"'"+" and kull_uyelik='"+tur+"'";
				
			
				
				
		
				
				 
				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						
						
					
						
						if(myRs.getInt("giris")==1) {
							if(tur=="admin") {
								fm1 ekr = new fm1();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							if(tur=="normal") {
								frm2 ekr = new frm2();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							if(tur=="premium") {
								frm3 ekr = new frm3();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							
								
							
							
							
							
						} else { btnNewButton.setText("hatalý giriþ"); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(143, 149, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("tur");
		lblNewLabel_2.setBounds(42, 123, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
