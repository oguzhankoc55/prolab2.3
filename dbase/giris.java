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
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class giris extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ad;
	private JTextField txt_sifre;
	static String ad;
	static String sifre;
	static String tur="";

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
		
		JLabel ad_lbl = new JLabel("Kullan\u0131c\u0131 ad\u0131");
		ad_lbl.setBounds(56, 106, 70, 16);
		contentPane.add(ad_lbl);
		
		JLabel sifre_lbl = new JLabel("\u015Eifre");
		sifre_lbl.setBounds(56, 152, 56, 16);
		contentPane.add(sifre_lbl);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(140, 103, 116, 22);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		txt_sifre = new JTextField();
		txt_sifre.setBounds(140, 149, 116, 22);
		contentPane.add(txt_sifre);
		txt_sifre.setColumns(10);
		
		JButton admin_btn = new JButton("Admin");
		admin_btn.setBounds(68, 55, 89, 39);
		contentPane.add(admin_btn);
		
		JButton kullanici_btn = new JButton("Kullanici");
		kullanici_btn.setBounds(221, 55, 89, 37);
		contentPane.add(kullanici_btn);
		
		JLabel secin_lbl = new JLabel("Kullanici se\u00E7iniz");
		secin_lbl.setBounds(148, 0, 104, 39);
		contentPane.add(secin_lbl);
		JButton giris_btn = new JButton("giris");
		
		
		giris_btn.setVisible(false);
		txt_sifre.setVisible(false);
		txt_ad.setVisible(false);
		sifre_lbl.setVisible(false);
		ad_lbl.setVisible(false);
		
		giris_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad = txt_ad.getText();
				sifre = txt_sifre.getText();
				
				/*String sql_sorgu = "select count(kul_id) as giris from kullanici where kul_ad='"+ad+
						"' and kul_sifre='"+sifre+"'"; 
*/
				String sql_sorgu = "SELECT  count(kul_id) , kul_uyelik FROM kullanici WHERE kul_ad='"+ad+"' and kul_sifre='"+sifre+"'";

				ResultSet myRs = baglanti.yap();
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
				
						if(myRs.getInt("count(kul_id)")==1) {
							
								tur=myRs.getString("kul_uyelik");
								System.out.println(tur);
							
							
							if(myRs.getString("kul_uyelik")=="admin") {
								fm1 ekr = new fm1();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							else if(tur=="normal") {
								frm2 ekr = new frm2();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							else if(tur=="premium") {
								frm3 ekr = new frm3();
								ekr.setVisible(true);
								setVisible(false);
								
							}
							
							
							
							
							
							
						} else { giris_btn.setText("hatal� giri�"); }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		giris_btn.setBounds(140, 206, 97, 25);
		contentPane.add(giris_btn);
	
		admin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String tur="admin";
				secin_lbl.setVisible(false);
				admin_btn.setVisible(false);
				kullanici_btn.setVisible(false);
				giris_btn.setVisible(true);
				txt_sifre.setVisible(true);
				txt_ad.setVisible(true);
				sifre_lbl.setVisible(true);
				ad_lbl.setVisible(true);
				
				
			}
		});
		kullanici_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
					
				
				secin_lbl.setVisible(false);
				admin_btn.setVisible(false);
				kullanici_btn.setVisible(false);
				giris_btn.setVisible(true);
				txt_sifre.setVisible(true);
				txt_ad.setVisible(true);
				sifre_lbl.setVisible(true);
				ad_lbl.setVisible(true);
				
				
				
			}
		});
		
		
	}
}

