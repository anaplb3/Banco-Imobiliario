package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import jogo.Jogo;
import posicoes.Posicao;
import posicoes.Propriedade;
import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;

public class JogoTest {
	Jogo jogo;
	ArrayList<Posicao> tabuleiro;
	ArrayList<Jogador> jogadores;
	Jogador j1, j2;
	int contador;
	ArrayList<String> lista_de_cores;

	@Before
	public void setUp() throws Exception {
		Tabuleiro tab = new Tabuleiro();
		tabuleiro = tab.criandoTab();
		
		jogo = new Jogo();
		contador = 0;
		
		j1 = new Jogador("ana", "preto");
		j1.setDinheiro(200);
		j2 = new Jogador("joao", "branco");
		
		lista_de_cores = jogo.carregandoCores();
		
		jogadores = new ArrayList<>();
		jogadores.add(j1);
		jogadores.add(j2);
		
		jogo.setJogadores(jogadores);
	}



	@Test
	public void testPegandoPosicaoNoTabuleiro() {
		j1.setPosicao(40);
		
		Posicao p = jogo.pegandoPosicaoNoTabuleiro(0, 1, tabuleiro, j1);
		assertEquals("Leblon", p.getNome());
		assertEquals(400, j1.getDinheiro(), 0);
		
		j1.setPosicao(0);
		p = jogo.pegandoPosicaoNoTabuleiro(0, 1, tabuleiro, j1);
		assertEquals("Leblon", p.getNome());
	}


	@Test
	public void testEscolhaDeCompra() {
		Posicao p = new Propriedade("nome", 50, 50);
		jogo.escolhaDeCompra("sim", j1, p);
		assertEquals(150, j1.getDinheiro(), 0);
		
		j1.setDinheiro(200);
		jogo.escolhaDeCompra("n", j1, p);
		assertEquals(200, j1.getDinheiro(), 0);
	}


	@Test
	public void testValidarCor() {
		assertTrue(jogo.validarCor("preto", lista_de_cores));
		assertFalse(jogo.validarCor("preto", lista_de_cores));
		assertFalse(jogo.validarCor("marrom", lista_de_cores));
	}

	@Test
	public void testSaindoDoJogo() {
		jogo.saindoDoJogo("sim", j2);
		assertFalse(jogadores.contains(j2));
	}
	
	@Test
	public void testVerificandoDadosIguais() {
		j1.setDadosIguais(2);
		assertTrue(jogo.verificandoDadosIguais(1, 1, j1));
		
	}
	
	@Test
	public void testVerificandoSePrisioneiroVisitante() {
		j1.setPrisioneiroVisitante(true);
		assertTrue(jogo.verificandoSePrisioneiroVisitante(j1));
		
	}

}
