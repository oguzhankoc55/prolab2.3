package deneme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class fm1 extends JFrame {

	private JPanel contentPane;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"Id","Ad","Tarih","Tur","Sure","Dinlenme","Album","Sanatci"};
	Object[] satirlar= new Object[8];
	DefaultTableModel modelim1=new DefaultTableModel();
	Object[] kolonlar1= {"Id","Album Ad","Sanatci","Tarih","Tur"};
	Object[] satirlar1= new Object[5];
	DefaultTableModel modelim2=new DefaultTableModel();
	Object[] kolonlar2= {"Id","Sanatci Ad","Ulke"};
	Object[] satirlar2= new Object[3];
	private JTable table;
	private JTextField txt_id;
	private JTextField txt_ad;
	private JTextField txt_tarih;
	private JTextField txt_album;
	private JTextField txt_tur;
	private JTextField txt_sure;
	private JTextField txt_dinlenme;
	private JTextField txt_sanatci;
	private JTable table_1;
	private JTable table_2;
	private JTextField txt_album_id;
	private JTextField txt_album_ad;
	private JTextField txt_album_sanatci;
	private JTextField txt_album_tarih;
	private JTextField txt_album_tur;
	private JTextField txt_sanatci_id;
	private JTextField txt_sanatci_ad;
	private JTextField txt_sanatci_ulke;
	static int sayac1=0,sayac2=0,sayac3=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fm1 frame = new fm1();
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
	public fm1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1361, 720);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(20, 97, 602, 573);
		contentPane.add(scrollPane);
		
		
		table=new JTable();
		
	
		table.setBounds(158,219,256,123);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Sarki Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac1=1;	
				sayac2=0;
				sayac3=0;
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs=baglanti.yap();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("sarki_id");
						satirlar[1]=myRs.getString("sarki_adi");
						satirlar[2]=myRs.getString("sarki_tarih");
						satirlar[3]=myRs.getString("tur_ad");
						satirlar[4]=myRs.getString("sarki_sure");
						satirlar[5]=myRs.getString("sarki_dinlenme");
					
						satirlar[6]=myRs.getString("album_ad");
						satirlar[7]=myRs.getString("sanatci_ad");
						
						modelim.addRow(satirlar);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(20, 8, 200, 90);
		contentPane.add(btnListele);
		
		txt_id = new JTextField();
		txt_id.setBounds(690, 53, 86, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(690, 84, 86, 20);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		txt_tarih = new JTextField();
		txt_tarih.setBounds(690, 115, 86, 20);
		contentPane.add(txt_tarih);
		txt_tarih.setColumns(10);
		
		txt_album = new JTextField();
		txt_album.setBounds(690, 227, 86, 20);
		contentPane.add(txt_album);
		txt_album.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id,ad,tarih,sanatci,album,tur,sure,dinlenme,sql_sorgu,sql_tur,sql_album,sql_sanatci;
				int tur_id ,album_id,sanatci_id;
				String tur_ids="";
				String album_ids="";
				String sanatci_ids="";
				
				id=txt_id.getText();
				ad=txt_ad.getText();
				tarih=txt_tarih.getText();
				album=txt_album.getText();
				tur=txt_tur.getText();
				sure=txt_sure.getText();
				dinlenme=txt_dinlenme.getText();
				sanatci=txt_sanatci.getText();
				
				//select sarki_id,sarki_adi,sarki_tarih,sarki_sure,sarki_dinlenme,tur_ad ,sanatci_ad,album_ad from sarki,tur,album,sanatci  where sarki.tur_id=tur.tur_id and sarki.album_id=album.album_id and sarki.sanatci_id=sanatci.sanatci_id ORDER BY sarki_id;
				sql_tur="select tur_id from tur where tur_ad='"+tur+"'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while(myRs.next()){
						tur_id=myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_album="select album_id from album where album_ad='"+album+"'";
				ResultSet myRs1 = baglanti.yap2(sql_album);
				myRs1 = baglanti.sorgula(sql_album);
				try {
					while(myRs1.next()){
						album_id=myRs1.getInt("album_id");
						album_ids = String.valueOf(album_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sanatci="select sanatci_id from sanatci where sanatci_ad='"+sanatci+"'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while(myRs2.next()){
						sanatci_id=myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				sql_sorgu="INSERT INTO sarki (sarki_id,sarki_adi,sarki_tarih,tur_id,sarki_sure,sarki_dinlenme,album_id,sanatci_id) VALUES("+
				id +",'"+ad+"',"+"'"+tarih  +"','"+tur_ids +"','"+sure +"','"+dinlenme+"','"+album_ids +"','"+sanatci_ids +"')";
				System.out.println(sql_sorgu);
				
				
				baglanti.ekle(sql_sorgu);
				
			}
		});
		btnKaydet.setBounds(632, 327, 89, 23);
		contentPane.add(btnKaydet);
		
		JLabel lbl_Id = new JLabel("Id");
		lbl_Id.setBounds(644, 56, 46, 14);
		contentPane.add(lbl_Id);
		
		JLabel lbl_ad = new JLabel("Ad");
		lbl_ad.setBounds(644, 87, 46, 14);
		contentPane.add(lbl_ad);
		
		JLabel lbl_tarih = new JLabel("Tarih");
		lbl_tarih.setBounds(644, 118, 46, 14);
		contentPane.add(lbl_tarih);
		
		JLabel lbl_sanatci = new JLabel("Sanatci");
		lbl_sanatci.setBounds(644, 255, 46, 25);
		contentPane.add(lbl_sanatci);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id,ad,tarih,sanatci,album,tur,sure,dinlenme,sql_sorgu,sql_tur,sql_album,sql_sanatci;
				int tur_id ,album_id,sanatci_id;
				String tur_ids="";
				String album_ids="";
				String sanatci_ids="";
				id=txt_id.getText();
				ad=txt_ad.getText();
				tarih=txt_tarih.getText();
				album=txt_album.getText();
				tur=txt_tur.getText();
				sure=txt_sure.getText();
				dinlenme=txt_dinlenme.getText();
				sanatci=txt_sanatci.getText();
				
				sql_tur="select tur_id from tur where tur_ad='"+tur+"'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while(myRs.next()){
						tur_id=myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_album="select album_id from album where album_ad='"+album+"'";
				ResultSet myRs1 = baglanti.yap2(sql_album);
				myRs1 = baglanti.sorgula(sql_album);
				try {
					while(myRs1.next()){
						album_id=myRs1.getInt("album_id");
						album_ids = String.valueOf(album_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sanatci="select sanatci_id from sanatci where sanatci_ad='"+sanatci+"'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while(myRs2.next()){
						sanatci_id=myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sorgu="UPDATE sarki SET sarki_id="+id+","+"sarki_adi='"+ad+"',sarki_tarih='"+tarih+
					"',tur_id='"+tur_ids+"',sarki_sure='"+sure+"',sarki_dinlenme='"+dinlenme+"',album_id='"+album_ids+"',sanatci_id='"+sanatci_ids+"' WHERE sarki_id="+id;
				System.out.println(sql_sorgu);
				
				baglanti.update(sql_sorgu);
				
				
			}
		});
		btnUpdate.setBounds(731, 327, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				id=txt_id.getText();
				sql_sorgu="DELETE FROM sarki WHERE sarki_id="+id;
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setBounds(687, 361, 89, 23);
		contentPane.add(btnSil);
		
		JLabel lblNewLabel = new JLabel("Alan:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(758, 33, 97, 25);
		contentPane.add(lblNewLabel);
		
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(giris.ad);
		
		JLabel lbl_album = new JLabel("Album");
		lbl_album.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_album.setBounds(632, 229, 41, 17);
		contentPane.add(lbl_album);
		
		JLabel lbl_tur = new JLabel("Tur");
		lbl_tur.setBounds(644, 146, 46, 20);
		contentPane.add(lbl_tur);
		
		JLabel lbl_sure = new JLabel("Sure");
		lbl_sure.setBounds(644, 177, 46, 14);
		contentPane.add(lbl_sure);
		
		JLabel lbl_dinlenme = new JLabel("Dinlenme");
		lbl_dinlenme.setBounds(644, 202, 46, 19);
		contentPane.add(lbl_dinlenme);
		
		txt_tur = new JTextField();
		txt_tur.setBounds(690, 146, 86, 20);
		contentPane.add(txt_tur);
		txt_tur.setColumns(10);
		
		txt_sure = new JTextField();
		txt_sure.setBounds(690, 174, 86, 20);
		contentPane.add(txt_sure);
		txt_sure.setColumns(10);
		
		txt_dinlenme = new JTextField();
		txt_dinlenme.setBounds(690, 201, 86, 20);
		contentPane.add(txt_dinlenme);
		txt_dinlenme.setColumns(10);
		
		txt_sanatci = new JTextField();
		txt_sanatci.setBounds(690, 257, 86, 20);
		contentPane.add(txt_sanatci);
		txt_sanatci.setColumns(10);
		
		JButton btnAlbumListele = new JButton("Album Listele");
		btnAlbumListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac1=0;	
				sayac2=1;
				sayac3=0;
				modelim1.setColumnIdentifiers(kolonlar1);
				modelim1.setRowCount(0);
				ResultSet myRs=baglanti.yap3();
				
				try {
					while(myRs.next()) {
						satirlar1[0]=myRs.getString("album_id");
						satirlar1[1]=myRs.getString("album_ad");
						satirlar1[2]=myRs.getString("sanatci_ad");
						satirlar1[3]=myRs.getString("tarih");
						satirlar1[4]=myRs.getString("tur_ad");
				
					
						
						modelim1.addRow(satirlar1);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim1);
				
				
				
				
			}
		});
		btnAlbumListele.setBounds(219, 8, 200, 90);
		contentPane.add(btnAlbumListele);
		
		table_2 = new JTable();
		table_2.setBounds(0, 0, 600, 1);
		contentPane.add(table_2);
		
		JButton btnListele_3 = new JButton("Sarkici Listele");
		btnListele_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac1=0;	
				sayac2=0;
				sayac3=1;
				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs=baglanti.yap4();
				
				try {
					while(myRs.next()) {
						satirlar2[0]=myRs.getString("sanatci_id");
						satirlar2[1]=myRs.getString("sanatci_ad");
						satirlar2[2]=myRs.getString("ulke_ad");
						
				
					
						
						modelim2.addRow(satirlar2);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);
				
			}
		});
		btnListele_3.setBounds(422, 8, 200, 90);
		contentPane.add(btnListele_3);
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 600, 1);
		contentPane.add(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sarki Ozellikleri");
		lblNewLabel_1.setBounds(644, 33, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_albumid = new JLabel("Id");
		lbl_albumid.setBounds(849, 56, 46, 14);
		contentPane.add(lbl_albumid);
		
		txt_album_id = new JTextField();
		txt_album_id.setBounds(902, 53, 86, 20);
		contentPane.add(txt_album_id);
		txt_album_id.setColumns(10);
		
		JLabel lbl_albumad = new JLabel("Ad");
		lbl_albumad.setEnabled(true);
		lbl_albumad.setBounds(849, 87, 46, 14);
		contentPane.add(lbl_albumad);
		
		txt_album_ad = new JTextField();
		txt_album_ad.setText("");
		txt_album_ad.setBounds(902, 84, 86, 20);
		contentPane.add(txt_album_ad);
		txt_album_ad.setColumns(10);
		
		JLabel lbl_albumsanatci = new JLabel("Sanatci");
		lbl_albumsanatci.setBounds(849, 118, 46, 14);
		contentPane.add(lbl_albumsanatci);
		
		txt_album_sanatci = new JTextField();
		txt_album_sanatci.setText("");
		txt_album_sanatci.setBounds(902, 115, 86, 20);
		contentPane.add(txt_album_sanatci);
		txt_album_sanatci.setColumns(10);
		
		JLabel lbl_albumtarih = new JLabel("Tarih");
		lbl_albumtarih.setBounds(849, 149, 46, 14);
		contentPane.add(lbl_albumtarih);
		
		txt_album_tarih = new JTextField();
		txt_album_tarih.setText("");
		txt_album_tarih.setBounds(902, 146, 86, 20);
		contentPane.add(txt_album_tarih);
		txt_album_tarih.setColumns(10);
		
		JLabel lbl_albumtur = new JLabel("Tur");
		lbl_albumtur.setBounds(849, 177, 46, 14);
		contentPane.add(lbl_albumtur);
		
		txt_album_tur = new JTextField();
		txt_album_tur.setText("");
		txt_album_tur.setBounds(902, 174, 86, 20);
		contentPane.add(txt_album_tur);
		txt_album_tur.setColumns(10);
		
		JButton btnKaydet_1 = new JButton("Kaydet");
		btnKaydet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad,tarih,sanatci,tur,sql_sorgu,sql_tur,sql_sanatci;
				int tur_id ,sanatci_id;
				String tur_ids="";
				
				String sanatci_ids="";
				
				id=txt_album_id.getText();
				ad=txt_album_ad.getText();
				sanatci=txt_album_sanatci.getText();
				tarih=txt_album_tarih.getText();
				tur=txt_album_tur.getText();
				
				
				//select sarki_id,sarki_adi,sarki_tarih,sarki_sure,sarki_dinlenme,tur_ad ,sanatci_ad,album_ad from sarki,tur,album,sanatci  where sarki.tur_id=tur.tur_id and sarki.album_id=album.album_id and sarki.sanatci_id=sanatci.sanatci_id ORDER BY sarki_id;
				sql_tur="select tur_id from tur where tur_ad='"+tur+"'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while(myRs.next()){
						tur_id=myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				sql_sanatci="select sanatci_id from sanatci where sanatci_ad='"+sanatci+"'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while(myRs2.next()){
						sanatci_id=myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				sql_sorgu="INSERT INTO album (album_id,album_ad,sanatci_id,tarih,tur_id) VALUES("+
				id +",'"+ad+"',"+ "','"+sanatci_ids+"'"+tarih  +"','"+tur_ids  +"')";
				System.out.println(sql_sorgu);
				
				
				baglanti.ekle(sql_sorgu);
				
				
			}
		});
		btnKaydet_1.setBounds(849, 327, 89, 23);
		contentPane.add(btnKaydet_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,ad,tarih,sanatci,tur,sql_sorgu,sql_tur,sql_sanatci;
				int tur_id ,sanatci_id;
				String tur_ids="";
				String sanatci_ids="";
				id=txt_album_id.getText();
				ad=txt_album_ad.getText();
				tarih=txt_album_tarih.getText();
				tur=txt_album_tur.getText();
				sanatci=txt_album_sanatci.getText();
				
				sql_tur="select tur_id from tur where tur_ad='"+tur+"'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while(myRs.next()){
						tur_id=myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				sql_sanatci="select sanatci_id from sanatci where sanatci_ad='"+sanatci+"'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while(myRs2.next()){
						sanatci_id=myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sorgu="UPDATE album SET album_id="+id+","+"album_ad='"+ad+"',sanatci_id='"+sanatci_ids+
					"',tarih='"+tarih+"',tur_id='"+tur_ids+"' WHERE album_id="+id;
				System.out.println(sql_sorgu);
				
				baglanti.update(sql_sorgu);
				
				
				
			}
			
			
		});
		btnUpdate_1.setBounds(948, 327, 89, 23);
		contentPane.add(btnUpdate_1);
		
		JButton btnSil_1 = new JButton("Sil");
		btnSil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				id=txt_album_id.getText();
				sql_sorgu="DELETE FROM album WHERE album_id="+id;
				baglanti.sil(sql_sorgu);
				
				
			}
		});
		btnSil_1.setBounds(899, 361, 89, 23);
		contentPane.add(btnSil_1);
		
		JButton btnKaydet_1_1 = new JButton("Kaydet");
		btnKaydet_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad,ulke,sql_sorgu,sql_tur;
				int ulke_id ;
				String ulke_ids="";
				
				
				
				id=txt_sanatci_id.getText();
				ad=txt_sanatci_ad.getText();
				ulke=txt_sanatci_ulke.getText();
				
				
				
				//select sarki_id,sarki_adi,sarki_tarih,sarki_sure,sarki_dinlenme,tur_ad ,sanatci_ad,album_ad from sarki,tur,album,sanatci  where sarki.tur_id=tur.tur_id and sarki.album_id=album.album_id and sarki.sanatci_id=sanatci.sanatci_id ORDER BY sarki_id;
				sql_tur="select ulke_id from ulke where ulke_ad='"+ulke+"'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula1(sql_tur);
				try {
					while(myRs.next()){
						ulke_id=myRs.getInt("ulke_id");
						ulke_ids = String.valueOf(ulke_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				sql_sorgu="INSERT INTO sanatci (sanatci_id,sanatci_ad,ulke_id) VALUES("+
				id +",'"+ad+"','"+ulke_ids+"')";
				System.out.println(sql_sorgu);
				
				
				baglanti.ekle(sql_sorgu);
				
				
				
			}
		});
		btnKaydet_1_1.setBounds(1065, 327, 89, 23);
		contentPane.add(btnKaydet_1_1);
		
		JButton btnUpdate_1_1 = new JButton("Update");
		btnUpdate_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,ad,ulke,sql_sorgu,sql_ulke;
				int ulke_id ;
				String ulke_ids="";
				id=txt_sanatci_id.getText();
				ad=txt_sanatci_ad.getText();
				ulke=txt_sanatci_ulke.getText();
				
				sql_ulke="select ulke_id from ulke where ulke_ad='"+ulke+"'";
				ResultSet myRs5 = baglanti.yap2(sql_ulke);
				myRs5 = baglanti.sorgula1(sql_ulke);
				try {
					while(myRs5.next()){
						ulke_id=myRs5.getInt("ulke_id");
						ulke_ids = String.valueOf(ulke_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
				
				sql_sorgu="UPDATE sanatci SET sanatci_id="+id+","+"sanatci_ad='"+ad+"',ulke_id='"+ulke_ids+
					"' WHERE sanatci_id="+id;
				System.out.println(sql_sorgu);
				
				baglanti.update(sql_sorgu);
				
				
			}
		});
		btnUpdate_1_1.setBounds(1164, 327, 89, 23);
		contentPane.add(btnUpdate_1_1);
		
		JButton btnSil_1_1 = new JButton("Sil");
		btnSil_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id,sql_sorgu;
				id=txt_sanatci_id.getText();
				sql_sorgu="DELETE FROM sanatci WHERE sanatci_id="+id;
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnSil_1_1.setBounds(1105, 361, 89, 23);
		contentPane.add(btnSil_1_1);
		
		JLabel lbl_sanatciid = new JLabel("Id");
		lbl_sanatciid.setBounds(1065, 56, 46, 14);
		contentPane.add(lbl_sanatciid);
		
		JLabel lbl_sanatciad = new JLabel("Ad");
		lbl_sanatciad.setEnabled(true);
		lbl_sanatciad.setBounds(1065, 87, 46, 14);
		contentPane.add(lbl_sanatciad);
		
		JLabel lbl_sanatci_ulke = new JLabel("Ulke");
		lbl_sanatci_ulke.setBounds(1065, 118, 46, 14);
		contentPane.add(lbl_sanatci_ulke);
		
		txt_sanatci_id = new JTextField();
		txt_sanatci_id.setColumns(10);
		txt_sanatci_id.setBounds(1121, 53, 86, 20);
		contentPane.add(txt_sanatci_id);
		
		txt_sanatci_ad = new JTextField();
		txt_sanatci_ad.setText("");
		txt_sanatci_ad.setColumns(10);
		txt_sanatci_ad.setBounds(1121, 84, 86, 20);
		contentPane.add(txt_sanatci_ad);
		
		txt_sanatci_ulke = new JTextField();
		txt_sanatci_ulke.setText("");
		txt_sanatci_ulke.setColumns(10);
		txt_sanatci_ulke.setBounds(1121, 115, 86, 20);
		contentPane.add(txt_sanatci_ulke);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(sayac1==1) {
					txt_id.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
					txt_ad.setText((String)modelim.getValueAt(table.getSelectedRow(),1));
					txt_tarih.setText((String)modelim.getValueAt(table.getSelectedRow(),2));
					txt_tur.setText((String)modelim.getValueAt(table.getSelectedRow(),3));
					txt_sure.setText((String)modelim.getValueAt(table.getSelectedRow(),4));
					txt_dinlenme.setText((String)modelim.getValueAt(table.getSelectedRow(),5));
					txt_album.setText((String)modelim.getValueAt(table.getSelectedRow(),6));
					txt_sanatci.setText((String)modelim.getValueAt(table.getSelectedRow(),7));
					txt_album_id.setText("");
					txt_album_ad.setText("");
					txt_album_sanatci.setText("");
					txt_album_tarih.setText("");
					txt_album_tur.setText("");
					txt_sanatci_id.setText("");
					txt_sanatci_ad.setText("");
					txt_sanatci_ulke.setText("");
				}
				if(sayac2==1) {
					txt_album_id.setText(modelim1.getValueAt(table.getSelectedRow(),0).toString());
					txt_album_ad.setText((String)modelim1.getValueAt(table.getSelectedRow(),1));
					txt_album_sanatci.setText((String)modelim1.getValueAt(table.getSelectedRow(),2));
					txt_album_tarih.setText((String)modelim1.getValueAt(table.getSelectedRow(),3));
					txt_album_tur.setText((String)modelim1.getValueAt(table.getSelectedRow(),4));
					
					txt_id.setText("");
					txt_ad.setText("");
					txt_tarih.setText("");
					txt_tur.setText("");
					txt_sure.setText("");
					txt_dinlenme.setText("");
					txt_album.setText("");
					txt_sanatci.setText("");
					
					txt_sanatci_id.setText("");
					txt_sanatci_ad.setText("");
					txt_sanatci_ulke.setText("");
					
				}
			
				
				if(sayac3==1) {
					txt_sanatci_id.setText(modelim2.getValueAt(table.getSelectedRow(),0).toString());
					txt_sanatci_ad.setText((String)modelim2.getValueAt(table.getSelectedRow(),1));
					txt_sanatci_ulke.setText((String)modelim2.getValueAt(table.getSelectedRow(),2));
					txt_id.setText("");
					txt_ad.setText("");
					txt_tarih.setText("");
					txt_tur.setText("");
					txt_sure.setText("");
					txt_dinlenme.setText("");
					txt_album.setText("");
					txt_sanatci.setText("");
					txt_album_id.setText("");
					txt_album_ad.setText("");
					txt_album_sanatci.setText("");
					txt_album_tarih.setText("");
					txt_album_tur.setText("");
				}
				
				
			
				
				
			}
		});
	}
}