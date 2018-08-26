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
	
	public int getPreco() {
		return 0;
	}
	
	public void setStatus(boolean status) {}
	
	public boolean isStatus() {
		return true;
	}
	
	public int getAluguel() {
		return 0;
	}

	public int getMultiplicador() {
		return 0;
	}
}
