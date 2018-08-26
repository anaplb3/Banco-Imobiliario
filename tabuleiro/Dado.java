package tabuleiro;

import java.util.Random;

public class Dado {
	Random gerador;
	
	public Dado() {
		this.gerador = new Random();
	}
	
	public int getDado() {
		return gerador.nextInt(6)+1;
	}

}