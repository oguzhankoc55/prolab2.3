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

public class fm1 extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolonlar= {"No","Ýsim","Soyisim"};
	Object[] satirlar= new Object[3];
	

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
		setBounds(100, 100, 633, 389);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		getContentPane().add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		modelim.setColumnIdentifiers(kolonlar);
		
		table_1.setModel(modelim);
		
		
		
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet myResultSet=baglanti.yap();
				try {
					while(myResultSet.next()) {
						satirlar[0]=myResultSet.getString("ogrenci_no");
						satirlar[1]=myResultSet.getString("ogrenci_ad");
						satirlar[2]=myResultSet.getString("ogrenci_soyad");
					
						modelim.addRow(satirlar);}
				} catch (Exception e2) {
					e2.printStackTrace();
					// TODO: handle exception
				}
				
			}
		});
		scrollPane_1.setRowHeaderView(btnNewButton);
		
		
	}

}
