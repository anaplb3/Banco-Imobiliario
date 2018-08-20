package userStory1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class CriandoJogo {
	
	private static ArrayList<String> lista_de_cores = new ArrayList<String>();
	static boolean game = true;
	
	public static void main(String[] args) {
		Scanner leitor =  new Scanner(System.in);
		Random gerador = new Random();
		int dado1, dado2;
		ArrayList<Jogador> jogadores = new ArrayList<>();
		
		lista_de_cores.add("preto");
		lista_de_cores.add("branco");
		lista_de_cores.add("vermelho");
		lista_de_cores.add("verde");
		lista_de_cores.add("azul");
		lista_de_cores.add("amarelo");
		lista_de_cores.add("laranja");
		lista_de_cores.add("rosa");
		
			System.out.println("Bem vindo ao Banco Imobiliário!");
			System.out.print("Quantos jogadores irão jogar? ");
			int qtdJogadores = Integer.parseInt(leitor.nextLine());
			
			//Pegando informações dos jogadores
			for(int i = 0; i < qtdJogadores; i++) {
				System.out.print("Qual seu nome? ");
				String nome = leitor.nextLine();
				
				System.out.println("[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]");
				System.out.print("Escolha sua cor: ");
				String cor = leitor.nextLine();
				boolean corJaEscolhida = validarCor(cor, lista_de_cores);
				
				while(corJaEscolhida == false) {
					System.out.println("Cor indisponível. Tente de novo!");
					System.out.print("Escolha sua cor: ");
					cor = leitor.nextLine();
					corJaEscolhida = validarCor(cor, lista_de_cores);
				}
				
				Jogador j = new Jogador(nome, cor);
				jogadores.add(j);
			}
			//Fim da coleta de informações
			
			int contador = 0;
			while(jogadores.size() >= 2) {
				
				System.out.println("O jogo vai começar. Divirta-se!");
				
				System.out.println("Vez de "+jogadores.get(contador).getNome()+ "("+jogadores.get(contador).getCor()+")");
				System.out.println("Comandos disponívels: [Jogar] [Sair]");
				System.out.print("Sua escolha: ");
				String escolha = leitor.nextLine();
				
				if(escolha.equals("sair") || escolha.equals("Sair")) {
					break;
				} else if(escolha.equals("jogar") || escolha.equals("Jogar")); {
					dado1 = gerador.nextInt(7);
					dado2 = gerador.nextInt(7);
					
					System.out.println(jogadores.get(contador).getNome()+" tirou "+dado1+","+dado2);
				}
				
				if(contador == jogadores.size()-1) {
					contador = 0;
				} else {
					contador += 1;
				}
			}
	
	}
	
	
	public static boolean validarCor(String cor, ArrayList<String> list_cor) {
		//Retira a cor do jogador da lista de cores
		try {
			//System.out.println(cor);
			for(int i =0 ; i <list_cor.size(); i++) {
				//System.err.println(list_cor.get(i));
				if(list_cor.get(i).equals(cor)) {
					//System.out.println(list_cor.get(i));
					//System.out.println(i);
					list_cor.remove(i);
					return true;
				}
			}
		}catch(NullPointerException e) {
			return false;
		}
		
		return false;
	}
	
	

}
