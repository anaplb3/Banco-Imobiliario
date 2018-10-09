package posicoes;

import tabuleiro.Jogador;

/**
* Essa classe abstrata possui vários métodos que as classes que herdeiras possuem
* @see Jogador
*/
public abstract class Posicao {
	protected String nome;
	protected Jogador proprietario;
	
	public void getNomeDaPosicao() {
		System.out.println("Você está em "+this.nome);
	}
	
	public void alterandoSaldoDoJogador(Jogador j) {}
	
	public String getNome() {
		return this.nome;
	}
	
	public Jogador getProprietario() {
		return this.proprietario;
	}
	
	public void setProprietario(Jogador p) {
		this.proprietario = p;
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
	
	public void pagandoAluguelOuMultiplicador(Jogador jogadorAtual, Posicao posicao, int dado1, int dado2) {}
}
