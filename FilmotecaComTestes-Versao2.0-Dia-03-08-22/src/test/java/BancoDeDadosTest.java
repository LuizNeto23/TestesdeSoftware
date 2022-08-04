import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class BancoDeDadosTest {

	@Test
	
	public void testNotNull() {

		assertNotNull (new BancodeDados());
		assertNotNull (new Filme());
		assertNotNull (new Main());
		assertNotNull (new Filme());
		assertNotNull (new TelaInsercao());
		
	}
	
	//Teste criado para verificar se o endere�o da conex�o � condizente. O endere�o errado verifica se h� exce��o
	@Test
	public void testTryCatchEnderecoBD() {
		try {
			DriverManager.getConnection("Endereco errado");
			fail();
			
			
			} catch (SQLException e) {
					System.out.println("Encontrou a excecao");		
		
			}
			
		}
	
}