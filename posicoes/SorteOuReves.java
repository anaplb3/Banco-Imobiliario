package posicoes;

import java.util.ArrayList;
import java.util.Stack;

import cartas.Baralho;
import cartas.Carta;
import command.PosicaoCommand;
import jogo.Jogo;
import tabuleiro.Dado;
import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;

/**
 * Essa classe representa a posição Sorte ou Revés do tabuleiro
 */
public class SorteOuReves extends Posicao {
    private ArrayList<Jogador> jogadores;
    private Stack<Carta> baralho;
    private Baralho deck;
    private Dado d1, d2;

    /**
     * Construtor que inicia o baralho de cartas sorte ou revés e os dados que serão
     * usados
     */
    public SorteOuReves() {
        this.deck = new Baralho();
        this.baralho = deck.criarBaralho();
        d1 = d1.getInstance();
        d2 = d2.getInstance();
        this.nome = "sorte ou revés";
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void getNomeDaPosicao() {
        System.out.println("Você parou no sorte ou revés!");
    }

    /**
     * Método que tira R$50 de cada jogador e coloca na conta do jogador da vez
     *
     * @param jogadorDaVez jogador da rodada atual
     * @see Jogador
     */
    public void recebaEspecial(Jogador jogadorDaVez) {
        int valor = 0;
        for (Jogador j : this.jogadores) {
            valor += 50;
            j.setDinheiro(j.getDinheiro() - 50);
        }
        jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + valor);
    }

    /**
     * Método que coloca o jogador da vez na prisão
     *
     * @param jogadorDaVez jogador da rodada atual
     * @see Jogador
     */
    public void vaParaPrisao(Jogador jogadorDaVez) {
        jogadorDaVez.setPrisioneiro(true);
    }

    /**
     * Dá um cartao de liberdade ao jogador
     *
     * @param jogadorDaVez jogador da rodada atual
     */
    public void cartaLiberdade(Jogador jogadorDaVez) {
        jogadorDaVez.setCartaoLiberdade(true);
    }

    /**
     * Coloca o jogador no começo do tabuleiro e lhe dá o valor da carta de bônus
     *
     * @param jogadorDaVez jogador da rodada atual
     * @param carta        carta do sorte ou revés
     * @see Jogador
     * @see Carta
     */
    public void inicio(Jogador jogadorDaVez, Carta carta) {
        jogadorDaVez.setPosicao(0);
        receba(jogadorDaVez, carta);

    }

    /**
     * Faz com que o jogador role os dados novamente
     *
     * @param jogadorDaVez jogador da rodada atual
     * @param jogo objeto jogo
     * @see Jogo
     * @see Jogador
     */
    public void jogueDados(Jogador jogadorDaVez, Jogo jogo) {
        int dado1 = d1.getDado();
        int dado2 = d2.getDado();

        jogo.jogada(dado1, dado2, jogadorDaVez);

    }

    /**
     * Verifica se a soma dos dados do jogador é par. Caso sim, ele ganha o valor da
     * carta
     *
     * @param jogadorDaVez jogador da rodada
     * @param carta        carta do sorte ou réves que foi puxada
     * @param dado1        numero do primeiro dado
     * @param dado2        numero do segundo dado
     * @see Jogador
     * @see Carta
     */
    public void somaDados(Jogador jogadorDaVez, Carta carta, int dado1, int dado2) {
        if ((dado1 + dado2) % 2 == 0) {
            receba(jogadorDaVez, carta);
        } else {
            pague(jogadorDaVez, carta);
        }
    }

    /**
     * O jogador recebe uma quantia, dependendo do valor da carta
     *
     * @param jogadorDaVez jogador da rodada
     * @param carta        carta puxada do baralho de sorte ou revés
     * @see Jogador
     * @see Carta
     */
    public void receba(Jogador jogadorDaVez, Carta carta) {

        jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + carta.getValor());
    }

    /**
     * O jogador paga uma quantia, dependendo do valor da carta
     *
     * @param jogadorDaVez jogador da rodada
     * @param carta        carta puxada do baralho de sorte ou revés
     * @see Jogador
     * @see Carta
     */
    public void pague(Jogador jogadorDaVez, Carta carta) {

        jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - carta.getValor());
    }

    /**
     * Puxa uma carta do baralho e executa sua ação
     *
     * @param jogadorDaVez jogador da rodada
     * @param dado1        numero do primeiro dado
     * @param dado2        numero do segundo dado
     * @see Carta
     * @see Jogador
     */
    public void execute(Jogador jogadorDaVez, int dado1, int dado2, Jogo jogo) {
        Carta carta = deck.puxarCarta();

        System.out.println(carta.getDescricao());

        switch (carta.getTipo()) {
            case "cartaoliberdade":

                cartaLiberdade(jogadorDaVez);

                break;

            case "recebaespecial":

                recebaEspecial(jogadorDaVez);

                break;
            case "prisao":
                vaParaPrisao(jogadorDaVez);

                break;
            case "inicio":

                inicio(jogadorDaVez, carta);

                break;
            case "joguedados":

                jogueDados(jogadorDaVez, jogo);

                break;
            case "somadados":

                somaDados(jogadorDaVez, carta, dado1, dado2);

                break;
            case "receba":

                receba(jogadorDaVez, carta);

                break;
            case "pague":

                pague(jogadorDaVez, carta);

                break;
        }

    }

}
