package dbase;

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
	Object[] kolonlar= {"No","Ad","Tarih","Album","tur","sure","dinlenme","Sanatci"};
	Object[] satirlar= new Object[8];
	private JTable table;
	private JTextField txt_id;
	private JTextField txt_ad;
	private JTextField txt_tarih;
	private JTextField txt_album;
	private JTextField txt_adsorgu;
	private JTextField txt_tur;
	private JTextField txt_sure;
	private JTextField txt_dinlenme;
	private JTextField txt_sanatci;
	

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
		
		scrollPane.setBounds(20, 103, 602, 398);
		contentPane.add(scrollPane);
		
		
		table=new JTable();
		modelim.setColumnIdentifiers(kolonlar);
	
		table.setBounds(158,219,256,123);
		scrollPane.setViewportView(table);
		
		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				ResultSet myRs=baglanti.yap();
				
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("sarki_Id");
						satirlar[1]=myRs.getString("sarki_adi");
						satirlar[2]=myRs.getString("sarki_tarih");
						
						satirlar[3]=myRs.getString("sarki_album");
						satirlar[4]=myRs.getString("sarki_tur");
						satirlar[5]=myRs.getString("sarki_sure");
						satirlar[6]=myRs.getString("sarki_dinlenme");
						satirlar[7]=myRs.getString("sarki_sanatci");
						modelim.addRow(satirlar);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(450, 51, 97, 25);
		contentPane.add(btnListele);
		
		txt_id = new JTextField();
		txt_id.setBounds(66, 512, 86, 20);
		contentPane.add(txt_id);
		txt_id.setColumns(10);
		
		txt_ad = new JTextField();
		txt_ad.setBounds(66, 543, 86, 20);
		contentPane.add(txt_ad);
		txt_ad.setColumns(10);
		
		txt_tarih = new JTextField();
		txt_tarih.setBounds(66, 574, 86, 20);
		contentPane.add(txt_tarih);
		txt_tarih.setColumns(10);
		
		txt_album = new JTextField();
		txt_album.setBounds(66, 605, 86, 20);
		contentPane.add(txt_album);
		txt_album.setColumns(10);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String id,ad,tarih,sanatci,album,tur,sure,dinlenme,sql_sorgu;
				id=txt_id.getText();
				ad=txt_ad.getText();
				tarih=txt_tarih.getText();
				album=txt_album.getText();
				tur=txt_tur.getText();
				sure=txt_sure.getText();
				dinlenme=txt_dinlenme.getText();
				sanatci=txt_sanatci.getText();
				sql_sorgu="INSERT INTO sarki (sarki_Id,sarki_adi,sarki_tarih,sarki_album,sarki_tur,sarki_sure,sarki_dinlenme,sarki_sanatci) VALUES("+
				id +",'"+ad+"',"+"'"+tarih +"','"+album +"','"+tur +"','"+sure +"','"+dinlenme+"','"+sanatci+"')";
				
				baglanti.ekle(sql_sorgu);
				
			}
		});
		btnKaydet.setBounds(0, 647, 89, 23);
		contentPane.add(btnKaydet);
		
		JLabel lbl_Id = new JLabel("Id");
		lbl_Id.setBounds(10, 515, 46, 14);
		contentPane.add(lbl_Id);
		
		JLabel lbl_ad = new JLabel("Ad");
		lbl_ad.setBounds(10, 546, 46, 14);
		contentPane.add(lbl_ad);
		
		JLabel lbl_tarih = new JLabel("Tarih");
		lbl_tarih.setBounds(10, 577, 46, 14);
		contentPane.add(lbl_tarih);
		
		JLabel lbl_sanatci = new JLabel("Sanatci");
		lbl_sanatci.setBounds(198, 608, 46, 14);
		contentPane.add(lbl_sanatci);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Id", "Tarih", "Sanatci", "Album", "Tur", "Sure", "Dinlenme"}));
		comboBox.setBounds(151, 52, 89, 22);
		contentPane.add(comboBox);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id,ad,tarih,sanatci,album,tur,sure,dinlenme,sql_sorgu;
				id=txt_id.getText();
				ad=txt_ad.getText();
				tarih=txt_tarih.getText();
				album=txt_album.getText();
				tur=txt_tur.getText();
				sure=txt_sure.getText();
				dinlenme=txt_dinlenme.getText();
				sanatci=txt_sanatci.getText();
				
				
				sql_sorgu="UPDATE sarki SET sarki_Id="+id+","+"sarki_adi='"+ad+"',sarki_tarih='"+tarih+
						"',sarki_album='"+album+"',sarki_tur='"+tur+"',sarki_sure='"+sure+"',sarki_dinlenme='"+dinlenme+"',sarki_sanatci='"+sanatci+"' WHERE sarki_Id="+id;
				
				baglanti.update(sql_sorgu);
				
				
			}
		});
		btnUpdate.setBounds(99, 647, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql_sorgu;
				id=txt_id.getText();
				sql_sorgu="DELETE FROM sarki WHERE sarki_Id="+id;
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setBounds(198, 647, 89, 23);
		contentPane.add(btnSil);
		
		JLabel lblNewLabel = new JLabel("Alan:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(758, 33, 97, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Sorgula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				String alan=txt_adsorgu.getText();
				ResultSet myRs=null;
				String sql_sorgu=null;
				
				int secilen=comboBox.getSelectedIndex();
				if(secilen==0) {
					 sql_sorgu="select *from sarki where sarki_adi like'"+alan+"%'";
					
				}
				else if(secilen==2) {
					 sql_sorgu="select *from sarki where sarki_tarih like'"+alan+"%'";
					
				}
				else if(secilen==1) {
					 sql_sorgu="select *from sarki where sarki_Id='"+Integer.parseInt(alan)+"%'";
					
				}
				else if(secilen==3) {
					 sql_sorgu="select *from sarki where sarki_sanatci like'"+alan+"%'";
					
				}
				else if(secilen==4) {
					 sql_sorgu="select *from sarki where sarki_album like'"+alan+"%'";
					
				}
				else if(secilen==5) {
					 sql_sorgu="select *from sarki where sarki_tur like'"+alan+"%'";
					
				}
				else if(secilen==6) {
					 sql_sorgu="select *from sarki where sarki_sure like'"+alan+"%'";
					
				}
				else if(secilen==7) {
					 sql_sorgu="select *from sarki where sarki_dinlenme like'"+alan+"%'";
					
				}
				
				myRs=baglanti.sorgula(sql_sorgu);
				try {
					while(myRs.next()) {
						satirlar[0]=myRs.getString("sarki_Id");
						satirlar[1]=myRs.getString("sarki_adi");
						satirlar[2]=myRs.getString("sarki_tarih");
						
						satirlar[3]=myRs.getString("sarki_album");
						satirlar[4]=myRs.getString("sarki_tur");
						satirlar[5]=myRs.getString("sarki_sure");
						satirlar[6]=myRs.getString("sarki_dinlenme");
						satirlar[7]=myRs.getString("sarki_sanatci");
						
						modelim.addRow(satirlar);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
			}
		});
		btnNewButton.setBounds(277, 53, 89, 23);
		contentPane.add(btnNewButton);
		
		txt_adsorgu = new JTextField();
		txt_adsorgu.setBounds(36, 53, 86, 20);
		contentPane.add(txt_adsorgu);
		txt_adsorgu.setColumns(10);
		
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(giris.ad);
		
		JLabel lbl_album = new JLabel("Album");
		lbl_album.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_album.setBounds(0, 608, 41, 14);
		contentPane.add(lbl_album);
		
		JLabel lbl_tur = new JLabel("Tur");
		lbl_tur.setBounds(198, 512, 46, 14);
		contentPane.add(lbl_tur);
		
		JLabel lbl_sure = new JLabel("Sure");
		lbl_sure.setBounds(198, 546, 46, 14);
		contentPane.add(lbl_sure);
		
		JLabel lbl_dinlenme = new JLabel("Dinlenme");
		lbl_dinlenme.setBounds(194, 577, 46, 14);
		contentPane.add(lbl_dinlenme);
		
		txt_tur = new JTextField();
		txt_tur.setBounds(277, 512, 86, 20);
		contentPane.add(txt_tur);
		txt_tur.setColumns(10);
		
		txt_sure = new JTextField();
		txt_sure.setBounds(277, 543, 86, 20);
		contentPane.add(txt_sure);
		txt_sure.setColumns(10);
		
		txt_dinlenme = new JTextField();
		txt_dinlenme.setBounds(277, 574, 86, 20);
		contentPane.add(txt_dinlenme);
		txt_dinlenme.setColumns(10);
		
		txt_sanatci = new JTextField();
		txt_sanatci.setBounds(277, 605, 86, 20);
		contentPane.add(txt_sanatci);
		txt_sanatci.setColumns(10);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_id.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
				txt_ad.setText((String)modelim.getValueAt(table.getSelectedRow(),1));
				txt_tarih.setText((String)modelim.getValueAt(table.getSelectedRow(),2));
				txt_album.setText((String)modelim.getValueAt(table.getSelectedRow(),3));
				txt_tur.setText((String)modelim.getValueAt(table.getSelectedRow(),4));
				txt_sure.setText((String)modelim.getValueAt(table.getSelectedRow(),5));
				txt_dinlenme.setText((String)modelim.getValueAt(table.getSelectedRow(),6));
				txt_sanatci.setText((String)modelim.getValueAt(table.getSelectedRow(),7));
				
			}
		});
	}
}