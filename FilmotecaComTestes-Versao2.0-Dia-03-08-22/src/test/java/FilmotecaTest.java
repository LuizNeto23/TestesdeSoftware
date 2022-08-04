import static org.junit.Assert.*;

import org.junit.Test;

public class FilmotecaTest {

	
	@Test
	//Teste para verificar se os valores iniciais s�o nulos
	public void testFilmotecaInicioNull() {
		Filmoteca filmoteca = new Filmoteca();
		assertNull(filmoteca.primeiroTitulo);
		assertNull(filmoteca.ultimoTitulo);
		assertNull(filmoteca.primeiroEstilo);
		assertNull(filmoteca.ultimoEstilo);
		assertNull(filmoteca.primeiroAP);
		assertNull(filmoteca.ultimoAP);
	}

	@Test
	public void testEstaVazia() {
		Filmoteca filmoteca = new Filmoteca();
	
		
		
		
		
		assertTrue(filmoteca.estaVazia());
	}

	
	@Test
	public void testExcluiFilme() {
		Filmoteca filmoteca = new Filmoteca();
		filmoteca.estaVazia();
		assertNotNull(filmoteca.excluiFilme(null));
	}

	@Test
	public void testRetornaPrimeiroTitulo() {
		Filmoteca filmoteca = new Filmoteca();
		filmoteca.insereOrdenado("a", "a", "a", "a", "a");

		assertEquals(filmoteca.retornaPrimeiro(), filmoteca.primeiroTitulo);
		
		
	}
	@Test
	public void testRetornaPrimeiroAP() {
		Filmoteca filmoteca = new Filmoteca();
		filmoteca.insereOrdenado("a", "a", "a", "a", "a");

		assertEquals(filmoteca.retornaPrimeiro(), filmoteca.primeiroAP);
		
	}

	@Test
	public void testRetornaPrimeiroEstilo() {
		Filmoteca filmoteca = new Filmoteca();
		filmoteca.insereOrdenado("a", "a", "a", "a", "a");

		assertEquals(filmoteca.retornaPrimeiro(), filmoteca.primeiroEstilo);
		
		
	}



}
