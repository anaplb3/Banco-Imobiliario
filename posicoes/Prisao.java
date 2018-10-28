package posicoes;

import java.util.ArrayList;
import java.util.Scanner;

import command.PosicaoCommand;
import jogo.Jogo;
import tabuleiro.Dado;
import tabuleiro.Jogador;

/**
 * Essa classe representa a posição Prisão do tabuleiro do jogo
 */
public class Prisao extends Posicao {
    Scanner leitor;

    public Prisao() {

        leitor = new Scanner(System.in);
        this.nome = "prisão";

    }

    public void getNomeDaPosicao() {
        System.out.println("Você está na prisão!");
    }

    /**
     * Método que coloca o jogador como prisioneiro
     *
     * @param j jogador que irá para a prisão
     * @see Jogador
     */
    public void caindoNaPrisao(Jogador j) {
        if (!j.isPrisioneiro()) {
            j.setPrisioneiro(true);

        }
    }

    /**
     * Mostra as possíveis opções de saída da prisão para o jogador, e executa a
     * escolhida por ele
     *
     * @param jogo    classe do jogo
     * @param posicao posição que o jogador se encontra
     * @param escolha decisão do jogador
     * @param j       jogador atual
     * @param d1      primeiro dado
     * @param d2      segundo dado
     * @see Jogo
     * @see Jogador
     * @see Dado
     */
    public void checandoLiberdade(Jogo jogo, Posicao posicao, String escolha, Jogador j, Dado d1, Dado d2) {
        if (escolha.toLowerCase().equals("carta")) {

            if (j.isCartaoLiberdade()) {

                System.out.println("Você usou uma carta de liberdade para sair da prisão.");
                j.setCartaoLiberdade(false);
                j.setPrisioneiro(false);

            } else {

                System.out.println("Você não possui uma carta de liberdade!");
                jogo.setIndiceDoJogador(jogo.getIndiceDoJogador() + 1);
            }

        } else if (escolha.toLowerCase().equals("pagar")) {

            System.out.println("Você pagou para sair da prisão.");
            j.setDinheiro(j.getDinheiro() - 50);
            j.setPrisioneiro(false);

        } else if (escolha.toLowerCase().equals("jogar")) {
            int dado1 = d1.getDado();
            int dado2 = d2.getDado();

            if (dado1 == dado2) {

                System.out.println("Você tirou " + dado1 + "," + dado2 + " e conseguiu sair da prisão!");
                j.setPrisioneiro(false);

            } else {

                System.out.println("Você tirou " + dado1 + "," + dado2 + " e não conseguiu sair da prisão.");
                jogo.setIndiceDoJogador(jogo.getIndiceDoJogador() + 1);
            }

        } else if (escolha.equals("status")) {

            j.status(posicao);

        } else if (escolha.equals("sair")) {

            System.out.print("Tem certeza? ");
            String certeza = leitor.nextLine();
            jogo.saindoDoJogo(certeza, j);

        }

    }

    /**
     * encapsula a chamada do método de jogar o jogador na prisão
     *
     * @param j     jogador da vez
     * @param dado1 resultado do dado 1
     * @param dado2 resultado do dado 2
     * @param jogo  classe do Jogo
     */
    @Override
    public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
        System.out.println("Você está em " + this.nome);
        caindoNaPrisao(j);
    }
}
