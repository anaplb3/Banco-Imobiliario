package posicoes;

import tabuleiro.Jogador;

/**
 * Essa classe corresponde a posição Lucros ou Dividendos do tabuleiro do jogo
 */

public class Lucros extends Posicao{

	/**
	 * Esse método mostra ao jogador onde ele se encontra
	 */
	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você parou em Lucros ou Dividendos! Ganhou R$200");
		
	}
	
	/**
	 * Esse método altera o saldo do jogador, adicionando R$200
	 *@param j Jogador atual da rodada
	 *@see Jogador.java
	 */
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() + 200);
	}
	
}
