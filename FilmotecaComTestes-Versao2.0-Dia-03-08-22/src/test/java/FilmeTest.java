import static org.junit.Assert.*;
import org.junit.Test;

public class FilmeTest{

    @Test
    public void testFilmeNull(){
        Filme filme = new Filme("a","a","a","a","a");
        assertNotNull(filme.getTitulo());
        assertNotNull(filme.getAtorPrincipal());
        assertNotNull(filme.getEstilo());
        assertNotNull(filme.getProdutora());
        assertNotNull(filme.getSinopse());
       
    }

    @Test
    public void testGetSetTitulo(){
        Filme filme = new Filme();
        filme.setTitulo("titulo");
        assertEquals(filme.getTitulo(), "titulo");

    }

    @Test
    public void testGetSetAtorPrincipal(){
        Filme filme = new Filme();
        filme.setAtorPrincipal("atorPrincipal");
        assertEquals(filme.getAtorPrincipal(), "atorPrincipal");

    }

    @Test
    public void testGetSetEstilo(){
        Filme filme = new Filme();
        filme.setEstilo("estilo");
        assertEquals(filme.getEstilo(), "estilo");

    }

    @Test
    public void testGetSetProdutora(){
        Filme filme = new Filme();
        filme.setProdutora("produtora");
        assertEquals(filme.getProdutora(), "produtora");

    }

    @Test
    public void testGetSetSinopse(){
        Filme filme = new Filme();
        filme.setSinopse("sinopse");
        assertEquals(filme.getSinopse(), "sinopse");

    }


}