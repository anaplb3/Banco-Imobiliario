package posicoes;

/**
 * Esta classe tem os atributos da posição Companhia
 */
public class Companhia extends Posicao{
	private String nome;
	private int preco;
	private boolean status;
	private int multiplicador;
	
	/**
	 * Construtor iniciando atributos vazios
	 */
	public Companhia() {
		this.nome = "";
		this.preco = 0;
		this.status = true;
	}
	
	/**
	 * Construtor iniciando atributos com valores
	 * @param nome Nome da compnhia
	 * @param preco Preço da companhia
	 * @param multiplicador Multiplicador de valor da companhia
	 */
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

	/**
	 * Esse método printa o nome da Companhia
	 */
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
