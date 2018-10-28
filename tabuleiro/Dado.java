package tabuleiro;

import java.util.Random;

/**
 * Esta classe está gerando os números dos dados.
 *
 */
public class Dado {
	private static Dado dado;
	private Random gerador;

	/**
	 * Esse método instancia um objeto do tipo random.
	 * 
	 */
	private Dado() {
		this.gerador = new Random();
	}

	/**
	 * instancia de forma estática um objeto Dado
	 * @return uma instância do objeto Dado
	 */
	public static Dado getInstance() {
		if(dado == null) {
			dado = new Dado();
		}

		return dado;
	}

	/**
	 * gera um número aleatório de 1 a 6
	 * @return o número do dado
	 */
	public int getDado() {
		return gerador.nextInt(6) + 1;
	}
	

}