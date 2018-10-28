package tabuleiro;

import java.util.ArrayList;

import posicoes.Companhia;
import posicoes.Posicao;
import posicoes.Propriedade;

/**
 * Esta classe tem os atributos de cada jogador
 */
public class Jogador {
    private String nome;
    private String cor;
    private int posicao;
    private double dinheiro;
    private ArrayList<Posicao> propriedades;
    private boolean prisioneiro;
    private boolean prisioneiroVisitante;
    private int dadosIguais;
    private boolean cartaoLiberdade;


    /**
     * Esse construtor está setando as informações do jogador
     *
     * @param nome Nome do jogador
     * @param cor  Cor do jogador
     */
    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.posicao = 0;
        this.dinheiro = 1500;
        this.propriedades = new ArrayList<>();
        this.prisioneiroVisitante = false;
    }

    /**
     * Esse método está adicionando o dominío no Array de propriedades do jogador
     *
     * @param p É a posição (Propriedade ou Companhia) que o jogador adquiriu
     */
    public void adicionandoPropriedade(Posicao p) {
        this.propriedades.add(p);
        p.setProprietario(this);
    }

    public boolean isPrisioneiroVisitante() {
        return prisioneiroVisitante;
    }

    public void setPrisioneiroVisitante(boolean prisioneiroVisitante) {
        this.prisioneiroVisitante = prisioneiroVisitante;
    }

    public boolean isCartaoLiberdade() {
        return cartaoLiberdade;
    }

    public void setCartaoLiberdade(boolean cartaoLiberdade) {
        this.cartaoLiberdade = cartaoLiberdade;
    }

    public boolean isPrisioneiro() {
        return prisioneiro;
    }

    public void setPrisioneiro(boolean prisioneiro) {
        this.prisioneiro = prisioneiro;
    }

    public int getDadosIguais() {
        return dadosIguais;
    }

    public void setDadosIguais(int dadosIguais) {
        this.dadosIguais = dadosIguais;
    }

    public ArrayList<Posicao> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(ArrayList<Posicao> propriedades) {
        this.propriedades = propriedades;
    }

    public void setDinheiro(double money) {
        this.dinheiro = money;
    }

    public double getDinheiro() {
        return this.dinheiro;
    }

    public int getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int p) {
        this.posicao = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    /**
     * Esse método mostra os atributos do jogador
     *
     * @param lugar posição que o jogador se encontra atualmente
     */
    public void status(Posicao lugar) {

        System.out.println(this.nome + " - " + this.cor);

        System.out.println("Você está na casa " + this.posicao + ", em " + lugar.getNome());

        System.out.println("Você possui R$" + this.dinheiro);


        if (this.propriedades.size() > 0) {
            System.out.println("Essas são suas propriedades: ");
            for (Posicao prop : this.propriedades) {
                if (prop instanceof Propriedade) {
                    Propriedade p = (Propriedade) prop;
                    System.out.println(p.getNome() + ", da cor " + p.getCor() + " com aluguel de R$" + p.getValorASerPago());
                } else {
                    Companhia c = (Companhia) prop;
                    System.out.println(c.getNome() + ", com multiplicador de " + c.getValorASerPago());
                }

            }
            System.out.println("\n");

        } else {
            System.out.println("Você ainda não tem propriedades!\n");
        }

    }

    /**
     * Deixa os domínios do jogador disponível novamente
     */
    public void saindo() {

        for (Posicao p : this.propriedades) {

            p.setCompravel(false);

        }

    }

}
