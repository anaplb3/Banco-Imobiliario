package jogo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import posicoes.Companhia;
import posicoes.Imposto;
import posicoes.Lucros;
import posicoes.Posicao;
import posicoes.Prisao;
import posicoes.SorteOuReves;
import tabuleiro.Dado;
import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;
import posicoes.Propriedade;

public class Jogo {
	Scanner leitor;
	Tabuleiro tab;
	ArrayList<Jogador> jogadores;
	LinkedList<Posicao> tabuleiro;
	Dado d1, d2;
	int qtdJogadores;

	public Jogo() {
		this.leitor = new Scanner(System.in);
		this.jogadores = new ArrayList<>();
		this.d1 = new Dado();
		this.d2 = new Dado();
		this.tab = new Tabuleiro();
		this.tabuleiro = tab.criandoTab();
	}

	// Fazendo jogada
	public void comecandoJogo() {

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
				System.out.print("Tem certeza disso? (sim/nao)");
				String certeza = leitor.nextLine();
				if(certeza.equals("sim")) {
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
				Posicao p;

				//Tratando o erro quando o jogador ultrapassa os limites do array
				try {
					p = tabuleiro.get(dado1 + dado2 + jogadores.get(contador).getPosicao());
				} catch (IndexOutOfBoundsException erro) {
					jaSetouPosicaoAntes = true;
					int faltaAndar = (jogadorAtual.getPosicao() + dado1 + dado2) - 40;
					p = tabuleiro.get(faltaAndar);
					jogadorAtual.setPosicao(faltaAndar);
				}

				System.out.println(jogadorAtual.getNome() + " tirou " + dado1 + "," + dado2);

				// Caso seja prisão ou sorte ou revés, que ainda não está implementado
				// completamente
				if (p instanceof Prisao || p instanceof SorteOuReves) {
					p.getNomeDaPosicao();

				}

				// Caso caia no imposto de renda ou lucros e dividendos
				else if (p instanceof Imposto) {
					System.out.println("Você caiu em Lucros e Dividendos. Ganhou 200!");
					p.alterandoSaldoDoJogador(jogadorAtual);
				} else if(p instanceof Lucros) {
					System.out.println("Você caiu no Imposto de Renda! Pague 200.");
					p.alterandoSaldoDoJogador(jogadorAtual);
				}

				// Caso caia em uma Companhia
				else if (p instanceof Companhia) {
					p.getNomeDaPosicao();
					Companhia companhia = (Companhia) p;
					
					System.out.println("Preço: "+companhia.getPreco());

					if (companhia.isStatus() == false) {
						int multiplicadorASePagar = (dado1 + dado2) * companhia.getMultiplicador();

						jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - multiplicadorASePagar);
						System.out.println(
								"Pagou R$"+multiplicadorASePagar+" de multiplicador. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
					}
					// Caso não tenha sido comprada, pergunta ao jogador se quer comprar
					else {
						System.out.print("Você quer comprar essa companhia? (sim/nao) ");
						String comprar = leitor.nextLine();

						if (comprar.equals("sim") || comprar.equals("Sim")) {
							jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - companhia.getPreco());
							jogadorAtual.adicionandoPropriedade(companhia);
							System.out.println(
									"Comprou propriedade. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
							companhia.setStatus(false);
						} else {
							System.out.println("Você não comprou esta propriedade.");
						}

					}
				}

				// Caso caia em uma propriedade
				else if (p instanceof Propriedade) {
					Propriedade propriedade = (Propriedade) p;
					p.getNomeDaPosicao();

					// Caso a propriedade já esteja comprada, o jogador paga o aluguel
					if (propriedade.isStatus() == false) {

						jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - propriedade.getAluguel());
						System.out.println("Pagou R$"+propriedade.getAluguel()+" de aluguel. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
					}

					// Caso não tenha sido comprada, pergunta ao jogador se quer comprar
					else {
						System.out.print("Você quer comprar essa propriedade? (sim/nao) ");
						String comprar = leitor.nextLine();

						if (comprar.equals("sim") || comprar.equals("Sim")) {
							jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - propriedade.getPreco());
							jogadorAtual.adicionandoPropriedade(propriedade);
							System.out.println(
									"Comprou propriedade. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
							propriedade.setStatus(false);
						} else {
							System.out.println("Você não comprou esta propriedade.");
						}

					}

				}

				// Setando posição do jogador depois que faz a jogada
				if(jaSetouPosicaoAntes == false) {
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

	public boolean validaQtdDeJogadores() {
		try {
			this.qtdJogadores = Integer.parseInt(leitor.nextLine());
			return true;

		} catch (NumberFormatException erro) {
			System.out.println("Número inválido. Tente de novo!");
			return false;
		}
	
	}
	
	public void carregandoJogadores() {
		ArrayList<String> lista_de_cores = carregandoCores();
		boolean numeroJogadores = false;
		boolean boolJogadores = false;
		
		while(boolJogadores == false) {
			
			System.out.print("Quantos jogadores irão jogar? ");
			boolJogadores = validaQtdDeJogadores();
		}
		
		while (numeroJogadores == false) {

			if (this.qtdJogadores < 2 || this.qtdJogadores > 8) {
				System.out.println("Número de jogadores inválido!");

			} else {
				numeroJogadores = true;
			}
		}

		// Pegando informações dos jogadores

		for (int i = 0; i < this.qtdJogadores; i++) {
			System.out.print("Qual seu nome? ");
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