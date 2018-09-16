package cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Esta classe é responsável por criar um baralho de cartas de sorte ou revés,
 * além de fornecer os métodos de puxar a carta e a recolocar na pilha
 * 
 * @see Carta
 */
public class Baralho {

	private Stack<Carta> baralho;
	private Carta carta;

	public Baralho() {
		this.baralho = new Stack<Carta>();
		this.carta = new Carta();
	}

	public Stack<Carta> getBaralho() {
		return this.baralho;
	}

	/**
	 * Método que cria o baralho de cartas
	 * 
	 * @return Retorna o baralho de cartas embaralhado
	 */
	public Stack<Carta> criarBaralho() {

		ArrayList<String> descricoes = carta.descricoesDasCartas();
		ArrayList<Integer> valores = carta.valoresDasCartas();

		for (int i = 1; i < 32; i++) {
			Carta cartaBaralho = new Carta();
			if (i == 2) {
				cartaBaralho.setTipo("recebaespecial");
			} else if (i == 5) {
				cartaBaralho.setTipo("prisao");
			} else if (i == 7) {
				cartaBaralho.setTipo("inicio");
			} else if (i == 12) {
				cartaBaralho.setTipo("joguedados");
			} else if (i == 24) {
				cartaBaralho.setTipo("somadados");
			} else if (i == 4 || i == 8 || i == 11 || i == 14 || i == 15 || i == 17 || i == 19 || i == 20 || i == 21
					|| i == 27 || i == 31) {
				cartaBaralho.setTipo("recebe");
			} else {
				cartaBaralho.setTipo("pague");
			}

			cartaBaralho.setDescricao(descricoes.get(i - 1));
			cartaBaralho.setValor(valores.get(i - 1));
			this.baralho.push(cartaBaralho);

		}

		Collections.shuffle(this.baralho);

		return this.baralho;
	}

	/**
	 * Método que puxa a carta do topo do baralho e a embaralha
	 * 
	 * @return Retorna uma carta de sorte ou revés
	 * @see Carta
	 */
	public Carta puxarCarta() {
		Carta carta = this.baralho.pop();

		Collections.shuffle(this.baralho);

		this.baralho = recolocandoNaPilha(carta);

		return carta;
	}

	/**
	 * Coloca a carta retirada do topo na base do baralho
	 * 
	 * @param carta
	 *            carta que foi tirada do topo
	 * @return Retorna o baralho com a carta na base
	 * @see Carta
	 */
	public Stack<Carta> recolocandoNaPilha(Carta carta) {

		Stack<Carta> auxiliar = new Stack<Carta>();
		auxiliar.add(carta);

		for (int i = 0; i < this.baralho.size(); i++) {
			auxiliar.add(this.baralho.get(i));
		}

		return auxiliar;
	}

}
