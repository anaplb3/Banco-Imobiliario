package tabuleiro;

import java.util.ArrayList;

import posicoes.Companhia;
import posicoes.Posicao;
import posicoes.Propriedade;

/**
 * Esta classe tem os atributos de cada jogador
 */
public class Jogador {
	private String nome;
	private String cor;
	private int posicao;
	private double dinheiro;
	ArrayList<Posicao> propriedades;

	/**
	 * Esse construtor está setando as informações do jogador
	 * 
	 * @param nome
	 *            Nome do jogador
	 * @param cor
	 *            Cor do jogador
	 */
	public Jogador(String nome, String cor) {
		this.nome = nome;
		this.cor = cor;
		this.posicao = 0;
		this.dinheiro = 1500;
		this.propriedades = new ArrayList<>();
	}

	/**
	 * Esse método está adicionando o dominío no Array de propriedades do jogador
	 * 
	 * @param p
	 *            É a posição (Propriedade ou Companhia) em que o jogador se
	 *            encontra
	 */
	public void adicionandoPropriedade(Posicao p) {
		this.propriedades.add(p);
	}
	
	
	public ArrayList<Posicao> getPropriedades() {
		return propriedades;
	}

	public void setPropriedades(ArrayList<Posicao> propriedades) {
		this.propriedades = propriedades;
	}

	public void setDinheiro(double money) {
		this.dinheiro = money;
	}

	public double getDinheiro() {
		return this.dinheiro;
	}

	public int getPosicao() {
		return this.posicao;
	}

	public void setPosicao(int p) {
		this.posicao = p;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * Esse método está criando a opção de Status do jogador
	 * 
	 * @param tabuleiro
	 *            É um Array com todas as posições disponíveis no tabuleiro
	 */
	public void status(ArrayList<Posicao> tabuleiro) {
		Posicao lugar = tabuleiro.get(this.posicao);

		if (lugar == null) {
			System.out.println(this.nome + " - " + this.cor);
			System.out.println("Você está na casa " + this.posicao + ", no ponto de partida.");
			System.out.println("Você possui R$" + this.dinheiro);

		} else {
			System.out.println(this.nome + " - " + this.cor);
			System.out.println("Você está na casa " + this.posicao + ", em " + lugar.getNome());
			System.out.println("Você possui R$" + this.dinheiro);

		}
		if (this.propriedades.size() > 0) {
			System.out.println("Essas são suas propriedades: ");
			for (Posicao prop : this.propriedades) {
				if (prop instanceof Propriedade) {
					Propriedade p = (Propriedade) prop;
					System.out.println(p.getNome() + ", da cor " + p.getCor() + " com aluguel de R$" + p.getAluguel());
				} else {
					Companhia c = (Companhia) prop;
					System.out.println(c.getNome() + ", com multiplicador de " + c.getMultiplicador());
				}

			}
			System.out.println("\n");

		} else {
			System.out.println("Você ainda não tem propriedades!\n");
		}

	}

}
