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

public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ad;
	private JTextField txt_sifre;
	static String ad;
	static String sifre;

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
		
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = txt_ad.getText();
				sifre = txt_sifre.getText();
				
				String sql_sorgu = "select count(idkull) as giris from kull where kull_ad='"+ad+
						"' and sifre='"+sifre+"'";
				
				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("giris")==1) {
							fm1 ekr = new fm1();
							ekr.setVisible(true);
							setVisible(false);
						} else { btnNewButton.setText("hatalý giriþ"); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(134, 122, 97, 25);
		contentPane.add(btnNewButton);
	}
}
