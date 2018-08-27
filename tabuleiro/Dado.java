package tabuleiro;

import java.util.Random;

/**
 * Esta classe está gerando os números dos dados.
 *
 */
public class Dado {
	Random gerador;

	/**
	 * Esse método instancia um objeto do tipo random.
	 * 
	 */
	public Dado() {
		this.gerador = new Random();
	}

	public int getDado() {
		return gerador.nextInt(6) + 1;
	}

}