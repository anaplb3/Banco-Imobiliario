package posicoes;

import tabuleiro.Jogador;

/**
*  Essa classe corresponde a posição Imposto de Renda no tabuleiro do jogo
*/
public class Imposto extends Posicao{

	/**
	 * Esse método mostra ao usuário que ele parou na posição de Imposto
	 */
	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você parou no imposto de renda! Pague R$200");
	}
	
	/**
	 * Esse método diminui R$200 do saldo do jogador
	 */
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() - 200);
	}

	public String getNome() {
		return "imposto de renda";
	}

}
