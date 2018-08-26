package posicoes;

public class Companhia extends Posicao{
	private String nome;
	private int preco;
	private boolean status;
	private int multiplicador;
	
	public Companhia() {
		this.nome = "";
		this.preco = 0;
		this.status = true;
	}
	
	public Companhia(String nome, int preco, int multiplicador) {
		this.nome = nome;
		this.preco = preco;
		this.status = true;
		this.multiplicador = multiplicador;
	}

	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getMultiplicador() {
		return multiplicador;
	}


	public void setMultiplicador(int multiplicador) {
		this.multiplicador = multiplicador;
	}


	public void getNomeDaPosicao() {
		System.out.println("Você está em "+this.nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
	
	
}
