package posicoes;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
*  Essa classe corresponde a posição Imposto de Renda no tabuleiro do jogo
*/
public class Imposto extends Posicao {

	public Imposto() {
		this.nome = "imposto de renda";
	}

	/**
	 * Esse método mostra ao usuário que ele parou na posição de Imposto
	 */
	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você parou no imposto de renda! Pague R$200");
	}
	
	/**
	 * Esse método diminui R$200 do saldo do jogador
	 * @param j jogador que vai ter o saldo diminuido
	 */
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() - 200);
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
