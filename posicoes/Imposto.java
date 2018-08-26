package posicoes;

import tabuleiro.Jogador;

public class Imposto extends Posicao{

	@Override
	public void getNomeDaPosicao() {
		System.out.println("Você parou no imposto de renda! Pague R$200");
	}
	
	
	public void alterandoSaldoDoJogador(Jogador j) {
		j.setDinheiro(j.getDinheiro() - 200);
	}

}
