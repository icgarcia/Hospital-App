package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myConnection {

		public static Connection getConnection() {
			
			Connection con = null;
			String url = "jdbc:sqlserver://DESKTOP-2837T8I;database=MedicalOffice;integratedSecurity=true";
	        try {
	        	con = DriverManager.getConnection(url);
	        }
	        catch (SQLException e) {
	             System.out.println("Error");
	             e.printStackTrace();
	             }
	        
			return con;
		}
}
