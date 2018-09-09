package posicoes;


import tabuleiro.Dado;
import tabuleiro.Jogador;

/**
* Essa classe representa a posição Prisão do tabuleiro do jogo
*/
public class Prisao extends Posicao{
		
		public void getNomeDaPosicao() {
			System.out.println("Você está na prisão!");
		}

		public String getNome() {
			return "prisão";
		}
		
		public void caindoNaPrisao(Jogador j) {
			
			if(j.isPrisioneiro() == false) {
				
				j.setPrisioneiro(true);
				j.setPosicao(10);
				
			} 
			
		}
		
		public int checandoLiberdade(String escolha, Jogador j, Dado d1, Dado d2, int contador) {
			
			if(escolha.toLowerCase().equals("carta")) {
				
				if(j.getCartaoLiberdade() > 0) {
					
					System.out.println("Você usou uma carta de liberdade para sair da prisão.");
					j.setCartaoLiberdade(j.getCartaoLiberdade() - 1);
					j.setPrisioneiro(false);
					
				} else {
					
					System.out.println("Você não possui uma carta de liberdade!");
					contador += 1;
					
				}
				
			} else if(escolha.toLowerCase().equals("pagar")) {
				
				System.out.println("Você pagou para sair da prisão.");
				j.setDinheiro(j.getDinheiro() - 50);
				j.setPrisioneiro(false);
				
			} else if(escolha.toLowerCase().equals("jogar")) {
				int dado1 = d1.getDado();
				int dado2 = d2.getDado();
				
				if(dado1 == dado2) {
					
					System.out.println("Você conseguiu sair da prisão!");
					j.setPrisioneiro(false);
					
				} else {
					
					System.out.println("Você não conseguiu sair da prisão.");
					contador += 1;
				}
				
			}
			
		
			return contador;
		}
	}


