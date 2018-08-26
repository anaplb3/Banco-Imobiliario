package posicoes;

public class Propriedade extends Posicao{
	private String nome;
	private int preco;
	private boolean status;
	private int aluguel;
	private String cor;
	
	public Propriedade() {
		this.nome = "";
		this.preco = 0;
		this.aluguel = 0;
	}
	
	public Propriedade(String nome, int preco, int aluguel) {
		this.nome = nome;
		this.preco = preco;
		this.status = true;
		this.aluguel = aluguel;
	}
	
	
	public void getNomeDaPosicao() {
		System.out.println("Você está em "+this.nome);
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAluguel() {
		return aluguel;
	}
	
	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
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

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

}
