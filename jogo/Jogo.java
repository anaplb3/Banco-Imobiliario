package jogo;

import java.util.ArrayList;
import java.util.Scanner;

import posicoes.Imposto;
import posicoes.Lucros;
import posicoes.ParadaLivre;
import posicoes.Posicao;
import posicoes.Prisao;
import posicoes.SorteOuReves;
import tabuleiro.Construtor;
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
    private int indiceDoJogador;

    /**
     * Construtor da classe Jogo, que inicia os Dados, o Tabuleiro o Scanner e o
     * array de Jogadores
     */
    public Jogo() {
        this.leitor = new Scanner(System.in);
        this.jogadores = new ArrayList<>();
        this.d1 = d1.getInstance();
        this.d2 = d2.getInstance();
        this.tab = tab.getInstance();
        this.tabuleiro = tab.criandoTab();
        this.prisao = new Prisao();
        this.indiceDoJogador = 0;
    }

    public void setIndiceDoJogador(int contador) {
        this.indiceDoJogador = contador;
    }

    public int getIndiceDoJogador() {
        return this.indiceDoJogador;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    /**
     * Verifica se o jogador é um prisioneiro visitante
     *
     * @param jogadorAtual Jogador da rodada
     * @return um booleano que retorna true caso ele seja, indicando que precisa
     * passar a rodada pra o próximo jogador
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
     * @param dado1        Resultado do primeiro dado
     * @param dado2        Resultado do segundo dado
     * @param jogadorAtual Jogador da rodada
     * @return Retorna um true caso tire dados repetidos 3 vezes seguidas ou false
     * se for o contrário
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
     * @param dado1        Resultado do primeiro dado
     * @param dado2        resultado do segundo dado
     * @param jogadorAtual jogador da rodada
     */
    public void jogada(int dado1, int dado2, Jogador jogadorAtual) {
        Posicao p;
        p = pegandoPosicaoNoTabuleiro(dado1, dado2, jogadorAtual);

        System.out.println(jogadorAtual.getNome() + " tirou " + dado1 + "," + dado2);

        if (!p.ehCompravel()) {
            p.execute(jogadorAtual, dado1, dado2, this);

        } else {
            p.getNomeDaPosicao();
            System.out.println("Preço: " + p.getPreco());
            System.out.print("Você deseja comprar? (s/n) ");
            String comprar = leitor.nextLine();
            escolhaDeCompra(comprar.toLowerCase(), jogadorAtual, p);
        }


        this.indiceDoJogador += 1;
    }

    /**
     * Tratando o erro quando o jogador ultrapassa os limites do array
     *
     * @param dado1        resultado do primeiro dado
     * @param dado2        resultado do segundo dado
     * @param jogadorAtual jogador da rodada
     * @return A posição em que o jogador caiu
     */
    public Posicao pegandoPosicaoNoTabuleiro(int dado1, int dado2, Jogador jogadorAtual) {
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
     * @param jogadorAtual jogador da rodada
     * @return A escolha de jogada do jogador
     */
    public String menu(Jogador jogadorAtual) {
        String menu = "Comandos disponíveis: [Construir] [Vender] [Jogar] [Sair] [Status]";
        String apresentacao = "\nVez de " + jogadorAtual.getNome() + "(" + jogadorAtual.getCor() + ")";


        if (jogadorAtual.isPrisioneiro()) {
            menu = "Comandos disponíveis: [Pagar] [Carta] [Jogar] [Sair] [Status]";
            apresentacao = "\n" + jogadorAtual.getNome() + ", você está na prisão!";
        }

        System.out.println(apresentacao + "\nVocê possui R$: " + jogadorAtual.getDinheiro());
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

		/*
		  Vai rodando o jogo enquanto houver jogadores e ninguém houver ganhado ainda
		 */
        while (this.jogadores.size() >= 2 && loop) {
            try {
                jogadorAtual = jogadores.get(indiceDoJogador);
            } catch (IndexOutOfBoundsException erro) {
                jogadorAtual = jogadores.get(0);
            }

            //Verifica se há ganhador
            if (checandoGanhador() != null) {
                System.out.println("Parabéns " + checandoGanhador().getNome() + ", você venceu!");
                System.out.println("Considere-se a pessoa mais rica do mundo!");
                loop = false;
            }

            //Caso não, continua a jogada normalmente
            else {
                boolean prisioneiroVisitante = verificandoSePrisioneiroVisitante(jogadorAtual);

                if (prisioneiroVisitante) {
                    continue;
                }

                String escolha = menu(jogadorAtual);

                // Verifica se o jogador é prisioneiro e caso sim, executa a sua escolha
                if (jogadorAtual.isPrisioneiro()) {
                    int posicaoDoJogador = jogadorAtual.getPosicao();
                    prisao.checandoLiberdade(this, this.tabuleiro.get(posicaoDoJogador), escolha, jogadorAtual, d1, d2);
                    continue;
                }

			/*
			  Série de if/else para determinar qual comando o jogador escolheu e executá-la
			 */

                switch (escolha) {
                    case "sair":
                        System.out.print("Tem certeza disso? (s/n) ");
                        String certeza = leitor.nextLine();

                        saindoDoJogo(certeza.toLowerCase(), jogadorAtual);
                        break;

                    case "jogar":
                        dado1 = d1.getDado();
                        dado2 = d2.getDado();

                        // Verificando a possibilidade do jogador ir a prisão por tirar dados iguais 3
                        // vezes seguidas

                        boolean dadosIguais = verificandoDadosIguais(dado1, dado2, jogadorAtual);
                        if (dadosIguais) {
                            continue;
                        }

                        jogada(dado1, dado2, jogadorAtual);

                        int posicaoAtual = jogadorAtual.getPosicao();
                        jogadorAtual.setPosicao(posicaoAtual + dado1 + dado2);
                        break;

                    case "status":
                        jogadorAtual.status(this.tabuleiro.get(jogadorAtual.getPosicao()));
                        break;

                    case "construir":
                        Construtor construtor = new Construtor(jogadorAtual);

                        if (construtor.haPropriedades()) {
                            construtor.opcoes();
                            int choice;

                            do {
                                choice = Integer.parseInt(leitor.nextLine());
                                try {
                                    construtor.construcao(choice);
                                } catch (IndexOutOfBoundsException e) {
                                    System.out.println("Opção não é válida. Tente de novo!");
                                }
                            } while (choice != 0);
                        } else {
                            System.out.println("Você não pode construir casas.");
                        }
                        break;

                    case "vender":
                        Construtor venda = new Construtor(jogadorAtual);
                        int choice;
                        boolean vendaEhValida;

                        if (venda.haPropriedades()) {
                            do {
                                venda.opcoes();
                                System.out.print("Digite o número da propriedade que quer vender: ");
                                choice = Integer.parseInt(leitor.nextLine());
                                vendaEhValida = venda.haCasasDisponiveis(choice);
                                if (vendaEhValida) {
                                    try {
                                        venda.venda(choice);
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Propriedade não existe para ser vendida!");
                                    }
                                } else {
                                    System.out.println("Você não tem casas disponíveis para a venda!");
                                }
                            } while (choice != 0 && vendaEhValida);
                        } else {
                            System.out.println("Você não tem propriedades disponíveis para a venda!");
                        }
                        break;

                    default:
                        System.out.println("Comando não é válido. Tente de novo!");
                        break;
                }

                ordenandoJogadores();
            }


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
     * Este método verifica se o jogador quer comprar determinada Propriedade ou
     * Companhia
     *
     * @param comprar      Escolha do jogador em comprar ou não
     * @param jogadorAtual jogador da rodada
     * @param posicao      Domínio em que ele se encontra
     * @see Jogador
     * @see Posicao
     */
    public void escolhaDeCompra(String comprar, Jogador jogadorAtual, Posicao posicao) {
        if (comprar.equals("sim") || comprar.equals("s")) {

            if (jogadorAtual.getDinheiro() < posicao.getPreco()) {
                System.out.println("Você não tem dinheiro suficiente para essa compra.");
            } else {
                jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - posicao.getPreco());
                jogadorAtual.adicionandoPropriedade(posicao);

                System.out.println("Comprou esse domínio. Dinheiro do jogador: " + jogadorAtual.getDinheiro() + "\n");
                posicao.setCompravel(false);
            }

        } else {

            System.out.println("Você não comprou esta propriedade.");
        }
    }

    /**
     * checa se algum jogador ganhou a partida
     * @return jogador vencedor
     */
    public Jogador checandoGanhador() {
        ArrayList<Jogador> vencedor = new ArrayList<>();

        for (Jogador j : this.jogadores) {
            if (j.getDinheiro() > 0) {
                vencedor.add(j);
            }
        }

        if (vencedor.size() > 1) {
            return null;
        } else {
            return vencedor.get(0);
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
     * @param cor      Cor escolhida pelo jogador
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

        while (!boolJogadores) {

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

            while (!corJaEscolhida) {
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
     * @param escolha      string com a decisão do jogador
     * @param jogadorAtual jogador da rodada
     * @see Jogador
     */
    public void saindoDoJogo(String escolha, Jogador jogadorAtual) {

        if (escolha.equals("sim") || escolha.equals("s")) {

            jogadorAtual.saindo();
            this.jogadores.remove(jogadorAtual);
            System.out.println("Até mais " + jogadorAtual.getNome() + "!");

        } else {

            this.indiceDoJogador -= 1;

        }

    }

}