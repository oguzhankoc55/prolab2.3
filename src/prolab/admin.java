package prolab;

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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class admin extends JFrame {

	private JPanel contentPane;
	DefaultTableModel modelim = new DefaultTableModel();
	Object[] kolonlar = { "Id", "Ad", "Tarih", "Tur", "Sure", "Dinlenme", "Album", "Sanatci" };
	Object[] satirlar = new Object[8];
	DefaultTableModel modelim1 = new DefaultTableModel();
	Object[] kolonlar1 = { "Id", "Album Ad", "Sanatci", "Tarih", "Tur" };
	Object[] satirlar1 = new Object[5];
	DefaultTableModel modelim2 = new DefaultTableModel();
	Object[] kolonlar2 = { "Id", "Sanatci Ad", "Ulke" };
	Object[] satirlar2 = new Object[3];
	DefaultTableModel modelim3 = new DefaultTableModel();
	Object[] kolonlar3 = { "Id", "Kullanici Ad", "Kul uyelik tur", "eposta", "Sifre", "Ulke" };
	Object[] satirlar3 = new Object[6];
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
	static int sayac = 0;
	private JTextField text_kul_id;
	private JTextField text_kul_ad;
	private JTextField text_kul_uyelik;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
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
	public admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1361, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(20, 97, 602, 573);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setBounds(158, 219, 256, 123);
		scrollPane.setViewportView(table);

		JButton btnListele = new JButton("Sarki Listele");
		btnListele.setBackground(new Color(147, 112, 219));
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
		btnListele.setBounds(20, 8, 150, 50);
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
		btnKaydet.setBackground(Color.CYAN);
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, ad, tarih, sanatci, album, tur, sure, dinlenme, sql_sorgu, sql_tur, sql_album, sql_sanatci;
				int tur_id, album_id, sanatci_id;
				String tur_ids = "";
				String album_ids = "";
				String sanatci_ids = "";

				id = txt_id.getText();
				ad = txt_ad.getText();
				tarih = txt_tarih.getText();
				album = txt_album.getText();
				tur = txt_tur.getText();
				sure = txt_sure.getText();
				dinlenme = txt_dinlenme.getText();
				sanatci = txt_sanatci.getText();

				sql_tur = "select tur_id from tur where tur_ad='" + tur + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while (myRs.next()) {
						tur_id = myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_album = "select album_id from album where album_ad='" + album + "'";
				ResultSet myRs1 = baglanti.yap2(sql_album);
				myRs1 = baglanti.sorgula(sql_album);
				try {
					while (myRs1.next()) {
						album_id = myRs1.getInt("album_id");
						album_ids = String.valueOf(album_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sanatci = "select sanatci_id from sanatci where sanatci_ad='" + sanatci + "'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while (myRs2.next()) {
						sanatci_id = myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sorgu = "INSERT INTO sarki (sarki_id,sarki_adi,sarki_tarih,tur_id,sarki_sure,sarki_dinlenme,album_id,sanatci_id) VALUES("
						+ id + ",'" + ad + "'," + "'" + tarih + "','" + tur_ids + "','" + sure + "','" + dinlenme
						+ "','" + album_ids + "','" + sanatci_ids + "')";

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
		btnUpdate.setBackground(Color.GREEN);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, ad, tarih, sanatci, album, tur, sure, dinlenme, sql_sorgu, sql_tur, sql_album, sql_sanatci;
				int tur_id, album_id, sanatci_id;
				String tur_ids = "";
				String album_ids = "";
				String sanatci_ids = "";
				id = txt_id.getText();
				ad = txt_ad.getText();
				tarih = txt_tarih.getText();
				album = txt_album.getText();
				tur = txt_tur.getText();
				sure = txt_sure.getText();
				dinlenme = txt_dinlenme.getText();
				sanatci = txt_sanatci.getText();

				sql_tur = "select tur_id from tur where tur_ad='" + tur + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while (myRs.next()) {
						tur_id = myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_album = "select album_id from album where album_ad='" + album + "'";
				ResultSet myRs1 = baglanti.yap2(sql_album);
				myRs1 = baglanti.sorgula(sql_album);
				try {
					while (myRs1.next()) {
						album_id = myRs1.getInt("album_id");
						album_ids = String.valueOf(album_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sanatci = "select sanatci_id from sanatci where sanatci_ad='" + sanatci + "'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while (myRs2.next()) {
						sanatci_id = myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sorgu = "UPDATE sarki SET sarki_id=" + id + "," + "sarki_adi='" + ad + "',sarki_tarih='" + tarih
						+ "',tur_id='" + tur_ids + "',sarki_sure='" + sure + "',sarki_dinlenme='" + dinlenme
						+ "',album_id='" + album_ids + "',sanatci_id='" + sanatci_ids + "' WHERE sarki_id=" + id;

				baglanti.update(sql_sorgu);

			}
		});
		btnUpdate.setBounds(731, 327, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnSil = new JButton("Sil");
		btnSil.setForeground(Color.WHITE);
		btnSil.setBackground(Color.RED);
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, sql_sorgu;
				id = txt_id.getText();
				sql_sorgu = "DELETE FROM sarki WHERE sarki_id=" + id;
				baglanti.sil(sql_sorgu);
			}
		});
		btnSil.setBounds(687, 361, 89, 23);
		contentPane.add(btnSil);

		JLabel lblNewLabel = new JLabel("Alan:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(756, 8, 97, 25);
		contentPane.add(lblNewLabel);

		contentPane.add(lblNewLabel);
		lblNewLabel.setText(giris.ad);

		JLabel lbl_album1 = new JLabel("Album");
		lbl_album1.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_album1.setBounds(632, 229, 41, 17);
		contentPane.add(lbl_album1);

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
		btnAlbumListele.setBackground(new Color(147, 112, 219));
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
		btnAlbumListele.setBounds(170, 8, 150, 50);
		contentPane.add(btnAlbumListele);

		table_2 = new JTable();
		table_2.setBounds(0, 0, 600, 1);
		contentPane.add(table_2);

		JButton btnListele_3 = new JButton("Sarkici Listele");
		btnListele_3.setBackground(new Color(147, 112, 219));
		btnListele_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sayac = 3;
				modelim2.setColumnIdentifiers(kolonlar2);
				modelim2.setRowCount(0);
				ResultSet myRs = baglanti.yap(2);

				try {
					while (myRs.next()) {
						satirlar2[0] = myRs.getString("sanatci_id");
						satirlar2[1] = myRs.getString("sanatci_ad");
						satirlar2[2] = myRs.getString("ulke_ad");
						modelim2.addRow(satirlar2);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim2);

			}
		});
		btnListele_3.setBounds(320, 8, 150, 50);
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
		btnKaydet_1.setBackground(Color.CYAN);
		btnKaydet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, ad, tarih, sanatci, tur, sql_sorgu, sql_tur, sql_sanatci;
				int tur_id, sanatci_id;
				String tur_ids = "";

				String sanatci_ids = "";

				id = txt_album_id.getText();
				ad = txt_album_ad.getText();
				sanatci = txt_album_sanatci.getText();
				tarih = txt_album_tarih.getText();
				tur = txt_album_tur.getText();

				sql_tur = "select tur_id from tur where tur_ad='" + tur + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while (myRs.next()) {
						tur_id = myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sanatci = "select sanatci_id from sanatci where sanatci_ad='" + sanatci + "'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while (myRs2.next()) {
						sanatci_id = myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sorgu = "INSERT INTO album (album_id,album_ad,sanatci_id,tarih,tur_id) VALUES(" + id + ",'" + ad
						+ "'," + "','" + sanatci_ids + "'" + tarih + "','" + tur_ids + "')";

				baglanti.ekle(sql_sorgu);

			}
		});
		btnKaydet_1.setBounds(849, 225, 89, 23);
		contentPane.add(btnKaydet_1);

		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.setBackground(Color.GREEN);
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, ad, tarih, sanatci, tur, sql_sorgu, sql_tur, sql_sanatci;
				int tur_id, sanatci_id;
				String tur_ids = "";
				String sanatci_ids = "";
				id = txt_album_id.getText();
				ad = txt_album_ad.getText();
				tarih = txt_album_tarih.getText();
				tur = txt_album_tur.getText();
				sanatci = txt_album_sanatci.getText();

				sql_tur = "select tur_id from tur where tur_ad='" + tur + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula(sql_tur);
				try {
					while (myRs.next()) {
						tur_id = myRs.getInt("tur_id");
						tur_ids = String.valueOf(tur_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sanatci = "select sanatci_id from sanatci where sanatci_ad='" + sanatci + "'";
				ResultSet myRs2 = baglanti.yap2(sql_sanatci);
				myRs2 = baglanti.sorgula(sql_sanatci);
				try {
					while (myRs2.next()) {
						sanatci_id = myRs2.getInt("sanatci_id");
						sanatci_ids = String.valueOf(sanatci_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sorgu = "UPDATE album SET album_id=" + id + "," + "album_ad='" + ad + "',sanatci_id='" + sanatci_ids
						+ "',tarih='" + tarih + "',tur_id='" + tur_ids + "' WHERE album_id=" + id;

				baglanti.update(sql_sorgu);

			}

		});
		btnUpdate_1.setBounds(948, 225, 89, 23);
		contentPane.add(btnUpdate_1);

		JButton btnSil_1 = new JButton("Sil");
		btnSil_1.setForeground(Color.WHITE);
		btnSil_1.setBackground(Color.RED);
		btnSil_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, sql_sorgu;
				id = txt_album_id.getText();
				sql_sorgu = "DELETE FROM album WHERE album_id=" + id;
				baglanti.sil(sql_sorgu);

			}
		});
		btnSil_1.setBounds(902, 256, 89, 23);
		contentPane.add(btnSil_1);

		JButton btnKaydet_1_1 = new JButton("Kaydet");
		btnKaydet_1_1.setBackground(Color.CYAN);
		btnKaydet_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, ad, ulke, sql_sorgu, sql_tur;
				int ulke_id;
				String ulke_ids = "";

				id = txt_sanatci_id.getText();
				ad = txt_sanatci_ad.getText();
				ulke = txt_sanatci_ulke.getText();

				sql_tur = "select ulke_id from ulke where ulke_ad='" + ulke + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula1(sql_tur);
				try {
					while (myRs.next()) {
						ulke_id = myRs.getInt("ulke_id");
						ulke_ids = String.valueOf(ulke_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sorgu = "INSERT INTO sanatci (sanatci_id,sanatci_ad,ulke_id) VALUES(" + id + ",'" + ad + "','"
						+ ulke_ids + "')";

				baglanti.ekle(sql_sorgu);

			}
		});
		btnKaydet_1_1.setBounds(651, 554, 89, 23);
		contentPane.add(btnKaydet_1_1);

		JButton btnUpdate_1_1 = new JButton("Update");
		btnUpdate_1_1.setBackground(Color.GREEN);
		btnUpdate_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, ad, ulke, sql_sorgu, sql_ulke;
				int ulke_id;
				String ulke_ids = "";
				id = txt_sanatci_id.getText();
				ad = txt_sanatci_ad.getText();
				ulke = txt_sanatci_ulke.getText();

				sql_ulke = "select ulke_id from ulke where ulke_ad='" + ulke + "'";
				ResultSet myRs5 = baglanti.yap2(sql_ulke);
				myRs5 = baglanti.sorgula1(sql_ulke);
				try {
					while (myRs5.next()) {
						ulke_id = myRs5.getInt("ulke_id");
						ulke_ids = String.valueOf(ulke_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sorgu = "UPDATE sanatci SET sanatci_id=" + id + "," + "sanatci_ad='" + ad + "',ulke_id='" + ulke_ids
						+ "' WHERE sanatci_id=" + id;

				baglanti.update(sql_sorgu);

			}
		});
		btnUpdate_1_1.setBounds(764, 554, 89, 23);
		contentPane.add(btnUpdate_1_1);

		JButton btnSil_1_1 = new JButton("Sil");
		btnSil_1_1.setForeground(Color.WHITE);
		btnSil_1_1.setBackground(Color.RED);
		btnSil_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, sql_sorgu;
				id = txt_sanatci_id.getText();
				sql_sorgu = "DELETE FROM sanatci WHERE sanatci_id=" + id;
				baglanti.sil(sql_sorgu);

			}
		});
		btnSil_1_1.setBounds(698, 596, 89, 23);
		contentPane.add(btnSil_1_1);

		JLabel lbl_sanatciid = new JLabel("Id");
		lbl_sanatciid.setBounds(644, 448, 46, 14);
		contentPane.add(lbl_sanatciid);

		JLabel lbl_sanatciad = new JLabel("Ad");
		lbl_sanatciad.setEnabled(true);
		lbl_sanatciad.setBounds(644, 483, 46, 14);
		contentPane.add(lbl_sanatciad);

		JLabel lbl_sanatci_ulke = new JLabel("Ulke");
		lbl_sanatci_ulke.setBounds(644, 519, 46, 14);
		contentPane.add(lbl_sanatci_ulke);

		txt_sanatci_id = new JTextField();
		txt_sanatci_id.setColumns(10);
		txt_sanatci_id.setBounds(690, 446, 86, 20);
		contentPane.add(txt_sanatci_id);

		txt_sanatci_ad = new JTextField();
		txt_sanatci_ad.setText("");
		txt_sanatci_ad.setColumns(10);
		txt_sanatci_ad.setBounds(690, 481, 86, 20);
		contentPane.add(txt_sanatci_ad);

		txt_sanatci_ulke = new JTextField();
		txt_sanatci_ulke.setText("");
		txt_sanatci_ulke.setColumns(10);
		txt_sanatci_ulke.setBounds(690, 517, 86, 20);
		contentPane.add(txt_sanatci_ulke);

		JLabel lbl_album = new JLabel("Album");
		lbl_album.setBounds(902, 34, 45, 13);
		contentPane.add(lbl_album);

		JLabel lbl_sarkici1 = new JLabel("Sarkici");
		lbl_sarkici1.setBounds(660, 414, 45, 13);
		contentPane.add(lbl_sarkici1);

		text_kul_id = new JTextField();
		text_kul_id.setColumns(10);
		text_kul_id.setBounds(1172, 53, 86, 20);
		contentPane.add(text_kul_id);

		text_kul_ad = new JTextField();
		text_kul_ad.setColumns(10);
		text_kul_ad.setBounds(1172, 84, 86, 20);
		contentPane.add(text_kul_ad);

		text_kul_uyelik = new JTextField();
		text_kul_uyelik.setColumns(10);
		text_kul_uyelik.setBounds(1172, 115, 86, 20);
		contentPane.add(text_kul_uyelik);

		JLabel lbl_Id_1 = new JLabel("Id");
		lbl_Id_1.setBounds(1126, 56, 46, 14);
		contentPane.add(lbl_Id_1);

		JLabel lbl_ad_1 = new JLabel("Ad");
		lbl_ad_1.setBounds(1126, 87, 46, 14);
		contentPane.add(lbl_ad_1);

		JLabel lbl_uyelik = new JLabel("Uyelik");
		lbl_uyelik.setBounds(1126, 118, 46, 14);
		contentPane.add(lbl_uyelik);

		JLabel text_lul_eposta = new JLabel("e-posta");
		text_lul_eposta.setBounds(1126, 146, 46, 20);
		contentPane.add(text_lul_eposta);

		JLabel text_kul_sifre = new JLabel("Sifre");
		text_kul_sifre.setBounds(1126, 177, 46, 14);
		contentPane.add(text_kul_sifre);

		JLabel text_kul_ulke = new JLabel("Ulke");
		text_kul_ulke.setBounds(1126, 202, 46, 19);
		contentPane.add(text_kul_ulke);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1172, 146, 150, 20);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1172, 174, 86, 20);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1172, 201, 86, 20);
		contentPane.add(textField_6);

		JLabel lbl_kullanici = new JLabel("Kullanici");
		lbl_kullanici.setBounds(1126, 33, 127, 14);
		contentPane.add(lbl_kullanici);

		JButton btnKaydet_1_2 = new JButton("Kaydet");
		btnKaydet_1_2.setBackground(Color.CYAN);
		btnKaydet_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, ad, ulke, sifre, eposta, uyelik, sql_sorgu, sql_tur;
				int uyelik_id;
				String uyelik_ids = "";

				id = text_kul_id.getText();
				ad = text_kul_ad.getText();
				uyelik = text_kul_uyelik.getText();
				eposta = textField_4.getText();
				sifre = textField_5.getText();
				ulke = textField_6.getText();

				sql_tur = "select kul_uyelik_id from kullanici_islem where kul_uyelik='" + uyelik + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula1(sql_tur);
				try {
					while (myRs.next()) {
						uyelik_id = myRs.getInt("kul_uyelik_id");
						uyelik_ids = String.valueOf(uyelik_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				sql_sorgu = "INSERT INTO kullanici (kul_id,kul_ad,kul_uyelik_id,kul_email,kul_sifre,ulke) VALUES('" + id
						+ "','" + ad + "','" + uyelik_ids + "','" + eposta + "','" + sifre + "','" + ulke + "')";

				baglanti.ekle(sql_sorgu);

				String sql_sorgu1 = "INSERT INTO liste(kullanici_id,tur_id)VALUES(" + id + ",1);";
				baglanti.ekle(sql_sorgu1);
				String sql_sorgu2 = "INSERT INTO liste(kullanici_id,tur_id)VALUES(" + id + ",2);";
				baglanti.ekle(sql_sorgu2);
				String sql_sorgu3 = "INSERT INTO liste(kullanici_id,tur_id)VALUES(" + id + ",3);";
				baglanti.ekle(sql_sorgu3);

			}
		});
		btnKaydet_1_2.setBounds(1112, 241, 89, 23);
		contentPane.add(btnKaydet_1_2);

		JButton btnUpdate_1_2 = new JButton("Update");
		btnUpdate_1_2.setBackground(Color.GREEN);
		btnUpdate_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, ad, ulke, sifre, eposta, uyelik, sql_sorgu, sql_tur;
				int uyelik_id;
				String uyelik_ids = "";

				id = text_kul_id.getText();
				ad = text_kul_ad.getText();
				uyelik = text_kul_uyelik.getText();
				eposta = textField_4.getText();
				sifre = textField_5.getText();
				ulke = textField_6.getText();

				sql_tur = "select kul_uyelik_id from kullanici_islem where kul_uyelik='" + uyelik + "'";
				ResultSet myRs = baglanti.yap2(sql_tur);
				myRs = baglanti.sorgula1(sql_tur);
				try {
					while (myRs.next()) {
						uyelik_id = myRs.getInt("kul_uyelik_id");
						uyelik_ids = String.valueOf(uyelik_id);
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				sql_sorgu = "UPDATE kullanici SET kul_id=" + id + "," + "kul_ad='" + ad + "',kul_uyelik_id='"
						+ uyelik_ids + "',kul_email='" + eposta + "',kul_sifre='" + sifre + "',ulke='" + ulke
						+ "' WHERE kul_id=" + id;
				System.out.println(sql_sorgu);

				baglanti.update(sql_sorgu);

			}
		});
		btnUpdate_1_2.setBounds(1211, 241, 89, 23);
		contentPane.add(btnUpdate_1_2);

		JButton btnSil_1_2 = new JButton("Sil");
		btnSil_1_2.setForeground(Color.WHITE);
		btnSil_1_2.setBackground(Color.RED);
		btnSil_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id, sql_sorgu;
				id = text_kul_id.getText();
				sql_sorgu = "DELETE FROM kullanici WHERE kul_id=" + id;
				baglanti.sil(sql_sorgu);

			}
		});
		btnSil_1_2.setBounds(1165, 272, 89, 23);
		contentPane.add(btnSil_1_2);

		JButton btn_kullanici_listele = new JButton("Kullanici Listele");
		btn_kullanici_listele.setBackground(new Color(147, 112, 219));
		btn_kullanici_listele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				sayac = 4;

				modelim3.setColumnIdentifiers(kolonlar3);
				modelim3.setRowCount(0);
				ResultSet myRs = baglanti.yap(9);

				try {
					while (myRs.next()) {
						satirlar3[0] = myRs.getString("kul_id");
						satirlar3[1] = myRs.getString("kul_ad");
						satirlar3[2] = myRs.getString("kul_uyelik");
						satirlar3[3] = myRs.getString("kul_email");
						satirlar3[4] = myRs.getString("kul_sifre");
						satirlar3[5] = myRs.getString("ulke");
						modelim3.addRow(satirlar3);
					}

				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				table.setModel(modelim3);

			}
		});
		btn_kullanici_listele.setBounds(472, 8, 150, 50);
		contentPane.add(btn_kullanici_listele);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(giris.adres));
		lblNewLabel_2.setBounds(0, 0, 1360, 760);
		contentPane.add(lblNewLabel_2);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (sayac == 1) {
					txt_id.setText(modelim.getValueAt(table.getSelectedRow(), 0).toString());
					txt_ad.setText((String) modelim.getValueAt(table.getSelectedRow(), 1));
					txt_tarih.setText((String) modelim.getValueAt(table.getSelectedRow(), 2));
					txt_tur.setText((String) modelim.getValueAt(table.getSelectedRow(), 3));
					txt_sure.setText((String) modelim.getValueAt(table.getSelectedRow(), 4));
					txt_dinlenme.setText((String) modelim.getValueAt(table.getSelectedRow(), 5));
					txt_album.setText((String) modelim.getValueAt(table.getSelectedRow(), 6));
					txt_sanatci.setText((String) modelim.getValueAt(table.getSelectedRow(), 7));

					fonksiyon1();
					fonksiyon();
					fonksiyon3();
				}
				if (sayac == 2) {
					txt_album_id.setText(modelim1.getValueAt(table.getSelectedRow(), 0).toString());
					txt_album_ad.setText((String) modelim1.getValueAt(table.getSelectedRow(), 1));
					txt_album_sanatci.setText((String) modelim1.getValueAt(table.getSelectedRow(), 2));
					txt_album_tarih.setText((String) modelim1.getValueAt(table.getSelectedRow(), 3));
					txt_album_tur.setText((String) modelim1.getValueAt(table.getSelectedRow(), 4));

					fonksiyon();
					fonksiyon2();
					fonksiyon3();
				}

				if (sayac == 3) {
					txt_sanatci_id.setText(modelim2.getValueAt(table.getSelectedRow(), 0).toString());
					txt_sanatci_ad.setText((String) modelim2.getValueAt(table.getSelectedRow(), 1));
					txt_sanatci_ulke.setText((String) modelim2.getValueAt(table.getSelectedRow(), 2));

					fonksiyon3();
					fonksiyon1();
					fonksiyon2();

				}

				if (sayac == 4) {
					text_kul_id.setText(modelim3.getValueAt(table.getSelectedRow(), 0).toString());
					text_kul_ad.setText((String) modelim3.getValueAt(table.getSelectedRow(), 1));
					text_kul_uyelik.setText((String) modelim3.getValueAt(table.getSelectedRow(), 2));
					textField_4.setText((String) modelim3.getValueAt(table.getSelectedRow(), 3));
					textField_5.setText((String) modelim3.getValueAt(table.getSelectedRow(), 4));
					textField_6.setText((String) modelim3.getValueAt(table.getSelectedRow(), 5));

					fonksiyon2();
					fonksiyon();
					fonksiyon1();

				}

			}
		});
	}

	void fonksiyon() {
		txt_sanatci_id.setText("");
		txt_sanatci_ad.setText("");
		txt_sanatci_ulke.setText("");
	}

	void fonksiyon1() {
		txt_album_id.setText("");
		txt_album_ad.setText("");
		txt_album_sanatci.setText("");
		txt_album_tarih.setText("");
		txt_album_tur.setText("");
	}

	void fonksiyon2() {
		txt_id.setText("");
		txt_ad.setText("");
		txt_tarih.setText("");
		txt_tur.setText("");
		txt_sure.setText("");
		txt_dinlenme.setText("");
		txt_album.setText("");
		txt_sanatci.setText("");
	}

	void fonksiyon3() {
		text_kul_id.setText("");
		text_kul_ad.setText("");
		text_kul_uyelik.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
	}

}