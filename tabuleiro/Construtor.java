package tabuleiro;

import posicoes.Posicao;
import posicoes.Propriedade;

import java.util.ArrayList;

/**
 * Classe que é responsável por construir e vender as casas na propriedade
 */
public class Construtor {
    private Jogador jogador;
    private final int COR_ROSA = 3;
    private final int COR_AZUL = 3;
    private final int COR_ROXO = 3;
    private final int COR_LARANJA = 2;
    private final int COR_VERMELHO = 2;
    private final int COR_AMARELO = 3;
    private final int COR_VERDE = 4;
    private final int COR_AZUL_ESCURO = 2;

    /**
     * Inicializa o jogador que quer construir as casas
     *
     * @param j Jogador que vai construir casas nas propriedades
     */
    public Construtor(Jogador j) {
        this.jogador = j;
    }

    /**
     * Checa se o jogador tem dinheiro suficiente para comprar a casa
     *
     * @param p Propriedade a ser checada
     * @return um booleano informando se o jogador tem dinheiro suficiente
     * @see Propriedade
     */
    private boolean temDinheiro(Propriedade p) {

        return jogador.getDinheiro() > p.getValorCasa();

    }

    /**
     * Separa as propriedades do jogador em um array
     *
     * @return as propriedades do jogador
     * @see Propriedade
     */
    public ArrayList<Propriedade> pegandoPropriedades() {
        ArrayList<Posicao> posicoes = jogador.getPropriedades();
        ArrayList<Propriedade> propriedades = new ArrayList<>();

        for (Posicao prop : posicoes) {

            if (prop instanceof Propriedade) {
                propriedades.add((Propriedade) prop);
            }

        }

        return propriedades;
    }

    /**
     * Verifica em quais propriedades pode-se contruir casas
     *
     * @return as propriedades em que pode haver construção de casas
     * @see Propriedade
     */
    public ArrayList<Propriedade> propriedadesDisponiveis() {
        ArrayList<Propriedade> propriedades = pegandoPropriedades();
        ArrayList<Propriedade> rosa = new ArrayList<>();
        ArrayList<Propriedade> azul = new ArrayList<>();
        ArrayList<Propriedade> roxo = new ArrayList<>();
        ArrayList<Propriedade> laranja = new ArrayList<>();
        ArrayList<Propriedade> vermelho = new ArrayList<>();
        ArrayList<Propriedade> amarelo = new ArrayList<>();
        ArrayList<Propriedade> verde = new ArrayList<>();
        ArrayList<Propriedade> azul_escuro = new ArrayList<>();
        ArrayList<Propriedade> propriedadesDisponiveis = new ArrayList<>();

        for (Propriedade p : propriedades) {
            String color = p.getCor();

            switch (color) {
                case "rosa":
                    rosa.add(p);
                    propriedadesDisponiveis = checandoTamanho(rosa, COR_ROSA, propriedadesDisponiveis);
                    break;
                case "azul":
                    azul.add(p);
                    propriedadesDisponiveis = checandoTamanho(azul, COR_AZUL, propriedadesDisponiveis);
                    break;
                case "roxo":
                    roxo.add(p);
                    propriedadesDisponiveis = checandoTamanho(roxo, COR_ROXO, propriedadesDisponiveis);
                    break;
                case "laranja":
                    laranja.add(p);
                    propriedadesDisponiveis = checandoTamanho(laranja, COR_LARANJA, propriedadesDisponiveis);
                    break;
                case "vermelho":
                    vermelho.add(p);
                    propriedadesDisponiveis = checandoTamanho(vermelho, COR_VERMELHO, propriedadesDisponiveis);
                    break;
                case "amarelo":
                    amarelo.add(p);
                    propriedadesDisponiveis = checandoTamanho(amarelo, COR_AMARELO, propriedadesDisponiveis);
                    break;
                case "verde":
                    verde.add(p);
                    propriedadesDisponiveis = checandoTamanho(verde, COR_VERDE, propriedadesDisponiveis);
                    break;
                default:
                    azul_escuro.add(p);
                    propriedadesDisponiveis = checandoTamanho(azul_escuro, COR_AZUL_ESCURO, propriedadesDisponiveis);
            }
        }

        return propriedadesDisponiveis;

    }

    /**
     * Checa se o jogador já construiu o número máximo de casas
     *
     * @param p Propriedade que será checada
     * @return um booleano que informa se ainda pode haver construção de casas
     */
    private boolean aindaPodeConstruir(Propriedade p) {

        return p.getValorASerPago() != p.getValorHotel();
    }

