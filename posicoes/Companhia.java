package posicoes;

import tabuleiro.Jogador;

/**
 * Esta classe tem os atributos da posição Companhia
 */
public class Companhia extends Posicao{
	private String nome;
	private int preco;
	private boolean status;
	private int multiplicador;
	private Jogador proprietario;
	
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
		this.proprietario = null;
	}
	
	public Jogador getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Jogador j) {
		this.proprietario = j;
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
	
	
	/**
	 * Este método retira o valor do multiplicador do saldo do jogador e paga ao dono da companhia
	 * 
	 * @param jogadorAtual
	 *            Jogador da rodada
	 * @param posicao
	 *            Companhia que ele se encontra
	 * @param dado1
	 *            Resultado do primeiro dado
	 * @param dado2
	 *            Resultado do segundo dado            
	 * @see Jogador
	 * @see Posicao
	 */
	public void pagandoAluguelOuMultiplicador(Jogador jogadorAtual, Posicao posicao, int dado1, int dado2) {
		
		int multiplicadorASePagar = (dado1 + dado2) * posicao.getMultiplicador();
		
		Jogador dono = posicao.getProprietario();
		if(dono.equals(jogadorAtual)) {
			
			System.out.println("Esse dominío já é seu!");
			
		} else {
			dono.setDinheiro(dono.getDinheiro() + multiplicadorASePagar);

			jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - multiplicadorASePagar);
			System.out.println("Pagou R$" + multiplicadorASePagar + " de multiplicador a "+dono.getNome()+". Dinheiro do jogador: "
				+ jogadorAtual.getDinheiro() + "\n");
		}
		
		
		
	}
	
	
}
