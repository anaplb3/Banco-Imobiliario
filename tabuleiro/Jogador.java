package tabuleiro;

import java.util.ArrayList;
import java.util.LinkedList;

import posicoes.Posicao;

public class Jogador {
	private String nome;
	private String cor;
	private int posicao;
	private double dinheiro;
	ArrayList<Posicao> propriedades;

	public Jogador(String nome, String cor, int posicao, double dinheiro) {
		this.nome = nome;
		this.cor = cor;
		this.posicao = posicao;
		this.dinheiro = dinheiro;
		this.propriedades = new ArrayList<>();
	}

	public void adicionandoPropriedade(Posicao p) {
		this.propriedades.add(p);
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

	public void status(LinkedList<Posicao> tabuleiro) {
		Posicao lugar = tabuleiro.get(this.posicao);

		if (lugar == null) {
			System.out.println(this.nome + " - " + this.cor);
			System.out.println("Você está na casa " + this.posicao + ", em uma posição nula.");
			System.out.println("Você possui R$" + this.dinheiro);

		} else {
			System.out.println(this.nome + " - " + this.cor);
			System.out.println("Você está na casa " + this.posicao + ", em " + lugar.getNome());
			System.out.println("Você possui R$" + this.dinheiro);

		}
		if (this.propriedades.size() > 0) {
			System.out.println("Essas são suas propriedades: ");
			for (Posicao prop : this.propriedades) {
				System.out.println(prop.getNome());
			}
			System.out.println("\n");

		} else {
			System.out.println("Você ainda não tem propriedades!\n");
		}

	}

}
