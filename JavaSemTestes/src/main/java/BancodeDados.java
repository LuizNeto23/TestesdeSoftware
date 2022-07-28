import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BancodeDados {

	private static Connection cnx = null;
	
		public static Connection getConnection() {
		try {
		cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/filmes", "postgres","123456");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
	
		}
		return cnx;
	}

		public static void printTable(Object conn, String string) {
			// TODO Auto-generated method stub
			
		}



		
}
