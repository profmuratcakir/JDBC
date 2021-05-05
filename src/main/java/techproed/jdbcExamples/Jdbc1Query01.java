package techproed.jdbcExamples;

import java.sql.*;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		// 1) Ilgili driver'i yuklemeliyiz.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2) Baglanti olusturmaliyiz.
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain", "Meryem", "1234");
		
		// 3) SQL komutlari icin bir Statement nesnesi olsutur.
		Statement st = con.createStatement();
		
		// 4) SQL ifadeleri yazabilir ve calistirabiliriz.
		// (Personel tablosundaki personel_id'si 7369 olan personelin adini sorgulayiniz).
		
		ResultSet isim = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE personel_id=7369");
		
		// 5) Sonuclari aldik ve isledik.
		while(isim.next()) {
			System.out.println("Personel Adi:" + isim.getString("personel_isim") );
			System.out.println("Personel Adi:" + isim.getString(1) + " Maas:" + isim.getInt(2));
		}
		
		// 6) Olusturulan nesneleri bellekten kaldiralim.
		con.close();
		st.close();
		isim.close();
	}	
}
