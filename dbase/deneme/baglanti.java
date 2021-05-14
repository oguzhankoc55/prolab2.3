package deneme;

import java.sql.*;


public class baglanti {
	static Connection conn;
	static Statement st;
	
	static ResultSet yap() {
		 ResultSet myRs=null;
	try
    {
	  String myDriver = "com.mysql.jdbc.Driver";
	  String db = "jdbc:mysql://localhost/prolab";
      Class.forName(myDriver);
      conn = DriverManager.getConnection(db, "root", "1234");
     String sorgu = "select sarki_id,sarki_adi,sarki_tarih,tur_ad ,sarki_sure,sarki_dinlenme,album_ad,sanatci_ad from sarki,tur,album,sanatci "
     		+ " where sarki.tur_id=tur.tur_id and sarki.album_id=album.album_id and sarki.sanatci_id=sanatci.sanatci_id ORDER BY sarki_id";

      st = conn.createStatement();
     myRs = st.executeQuery(sorgu);
    }
   
    catch (Exception a)
    {
      System.err.println("Hata ! ");
      System.err.println(a.getMessage());
    }
	   return myRs;
	}

	static ResultSet yap1(String secilen1,int kull_id) {
		 ResultSet myRs=null;
	try
   {
	  String myDriver = "com.mysql.jdbc.Driver";
     String db = "jdbc:mysql://localhost/prolab";
     Class.forName(myDriver);
     conn = DriverManager.getConnection(db, "root", "1234");
     String sql_sorgu="";
    		 //"select *from sarki where sarki_Id in (select sarki_Id from liste where idkull="+kull_id+" and liste_adi='"+secilen1+"')";
     System.out.println(sql_sorgu);
     st = conn.createStatement();
    myRs = st.executeQuery(sql_sorgu);
   }
  
   catch (Exception a)
   {
     System.err.println("Hata ! ");
     System.err.println(a.getMessage());
   }
	   return myRs;
	}
	static ResultSet yap2(String sql_sorgu) {
		 ResultSet myRs=null;
	try
  {
	  String myDriver = "com.mysql.jdbc.Driver";
	  String db = "jdbc:mysql://localhost/prolab";
    Class.forName(myDriver);
    conn = DriverManager.getConnection(db, "root", "1234");
    //String sql_sorgu;
    System.out.println(sql_sorgu);
    st = conn.createStatement();
   myRs = st.executeQuery(sql_sorgu);
  }
 
  catch (Exception a)
  {
    System.err.println("Hata ! ");
    System.err.println(a.getMessage());
  }
	   return myRs;
	}
	static ResultSet yap3() {
		 ResultSet myRs=null;
	try
   {
	  String myDriver = "com.mysql.jdbc.Driver";
	  String db = "jdbc:mysql://localhost/prolab";
     Class.forName(myDriver);
     conn = DriverManager.getConnection(db, "root", "1234");
     String sorgu = "select album_id,album_ad,sanatci_ad,tarih,tur_ad from tur,album,sanatci "
    		+ " where album.tur_id=tur.tur_id and album.sanatci_id=sanatci.sanatci_id ORDER BY album_id";

     st = conn.createStatement();
    myRs = st.executeQuery(sorgu);
   }
  
   catch (Exception a)
   {
     System.err.println("Hata ! ");
     System.err.println(a.getMessage());
   }
	   return myRs;
	}
	static ResultSet yap4() {
		 ResultSet myRs=null;
	try
  {
	  String myDriver = "com.mysql.jdbc.Driver";
	  String db = "jdbc:mysql://localhost/prolab";
    Class.forName(myDriver);
    conn = DriverManager.getConnection(db, "root", "1234");
    String sorgu = "select sanatci_id,sanatci_ad,ulke_ad from sanatci,ulke "
   		+ " where sanatci.ulke_id=ulke.ulke_id  ORDER BY sanatci_id";

    st = conn.createStatement();
   myRs = st.executeQuery(sorgu);
  }
 
  catch (Exception a)
  {
    System.err.println("Hata ! ");
    System.err.println(a.getMessage());
  }
	   return myRs;
	}
	
	static ResultSet yap5() {
		 ResultSet myRs=null;
	try
 {
	  String myDriver = "com.mysql.jdbc.Driver";
	  String db = "jdbc:mysql://localhost/prolab";
   Class.forName(myDriver);
   conn = DriverManager.getConnection(db, "root", "1234");
   String sorgu = "select liste_id,kul_ad,tur_ad from liste,kullanici,tur "
  		+ " where liste.kullanici_id=kullanici.kul_id and liste.tur_id = tur.tur_id  ORDER BY liste_id";

   st = conn.createStatement();
  myRs = st.executeQuery(sorgu);
 }

 catch (Exception a)
 {
   System.err.println("Hata ! ");
   System.err.println(a.getMessage());
 }
	   return myRs;
	}
	
	static void ekle(String sql_sorgu) {
		try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	static void update(String sql_sorgu) {
		try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void sil(String sql_sorgu) {
		try {
			st.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static ResultSet sorgula(String sql_sorgu) {
		 ResultSet myRs=null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return myRs;
	}
	static ResultSet sorgula1(String sql_sorgu) {
		 ResultSet myRs=null;
		 try {
			myRs = st.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return myRs;
	}

	
	
	

}
