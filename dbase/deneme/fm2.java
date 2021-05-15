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

public class fm2 extends JFrame {

	
	String metin="";
	private JPanel contentPane;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"Id","Ad","Tarih","Tur","Sure","Dinlenme","Album","Sanatci"};
	Object[] satirlar= new Object[8];
	DefaultTableModel modelim1=new DefaultTableModel();
	Object[] kolonlar1= {"Id","Album Ad","Sanatci","Tarih","Tur"};
	Object[] satirlar1= new Object[5];
	DefaultTableModel modelim2=new DefaultTableModel();
	Object[] kolonlar2= {"Id","Kullanici Ad","Tur"};
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
	static int sayac1=0,sayac2=0,sayac3=0;
	String kullanici_id = "";
	String kullanici_ad = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fm2 frame = new fm2();
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
	public fm2() {
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
				ResultSet myRs=baglanti.yap(0);
				
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
		btnUpdate.setBounds(690, 324, 89, 23);
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
		lblNewLabel.setBounds(781, 22, 97, 25);
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
				ResultSet myRs=baglanti.yap(1);
				
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
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 600, 1);
		contentPane.add(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sarki Ozellikleri");
		lblNewLabel_1.setBounds(644, 33, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("calma listesi");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				sayac1=0;	
				sayac2=0;
				sayac3=1;
				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs=baglanti.yap(3);
				
				try {
					while(myRs.next()) {
						
						satirlar2[0]=myRs.getString("liste_id");
						satirlar2[1]=myRs.getString("kul_ad");
						satirlar2[2]=myRs.getString("tur_ad");
						
						modelim2.addRow(satirlar2);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);
			//	System.out.println(metin);
				
			}
		});
		btnNewButton.setBounds(424, 8, 176, 79);
		contentPane.add(btnNewButton);
		
		JButton btn_gecis = new JButton("gecis");
		btn_gecis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sayac1=1;	
				sayac2=0;
				sayac3=0;
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs=baglanti.sorgulama_1(metin);
				
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
		btn_gecis.setBounds(691, 424, 85, 21);
		contentPane.add(btn_gecis);
		
		JButton btn_benim_listem = new JButton("benim listem");
		btn_benim_listem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sorgu = "select kul_id from kullanici where kul_ad ='"+giris.ad+"'";
				kullanici_ad=giris.ad;
				ResultSet myRs=baglanti.yap2(sorgu);
				try {
					while(myRs.next()) {
						kullanici_id = myRs.getString("kul_id");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				
				sayac1=0;	
				sayac2=0;
				sayac3=1;
				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs1=baglanti.sorgulama_2(kullanici_id);
				
				try {
					while(myRs1.next()) {
						
						satirlar2[0]=myRs1.getString("liste_id");
						satirlar2[1]=myRs1.getString("kul_ad");
						satirlar2[2]=myRs1.getString("tur_ad");
						
						modelim2.addRow(satirlar2);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);
				
			}
		});
		btn_benim_listem.setBounds(690, 480, 85, 21);
		contentPane.add(btn_benim_listem);
		
		JButton btn_ekle = new JButton("ekle");
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
			
				
	
				
				String sql_sorgu="INSERT INTO liste_islem (liste_id,sarki_id) VALUES("+
				metin +",'"+sarki_id+"')";
				System.out.println(sql_sorgu);
				
				
				baglanti.ekle(sql_sorgu);
				
				
				
			}
		});
		btn_ekle.setBounds(793, 480, 85, 21);
		contentPane.add(btn_ekle);
		
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
				//txt_id.setText(modelim2.getValueAt(table.getSelectedRow(),0).toString());
			}
			if(sayac3==1) {
				metin = modelim2.getValueAt(table.getSelectedRow(),0).toString();
				txt_id.setText(modelim2.getValueAt(table.getSelectedRow(),0).toString());
				System.out.println(metin);
			}
				
			}
		});
	}
}