    /**
     * Checa se o tamanho do array da cor é igual ao total de propriedades daquela cor.
     *
     * @param p                   Array com propriedades de determinada cor
     * @param totalCorPropriedade total de propriedades daquela cor
     * @param propriedades        array que vai receber as propriedades que pode construir
     * @return array com as propriedades em que pode haver construção
     */
    public ArrayList<Propriedade> checandoTamanho(ArrayList<Propriedade> p, int totalCorPropriedade, ArrayList<Propriedade> propriedades) {
        if (totalCorPropriedade == p.size()) {
            propriedades.addAll(p);
        }
        return propriedades;
    }

    /**
     * Constroi casas na propriedade escolhida
     *
     * @param index indice da propriedade em que o jogador que construir
     * @throws IndexOutOfBoundsException
     * @see Propriedade
     */
    public void construcao(int index) throws IndexOutOfBoundsException {
        ArrayList<Propriedade> props = propriedadesDisponiveis();
        Propriedade p = props.get(index - 1);

        if (temDinheiro(p) && !aindaPodeConstruir(p)) {
            if (p.getQuantasCasasJaConstruidas() == 0) {
                p.setValorASerPago(p.getValor1Casa());

            } else if (p.getQuantasCasasJaConstruidas() == 1) {
                p.setValorASerPago(p.getValor2Casa());

            } else if (p.getQuantasCasasJaConstruidas() == 2) {
                p.setValorASerPago(p.getValor3Casa());

            } else if (p.getQuantasCasasJaConstruidas() == 3) {
                p.setValorASerPago(p.getValor4Casa());

            } else {
                p.setValorASerPago(p.getValorHotel());

            }
            p.setQuantasCasasJaConstruidas(p.getQuantasCasasJaConstruidas() + 1);
            jogador.setDinheiro(jogador.getDinheiro() - p.getValorCasa());

        }

    }

    /**
     * Vende uma casa da propriedade escolhida pelo jogador
     *
     * @param index indice que identifica a propriedade no array
     * @throws IndexOutOfBoundsException
     */
    public void venda(int index) throws IndexOutOfBoundsException {
        ArrayList<Propriedade> props = propriedadesDisponiveis();
        Propriedade p = props.get(index - 1);

        switch (p.getQuantasCasasJaConstruidas()) {
            case (1):
                p.setValorASerPago(p.getValorASerPago());
                break;
            case (2):
                p.setValorASerPago(p.getValor1Casa());
                break;
            case (3):
                p.setValorASerPago(p.getValor2Casa());
                break;
            case (4):
                p.setValorASerPago(p.getValor3Casa());
                break;
            case (5):
                p.setValorASerPago(p.getValor4Casa());
                break;

        }
        p.setQuantasCasasJaConstruidas(p.getQuantasCasasJaConstruidas() - 1);
        double novoSaldo = jogador.getDinheiro() + p.getValorCasa();
        jogador.setDinheiro(novoSaldo);
    }


    /**
     * Checa se há propriedades disponíveis para construção
     *
     * @return um booleano que informa se há propriedades para construção
     */
    public boolean haPropriedades() {
        ArrayList<Propriedade> props = propriedadesDisponiveis();

        if (props.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * Mostra as opções de propriedades para se construir
     */
    public void opcoes() {
        ArrayList<Propriedade> props = propriedadesDisponiveis();

        for (int i = 0; i < props.size(); i++) {
            Propriedade p = props.get(i);
            String dominio = "casa";
            int preco = p.getValorCasa();

            if (p.getQuantasCasasJaConstruidas() == 5) {
                dominio = "hotel";
                preco = p.getValorHotel();
            }

            System.out.println(i + 1 + "- " + p.getNome() + " tem " + p.getQuantasCasasJaConstruidas() + " casas construídas, " + dominio + " custa R$" + preco);
        }


    }

    /**
     * Checa se na propriedade há casas disponíveis para a venda
     * @param index indice da propriedade no array
     * @return true caso seja possível ou false caso não
     */
    public boolean haCasasDisponiveis(int index) {
        ArrayList<Propriedade> props = propriedadesDisponiveis();
        Propriedade p;

        try {
             p = props.get(index - 1);
        } catch(Exception e) {
            return false;
        }


        if (p.getQuantasCasasJaConstruidas() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
