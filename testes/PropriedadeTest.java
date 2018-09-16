package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import posicoes.Propriedade;

public class PropriedadeTest {
	Propriedade propriedade;
	
	@Before
	public void setUp() {
		propriedade = new Propriedade();
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

}
