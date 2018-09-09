package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import posicoes.Companhia;
import posicoes.Posicao;
import posicoes.Propriedade;
import tabuleiro.Dado;
import tabuleiro.Jogador;

public class JogoTest {
	Jogo jogo;
	Jogador j1;
	Dado d1, d2;
	Posicao p1;
	Posicao p2;

	@Before
	public void setUp() {
		jogo = new Jogo();
		j1 = new Jogador("Ana", "preto");
		d1 = new Dado();
		d2 = new Dado();
		p1 = new Propriedade("lugar aleatorio", 200, 2);
		p2 = new Companhia("place aleatorio", 150, 40);
	}


	@Test
	public void testEscolhaDeCompra() {
		jogo.escolhaDeCompra("sim", j1, p1);
		assertTrue(1300.00 == j1.getDinheiro());
		
		j1.setDinheiro(1500);
		
		jogo.escolhaDeCompra("sim", j1, p2);
		assertTrue(1350.00 == j1.getDinheiro());
	}

	@Test
	public void testCarregandoCores() {
		ArrayList<String> cores = jogo.carregandoCores();
		for (int i = 0; i < cores.size(); i++) {
			if(i == 0) {
				assertEquals("preto", cores.get(i));
			} else if (i == 1) {
				assertEquals("branco", cores.get(i));
			} else if (i == 2) {
				assertEquals("vermelho", cores.get(i));
			} else if (i == 3) {
				assertEquals("verde", cores.get(i));
			} else if (i == 4) {
				assertEquals("azul", cores.get(i));
			} else if (i == 5) {
				assertEquals("amarelo", cores.get(i));
			} else if (i == 6) {
				assertEquals("laranja", cores.get(i));
			} else if (i == 7) {
				assertEquals("rosa", cores.get(i));
			}
		}
	}


	@Test
	public void testCarregandoJogadores() {
		ArrayList<Jogador> jogadores = new ArrayList<>();
		jogadores.add(j1);
		for(Jogador j: jogadores) {
			assertEquals("Ana", j.getNome());
			assertEquals("preto", j.getCor());
		}
	}

}
