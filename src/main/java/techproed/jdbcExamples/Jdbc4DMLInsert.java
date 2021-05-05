package techproed.jdbcExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc4DMLInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String yol = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(yol, "meryem", "1234");
		
		Statement st = con.createStatement();
		
		/*=======================================================================
		  ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') 
		  ekleyelim ve eklenen kaydi teyit icin sorgulayalim.
		========================================================================*/ 
		
//		String q1 = "INSERT INTO bolumler VALUES(80, 'ARGE','ISTANBUL')";
//		int s1 = st.executeUpdate(q1);
//		System.out.println(s1 + " satir eklendi");
		
		ResultSet rs = st.executeQuery("SELECT * FROM bolumler");
        
        while(rs.next()) {
            System.out.println("Bölüm ID:" + rs.getInt("bolum_id")+" "+"Bölüm Isim:" + rs.getString("bolum_isim")+"\t"+"Konum:" + rs.getString("konum"));
        }
               
        /*=======================================================================
		  ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
		 ========================================================================*/ 
        
        // 1.YONTEM
     	// -----------------------------------------------
     	// Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin 
     	// yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
        // bu kotu bir yaklasimdir.
     		
     	String [] sorgular = {"INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
     		            	  "INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')",
     		            	  "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')"};
		
     	con.close();
		st.close();
		rs.close();
		
	}

}
