package testes;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import cartas.Baralho;
import cartas.Carta;

public class BaralhoTest {
	Carta carta;
	Baralho b;
	Stack<Carta> baralho;
	
	@Before
	public void setUp() {
		
		carta = new Carta();
		b = new Baralho();
		baralho = b.criarBaralho();
		
	}

	@Test
	public void testCriarBaralho() {
		Carta base = baralho.firstElement();
		
		assertEquals(base.getDescricao(), baralho.get(0).getDescricao());
		
	}

	//Testando se 
	@Test
	public void testPuxarCarta() {
		Carta carta = baralho.peek();
		Carta c = b.puxarCarta();
		assertEquals(carta.getDescricao(), c.getDescricao());
		
	}
	
	@Test
	public void testRecolocandoNaPilha() {
		Carta c = b.puxarCarta();

		baralho = b.recolocandoNaPilha(c);
		assertEquals(c.getDescricao(), baralho.get(0).getDescricao());
		
	}
	

}
