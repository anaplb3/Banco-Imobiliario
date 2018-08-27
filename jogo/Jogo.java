package jogo;

import java.util.ArrayList;
import java.util.Scanner;

import posicoes.Imposto;
import posicoes.Lucros;
import posicoes.ParadaLivre;
import posicoes.Posicao;
import posicoes.Prisao;
import posicoes.SorteOuReves;
import tabuleiro.Dado;
import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;
import posicoes.Propriedade;


/**
 * Este classe é responsável por criar os jogadores e fazer as jogadas disponíveis
 */
public class Jogo {
	private Scanner leitor;
	private Tabuleiro tab;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Posicao> tabuleiro;
	private Dado d1, d2;
	private int qtdJogadores;

	
	/**
	 * Construtor da classe Jogo, que inicia os Dados, o Tabuleiro
	 * o Scanner e o array de Jogadores
	 * @see Dado.java
	 * @see Tabuleiro.java
	 */
	public Jogo() {
		this.leitor = new Scanner(System.in);
		this.jogadores = new ArrayList<>();
		this.d1 = new Dado();
		this.d2 = new Dado();
		this.tab = new Tabuleiro();
		this.tabuleiro = tab.criandoTab();
	}

	/**
	 * Calcula de quem é a vez de jogar, mostra os comandos
	 * possíveis e os executa
	 * @see Jogador.java
	 * @see Posicao.java
	 * @see Prisao.java
	 * @see SorteOuReves.java
	 * @see Imposto.java
	 * @see Lucros.java
	 * @see ParadaLivre
	 */
	public void fazendoJogada() {

		System.out.println("O jogo vai começar. Divirta-se!");
		int contador = 0;
		int dado1, dado2;
		boolean loop = true;

		while (this.jogadores.size() >= 2 || loop == true) {
			Jogador jogadorAtual = jogadores.get(contador);
			boolean jaSetouPosicaoAntes = false;

			// Mostrando situação do jogador
			System.out.println("\nVez de " + jogadorAtual.getNome() + "(" + jogadorAtual.getCor() + ")"
					+ "\nVocê possui R$: " + jogadorAtual.getDinheiro());
			System.out.println("Comandos disponívels: [Jogar] [Sair] [Status]");
			System.out.print("Sua escolha: ");
			String escolha = leitor.nextLine();

			// Caso o jogador queira sair
			if (escolha.equals("sair") || escolha.equals("Sair")) {
				System.out.print("Tem certeza disso? (sim/nao) ");
				String certeza = leitor.nextLine();
				if (certeza.equals("sim")) {
					leitor.close();
					break;
				} else {
					contador -= 1;
				}
			}

			// Caso o jogador queira fazer a jogada
			else if (escolha.equals("jogar") || escolha.equals("Jogar")) {
				dado1 = d1.getDado();
				dado2 = d2.getDado();
				Posicao posicao;

				// Tratando o erro quando o jogador ultrapassa os limites do array
				try {
					posicao = tabuleiro.get(dado1 + dado2 + jogadores.get(contador).getPosicao());
				} catch (IndexOutOfBoundsException erro) {
					jaSetouPosicaoAntes = true;
					int faltaAndar = (jogadorAtual.getPosicao() + dado1 + dado2) - 40;
					posicao = tabuleiro.get(faltaAndar);
					jogadorAtual.setPosicao(faltaAndar);
				}

				System.out.println(jogadorAtual.getNome() + " tirou " + dado1 + "," + dado2);

				// Caso seja prisão ou sorte ou revés, que ainda não está implementado
				// completamente
				if (posicao instanceof Prisao || posicao instanceof SorteOuReves) {
					posicao.getNomeDaPosicao();

				}

				// Caso caia no imposto de renda ou lucros e dividendos
				else if (posicao instanceof Imposto) {
					posicao.getNomeDaPosicao();
					posicao.alterandoSaldoDoJogador(jogadorAtual);
					
				} else if (posicao instanceof Lucros) {
					posicao.getNomeDaPosicao();
					posicao.alterandoSaldoDoJogador(jogadorAtual);
				}

				// Caso caia em uma parada livre
				else if (posicao instanceof ParadaLivre) {
					System.out.println("Você está na parada livre!");
				} 
				
				//Caso esteja no ponto de partida
				else if (posicao == null) {
					System.out.println("Você está no ponto de partida!");
				} 
				
				//Caso seja propriedade ou companhia
				else {
					posicao.getNomeDaPosicao();
					if (posicao.isStatus() == false) {
						pagandoAluguelOuMultiplicador(jogadorAtual, posicao, dado1, dado2);
					} else {
						System.out.print("Você deseja comprar? (sim/nao) ");
						String comprar = leitor.nextLine();
						escolhaDeCompra(comprar, jogadorAtual, posicao);
					}
				}

				// Setando posição do jogador depois que faz a jogada
				if (jaSetouPosicaoAntes == false) {
					int posicaoAtual = jogadorAtual.getPosicao();
					jogadorAtual.setPosicao(posicaoAtual + dado1 + dado2);
				}

			}

			// Caso escolha ver o status
			else if (escolha.equals("status") || escolha.equals("Status")) {

				jogadorAtual.status(this.tabuleiro);

				contador -= 1;
			}

			// Caso escolha um comando inválido
			else {
				System.out.println("Comando não é válido. Tente de novo!");
				contador -= 1;
			}

			// Incrementando contador para pegar jogador na ordem
			if (contador == jogadores.size() - 1) {
				contador = 0;
			} else {
				contador += 1;
			}

		}
	}

	
	/**
	 * Este método retira o valor do aluguel ou multiplicador do saldo do jogador
	 * @param jogadorAtual Jogador da rodada
	 * @param posicao Propriedade ou Companhia que ele se encontra
	 * @param dado1 Resultado do primeiro dado
	 * @param dado2 Resultado do segundo dado
	 * @see Propriedade.java
	 * @see Jogador.java
	 * @see Posicao.java
	 */
	public void pagandoAluguelOuMultiplicador(Jogador jogadorAtual, Posicao posicao, int dado1, int dado2) {
	
		if (posicao instanceof Propriedade) {

			jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - posicao.getAluguel());
			System.out.println("Pagou R$" + posicao.getAluguel() + " de aluguel. Dinheiro do jogador: "
					+ jogadorAtual.getDinheiro() + "\n");
		} 
		
