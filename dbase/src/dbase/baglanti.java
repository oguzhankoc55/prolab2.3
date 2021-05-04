package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class baglanti {
	 static ResultSet yap() {
		 ResultSet myRs=null;
	try
    {
	  
      String myDriver = "com.mysql.jdbc.Driver";
      String db = "jdbc:mysql://localhost/deneme";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(db, "root", "850542ok");
     
     String sorgu = "SELECT * FROM ogrenci";

      Statement st = conn.createStatement();
     
       myRs = st.executeQuery(sorgu);
   
      /*
      while (rs.next())
      {
        String s_ad = rs.getString("ogrenci_ad");
        String s_soyad = rs.getString("ogrenci_soyad");
       
        System.out.print(s_ad + " " + s_soyad + "\n");
       
      }
      st.close();*/
    }
   
    catch (Exception a)
    {
      System.err.println("Hata ! ");
      System.err.println(a.getMessage());
    }
	   return myRs;
	}

}
