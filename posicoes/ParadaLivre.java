package posicoes;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
* Essa classe corresponde a Parada Livre no tabuleiro
*/
public class ParadaLivre extends Posicao {

	public ParadaLivre() {
		this.nome = "parada livre";
	}

	/**
	 * informa ao jogador que ele se encontra na parada livre
	 * @param j jogador da vez
	 * @param dado1 resultado do dado 1
	 * @param dado2 resultado do dado 2
	 * @param jogo  classe do Jogo
	 */
	@Override
	public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
		getNomeDaPosicao();
	}
}
