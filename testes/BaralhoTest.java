package testes;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import Cartas.Baralho;
import Cartas.CartaSorte;

public class BaralhoTest {
	CartaSorte carta;
	Baralho b;
	
	@Before
	public void setUp() {
		
		carta = new CartaSorte();
		b = new Baralho();
		
	}

	@Test
	public void testCriarBaralho() {
		
		Stack<CartaSorte> baralho = b.criarBaralho();
		assertEquals("Sua empresa foi multada por poluir demais. Pague 200", baralho.get(0).getDescricao());
		
	}

	@Test
	public void testPuxarCarta() {

		CartaSorte c = b.puxarCarta();
		assertEquals("Tirou primeiro lugar no torneio de golfe. Receba 100", c.getDescricao());
		
		
	}

}
