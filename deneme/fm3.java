package deneme;

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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class fm3 extends JFrame {

	String metin = "";
	String metin1 = "";
	String metin2 = "";
	String sarki_id = "";
	String ulke_id = "";
	String k_id = "";
	private JPanel contentPane;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = { "Id", "Ad", "Tarih", "Tur", "Sure", "Dinlenme", "Album", "Sanatci" };
	Object[] satirlar = new Object[8];
	DefaultTableModel modelim1 = new DefaultTableModel();
	Object[] kolonlar1 = { "Id", "Album Ad", "Sanatci", "Tarih", "Tur" };
	Object[] satirlar1 = new Object[5];
	DefaultTableModel modelim2 = new DefaultTableModel();
	Object[] kolonlar2 = { "Id", "Kullanici Ad", "Tur" };
	Object[] satirlar2 = new Object[3];
	DefaultTableModel modelim3 = new DefaultTableModel();
	Object[] kolonlar3 = { "Id", "Kullanici Ad" };
	Object[] satirlar3 = new Object[2];
	DefaultTableModel modelim4 = new DefaultTableModel();
	Object[] kolonlar4 = { "Id", "Kullanici Ad" };
	Object[] satirlar4 = new Object[2];
	DefaultTableModel modelim5 = new DefaultTableModel();
	Object[] kolonlar5 = { "Id", "Ulke Ad" };
	Object[] satirlar5 = new Object[2];
	DefaultTableModel modelim6 = new DefaultTableModel();
	Object[] kolonlar6 = { "Id", "Odenme Durumu"};
	Object[] satirlar6 = new Object[2];

	private JTable table;
	static int sayac = 0;
	String kullanici_id = "";
	String kullanici_ad = "";

	
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

	
	public fm3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1361, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(229, 97, 822, 573);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setBounds(158, 219, 256, 123);
		scrollPane.setViewportView(table);

		JButton btnListele = new JButton("Sarki Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac = 1;

				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap(0);

				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");

						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setBounds(972, 27, 150, 50);
		contentPane.add(btnListele);

		JButton btn_kaldir = new JButton("Kaldir");
		btn_kaldir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sorgu_kullanici = "select kul_id from kullanici where kul_ad ='" + giris.ad + "'";
				kullanici_ad = giris.ad;
				ResultSet myRs2 = baglanti.yap2(sorgu_kullanici);
				try {
					while (myRs2.next()) {
						kullanici_id = myRs2.getString("kul_id");
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				String sql_sorgu_tur = "select tur_id from sarki where sarki_id='" + sarki_id + "'";
				String tur_id = "";
				ResultSet myRs = baglanti.yap2(sql_sorgu_tur);
				try {
					while (myRs.next()) {

						tur_id = myRs.getString("tur_id");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				String liste_id = "";
				ResultSet myRs1 = baglanti.sorgulama_3(kullanici_id, tur_id);

				try {
					while (myRs1.next()) {
						liste_id = myRs1.getString("liste_id");

					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				String sql_sorgu_sil = "DELETE FROM liste_islem WHERE sarki_id='" + sarki_id + "' and liste_id='"
						+ liste_id + "'";

				baglanti.sil(sql_sorgu_sil);
			}
		});
		btn_kaldir.setBounds(1124, 613, 150, 50);
		contentPane.add(btn_kaldir);

		JLabel lblNewLabel = new JLabel("Alan:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(578, 27, 150, 60);
		contentPane.add(lblNewLabel);

		contentPane.add(lblNewLabel);
		lblNewLabel.setText(giris.ad);

		JButton btnAlbumListele = new JButton("Album Listele");
		btnAlbumListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac = 2;

				modelim1.setColumnIdentifiers(kolonlar1);
				modelim1.setRowCount(0);
				ResultSet myRs = baglanti.yap(1);

				try {
					while (myRs.next()) {
						satirlar1[0] = myRs.getString("album_id");
						satirlar1[1] = myRs.getString("album_ad");
						satirlar1[2] = myRs.getString("sanatci_ad");
						satirlar1[3] = myRs.getString("tarih");
						satirlar1[4] = myRs.getString("tur_ad");

						modelim1.addRow(satirlar1);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim1);

			}
		});
		btnAlbumListele.setBounds(377, 27, 150, 50);
		contentPane.add(btnAlbumListele);

		JButton btnNewButton = new JButton("Premium Kullan\u0131c\u0131lar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sayac = 5;

				modelim4.setColumnIdentifiers(kolonlar4);
				modelim4.setRowCount(0);
				ResultSet myRs = baglanti.yap(3);

				try {
					while (myRs.next()) {

						satirlar4[0] = myRs.getString("kul_id");
						satirlar4[1] = myRs.getString("kul_ad");

						modelim4.addRow(satirlar4);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim4);
				// System.out.println(metin);

			}
		});
		btnNewButton.setBounds(168, 27, 150, 50);
		contentPane.add(btnNewButton);

		JButton btn_gecis = new JButton("gecis");
		btn_gecis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sayac = 1;

				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.sorgulama_1(metin);

				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);

			}
		});
		btn_gecis.setBounds(1124, 488, 150, 50);
		contentPane.add(btn_gecis);

		JButton btn_benim_listem = new JButton("benim listem");
		btn_benim_listem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fonksiyon();

				sayac = 3;

				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs1 = baglanti.sorgulama_2(kullanici_id);

				try {
					while (myRs1.next()) {

						satirlar2[0] = myRs1.getString("liste_id");
						satirlar2[1] = myRs1.getString("kul_ad");
						satirlar2[2] = myRs1.getString("tur_ad");

						modelim2.addRow(satirlar2);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);

			}
		});
		btn_benim_listem.setBounds(788, 27, 150, 50);
		contentPane.add(btn_benim_listem);

		JButton btn_ekle = new JButton("ekle");
		btn_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fonksiyon();

				String sql_sorgu_tur = "select tur_id from sarki where sarki_id='" + sarki_id + "'";
				String tur_id = "";
				ResultSet myRs = baglanti.yap2(sql_sorgu_tur);
				try {
					while (myRs.next()) {

						tur_id = myRs.getString("tur_id");
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				String liste_id = "";
				ResultSet myRs1 = baglanti.sorgulama_3(kullanici_id, tur_id);

				try {
					while (myRs1.next()) {
						liste_id = myRs1.getString("liste_id");

					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				String sql_sorgu = "INSERT INTO liste_islem (liste_id,sarki_id) VALUES(" + liste_id + ",'" + sarki_id
						+ "')";
				System.out.println(sql_sorgu);

				baglanti.ekle(sql_sorgu);

			}
		});
		btn_ekle.setBounds(1124, 248, 150, 50);
		contentPane.add(btn_ekle);

		JButton btnNewButton_1 = new JButton("Takip Et");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac = 4;

				fonksiyon();

				String sql_sorgu = "INSERT INTO takip (takip_eden_id,takip_edilen_id) VALUES(" + kullanici_id + ",'"
						+ metin1 + "')";
				System.out.println(sql_sorgu);

				baglanti.ekle(sql_sorgu);

			}

		});
		btnNewButton_1.setBounds(1124, 308, 150, 50);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Takip Ettiklerim");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac = 4;

				fonksiyon();

				modelim3.setColumnIdentifiers(kolonlar3);
				modelim3.setRowCount(0);

				ResultSet myRs = baglanti.sorgulama_4(kullanici_id);

				try {
					while (myRs.next()) {

						satirlar3[0] = myRs.getString("kul_id");
						satirlar3[1] = myRs.getString("kul_ad");

						modelim3.addRow(satirlar3);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim3);
				System.out.println(giris.k_id);

			}
		});
		btnNewButton_2.setBounds(22, 248, 150, 50);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Takipten \u00C7\u0131kar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sayac = 4;
				fonksiyon();

				String sql_sorgu = "DELETE FROM takip WHERE takip.takip_eden_id='" + kullanici_id
						+ "' and takip.takip_edilen_id='" + metin2 + "'";
				System.out.println(sql_sorgu);

				baglanti.sil(sql_sorgu);

			}
		});
		btnNewButton_3.setBounds(1124, 553, 150, 50);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("TakipL. Gecis");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sayac = 3;
				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs = baglanti.sorgulama_5(metin2);

				try {
					while (myRs.next()) {

						satirlar2[0] = myRs.getString("liste_id");
						satirlar2[1] = myRs.getString("kul_ad");
						satirlar2[2] = myRs.getString("tur_ad");

						modelim2.addRow(satirlar2);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);
				// System.out.println(metin);

			}
		});
		btnNewButton_4.setBounds(1124, 428, 150, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btn_dinle = new JButton("dinle");
		btn_dinle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dinlenme =0;
				ResultSet myRs = baglanti.sorgulama_6(sarki_id);	
				try {
					while (myRs.next()) {

						dinlenme = myRs.getInt("sarki_dinlenme");

					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				dinlenme+=1;
				String dinl = Integer.toString(dinlenme);
				String sql_sorgu="UPDATE sarki SET sarki_dinlenme='"+dinl+"' WHERE sarki_id='"+sarki_id+"'";
				
				//	System.out.println(sql_sorgu);
					
					baglanti.update(sql_sorgu);
					
				
				
				
			}
		});
		btn_dinle.setBounds(1124, 368, 150, 50);
		contentPane.add(btn_dinle);
		
		JButton btn_ulke = new JButton("ulkeler");
		btn_ulke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sayac = 6;
				modelim5.setColumnIdentifiers(kolonlar5);
				modelim5.setRowCount(0);
				ResultSet myRs = baglanti.yap(4);

				try {
					while (myRs.next()) {

						satirlar5[0] = myRs.getString("ulke_id");
						satirlar5[1] = myRs.getString("ulke_ad");
					

						modelim5.addRow(satirlar5);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim5);
			}
		});
		btn_ulke.setBounds(22, 368, 150, 50);
		contentPane.add(btn_ulke);
		
		JButton btn_ulke_sarki = new JButton("ulke-sarki");
		btn_ulke_sarki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//sayac = 6;
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.sorgulama_7(ulke_id);

				try {
					while (myRs.next()) {

						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
				
			}
		});
		btn_ulke_sarki.setBounds(22, 308, 150, 50);
		contentPane.add(btn_ulke_sarki);
		
		JButton btn_ecd10s = new JButton("ECD10S");
		btn_ecd10s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap(5);

				try {
					while (myRs.next()) {

						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);	
				
				
			}
		});
		btn_ecd10s.setBounds(22, 428, 150, 50);
		contentPane.add(btn_ecd10s);
		
		JButton btn_pop_ecd = new JButton("pop_ECD10S");
		btn_pop_ecd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap(7);

				try {
					while (myRs.next()) {

						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
				
				
				
				
			}
		});
		btn_pop_ecd.setBounds(22, 488, 150, 50);
		contentPane.add(btn_pop_ecd);
		
		JButton btn_jazz_ecd = new JButton("jazz_ECD10S");
		btn_jazz_ecd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap(6);

				try {
					while (myRs.next()) {

						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
				
			}
		});
		btn_jazz_ecd.setBounds(22, 620, 150, 50);
		contentPane.add(btn_jazz_ecd);
		
		JButton btn_kalsik_ecd = new JButton("klasik_ecd10s");
		btn_kalsik_ecd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modelim.setColumnIdentifiers(kolonlar);
				modelim.setRowCount(0);
				ResultSet myRs = baglanti.yap(8);

				try {
					while (myRs.next()) {

						satirlar[0] = myRs.getString("sarki_id");
						satirlar[1] = myRs.getString("sarki_adi");
						satirlar[2] = myRs.getString("sarki_tarih");
						satirlar[3] = myRs.getString("tur_ad");
						satirlar[4] = myRs.getString("sarki_sure");
						satirlar[5] = myRs.getString("sarki_dinlenme");
						satirlar[6] = myRs.getString("album_ad");
						satirlar[7] = myRs.getString("sanatci_ad");

						modelim.addRow(satirlar);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim);
				
				
				
			}
		});
		btn_kalsik_ecd.setBounds(22, 553, 150, 50);
		contentPane.add(btn_kalsik_ecd);
		
		JButton btn_takipciler = new JButton("takipciler");
		btn_takipciler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sayac = 4;

				fonksiyon();

				modelim3.setColumnIdentifiers(kolonlar3);
				modelim3.setRowCount(0);

				ResultSet myRs = baglanti.sorgulama_8(kullanici_id);

				try {
					while (myRs.next()) {

						satirlar3[0] = myRs.getString("kul_id");
						satirlar3[1] = myRs.getString("kul_ad");

						modelim3.addRow(satirlar3);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim3);
				System.out.println(giris.k_id);
				
			}
		});
		btn_takipciler.setBounds(22, 188, 150, 50);
		contentPane.add(btn_takipciler);
		
		JButton btn_odeme_kontrol = new JButton("odeme_kontrol");
		btn_odeme_kontrol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fonksiyon();
				modelim6.setColumnIdentifiers(kolonlar6);
				modelim6.setRowCount(0);
				ResultSet myRs = baglanti.sorgulama_9(kullanici_id);
				
				try {
					while (myRs.next()) {

						satirlar6[0] = myRs.getString("kul_id"); 
						if(myRs.getBoolean("odenme")) {
							satirlar6[1]="Odemesi yapildi";
						}else {
							satirlar6[1]="Odemesi yapilmadi";
						}
						
						modelim6.addRow(satirlar6);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim6);
				
				
				
				
			}
		});
		btn_odeme_kontrol.setBounds(22, 128, 150, 50);
		contentPane.add(btn_odeme_kontrol);
		
		JButton btn_odeme_yap = new JButton("odeme_yap");
		btn_odeme_yap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				fonksiyon();
			
				String sql_sorgu="UPDATE odenme SET odenme= true WHERE kul_id='"+kullanici_id+"'";

					
					baglanti.update(sql_sorgu);
					
				
				
			}
		});
		btn_odeme_yap.setBounds(1124, 186, 150, 50);
		contentPane.add(btn_odeme_yap);
		
		JButton btn_tumunu_ekle = new JButton("tumunu_ekle");
		btn_tumunu_ekle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fonksiyon();
				ArrayList<String> sarkilar = new ArrayList<>();
				String tur_id="";
				ResultSet myRs2 = baglanti.sorgulama_11(metin);
				try {
					while (myRs2.next()) {
						
						tur_id=myRs2.getString("tur_id");


					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				ResultSet myRs = baglanti.sorgulama_10(metin);
				try {
					while (myRs.next()) {
						
						sarkilar.add(myRs.getString("sarki_id"));


					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				String liste_id = "";
				ResultSet myRs1 = baglanti.sorgulama_3(kullanici_id, tur_id);

				try {
					while (myRs1.next()) {
						liste_id = myRs1.getString("liste_id");

					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				for(int i=0;i<sarkilar.size();i++)
				{
				String sql_sorgu = "INSERT INTO liste_islem (liste_id,sarki_id) VALUES(" + liste_id + ",'" + sarkilar.get(i)+ "')";
				baglanti.ekle(sql_sorgu);
				
				}
				
				
			}
		});
		btn_tumunu_ekle.setBounds(1124, 128, 150, 50);
		contentPane.add(btn_tumunu_ekle);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (sayac == 1) {

					sarki_id = modelim.getValueAt(table.getSelectedRow(), 0).toString();

				}
				if (sayac == 3) {
					// metin1=modelim3.getValueAt(table.getSelectedRow(),0).toString();
					metin = modelim2.getValueAt(table.getSelectedRow(), 0).toString();// Kullanici_id

				}
				if (sayac == 4) {
					metin2 = modelim3.getValueAt(table.getSelectedRow(), 0).toString();// Takipten çýkramak premium
																						// kullanýcý_id alýnýr//takip
																						// eeiklerimden

				}
				if (sayac == 5) {
					metin1 = modelim4.getValueAt(table.getSelectedRow(), 0).toString();// Takip edilen premium
																						// kullanýcý_id alýnýr//premium
																						// kullanicilardan

				}
				if (sayac == 6) {

					ulke_id = modelim5.getValueAt(table.getSelectedRow(), 0).toString();

				}
				

			}
		});
	}

	void fonksiyon() {
		String sorgu = "select kul_id from kullanici where kul_ad ='" + giris.ad + "'";
		kullanici_ad = giris.ad;
		ResultSet myRs = baglanti.yap2(sorgu);
		try {
			while (myRs.next()) {
				kullanici_id = myRs.getString("kul_id");
				k_id = kullanici_id;
			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
}