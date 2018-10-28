package posicoes;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
 * Classe que representa a posição inicial no jogo
 */
public class PosicaoInicial extends Posicao{

    @Override
    public void getNomeDaPosicao() {
        System.out.println("Você está na posição inicial do jogo!");
    }

    public PosicaoInicial() {
        this.nome = "posição inicial";
    }
    /**
     * informa ao jogador que ele está na posição inicial do jogo
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
