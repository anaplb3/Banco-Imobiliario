package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Companhia;
import tabuleiro.Jogador;

public class CompanhiaTest {
	Companhia c;
	Jogador j1, j2;

	@Before
	public void setUp() throws Exception {
		c = new Companhia("bla", 50, 50);
		j1 = new Jogador("ana", "preto");
		j2 = new Jogador("pedro", "amarelo");
		
		j1.setDinheiro(200);
		j2.setDinheiro(200);
		
		c.setProprietario(j2);
	}

	@Test
	public void testPagandoAluguelOuMultiplicador() {
		c.pagandoAluguelOuMultiplicador(j1, c, 1, 1);
		assertEquals(100, j1.getDinheiro(), 0);
		assertEquals(300, j2.getDinheiro(), 0);
		
		c.pagandoAluguelOuMultiplicador(j2, c, 1, 1);
		assertEquals(300, j2.getDinheiro(), 0);
	}

}
