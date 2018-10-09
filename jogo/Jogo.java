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
	private Prisao prisao;
	private SorteOuReves sorte;
	private int indiceDoJogador;

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
		this.prisao = new Prisao();
		this.sorte = new SorteOuReves();
		this.indiceDoJogador = 0;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	/**
	 * Verifica se o jogador é um prisioneiro visitante
	 * 
	 * @param jogadorAtual
	 *            Jogador da rodada
	 * @return um booleano que retorna true caso ele seja, indicando que precisa
	 *         passar a rodada pra o próximo jogador
	 */
	public boolean verificandoSePrisioneiroVisitante(Jogador jogadorAtual) {
		boolean check = false;

		if (jogadorAtual.isPrisioneiroVisitante()) {

			System.out.println("\n" + jogadorAtual.getNome() + ",  você está preso por uma rodada!");
			jogadorAtual.setPrisioneiroVisitante(false);
			this.indiceDoJogador += 1;
			check = true;
		}

		return check;
	}

	/**
	 * Verifica se o jogador tirou dados iguais por 3 vezes seguidas.
	 * 
	 * @param dado1
	 *            Resultado do primeiro dado
	 * @param dado2
	 *            Resultado do segundo dado
	 * @param jogadorAtual
	 *            Jogador da rodada
	 * @return Retorna um true caso tire dados repetidos 3 vezes seguidas ou false
	 *         se for o contrário
	 * @see Jogador
	 */
	public boolean verificandoDadosIguais(int dado1, int dado2, Jogador jogadorAtual) {
		boolean checando = false;

		if (dado1 == dado2) {
			jogadorAtual.setDadosIguais(jogadorAtual.getDadosIguais() + 1);

			if (jogadorAtual.getDadosIguais() == 3) {
				System.out.println("Você tirou dados iguais 3 vezes! Vá para a prisão.");
				jogadorAtual.setPrisioneiro(true);
				jogadorAtual.setPosicao(30);
				jogadorAtual.setDadosIguais(0);
				this.indiceDoJogador += 1;
				checando = true;

			}

		} else {
			jogadorAtual.setDadosIguais(0);

		}

		return checando;

	}

	/**
	 * Método responsável por executar a jogada do jogador
	 * 
	 * @param dado1
	 *            Resultado do primeiro dado
	 * @param dado2
	 *            resultado do segundo dado
	 * @param tabuleiro
	 *            tabuleiro do jogo
	 * @param jogadorAtual
	 *            jogador da rodada
	 */
	public void jogada(int dado1, int dado2, ArrayList<Posicao> tabuleiro, Jogador jogadorAtual) {
		Posicao p;
		p = pegandoPosicaoNoTabuleiro(dado1, dado2, tabuleiro, jogadorAtual);

		System.out.println(jogadorAtual.getNome() + " tirou " + dado1 + "," + dado2);

		determinandoTipoDePosicao(p, jogadorAtual, dado1, dado2);
		this.indiceDoJogador += 1;
	}

	/**
	 * Tratando o erro quando o jogador ultrapassa os limites do array
	 * 
	 * @param dado1
	 *            resultado do primeiro dado
	 * @param dado2
	 *            resultado do segundo dado
	 * @param tabuleiro
	 *            tabuleiro do jogo
	 * @param jogadorAtual
	 *            jogador da rodada
	 * @return A posição em que o jogador caiu
	 */
	public Posicao pegandoPosicaoNoTabuleiro(int dado1, int dado2, ArrayList<Posicao> tabuleiro, Jogador jogadorAtual) {
		Posicao p;

		try {
			p = tabuleiro.get(dado1 + dado2 + jogadorAtual.getPosicao());
		} catch (IndexOutOfBoundsException erro) {
			System.out.println("Você deu uma volta no tabuleiro! Ganhou R$200!");
			jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() + 200);

			int faltaAndar = (jogadorAtual.getPosicao() + dado1 + dado2) - 40;

			p = tabuleiro.get(faltaAndar);
			jogadorAtual.setPosicao(faltaAndar);
		}

		return p;
	}

	/**
	 * Mostrando as opções de jogada de cada jogador
	 * 
	 * @param jogadorAtual
	 *            jogador da rodada
	 * @return A escolha de jogada do jogador
	 */
	public String menu(Jogador jogadorAtual) {
		String menu = "Comandos disponívels: [Jogar] [Sair] [Status]";

		if (jogadorAtual.isPrisioneiro()) {
			menu = "Comandos disponívels: [Pagar] [Carta] [Jogar] [Sair] [Status]";
		}

		System.out.println("\nVez de " + jogadorAtual.getNome() + "(" + jogadorAtual.getCor() + ")"
				+ "\nVocê possui R$: " + jogadorAtual.getDinheiro());
		System.out.println(menu);
		System.out.print("Sua escolha: ");
		String escolha = leitor.nextLine();
		escolha = escolha.toLowerCase();

		return escolha;
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
		int dado1, dado2;
		boolean loop = true;
		Jogador jogadorAtual;

		/**
		 * Vai rodando o jogo enquanto houver jogadores e ninguém houver ganhado ainda
		 */
		while (this.jogadores.size() >= 2 && loop == true) {
			jogadorAtual = jogadores.get(indiceDoJogador);

			boolean prisioneiroVisitante = verificandoSePrisioneiroVisitante(jogadorAtual);
			if (prisioneiroVisitante) {
				continue;
			}

			String escolha = menu(jogadorAtual);

			// Verifica se o jogador é prisioneiro e caso sim, executa a sua escolha
			if (jogadorAtual.isPrisioneiro()) {
				this.indiceDoJogador = prisao.checandoLiberdade(this, this.tabuleiro, escolha, jogadorAtual, d1, d2,
						this.indiceDoJogador);
				continue;
			}

			/**
			 * Série de if/else para determinar qual comando o jogador escolheu e executá-la
			 */

			if (escolha.equals("sair")) {
				System.out.print("Tem certeza disso? (sim/nao) ");
				String certeza = leitor.nextLine();

				saindoDoJogo(certeza, jogadorAtual);
			}

			else if (escolha.equals("jogar")) {
				dado1 = d1.getDado();
				dado2 = d2.getDado();

				// Verificando a possibilidade do jogador ir a prisão por tirar dados iguais 3
				// vezes seguidas

				boolean dadosIguais = verificandoDadosIguais(dado1, dado2, jogadorAtual);
				if (dadosIguais) {
					continue;
				}

				jogada(dado1, dado2, tabuleiro, jogadorAtual);

				int posicaoAtual = jogadorAtual.getPosicao();
				jogadorAtual.setPosicao(posicaoAtual + dado1 + dado2);
			}

			else if (escolha.equals("status")) {
				jogadorAtual.status(this.tabuleiro);
			}

			else {
				System.out.println("Comando não é válido. Tente de novo!");
			}

			ordenandoJogadores();
		}

		System.out.println("\nJogo finalizado. Obrigada por jogar!");
		leitor.close();
	}

	/**
	 * Método que seta o índice do jogador da vez
	 */
	public void ordenandoJogadores() {
		this.indiceDoJogador = this.indiceDoJogador % this.jogadores.size();
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
			prisao = (Prisao) posicao;

			if (prisao.getTipo().equals("prisão")) {
				prisao.caindoNaPrisao(jogadorAtual);

			} else {
				System.out.println("Você é visitante da prisão. Fique 1 rodada sem jogar!");
				jogadorAtual.setPrisioneiroVisitante(true);
			}
		}

		else if (posicao instanceof SorteOuReves) {
			posicao.getNomeDaPosicao();

			sorte = (SorteOuReves) posicao;

			sorte.setJogadores(jogadores);
			sorte.acoes(jogadorAtual, this, tabuleiro, dado1, dado2);
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
				System.out.println("Preço: " + posicao.getPreco());
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

	/**
	 * Esse método retira o jogador do jogo
	 * 
	 * @param escolha
	 *            string com a decisão do jogador
	 * @param jogadorAtual
	 *            jogador da rodada
	 * @see Jogador
	 */
	public void saindoDoJogo(String escolha, Jogador jogadorAtual) {

		if (escolha.equals("sim")) {

			jogadorAtual.saindo();
			this.jogadores.remove(jogadorAtual);

		} else {

			this.indiceDoJogador -= 1;

		}

	}

}