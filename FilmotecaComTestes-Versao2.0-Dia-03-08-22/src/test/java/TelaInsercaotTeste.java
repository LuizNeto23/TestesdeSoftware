import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class TelaInsercaotTeste {

	@Test
	
	//Certifica que as duas frases,apesar de serem iguais, estao em formatos diferentes
	public void confirmaEnvio() throws SQLException {
		
		
		PreparedStatement ps;
		String ts;

		ps = BancodeDados.getConnection().prepareStatement("Insert into teste(titulo,sinopse,produtora,ator,estilo)"+"values(?,?,?,?,?)");
		
			
		ps.setString(1, "A");	
		ps.setString(2, "A");
		ps.setString(3, "A");
		ps.setString(4, "A");
		ps.setString(5, "A");
		
		ts = ("Insert into teste(titulo,sinopse,produtora,ator,estilo)"+"values('A','A','A','A','A')");
		assertEquals(ps,ts);

			
		}

}
