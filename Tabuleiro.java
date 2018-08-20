package tabuleiro;

import java.util.ArrayList;

public class Tabuleiro {
	
	public ArrayList<Propriedade> criandoTab() {
		ArrayList<Propriedade> tab = new ArrayList<>();
		ArrayList<Propriedade> propriedades = criandoPropriedades();
		
		System.out.println("tamanho propriedades: "+propriedades.size()+"\n");
		
		int contador = 0;
		for(int i = 0; i < 40; i++) {
			if(i == 0 || i == 2 || i == 10 || i == 12 || i == 16 || i == 18 || i == 20 || i == 22 || i == 24 || i == 27 || i == 30 || i == 37) {
				tab.add(null);
			} else {
				tab.add(propriedades.get(contador));
				contador += 1;
			}
		}
		
		return tab;
	}
	
	public ArrayList<Propriedade> criandoPropriedades() {
		ArrayList<String> nomes = nomesDasPropriedades();
		ArrayList<Integer> precos = precoDasPropriedades();
		ArrayList<Propriedade> propriedades = new ArrayList<>();
		
		for(int i = 0; i < nomes.size(); i++) {
			Propriedade p = new Propriedade(nomes.get(i), precos.get(i), true);
			propriedades.add(p);
		}
		
		return propriedades;
		
	}
	
	public ArrayList<String> nomesDasPropriedades() {
		ArrayList<String> nomes = new ArrayList<>();
		
		nomes.add("Leblon");
		nomes.add("Av. Presidente Vargas");
		nomes.add("Av. Nossa Senhora De Copacabana");
		nomes.add("Cia Ferroviária");
		nomes.add("Av. Brigadeiro Faria Lima");
		nomes.add("Cia de Viação");
		nomes.add("Av. Rebouças");
		nomes.add("Av. 9 de Julho");
		nomes.add("Av. Europa");
		nomes.add("Rua Augusta");
		nomes.add("Av. Pacaembu");
		nomes.add("Cia de Taxi");
		nomes.add("Interlagos");
		nomes.add("Morumbi");
		nomes.add("Flamengo");
		nomes.add("Botafogo");
		nomes.add("Cia de Navegação");
		nomes.add("Av. Brasil");
		nomes.add("Av. Paulista");
		nomes.add("Jardim Europa");
		nomes.add("Copacabana");
		nomes.add("Cia de Aviação");
		nomes.add("Av. Vieira Souto");
		nomes.add("Av. Atlântica");
		nomes.add("Cia de Taxi Áereo");
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
		precos.add(200);
		precos.add(240);
		precos.add(200);
		precos.add(220);
		precos.add(220);
		precos.add(200);
		precos.add(180);
		precos.add(180);
		precos.add(150);
		precos.add(350);
		precos.add(400);
		precos.add(120);
		precos.add(100);
		precos.add(150);
		precos.add(160);
		precos.add(140);
		precos.add(140);
		precos.add(260);
		precos.add(200);
		precos.add(320);
		precos.add(300);
		precos.add(200);
		precos.add(300);
		precos.add(280);
		precos.add(260);
		
		return precos;
	}
}
