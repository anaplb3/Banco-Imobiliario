package posicoes;

import java.util.ArrayList;
import java.util.Stack;

import cartas.Baralho;
import cartas.Carta;
import jogo.Jogo;
import tabuleiro.Dado;
import tabuleiro.Jogador;

/**
 * Essa classe representa a posição Sorte ou Revés do tabuleiro
 */
public class SorteOuReves extends Posicao {
	ArrayList<Jogador> jogadores;
	Stack<Carta> baralho;
	Baralho deck;
	Dado d1, d2;

	/**
	 * Construtor que inicia o baralho de cartas sorte ou revés e os dados que serão
	 * usados
	 */
	public SorteOuReves() {
		this.deck = new Baralho();
		this.baralho = deck.criarBaralho();
		d1 = new Dado();
		d2 = new Dado();

	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public void getNomeDaPosicao() {
		System.out.println("Você parou no sorte ou revés!");
	}

	public String getNome() {
		return "sorte ou revés";
	}

	/**
	 * Método que tira R$50 de cada jogador e coloca na conta do jogador da vez
	 * 
	 * @param jogadorDaVez
	 *            jogador da rodada atual
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
	 * @param jogadorDaVez
	 *            jogador da rodada atual
	 * @see Jogador
	 */
	public void prisao(Jogador jogadorDaVez) {
		jogadorDaVez.setPrisioneiro(true);
	}

	/**
	 * Coloca o jogador no começo do tabuleiro e lhe dá o valor da carta de bônus
	 * 
	 * @param jogadorDaVez
	 *            jogador da rodada atual
	 * @param carta
	 *            carta do sorte ou revés
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
	 * @param jogadorDaVez
	 *            jogador da rodada atual
	 * @param jogo
	 *            classe que tem o método da jogada
	 * @param tabuleiro
	 *            tabuleiro do jogo
	 * @see Jogo
	 * @see Jogador
	 */
	public void jogueDados(Jogador jogadorDaVez, Jogo jogo, ArrayList<Posicao> tabuleiro) {
		int dado1 = d1.getDado();
		int dado2 = d2.getDado();

		jogo.jogada(dado1, dado2, tabuleiro, jogadorDaVez);

	}

	/**
	 * Verifica se a soma dos dados do jogador é par. Caso sim, ele ganha o valor da
	 * carta
	 * 
	 * @param jogadorDaVez
	 *            jogador da rodada
	 * @param carta
	 *            carta do sorte ou réves que foi puxada
	 * @param dado1
	 *            numero do primeiro dado
	 * @param dado2
	 *            numero do segundo dado
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
	 * @param jogadorDaVez
	 *            jogador da rodada
	 * @param carta
	 *            carta puxada do baralho de sorte ou revés
	 * @see Jogador
	 * @see Carta
	 */
	public void receba(Jogador jogadorDaVez, Carta carta) {

		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() + carta.getValor());
	}

	/**
	 * O jogador paga uma quantia, dependendo do valor da carta
	 * 
	 * @param jogadorDaVez
	 *            jogador da rodada
	 * @param carta
	 *            carta puxada do baralho de sorte ou revés
	 * @see Jogador
	 * @see Carta
	 */
	public void pague(Jogador jogadorDaVez, Carta carta) {

		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro() - carta.getValor());
	}

	/**
	 * Puxa uma carta do baralho e executa sua ação
	 * 
	 * @param jogadorDaVez
	 *            jogador da rodada
	 * @param jogo
	 *            objeto que tem o método da jogada
	 * @param tabuleiro
	 *            tabuleiro do jogo
	 * @param dado1
	 *            numero do primeiro dado
	 * @param dado2
	 *            numero do segundo dado
	 * @see Carta
	 * @see Jogador
	 */
	public void acoes(Jogador jogadorDaVez, Jogo jogo, ArrayList<Posicao> tabuleiro, int dado1, int dado2) {
		Carta carta = deck.puxarCarta();

		System.out.println(carta.getDescricao());

		if (carta.getTipo().equals("recebaespecial")) {

			recebaEspecial(jogadorDaVez);

		} else if (carta.getTipo().equals("prisao")) {
			prisao(jogadorDaVez);

		} else if (carta.getTipo().equals("inicio")) {

			inicio(jogadorDaVez, carta);

		} else if (carta.getTipo().equals("joguedados")) {

			jogueDados(jogadorDaVez, jogo, tabuleiro);

		} else if (carta.getTipo().equals("somadados")) {

			somaDados(jogadorDaVez, carta, dado1, dado2);

		} else if (carta.getTipo().equals("receba")) {

			receba(jogadorDaVez, carta);

		} else if (carta.getTipo().equals("pague")) {

			pague(jogadorDaVez, carta);

		}

	}

}
