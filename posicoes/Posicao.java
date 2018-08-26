package posicoes;

import tabuleiro.Jogador;

public abstract class Posicao {
	String nome;
	
	public void getNomeDaPosicao() {
		System.out.println("Você está em "+this.nome);
	}
	
	public void alterandoSaldoDoJogador(Jogador j) {}
	
	public String getNome() {
		return this.nome;
	}
}
