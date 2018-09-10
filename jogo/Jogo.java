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

/**
 * Este classe é responsável por criar os jogadores e fazer as jogadas
 * disponíveis
 * 
 * @see Jogador
 * @see Posicao
 * @see Dado
 * @see Tabuleiro
 */
public class Jogo {
	private Scanner leitor;
	private Tabuleiro tab;
	private ArrayList<Jogador> jogadores;
	private ArrayList<Posicao> tabuleiro;
	private Dado d1, d2;
	private int qtdJogadores;

	/**
	 * Construtor da classe Jogo, que inicia os Dados, o Tabuleiro o Scanner e o
	 * array de Jogadores
	 * 
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
	 * Calcula de quem é a vez de jogar, mostra os comandos possíveis e os executa
	 * 
	 * @see Jogador
	 * @see Posicao
	 * @see Prisao
	 * @see SorteOuReves
	 * @see Imposto
	 * @see Lucros
	 * @see ParadaLivre
	 */
	public void fazendoJogada() {

		System.out.println("O jogo vai começar. Divirta-se!");
		int contador = 0;
		int dado1, dado2;
		boolean loop = true;
		Jogador jogadorAtual;

		/**
		 * Vai rodando
		 */
		while (this.jogadores.size() >= 2 && loop == true) {
			/**
			 * Mostrando situação do jogador
			 */
			
			if (jogadores.get(contador).isPrisioneiro()) {
				Prisao p = new Prisao();

				System.out.println("\n" + jogadores.get(contador).getNome() + " está na prisão!");
				System.out.print("Comandos disponívels: [Pagar] [Carta] [Jogar] [Sair] [Status] ");
				String escolha = leitor.nextLine();

				contador = p.checandoLiberdade(this, this.tabuleiro, escolha, jogadores.get(contador), d1, d2, contador);
				continue;

			}

			try {
				jogadorAtual = jogadores.get(contador);
			} catch (Exception e) {
				contador = 0;
				jogadorAtual = jogadores.get(contador);
			}

			boolean jaSetouPosicaoAntes = false;

			System.out.println("\nVez de " + jogadorAtual.getNome() + "(" + jogadorAtual.getCor() + ")"
					+ "\nVocê possui R$: " + jogadorAtual.getDinheiro());
			System.out.println("Comandos disponívels: [Jogar] [Sair] [Status]");
			System.out.print("Sua escolha: ");
			String escolha = leitor.nextLine();
			escolha = escolha.toLowerCase();

			/**
			 * Série de if/else para determinar qual comando o jogador escolheu e executá-la
			 */

			if (escolha.equals("sair")) {
				System.out.print("Tem certeza disso? (sim/nao) ");
				String certeza = leitor.nextLine();

				contador = saindoDoJogo(certeza, jogadorAtual, contador);
			}

			else if (escolha.equals("jogar")) {
				dado1 = d1.getDado();
				dado2 = d2.getDado();
				Posicao posicao;

				// Verificando a possibilidade do jogador ir a prisão por tirar dados iguais 3
				// vezes seguidas
				if (dado1 == dado2) {

					jogadorAtual.setDadosIguais(jogadorAtual.getDadosIguais() + 1);

					if (jogadorAtual.getDadosIguais() == 3) {

						System.out.println("Você tirou dados iguais 3 vezes! Vá para a prisão.");
						jogadorAtual.setPrisioneiro(true);
						continue;

					}

				} else {
					
					jogadorAtual.setDadosIguais(0);
					
				}

				/**
				 * Tratando o erro quando o jogador ultrapassa os limites do array
				 */
				try {
					posicao = tabuleiro.get(dado1 + dado2 + jogadores.get(contador).getPosicao());
				} catch (IndexOutOfBoundsException erro) {
					jaSetouPosicaoAntes = true;
					int faltaAndar = (jogadorAtual.getPosicao() + dado1 + dado2) - 40;
					posicao = tabuleiro.get(faltaAndar);
					jogadorAtual.setPosicao(faltaAndar);
				}

				System.out.println(jogadorAtual.getNome() + " tirou " + dado1 + "," + dado2);

				determinandoTipoDePosicao(posicao, jogadorAtual, dado1, dado2);

				/**
				 * Setando posição do jogador depois que faz a jogada
				 */
				if (jaSetouPosicaoAntes == false) {
					int posicaoAtual = jogadorAtual.getPosicao();
					jogadorAtual.setPosicao(posicaoAtual + dado1 + dado2);
				}

			}

			else if (escolha.equals("status")) {

				jogadorAtual.status(this.tabuleiro);

				contador -= 1;
			}

			else {
				
				System.out.println("Comando não é válido. Tente de novo!");
				contador -= 1;
			}

			contador = ordenandoJogadores(contador);

		}

		System.out.println("\nJogo finalizado. Obrigada por jogar!");
		leitor.close();
	}

