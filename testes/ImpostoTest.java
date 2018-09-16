package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Imposto;
import tabuleiro.Jogador;

public class ImpostoTest {
	Imposto i;
	Jogador j1;

	@Before
	public void setUp() throws Exception {
		i = new Imposto();
		j1 = new Jogador("ana", "preto");
		j1.setDinheiro(200);
	}

	@Test
	public void testAlterandoSaldoDoJogador() {
		i.alterandoSaldoDoJogador(j1);
		assertEquals(0, j1.getDinheiro(), 0);
	}

}
