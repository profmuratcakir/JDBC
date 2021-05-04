package techproed.jdbcExamples;

import java.sql.*;   // Tum JDBC metotlarini eklemek icin 

public class JdbcQuery02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String yol = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(yol, "meryem", "1234");
		
		Statement st = con.createStatement();
		
		/*=======================================================================
		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
		========================================================================*/ 
		String selectQuery = "SELECT * FROM bolumler";
		ResultSet tablo1 = st.executeQuery(selectQuery);
		
		while(tablo1.next()) {
			System.out.println(tablo1.getInt(1) + " " + tablo1.getString(2) + " "+tablo1.getString(3));
		}
		System.out.println("=====================================");
		
		/*=======================================================================
		 ORNEK2: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve 
 		 maaslarini, maas ters sirali olarak listeleyiniz
		========================================================================*/ 
		String q2 = "SELECT personel_isim,maas"
				 + " FROM personel"
				 + " WHERE bolum_id IN(10,30)"
				 + " ORDER BY maas DESC";
		
		ResultSet sonuc = st.executeQuery(q2);
		
		while(sonuc.next()) {
			System.out.println("ISIM:" + sonuc.getString(1) + "\t" + "MAAS:" + sonuc.getInt(2));
		}
		
		con.close();
		st.close();
		sonuc.close();
		tablo1.close();
	
	}

}
