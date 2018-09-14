package Cartas;

import java.util.ArrayList;
import java.util.Stack;

public class Baralho {
	
	private Stack <CartaSorte> baralho;
	private CartaSorte carta;
	
	public Baralho() {
		this.baralho = new Stack<CartaSorte>();
		this.carta = new CartaSorte();
	}
	 
	public Stack<CartaSorte> criarBaralho(){
		
		ArrayList<String> descricoes = carta.descricoesDasCartas();
		ArrayList<Integer> valores = carta.valoresDasCartas();

		
		for(int i =1; i<32; i++) {
			CartaSorte cartaBaralho = new CartaSorte();
			if(i == 2) {
				cartaBaralho.setTipo("recebaespecial");
			}else if(i == 5) {
				cartaBaralho.setTipo("prisao");
			}else if(i == 7) {
				cartaBaralho.setTipo("inicio");
			}else if(i == 12) {
				cartaBaralho.setTipo("joguedados");
			}else if(i == 24) {
				cartaBaralho.setTipo("somadados");
			}else if(i == 4 || i == 8 || i == 11 || i == 14 || i == 15 || i == 17 || i == 19 || i == 20 || i == 21 || i == 27 || i == 31 ) {
				cartaBaralho.setTipo("recebe");
			}else {
				cartaBaralho.setTipo("pague");
			}
			
			cartaBaralho.setDescricao(descricoes.get(i-1));
			cartaBaralho.setValor(valores.get(i-1));
			this.baralho.push(cartaBaralho);
			
		
			
		}
		return baralho;
		
		
		
	}
	public CartaSorte puxarCarta() {
		Stack<CartaSorte> baralho = criarBaralho();
		CartaSorte carta = baralho.pop();
		
		this.baralho.add(carta);
		
		return carta;
	}
	
	

}
