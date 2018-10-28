package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cartas.Carta;
import posicoes.SorteOuReves;
import tabuleiro.Jogador;


public class SorteOuRevesTest {
	SorteOuReves sorte;
	Jogador j1, j2, j3;
	ArrayList<Jogador> jogadores;
	Carta carta;


	@Before
	public void setUp() {
		sorte = new SorteOuReves();
		j1 = new Jogador("ana", "preto");
		j1.setDinheiro(200);
		
		j2 = new Jogador("pedro", "amarelo");
		j2.setDinheiro(200);
		j3 = new Jogador("joao", "branco");
		
		jogadores = new ArrayList<>();
		jogadores.add(j1);
		jogadores.add(j2);
		jogadores.add(j3);
		
		sorte.setJogadores(jogadores);
		
		carta = new Carta();
		carta.setValor(200);

	}


	@Test
	public void testRecebaEspecial() {
		sorte.recebaEspecial(j1);
		assertEquals(300, j1.getDinheiro(), 0);
	}

	@Test
	public void testvaParaPrisao() {
		sorte.vaParaPrisao(j1);
		assertTrue(j1.isPrisioneiro());
	}

	@Test
	public void testInicio() {

		sorte.inicio(j1, carta);
		assertEquals(0, j1.getPosicao());
		assertEquals(400, j1.getDinheiro(), 0);
	}

	@Test
	public void testReceba() {
		sorte.receba(j1, carta);
		assertEquals(400, j1.getDinheiro(), 0);
	}

	@Test
	public void testPague() {
		sorte.pague(j1, carta);
		assertEquals(0, j1.getDinheiro(), 0);
	}

	@Test
	public void testSomaDados() {
		carta.setValor(100);
		
		sorte.somaDados(j1, carta, 2, 2);
		assertEquals(300, j1.getDinheiro(), 0);
		
		sorte.somaDados(j2, carta, 1, 2);
		assertEquals(100, j2.getDinheiro(), 0);
	}


}
