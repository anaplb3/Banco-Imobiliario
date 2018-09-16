package posicoes;

/**
* Essa classe corresponde a Parada Livre no tabuleiro
*/
public class ParadaLivre extends Posicao{

	/**
	 * Esse método mostra ao jogador onde ele se encontra no tabuleiro 
	 */
	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você está em uma parada livre");
	}
	
	public String getNome() {
		return "parada livre";
	}
}
