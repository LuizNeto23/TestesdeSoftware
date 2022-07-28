import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Filmoteca filmoteca = new Filmoteca();
		//filmoteca.insereOrdenado("Vingadores", "Filme muito louco", "Disney", "Robert Downey Jr.", "Acão/Fantasia");
		int i;
		for(i=0;i>10;i++) {
		PreparedStatement ps = BancodeDados.getConnection().prepareStatement("Select * from teste where titulo = '?'");
			filmoteca.insereOrdenado(null, null, null, null, null);	
				
				
				;
		}

		
		
		
		Tela tela = new Tela();
		tela.inicializaTela(filmoteca);
		
		
		
	}

}
