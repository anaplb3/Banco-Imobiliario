package cartas;

import java.util.ArrayList;


/**
 * Classe que dá forma as cartas de sorte ou revés do jogo.
 */
public class Carta {
	
	private String descricao;
	private int valor;
	private String tipo;
	
	public Carta() {
		this.descricao = "";
		this.valor = 0;
		this.tipo = "";
	}

	public String tipo() {
		return this.tipo;
	}
	
	/**
	 * Coloca as descrições das cartas de sorte ou revés dentro de um array
	 * @return Retorna um array com todas as descrições das cartas
	 */
	public ArrayList<String> descricoesDasCartas(){
		ArrayList<String> descricoes  = new ArrayList<>();
		
		descricoes.add("Sua empresa foi multada por poluir demais. Pague 200");
		descricoes.add("O dia do seu casamento chegou, receba os presente. Receba 50 de cada jogador");
		descricoes.add("Reformou sua casa. Pague 50");
		descricoes.add("Seu livro será publicado por uma grande editora. Receba 50");
		descricoes.add("Utilize este cartão para se livrar da prosão");
		descricoes.add("Vá para prisão");
		descricoes.add("Vá até o início. Receba 200");
		descricoes.add("Suas ações na bolsa de valores estão em alta. Receba 100");
		descricoes.add("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista. Pague 20");
		descricoes.add("Férias com a família. Pague 20");
		descricoes.add("Recebeu o prêmio de profissional do ano e ganhou um carro. Receba 10");
		descricoes.add("Jogue os dados novamente");
		descricoes.add("Sua empresa irá patrocinar uma expedição a Antártida. Pague 50");
		descricoes.add("Vendeu a parte de sua empresa para um investidor. Receba 75");
		descricoes.add("Apostou no cavalo azarão e ganhou. Receba 100");
		descricoes.add("A falta de chuva prejudicou a colheita. Pague 45");
		descricoes.add("Recebeu uma herança inesperada. Receba 75");
		descricoes.add("Seu filho decidiu fazer intercâmbio. Pague 20");
		descricoes.add("Sua casa será desapropriada para a construção de um metrô e ganhará uma gorda indenização. Receba 60");
		descricoes.add("Venceu licitação para grande obra. Receba 150");
		descricoes.add("Seu iate afundou, mas você tinha seguro! Receba 25");
		descricoes.add("Seus funcionários entraram em greve. Pague 30");
		descricoes.add("Comprou obra de arte falsificada. Pague 22");
		descricoes.add("Sorte se tirou o número par da soma dos dados e revés caso contrário. Pague 100 ou Receba 100");
		descricoes.add("Seu jatinho precisa de manutenção. Pague 9");
		descricoes.add("Renovou a frota de carros da sua empresa. Pague 100");
		descricoes.add("Ganhou sozinho na loteria. Receba 80");
		descricoes.add("Atualizou os computadores da sua empresa. Pague 30");
		descricoes.add("Um navio afundou com suas mercadorias(não tinha seguro). Pague 40");
		descricoes.add("Produção de leite de suas fazendas ficou abaixo da expectativa. Pague 60");
		descricoes.add("Tirou primeiro lugar no torneio de golfe. Receba 100");
		
		return descricoes;
	}
	
	/**
	 *  Coloca todos os valores das cartas de sorte e revés dentro de um array
	 *  @return Retorna um array com todos os valores
	 */
	public ArrayList<Integer> valoresDasCartas(){
		
		ArrayList<Integer> valores = new ArrayList<>();
		
		valores.add(200);
		valores.add(0);
		valores.add(50);
		valores.add(50);
		valores.add(0);
		valores.add(0);
		valores.add(200);
		valores.add(100);
		valores.add(20);
		valores.add(20);
		valores.add(10);
		valores.add(0);
		valores.add(50);
		valores.add(75);
		valores.add(100);
		valores.add(45);
		valores.add(75);
		valores.add(20);
		valores.add(60);
		valores.add(150);
		valores.add(25);
		valores.add(30);
		valores.add(22);
		valores.add(100);
		valores.add(9);
		valores.add(100);
		valores.add(80);
		valores.add(30);
		valores.add(40);
		valores.add(60);
		valores.add(100);
		
		return valores;
		
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getValor() {
		return this.valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
