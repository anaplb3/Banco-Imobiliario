package posicoes;

import jogo.Jogo;
import tabuleiro.Jogador;

/**
 * classe que representa a posição de visitante na prisão no tabuleiro
 */
public class PrisaoVisitante extends Posicao {

    public PrisaoVisitante() {
        this.nome = "prisão visitante";
    }

    /**
     * coloca o jogador como visitante da prisão
     * @param j1 jogador que será visitante na prisão
     */
    public void visitanteNaPrisao(Jogador j1) {
        System.out.println("Você é visitante da prisão. Fique 1 rodada sem jogar!");
        j1.setPrisioneiroVisitante(true);
    }
    /**
     * encapsula a chamada do método de colocar o jogador como visitante na prisão
     * @param j jogador da vez
     * @param dado1 resultado do dado 1
     * @param dado2 resultado do dado 2
     * @param jogo  classe do Jogo
     */
    @Override
    public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
        visitanteNaPrisao(j);
    }
}
