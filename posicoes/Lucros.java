package posicoes;

import tabuleiro.Jogador;

public class Lucros extends Posicao{

	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você parou em Lucros ou Dividendos! Ganhou R$200");
		
	}
	
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() + 200);
	}
	
}
