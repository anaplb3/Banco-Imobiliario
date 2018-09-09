package posicoes;

import java.util.ArrayList;

import tabuleiro.Jogador;

/**
 * Essa classe representa uma propriedade do jogo, tendo os atributos
 * correspondentes
 */
public class Propriedade extends Posicao {
	private String nome;
	private int preco;
	private boolean status;
	private int aluguel;
	private String cor;
	private Jogador proprietario;

	public Propriedade() {
		this.nome = "";
		this.preco = 0;
		this.aluguel = 0;
		this.proprietario = null;
	}

	public Propriedade(String nome, int preco, int aluguel) {
		this.nome = nome;
		this.preco = preco;
		this.status = true;
		this.aluguel = aluguel;
	}

	public void getNomeDaPosicao() {
		System.out.println("Você está em " + this.nome);
	}
	
	public Jogador getProprietario() {
		return this.proprietario;
	}

	public void setProprietario(Jogador j) {
		this.proprietario = j;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAluguel() {
		return aluguel;
	}

	public void setAluguel(int aluguel) {
		this.aluguel = aluguel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Esse método cria os objetos Propriedades
	 * 
	 * @return Retorna um array com as Propriedades do jogo
	 * @see Propriedade
	 */
	public ArrayList<Propriedade> criandoPropriedades() {
		ArrayList<String> nomes = nomesDasPropriedades();
		ArrayList<Integer> precos = precoDasPropriedades();
		ArrayList<Integer> aluguel = alugueis();
		ArrayList<Propriedade> propriedades = new ArrayList<>();

		for (int i = 0; i < nomes.size(); i++) {
			Propriedade p = new Propriedade();

			if (i == 0 || i == 1 || i == 2) {
				p.setCor("rosa");
			} else if (i == 3 || i == 4 || i == 5) {
				p.setCor("azul");
			} else if (i == 6 || i == 7 || i == 8) {
				p.setCor("roxo");
			} else if (i == 9 || i == 10) {
				p.setCor("laranja");
			} else if (i == 11 || i == 12) {
				p.setCor("vermelho");
			} else if (i == 13 || i == 14 || i == 15) {
				p.setCor("amarelo");
			} else if (i == 16 || i == 17 || i == 18 || i == 19) {
				p.setCor("verde");
			} else if (i == 20 || i == 21) {
				p.setCor("azul escuro");
			}

			p.setNome(nomes.get(i));
			p.setPreco(precos.get(i));
			p.setAluguel(aluguel.get(i));
			p.setStatus(true);
			propriedades.add(p);
		}

		return propriedades;

	}

	/**
	 * Esse método está adicionando os aluguéis as propriedades
	 * 
	 * @return Retorna um array com os alugueis das propriedades
	 */
	public ArrayList<Integer> alugueis() {
		ArrayList<Integer> aluguel = new ArrayList<>();

		aluguel.add(6);
		aluguel.add(2);
		aluguel.add(2);
		aluguel.add(20);
		aluguel.add(18);
		aluguel.add(18);
		aluguel.add(16);
		aluguel.add(14);
		aluguel.add(14);
		aluguel.add(35);
		aluguel.add(50);
		aluguel.add(8);
		aluguel.add(6);
		aluguel.add(12);
		aluguel.add(10);
		aluguel.add(12);
		aluguel.add(22);
		aluguel.add(28);
		aluguel.add(26);
		aluguel.add(26);
		aluguel.add(24);
		aluguel.add(22);

		return aluguel;

	}

	/**
	 * Esse método está adicionando os nomes das propriedades a um array
	 * 
	 * @return Retorna um array com os nomes das propriedades
	 */
	public ArrayList<String> nomesDasPropriedades() {
		ArrayList<String> nomes = new ArrayList<>();

		nomes.add("Leblon");
		nomes.add("Av. Presidente Vargas");
		nomes.add("Av. Nossa Senhora De Copacabana");

		nomes.add("Av. Brigadeiro Faria Lima");
		nomes.add("Av. Rebouças");
		nomes.add("Av. 9 de Julho");

		nomes.add("Av. Europa");
		nomes.add("Rua Augusta");
		nomes.add("Av. Pacaembu");

		nomes.add("Interlagos");
		nomes.add("Morumbi");

		nomes.add("Flamengo");
		nomes.add("Botafogo");

		nomes.add("Av. Brasil");
		nomes.add("Av. Paulista");
		nomes.add("Jardim Europa");

		nomes.add("Copacabana");
		nomes.add("Av. Vieira Souto");
		nomes.add("Av. Atlântica");
		nomes.add("Ipanema");

		nomes.add("Jardim Paulista");
		nomes.add("Brooklin");

		return nomes;
	}

	/**
	 * Esse método está adiconando os preços das propriedades a um array
	 * 
	 * @return Retorna um array com os preços das propriedades
	 */
	public ArrayList<Integer> precoDasPropriedades() {
		ArrayList<Integer> precos = new ArrayList<>();

		precos.add(100);
		precos.add(60);
		precos.add(60);

		precos.add(240);

		precos.add(220);
		precos.add(220);
		precos.add(200);
		precos.add(180);
		precos.add(180);

		precos.add(350);
		precos.add(400);
		precos.add(120);
		precos.add(100);

		precos.add(160);
		precos.add(140);
		precos.add(140);
		precos.add(260);

		precos.add(320);
		precos.add(300);

		precos.add(300);
		precos.add(280);
		precos.add(260);

		return precos;
	}
	
	
	
	/**
	 * Este método retira o valor do aluguel do saldo do jogador
	 * 
	 * @param jogadorAtual
	 *            Jogador da rodada
	 * @param posicao
	 *            Propriedade que ele se encontra
	 * @param dado1
	 *            Resultado do primeiro dado
	 * @param dado2
	 *            Resultado do segundo dado
	 * @see Jogador
	 * @see Posicao
	 */
	public void pagandoAluguelOuMultiplicador(Jogador jogadorAtual, Posicao posicao, int dado1, int dado2) {
		
		Jogador dono = posicao.getProprietario();
		dono.setDinheiro(dono.getDinheiro() + posicao.getAluguel());
		
		jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - posicao.getAluguel());
		System.out.println("Pagou R$" + posicao.getAluguel() + " de aluguel a "+dono.getNome()+". Dinheiro do jogador: "
				+ jogadorAtual.getDinheiro() + "\n");
		
	}

}
