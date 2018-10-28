package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Companhia;
import tabuleiro.Jogador;

import java.util.ArrayList;

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
		c.pagandoMultiplicador(j1, 1, 1);
		assertEquals(100, j1.getDinheiro(), 0);
		assertEquals(300, j2.getDinheiro(), 0);

		c.pagandoMultiplicador(j2, 1, 1);
		assertEquals(300, j2.getDinheiro(), 0);
	}

	@Test
	public void testCriandoCompanhias() {
		ArrayList<Companhia> companhias = c.criandoCompanhias();

		Companhia teste1 = companhias.get(0);
		Companhia teste2 = companhias.get(1);
		Companhia teste3 = companhias.get(2);
		Companhia teste4 = companhias.get(3);
		Companhia teste5 = companhias.get(4);
		Companhia teste6 = companhias.get(5);

		assertEquals("Companhia Ferroviária", teste1.getNome());
		assertEquals(200, teste1.getPreco());
		assertEquals(50, teste1.getValorASerPago());

		assertEquals("Companhia de Viação", teste2.getNome());
		assertEquals(200, teste2.getPreco());
		assertEquals(50, teste2.getValorASerPago());

		assertEquals("Companhia de Táxi", teste3.getNome());
		assertEquals(150, teste3.getPreco());
		assertEquals(40, teste3.getValorASerPago());

		assertEquals("Companhia de Navegação", teste4.getNome());
		assertEquals(150, teste4.getPreco());
		assertEquals(40, teste4.getValorASerPago());

		assertEquals("Companhia de Aviação", teste5.getNome());
		assertEquals(200, teste5.getPreco());
		assertEquals(50, teste5.getValorASerPago());

		assertEquals("Companhia de Táxi Aéreo", teste6.getNome());
		assertEquals(200, teste6.getPreco());
		assertEquals(50, teste6.getValorASerPago());
	}

}
