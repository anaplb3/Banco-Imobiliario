package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import posicoes.Propriedade;
import tabuleiro.Jogador;

public class PropriedadeTest {
	Propriedade propriedade;
	Jogador j1, j2;

	
	@Before
	public void setUp() {
		propriedade = new Propriedade("lugar nenhum", 200, 14);
		j1 = new Jogador("ana", "preto");
		j2 = new Jogador("joao", "branco");
	}

	@Test
	public void testCriandoPropriedades() {
		ArrayList<String> nomes = propriedade.nomesDasPropriedades();
		ArrayList<Integer> precos = propriedade.precoDasPropriedades();
		ArrayList<Integer> aluguel = propriedade.alugueis();
		ArrayList<Propriedade> propriedades = propriedade.criandoPropriedades();
		
		for(int i = 0; i < propriedades.size(); i++) {
			String nome = nomes.get(i);
			int preco = precos.get(i);
			int rent = aluguel.get(i);
			
			String nomeProp = propriedades.get(i).getNome();
			int precoProp = propriedades.get(i).getPreco();
			int rentProp = propriedades.get(i).getAluguel();
			
			assertTrue(nome.equals(nomeProp));
			assertTrue(preco == precoProp);
			assertTrue(rent == rentProp);
		}
	}
	
	@Test
	public void pagandoAluguelOuMultiplicadorTest() {
		j1.setDinheiro(100);
		j2.setDinheiro(100);
		propriedade.setProprietario(j1);
		
		propriedade.pagandoAluguelOuMultiplicador(j2, propriedade, 1, 2);
		
		assertEquals(114, j1.getDinheiro(), 0);
		assertEquals(86, j2.getDinheiro(), 0);
		
		
	}

}
