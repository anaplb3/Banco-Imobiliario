package testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import posicoes.Companhia;
import posicoes.Imposto;
import posicoes.Lucros;
import posicoes.ParadaLivre;
import posicoes.Posicao;
import posicoes.Prisao;
import posicoes.Propriedade;
import posicoes.SorteOuReves;
import tabuleiro.Tabuleiro;

public class TabuleiroTest {
	Tabuleiro tab;
	Propriedade prop;
	Companhia comp;
	SorteOuReves sorte;
	Prisao prisao;
	Lucros lucro;
	Imposto imposto;
	ParadaLivre parada;
	int contadorPropriedade;

	@Before
	public void setUp() {
		tab = new Tabuleiro();
		prop = new Propriedade();
		comp = new Companhia();
		sorte = new SorteOuReves();
		prisao = new Prisao();
		lucro = new Lucros();
		imposto = new Imposto();
		parada = new ParadaLivre();
		contadorPropriedade = 0;
	}

	@Test
	public void testCriandoTab() {
		ArrayList<Posicao> tabuleiro = tab.criandoTab();
		ArrayList<Propriedade> propriedades = prop.criandoPropriedades();
		
		for(int i = 0; i < tabuleiro.size(); i++) {
			Posicao posicao = tabuleiro.get(i);
			
			Propriedade prop = propriedades.get(contadorPropriedade);
					
			if(i == 1 || i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 11 || i == 13 || i == 14 || i == 17 || i == 19 || i == 21 || i == 23 || i == 26 || i == 28 || i == 29 || i == 31 || i == 33 || i == 34 || i == 36 || i == 38 || i == 39) {
				assertEquals(prop, posicao);
				contadorPropriedade += 1;
			} else if(i == 5 || i == 7 || i == 15 || i == 25 || i == 32 || i == 35) {
				assertEquals(comp, posicao);
			} else if (i == 2 || i == 12 || i == 16 || i == 22 || i == 27 || i == 37) {
				assertEquals(sorte, posicao);
			} else if (i == 10 || i == 30) {
				assertEquals(prisao, posicao);
			} else if (i == 18) {
				assertEquals(lucro, posicao);
			} else if (i == 24) {
				assertEquals(imposto, posicao);
			} else if (i == 0) {
				assertEquals(null, posicao);
			} else if (i == 20) {
				assertEquals(parada, posicao);
			}
		}
	}

}
