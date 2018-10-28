package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import posicoes.Posicao;
import posicoes.Propriedade;
import tabuleiro.Jogador;

public class JogadorTest {
	Jogador j1;
	Posicao p;

	@Before
	public void setUp() {
		j1 = new Jogador("ana", "preto");
		p = new Propriedade();
	}

	@Test
	public void testAdicionandoPropriedade() {
		j1.adicionandoPropriedade(p);
		for(Posicao prop: j1.getPropriedades()) {
			assertEquals(p, prop);
		}
	}

	@Test
	public void status() {
		j1.status(p);
	}

}
