package tabuleiro;

import java.util.ArrayList;

import posicoes.Companhia;
import posicoes.Imposto;
import posicoes.Lucros;
import posicoes.ParadaLivre;
import posicoes.Posicao;
import posicoes.Prisao;
import posicoes.Propriedade;
import posicoes.SorteOuReves;

/**
 * Esta classe é responsável por criar o tabuleiro
 */
public class Tabuleiro {
	private Propriedade prop;

	/**
	 * Esse construtor inicia um objeto Propriedade para usar o método
	 * criandoPropriedades
	 * 
	 * @see Propriedade
	 */
	public Tabuleiro() {
		this.prop = new Propriedade();
	}

	/**
	 * Esse método adiciona os objetos componentes do tabuleiro no tabuleiro
	 */

	public ArrayList<Posicao> criandoTab() {
		ArrayList<Posicao> tab = new ArrayList<>();
		ArrayList<Propriedade> propriedades = prop.criandoPropriedades();
		Prisao prisao = new Prisao();
		SorteOuReves sorte = new SorteOuReves();
		Lucros lucros = new Lucros();
		Imposto imposto = new Imposto();
		ParadaLivre parada = new ParadaLivre();

		int contador = 0;
		for (int i = 0; i < 40; i++) {

			if (i == 2 || i == 12 || i == 16 || i == 22 || i == 27 || i == 37) {
				tab.add(sorte);
			} else if (i == 10 || i == 30) {
				tab.add(prisao);
			} else if (i == 18) {
				tab.add(lucros);
			} else if (i == 24) {
				tab.add(imposto);
			} else if (i == 5) {
				Companhia companhia1 = new Companhia("Cia Ferroviaria", 200, 50);
				tab.add(companhia1);

			} else if (i == 7) {

				Companhia companhia2 = new Companhia("Cia de Viação", 200, 50);
				tab.add(companhia2);

			} else if (i == 15) {
				Companhia companhia3 = new Companhia("Cia de Taxi", 150, 40);
				tab.add(companhia3);

			} else if (i == 25) {
				Companhia companhia4 = new Companhia("Cia de Navegação", 150, 40);
				tab.add(companhia4);

			} else if (i == 32) {
				Companhia companhia5 = new Companhia("Cia de Aviação", 200, 50);
				tab.add(companhia5);

			} else if (i == 35) {
				Companhia companhia6 = new Companhia("Cia de Taxi Aereo", 200, 50);
				tab.add(companhia6);
			}

			else if (i == 0) {
				tab.add(null);

			} else if (i == 20) {
				tab.add(parada);
			} else {
				tab.add(propriedades.get(contador));
				contador += 1;
			}

		}

		return tab;
	}

}