		// Aqui a posicao é uma Companhia
		else {
			int multiplicadorASePagar = (dado1 + dado2) * posicao.getMultiplicador();

			jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - multiplicadorASePagar);
			System.out.println("Pagou R$" + multiplicadorASePagar + " de multiplicador. Dinheiro do jogador: "
					+ jogadorAtual.getDinheiro() + "\n");
		}
	}

	/**
	 * Este método verifica se o jogador quer comprar determinada Propriedade ou Companhia
	 * @param comprar Escolha do jogador em comprar ou não
	 * @param jogadorAtual jogador da rodada
	 * @param posicao Domínio em que ele se encontra
	 * @see Jogador.java
	 * @see Posicao.java
	 */
	public void escolhaDeCompra(String comprar, Jogador jogadorAtual, Posicao posicao) {
		if (comprar.equals("sim") || comprar.equals("Sim")) {
			jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - posicao.getPreco());
			jogadorAtual.adicionandoPropriedade(posicao);
			System.out.println("Comprou esse domínio. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
			posicao.setStatus(false);
		} else {
			System.out.println("Você não comprou esta propriedade.");
		}
	}

	/**
	 * Este método inicia o array com as cores
	 * @return Retorna um array com as cores disponíveis
	 */
	public ArrayList<String> carregandoCores() {
		ArrayList<String> lista_de_cores = new ArrayList<>();

		lista_de_cores.add("preto");
		lista_de_cores.add("branco");
		lista_de_cores.add("vermelho");
		lista_de_cores.add("verde");
		lista_de_cores.add("azul");
		lista_de_cores.add("amarelo");
		lista_de_cores.add("laranja");
		lista_de_cores.add("rosa");

		return lista_de_cores;
	}
	
	/**
	 * Este método verifica se a cor escolhida está disponível
	 * @param cor Cor escolhida pelo jogador
	 * @param list_cor Array com as cores disponíveis
	 * @return Retorna um boolean dependo da disponibilidade da cor
	 */
	public boolean validarCor(String cor, ArrayList<String> list_cor) {
		// Retira a cor do jogador da lista de cores
		try {
			for (int i = 0; i < list_cor.size(); i++) {

				if (list_cor.get(i).equals(cor)) {
					list_cor.remove(i);
					return true;
				}
			}
		} catch (NullPointerException e) {
			return false;
		}

		return false;
	}

	/**
	 * Este método verifica se o jogador entrou com uma quantidade de jogadores válida
	 * @return Retorna um boolean true se for válido ou um false se for inválido
	 */
	public boolean validaQtdDeJogadores() {
		try {
			this.qtdJogadores = Integer.parseInt(leitor.nextLine());

		} catch (NumberFormatException erro) {
			System.out.println("Número inválido. Tente de novo!\n");
			return false;
		}
		
		
		if (this.qtdJogadores < 2 || this.qtdJogadores > 8) {
				System.out.println("Número de jogadores inválido!\n");
				return false;
			} else {
				return true;
			}
		

	}
	
	/**
	 * Este método inicia o array com as jogadores, pegando as informações e testando se as cores e a quantidade são válidas
	 * @see Jogador.java
	 */
	public void carregandoJogadores() {
		ArrayList<String> lista_de_cores = carregandoCores();
		boolean boolJogadores = false;

		while (boolJogadores == false) {

			System.out.print("Quantos jogadores irão jogar? ");
			boolJogadores = validaQtdDeJogadores();
		}

		// Pegando informações dos jogadores

		for (int i = 0; i < this.qtdJogadores; i++) {
			System.out.print("\nQual seu nome? ");
			String nome = leitor.nextLine();

			System.out.println("[preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]");
			System.out.print("Escolha sua cor: ");
			String cor = leitor.nextLine();
			boolean corJaEscolhida = validarCor(cor, lista_de_cores);

			while (corJaEscolhida == false) {
				System.out.println("Cor indisponível. Tente de novo!");
				System.out.print("Escolha sua cor: ");
				cor = leitor.nextLine();
				corJaEscolhida = validarCor(cor, lista_de_cores);
			}

			Jogador j = new Jogador(nome, cor, 0, 1500);
			this.jogadores.add(j);
		}
	}

}