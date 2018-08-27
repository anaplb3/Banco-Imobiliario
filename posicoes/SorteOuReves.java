package posicoes;

/**
* Essa classe representa a posição Sorte ou Revés do tabuleiro 
*/
public class SorteOuReves extends Posicao{

	public void getNomeDaPosicao() {
		System.out.println("Você parou no sorte ou revés!");
	}

	public String getNome() {
		return "sorte ou revés";
	}
}