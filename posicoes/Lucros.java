package posicoes;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
 * Essa classe corresponde a posição Lucros ou Dividendos do tabuleiro do jogo
 */

public class Lucros extends Posicao {

	public Lucros() {
		this.nome = "lucros";
	}

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
	 *@see Jogador
	 */
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() + 200);
	}

	/**
	 * encapsula a chamada do método de alterar o saldo do jogador
	 * @param j jogador da vez
	 * @param dado1 resultado do dado 1
	 * @param dado2 resultado do dado 2
	 * @param jogo  classe do Jogo
	 */
	@Override
	public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
		getNomeDaPosicao();
		alterandoSaldoDoJogador(j);
	}
}
