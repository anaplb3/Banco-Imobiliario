package tabuleiro;

import java.util.ArrayList;

import posicoes.*;

/**
 * Esta classe é responsável por criar o tabuleiro
 */
public class Tabuleiro {
    private static Tabuleiro tab;
    private Propriedade prop;
    private Companhia comp;

    /**
     * Esse construtor inicia um objeto Propriedade  e Companhia para usar seus métodos
     * de criação de objetos
     *
     * @see Propriedade
     * @see Companhia
     */
    private Tabuleiro() {
        this.prop = new Propriedade();
        this.comp = new Companhia();
    }

    /**
     * instancia de forma estática um objeto Tabuleiro
     * @return uma instância do objeto Tabuleiro
     */
    public static Tabuleiro getInstance() {
        if (tab == null) {
            tab = new Tabuleiro();
        }

        return tab;
    }

    /**
     * Esse método adiciona os objetos componentes do tabuleiro no tabuleiro
     *
     * @return Retorna um array com todas as posições dentro da lista, formando
     * assim o tabuleiro
     */

    public ArrayList<Posicao> criandoTab() {
        ArrayList<Posicao> tab = new ArrayList<>();
        ArrayList<Propriedade> propriedades = prop.criandoPropriedades();
        ArrayList<Companhia> companhias = comp.criandoCompanhias();

        Prisao prisao = new Prisao();
        PosicaoInicial posicaoInicial = new PosicaoInicial();
        PrisaoVisitante prisaoVisitante = new PrisaoVisitante();
        SorteOuReves sorte = new SorteOuReves();
        Lucros lucros = new Lucros();
        Imposto imposto = new Imposto();
        ParadaLivre parada = new ParadaLivre();

        int contadorPropriedade = 0;
        int contadorCompanhia = 0;
        for (int i = 0; i < 40; i++) {

            if (i == 2 || i == 12 || i == 16 || i == 22 || i == 27 || i == 37) {
                tab.add(sorte);
            } else if (i == 10) {

                tab.add(prisao);

            } else if (i == 18) {

                tab.add(lucros);

            } else if (i == 24) {

                tab.add(imposto);

            } else if (i == 30) {

                tab.add(prisaoVisitante);

            } else if (i == 5 || i == 7 || i == 15 || i == 25 || i == 32 || i == 35) {
                tab.add(companhias.get(contadorCompanhia));
                contadorCompanhia += 1;


            } else if (i == 0) {
                tab.add(posicaoInicial);

            } else if (i == 20) {
                tab.add(parada);
            } else {
                tab.add(propriedades.get(contadorPropriedade));
                contadorPropriedade += 1;
            }

        }

        return tab;
    }

}