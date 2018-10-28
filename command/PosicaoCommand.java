package command;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
 * Interface que unifica as chamadas de métodos das classes de posição do tabuleiro
 */
public interface PosicaoCommand {
    /**
     * método que será implementado pelas classes herdeiras
     * @param j jogador da vez
     * @param dado1 resultado do dado 1
     * @param dado2 resultado do dado 2
     * @param jogo  classe do Jogo
     */
    void execute(Jogador j, int dado1, int dado2, Jogo jogo);

}
