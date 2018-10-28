package testes;

import static org.junit.Assert.*;

import jogo.Jogo;
import org.junit.Before;
import org.junit.Test;

import posicoes.Prisao;
import tabuleiro.Dado;
import tabuleiro.Jogador;

public class PrisaoTest {
	Prisao prisao;
	Jogador j1;
	Dado d1, d2;
	Jogo jogo;
	
	@Before
	public void setUp() {
		prisao = new Prisao();
		j1 = new Jogador("ana", "preto");
		j1.setPrisioneiro(false);
		d1 = d1.getInstance();
		d2 = d2.getInstance();
		jogo = new Jogo();
		jogo.setIndiceDoJogador(0);
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
		prisao.checandoLiberdade(jogo, null, "carta", j1, d1, d2);
		assertFalse(j1.isCartaoLiberdade());
		assertFalse(j1.isPrisioneiro());
		
		j1.setPrisioneiro(true);
		prisao.checandoLiberdade(jogo, null, "carta", j1, d1, d2);
		assertTrue(j1.isPrisioneiro());
		
		
		//Testando pagamento
		j1.setDinheiro(100);
		prisao.checandoLiberdade(jogo, null, "pagar", j1, d1, d2);
		assertEquals(50, j1.getDinheiro(), 0);
		assertFalse(j1.isPrisioneiro());
		
		
	}

}
