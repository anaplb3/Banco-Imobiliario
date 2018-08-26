package jogo;

public class TestandoJogo {
	public static void main(String[] args) {
		Jogo jogo = new Jogo();

		System.out.println("Bem vindo ao Banco Imobiliário!");

		jogo.carregandoJogadores();

		jogo.comecandoJogo();
	}
}
