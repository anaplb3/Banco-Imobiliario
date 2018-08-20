package tabuleiro;

import java.util.ArrayList;

public class Propriedade {
	private String nome;
	private int preco;
	private boolean status;
	
	
	public Propriedade(String nome, int preco, boolean status) {
		this.nome = nome;
		this.preco = preco;
		this.status = status;
	}
	
	
	public String getNome() {
		return nome;
	}



	public int getPreco() {
		return preco;
	}



	public boolean isStatus() {
		return status;
	}



	public boolean jaComprado() {
		if(this.status == true) {
			return true;
		} else {
			return false;
		}
	}
	
}
