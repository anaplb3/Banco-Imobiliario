package posicoes;

import java.util.ArrayList;
import java.util.Scanner;

import jogo.Jogo;
import tabuleiro.Dado;
import tabuleiro.Jogador;

/**
 * Essa classe representa a posição Prisão do tabuleiro do jogo
 */
public class Prisao extends Posicao {
	Scanner leitor;
	String tipo;

	public Prisao() {

		leitor = new Scanner(System.in);
		this.tipo = "";

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void getNomeDaPosicao() {
		System.out.println("Você está na prisão!");
	}

	public String getNome() {
		return "prisão";
	}

	/**
	 * Método que coloca o jogador como prisioneiro
	 * 
	 * @param j
	 *            jogador que irá para a prisão
	 * @see Jogador
	 */
	public void caindoNaPrisao(Jogador j) {
		if (j.isPrisioneiro() == false) {
			j.setPrisioneiro(true);

		}
	}

	/**
	 * Mostra as possíveis opções de saída da prisão para o jogador, e executa a
	 * escolhida por ele
	 * 
	 * @param jogo
	 *            classe do jogo
	 * @param tab
	 *            tabuleiro do jogo
	 * @param escolha
	 *            decisão do jogador
	 * @param j
	 *            jogador atual
	 * @param d1
	 *            primeiro dado
	 * @param d2
	 *            segundo dado
	 * @param contador
	 *            indice que indica o jogador atual
	 * @return Retorna o indice do jogador na próxima rodada
	 * @see Jogo
	 * @see Jogador
	 * @see Dado
	 */
	public int checandoLiberdade(Jogo jogo, ArrayList<Posicao> tab, String escolha, Jogador j, Dado d1, Dado d2,
			int contador) {
		if (escolha.toLowerCase().equals("carta")) {

			if (j.isCartaoLiberdade()) {

				System.out.println("Você usou uma carta de liberdade para sair da prisão.");
				j.setCartaoLiberdade(false);
				j.setPrisioneiro(false);

			} else {

				System.out.println("Você não possui uma carta de liberdade!");
				contador += 1;

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
				contador += 1;
			}

		} else if (escolha.equals("status")) {

			j.status(tab);

		} else if (escolha.equals("sair")) {

			System.out.print("Tem certeza? ");
			String certeza = leitor.nextLine();
			jogo.saindoDoJogo(certeza, j);

		}

		return contador;
	}
}
