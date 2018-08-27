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

public class Tabuleiro {
	/**
		*Esse método adiciona os objetos componentes do tabuleiro no tabuleiro
		*@param criandoTab Está setando os componentes no tabuleiro
	*/

	public ArrayList<Posicao> criandoTab() {
		ArrayList<Posicao> tab = new ArrayList<>();
		ArrayList<Propriedade> propriedades = criandoPropriedades();
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
				Companhia companhia6 = new Companhia("Cia de Taxi Áereo", 200, 50);
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

	/** 
		*Esse método está adicionando as cores das propriedades
		@param criandoPropriedades Está setando as cores nas propriedades
	*/
	public ArrayList<Propriedade> criandoPropriedades() {
		ArrayList<String> nomes = nomesDasPropriedades();
		ArrayList<Integer> precos = precoDasPropriedades();
		ArrayList<Integer> aluguel = alugueis();
		ArrayList<Propriedade> propriedades = new ArrayList<>();

		for (int i = 0; i < nomes.size(); i++) {
			Propriedade p = new Propriedade();

			if (i == 0 || i == 1 || i == 2) {
				p.setCor("rosa");
			} else if (i == 4 || i == 6 || i == 7) {
				p.setCor("azul");
			} else if (i == 8 || i == 9 || i == 10) {
				p.setCor("roxo");
			} else if (i == 12 || i == 13) {
				p.setCor("laranja");
			} else if (i == 14 || i == 15) {
				p.setCor("vermelho");
			} else if (i == 18 || i == 19 || i == 20) {
				p.setCor("amarelo");
			} else if (i == 21 || i == 23 || i == 24 || i == 26) {
				p.setCor("verde");
			} else if (i == 27 || i == 28) {
				p.setCor("azul escuro");
			}

			p.setNome(nomes.get(i));
			p.setPreco(precos.get(i));
			p.setAluguel(aluguel.get(i));
			p.setStatus(true);
			propriedades.add(p);
		}

		return propriedades;

	}
	/**
		*Esse método está adiconando os aluguéis as propriedades
		*@param alugueis Está setando os aluguéis nas propriedades
	*/
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
	/**
		*Esse método está adicinando os nomes as Propriedades
		*@param nomesDasProprieadades Está setando os nomes correspondentes nas devidas propriedades
	*/
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
	/**
		*Esse método está adiconando os preços nas propriedades
		*@param precoDasPropriedades Está setando os preços das propriedades
	*/
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