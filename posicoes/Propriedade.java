package posicoes;

import java.util.ArrayList;

import command.PosicaoCommand;
import jogo.Jogo;
import properties.Manipulador;
import tabuleiro.Jogador;

/**
 * Essa classe representa uma propriedade do jogo, tendo os atributos
 * correspondentes
 */
public class Propriedade extends Posicao {
    private Manipulador mani;
    private String cor;
    private int valor1Casa;
    private int valor2Casa;
    private int valor3Casa;
    private int valor4Casa;
    private int valorHotel;
    private int valorHipoteca;
    private int valorCasa;
    private int quantasCasasJaConstruidas;

    public Propriedade() {
        this.nome = "";
        this.preco = 0;
        this.valorASerPago = 0;
        this.proprietario = null;
    }

    public Propriedade(String nome, int preco, int aluguel) {
        this.nome = nome;
        this.preco = preco;
        this.compravel = true;
        this.valorASerPago = aluguel;
        this.quantasCasasJaConstruidas = 0;
    }

    public int getQuantasCasasJaConstruidas() {
        return quantasCasasJaConstruidas;
    }

    public void setQuantasCasasJaConstruidas(int quantasCasasJaConstruidas) {
        this.quantasCasasJaConstruidas = quantasCasasJaConstruidas;
    }

    public int getValor1Casa() {
        return valor1Casa;
    }

    public void setValor1Casa(int valor1Casa) {
        this.valor1Casa = valor1Casa;
    }

    public int getValor2Casa() {
        return valor2Casa;
    }

    public void setValor2Casa(int valor2Casa) {
        this.valor2Casa = valor2Casa;
    }

    public int getValor3Casa() {
        return valor3Casa;
    }

    public void setValor3Casa(int valor3Casa) {
        this.valor3Casa = valor3Casa;
    }

    public int getValor4Casa() {
        return valor4Casa;
    }

    public void setValor4Casa(int valor4Casa) {
        this.valor4Casa = valor4Casa;
    }

    public int getValorHotel() {
        return valorHotel;
    }

    public void setValorHotel(int valorHotel) {
        this.valorHotel = valorHotel;
    }

    public int getValorHipoteca() {
        return valorHipoteca;
    }

    public void setValorHipoteca(int valorHipoteca) {
        this.valorHipoteca = valorHipoteca;
    }

    public int getValorCasa() {
        return valorCasa;
    }

    public void setValorCasa(int valorCasa) {
        this.valorCasa = valorCasa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Esse método cria os objetos Propriedades
     *
     * @return Retorna um array com as Propriedades do jogo
     * @see Propriedade
     */
    public ArrayList<Propriedade> criandoPropriedades() {
        mani = new Manipulador("properties/propriedades.properties");

        int tamanho = 0;
        try {
            tamanho = Integer.parseInt(mani.getTamanho());
        } catch (Exception e) {
            e.getMessage();
        }

        ArrayList<Propriedade> propriedades = new ArrayList<>();

        for (int i = 0; i < tamanho; i++) {
            Propriedade p = new Propriedade();

            try {
                mani.setandoAtributos(i);
            } catch (Exception e) {
                e.getMessage();
            }


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

            p.setNome(mani.getNome());
            p.setPreco(Integer.parseInt(mani.getPreco()));
            p.setValorASerPago(Integer.parseInt(mani.getAluguel()));
            p.setValor1Casa(mani.getValorCasa1());
            p.setValor2Casa(mani.getValorCasa2());
            p.setValor3Casa(mani.getValorCasa3());
            p.setValor4Casa(mani.getValorCasa4());
            p.setValorHipoteca(mani.getValorHipoteca());
            p.setValorHotel(mani.getValorHotel());
            p.setValorCasa(mani.getValorDaCasa());
            p.setCompravel(true);
            propriedades.add(p);
        }

        return propriedades;

    }


    /**
     * Este método retira o valor do aluguel do saldo do jogador e paga ao dono da propriedade
     *
     * @param jogadorAtual Jogador da rodada
     * @see Jogador
     */
    public void pagandoAluguel(Jogador jogadorAtual) {

        Jogador dono = this.getProprietario();
        System.out.println(dono.getNome());
        if (dono.equals(jogadorAtual)) {

            System.out.println("Esse domínio já é seu.");

        } else {
            dono.setDinheiro(dono.getDinheiro() + this.getValorASerPago());

            jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - this.getValorASerPago());
            System.out.println("Pagou R$" + this.getValorASerPago() + " de aluguel a " + dono.getNome() + ". Dinheiro do jogador: "
                    + jogadorAtual.getDinheiro() + "\n");
        }

    }

    /**
     * encapsula a chamada do método de pagamento de aluguel
     * @param j jogador da vez
     * @param dado1 resultado do dado 1
     * @param dado2 resultado do dado 2
     * @param jogo  classe do Jogo
     */
    @Override
    public void execute(Jogador j, int dado1, int dado2, Jogo jogo) {
        getNomeDaPosicao();
        pagandoAluguel(j);
    }

}
