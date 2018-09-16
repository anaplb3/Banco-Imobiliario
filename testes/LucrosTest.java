package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Lucros;
import tabuleiro.Jogador;

public class LucrosTest {
	Lucros l;
	Jogador j1;

	@Before
	public void setUp() throws Exception {
		l = new Lucros();
		
		j1 = new Jogador("ana", "preto");
		j1.setDinheiro(100);
	}

	@Test
	public void testAlterandoSaldoDoJogador() {
		l.alterandoSaldoDoJogador(j1);
		assertEquals(300, j1.getDinheiro(), 0);
	}

}
