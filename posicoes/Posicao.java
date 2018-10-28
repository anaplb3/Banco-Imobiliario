package posicoes;

import command.PosicaoCommand;
import tabuleiro.Jogador;

/**
* Essa classe abstrata possui vários métodos que as classes que herdeiras possuem
* @see Jogador
*/
public abstract class Posicao implements PosicaoCommand{
	protected String nome;
	protected Jogador proprietario;
	protected int preco;
	protected int valorASerPago;
	protected boolean compravel;
	
	
	public void getNomeDaPosicao() {
		System.out.println("Você está em " + this.nome);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) { this.nome = nome; }

	public void setNome() {}
	
	public Jogador getProprietario() {
		return this.proprietario;
	}
	
	public void setProprietario(Jogador p) {
		this.proprietario = p;
	}
	
	public int getPreco() {
		return this.preco;
	}

	public void setPreco(int preco) { this.preco = preco; }
	
	public void setCompravel(boolean compravel) {
		this.compravel = compravel;
	}

	public boolean ehCompravel() {
		return this.compravel;
	}
	
	public int getValorASerPago() {
		return this.valorASerPago;
	}

	public void setValorASerPago(int valor) { this.valorASerPago = valor; }

}
