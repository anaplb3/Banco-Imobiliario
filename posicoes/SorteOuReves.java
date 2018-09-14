package posicoes;

import java.util.ArrayList;
import java.util.Stack;

import Cartas.Baralho;
import Cartas.Carta;
import Cartas.CartaSorte;
import tabuleiro.Dado;
import tabuleiro.Jogador;

/**
* Essa classe representa a posição Sorte ou Revés do tabuleiro 
*/
public class SorteOuReves extends Posicao{
	ArrayList<Jogador> jogadores;
	Stack <CartaSorte> baralho;
	Baralho deck;
	Dado d1,d2;
	
	public SorteOuReves(ArrayList<Jogador>jogadores) {
		this.jogadores = jogadores;
		this.deck = new Baralho();
		this.baralho = deck.criarBaralho();
		d1 = new Dado();
		d2 = new Dado();

	}

	public void getNomeDaPosicao() {
		System.out.println("Você parou no sorte ou revés!");
	}

	public String getNome() {
		return "sorte ou revés";
	}
	
	public void recebaEspecial(Jogador jogadorDaVez) {
		int valor = 0;
		for(Jogador j : this.jogadores) {
			valor += 50;
			j.setDinheiro(j.getDinheiro()-50);
		}
		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro()+valor);
	}
	public void prisao(Jogador jogadorDaVez) {
		jogadorDaVez.setPrisioneiro(true);
	}
	public void inicio(Jogador jogadorDaVez,CartaSorte carta) {
		jogadorDaVez.setPosicao(0);
		receba(jogadorDaVez,carta);
		
	}
	/*Falta terminar*/
	public void jogueDados(Jogador jogadorDaVez) {
		int dado1 = d1.getDado();
		int dado2 = d2.getDado();
		
	}
	public void somaDados(Jogador jogadorDaVez) {
		int dado1 = d1.getDado();
		int dado2 = d2.getDado();
		
		if((dado1+dado2)%2 == 0) {
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro()+100);
		}else {
			jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro()-100);
		}
	}
	public void receba(Jogador jogadorDaVez, CartaSorte carta) {
		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro()+carta.getValor());
	}
	public void pague(Jogador jogadorDaVez,CartaSorte carta) {
		jogadorDaVez.setDinheiro(jogadorDaVez.getDinheiro()-carta.getValor());
	}
	

	public void acoes(Jogador jogadorDaVez) {
		CartaSorte carta = deck.puxarCarta();
		
		if(carta.getTipo().equals("recebaespecial")) {
			recebaEspecial(jogadorDaVez);
			}else if(carta.getTipo().equals("prisao")){
				prisao(jogadorDaVez);
				
			}else if(carta.getTipo().equals("inicio")) {
				inicio(jogadorDaVez,carta);
			}else if(carta.getTipo().equals("joguedados")) {
				
			}else if(carta.getTipo().equals("somadados")) {
				somaDados(jogadorDaVez);
			}else if(carta.getTipo().equals("receba")) {
				receba(jogadorDaVez,carta);
			}else if(carta.getTipo().equals("pague")) {
				pague(jogadorDaVez,carta);
			}
		

	}
	
	
	
	


	}