	/**
	 * Método que seta o índice do jogador da vez
	 * 
	 * @param contador
	 *            É um indice para o array de jogadores
	 * @return Retorna o indice do jogador da rodada
	 */
	public int ordenandoJogadores(int contador) {
		if (contador == jogadores.size() - 1) {
			contador = 0;
		} else {
			contador += 1;
		}

		return contador;
	}

	/**
	 * Método que verifica em que posição o jogador parou e executa um método de
	 * acordo com a posição
	 * 
	 * @param posicao
	 *            Posição atual do jogador
	 * @param jogadorAtual
	 *            jogador da rodada
	 * @param dado1
	 *            Resultado do dado1
	 * @param dado2
	 *            Resultado do dado2
	 */
	public void determinandoTipoDePosicao(Posicao posicao, Jogador jogadorAtual, int dado1, int dado2) {
		if (posicao instanceof Prisao) {
			posicao.getNomeDaPosicao();

			((Prisao) posicao).caindoNaPrisao(jogadorAtual);
		}

		else if (posicao instanceof SorteOuReves) {
			posicao.getNomeDaPosicao();
		}

		else if (posicao instanceof Imposto) {
			posicao.getNomeDaPosicao();
			posicao.alterandoSaldoDoJogador(jogadorAtual);

		}

		else if (posicao instanceof Lucros) {
			posicao.getNomeDaPosicao();
			posicao.alterandoSaldoDoJogador(jogadorAtual);
		}

		else if (posicao instanceof ParadaLivre) {
			System.out.println("Você está na parada livre!");
		}

		else if (posicao == null) {
			System.out.println("Você está no ponto de partida!");
		}

		else {
			posicao.getNomeDaPosicao();
			if (posicao.isStatus() == false) {
				posicao.pagandoAluguelOuMultiplicador(jogadorAtual, posicao, dado1, dado2);

			} else {
				System.out.println("Preço: "+posicao.getPreco());
				System.out.print("Você deseja comprar? (sim/nao) ");
				String comprar = leitor.nextLine();
				escolhaDeCompra(comprar, jogadorAtual, posicao);

			}
		}
	}

	/**
	 * Este método verifica se o jogador quer comprar determinada Propriedade ou
	 * Companhia
	 * 
	 * @param comprar
	 *            Escolha do jogador em comprar ou não
	 * @param jogadorAtual
	 *            jogador da rodada
	 * @param posicao
	 *            Domínio em que ele se encontra
	 * @see Jogador
	 * @see Posicao
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
	 * 
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
	 * 
	 * @param cor
	 *            Cor escolhida pelo jogador
	 * @param list_cor
	 *            Array com as cores disponíveis
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
	 * Este método verifica se o jogador entrou com uma quantidade de jogadores
	 * válida
	 * 
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
	 * Este método inicia o array com as jogadores, pegando as informações e
	 * testando se as cores e a quantidade são válidas
	 * 
	 * @see Jogador
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

			Jogador j = new Jogador(nome, cor);
			this.jogadores.add(j);
		}
	}
	
	public int saindoDoJogo(String escolha, Jogador jogadorAtual, int contador) {
		
		if (escolha.equals("sim")) {
			
			jogadorAtual.saindo();
			this.jogadores.remove(jogadorAtual);

		} else {

			contador -= 1;

		}
		
		return contador;
	}

}