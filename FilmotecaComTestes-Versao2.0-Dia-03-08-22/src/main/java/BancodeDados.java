import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancodeDados {

	private static Connection cnx = null;
	
		public static Connection getConnection() {
		try {
		cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/filmes", "postgres","123456");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Banco não conectado");
			
	
		}
		return cnx;
	}

	



		
}
