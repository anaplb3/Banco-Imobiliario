package posicoes;

import jogo.Jogo;
import properties.Manipulador;
import tabuleiro.Jogador;

import java.util.ArrayList;

/**
 * Esta classe tem os atributos da posição Companhia
 */
public class Companhia extends Posicao{
    private Manipulador mani;

    /**
     * Construtor iniciando atributos vazios
     */
    public Companhia() {
        this.nome = "";
        this.preco = 0;
        this.compravel = true;
    }

    /**
     * Construtor iniciando atributos com valores
     *
     * @param nome          Nome da companhia
     * @param preco         Preço da companhia
     * @param valor Multiplicador de valor da companhia
     */
    public Companhia(String nome, int preco, int valor) {
        this.nome = nome;
        this.preco = preco;
        this.compravel = true;
        this.valorASerPago = valor;
        this.proprietario = null;
    }


    /**
     * Lê o arquivo .properties e seta as informações nos atributos do objeto
     *
     * @return um array com todas as companhias
     * @see Manipulador
     */
    public ArrayList<Companhia> criandoCompanhias() {
        ArrayList<Companhia> companhias = new ArrayList<>();
        mani = new Manipulador("properties/companhias.properties");

        int tamanho = 0;
        try {
            tamanho = Integer.parseInt(mani.getTamanho());
        } catch (Exception e) {
            e.getMessage();
        }

        for (int i = 0; i < tamanho; i++) {
            try {
                mani.setandoAtributos(i);
            } catch (Exception e) {
                e.getMessage();
            }

            String nome = mani.getNome();
            int preco = Integer.parseInt(mani.getPreco());
            int multiplicador = Integer.parseInt(mani.getAluguel());

            Companhia c = new Companhia(nome, preco, multiplicador);

            companhias.add(c);
        }

        return companhias;
    }

    /**
     * Este método retira o valor do multiplicador do saldo do jogador e paga ao dono da companhia
     *
     * @param jogadorAtual Jogador da rodada
     * @param dado1        Resultado do primeiro dado
     * @param dado2        Resultado do segundo dado
     * @see Jogador
     * @see Posicao
     */
    public void pagandoMultiplicador(Jogador jogadorAtual, int dado1, int dado2) {

        int multiplicadorASePagar = (dado1 + dado2) * this.getValorASerPago();

        Jogador dono = this.getProprietario();
        if (dono.equals(jogadorAtual)) {

            System.out.println("Esse dominío já é seu!");

        } else {
            dono.setDinheiro(dono.getDinheiro() + multiplicadorASePagar);

            jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - multiplicadorASePagar);
            System.out.println("Pagou R$" + multiplicadorASePagar + " de multiplicador a " + dono.getNome() + ". Dinheiro do jogador: "
                    + jogadorAtual.getDinheiro() + "\n");
        }


    }

    /**
     * método que faz a chamada do método de pagar o multiplicador
     * @param j jogador da vez
     * @param dado1 resultado do dado 1
     * @param dado2 resultado do dado 2
     * @param jogo  classe do Jogo
     */
    @Override
    public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
        System.out.println("Você está em "+this.nome);
        pagandoMultiplicador(j, dado1, dado2);
    }
}
