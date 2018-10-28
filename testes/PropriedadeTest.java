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
		ArrayList<String> nomes = nomesDasPropriedades();
		ArrayList<Integer> precos = precoDasPropriedades();
		ArrayList<Integer> alugueis = alugueis();
		ArrayList<Propriedade> propriedades = propriedade.criandoPropriedades();

		for(int i = 0; i < propriedades.size(); i++) {
			assertEquals(nomes.get(i), propriedades.get(i).getNome());
			assertEquals(precos.get(i), propriedades.get(i).getPreco(), 0);
			assertEquals(alugueis.get(i), propriedades.get(i).getValorASerPago(), 0);
			assertTrue(propriedades.get(i).ehCompravel());
		}
	}
	
	@Test
	public void pagandoAluguelOuMultiplicadorTest() {
		j1.setDinheiro(100);
		j2.setDinheiro(100);
		propriedade.setProprietario(j1);
		
		propriedade.pagandoAluguel(j2);
		
		assertEquals(114, j1.getDinheiro(), 0);
		assertEquals(86, j2.getDinheiro(), 0);
		

	}


	public ArrayList<Integer> alugueis() {
		ArrayList<Integer> aluguel = new ArrayList<>();

		aluguel.add(6);
		aluguel.add(2);
		aluguel.add(2);
		aluguel.add(20);
		aluguel.add(18);
		aluguel.add(18);
		aluguel.add(16);
		aluguel.add(14);
		aluguel.add(14);
		aluguel.add(35);
		aluguel.add(50);
		aluguel.add(8);
		aluguel.add(6);
		aluguel.add(12);
		aluguel.add(10);
		aluguel.add(12);
		aluguel.add(22);
		aluguel.add(28);
		aluguel.add(26);
		aluguel.add(26);
		aluguel.add(24);
		aluguel.add(22);

		return aluguel;

	}

	public ArrayList<String> nomesDasPropriedades() {
		ArrayList<String> nomes = new ArrayList<>();

		nomes.add("Leblon");
		nomes.add("Av. Presidente Vargas");
		nomes.add("Av. Nossa Senhora De Copacabana");

		nomes.add("Av. Brigadeiro Faria Lima");
		nomes.add("Av. Rebouças");
		nomes.add("Av. 9 de Julho");

		nomes.add("Av. Europa");
		nomes.add("Rua Augusta");
		nomes.add("Av. Pacaembu");

		nomes.add("Interlagos");
		nomes.add("Morumbi");

		nomes.add("Flamengo");
		nomes.add("Botafogo");

		nomes.add("Av. Brasil");
		nomes.add("Av. Paulista");
		nomes.add("Jardim Europa");

		nomes.add("Copacabana");
		nomes.add("Av. Vieira Souto");
		nomes.add("Av. Atlântica");
		nomes.add("Ipanema");

		nomes.add("Jardim Paulista");
		nomes.add("Brooklin");

		return nomes;
	}

	public ArrayList<Integer> precoDasPropriedades() {
		ArrayList<Integer> precos = new ArrayList<>();

		precos.add(100);
		precos.add(60);
		precos.add(60);

		precos.add(240);

		precos.add(220);
		precos.add(220);
		precos.add(200);
		precos.add(180);
		precos.add(180);

		precos.add(350);
		precos.add(400);
		precos.add(120);
		precos.add(100);

		precos.add(160);
		precos.add(140);
		precos.add(140);
		precos.add(260);

		precos.add(320);
		precos.add(300);

		precos.add(300);
		precos.add(280);
		precos.add(260);

		return precos;
	}

}
