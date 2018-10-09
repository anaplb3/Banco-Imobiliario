package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Prisao;
import tabuleiro.Dado;
import tabuleiro.Jogador;

public class PrisaoTest {
	Prisao prisao;
	Jogador j1;
	Dado d1, d2;
	
	@Before
	public void setUp() {
		prisao = new Prisao();
		j1 = new Jogador("ana", "preto");
		j1.setPrisioneiro(false);
		d1 = new Dado();
		d2 = new Dado();
	}

	@Test
	public void caindoNaPrisaoTest() {
		prisao.caindoNaPrisao(j1);
		assertTrue(j1.isPrisioneiro());
	}
	
	@Test
	public void checandoLiberdadeTest() {
		
		//Testando carta liberdade
		j1.setCartaoLiberdade(true);
		prisao.checandoLiberdade(null, null, "carta", j1, d1, d2, 0);
		assertFalse(j1.isCartaoLiberdade());
		assertFalse(j1.isPrisioneiro());
		
		j1.setPrisioneiro(true);
		prisao.checandoLiberdade(null, null, "carta", j1, d1, d2, 0);
		assertTrue(j1.isPrisioneiro());
		
		
		//Testando pagamento
		j1.setDinheiro(100);
		prisao.checandoLiberdade(null, null, "pagar", j1, d1, d2, 0);
		assertEquals(50, j1.getDinheiro(), 0);
		assertFalse(j1.isPrisioneiro());
		
		
	}

}
