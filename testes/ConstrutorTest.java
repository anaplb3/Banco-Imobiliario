package testes;

import org.junit.Before;
import org.junit.Test;
import posicoes.Propriedade;
import tabuleiro.Construtor;
import tabuleiro.Jogador;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConstrutorTest {
    Construtor construtor;
    Jogador j1;
    Propriedade p1, p2, p3, p4;

    @Before
    public void setUp() throws Exception {
        j1 = new Jogador("ana", "amarelo");
        construtor = new Construtor(j1);
        p1 = new Propriedade("lugar nenhum", 0, 0);
        p2 = new Propriedade("lugar nenhum", 0, 0);
        p3 = new Propriedade("lugar nenhum", 0, 0);
        p4 = new Propriedade("lugar nenhum", 0, 0);

        p1.setCor("laranja");
        p1.setValorCasa(50);
        p2.setCor("laranja");

        j1.adicionandoPropriedade(p1);
        j1.adicionandoPropriedade(p2);

        p3.setCor("vermelho");
        p4.setCor("vermelho");
        j1.adicionandoPropriedade(p3);
        j1.adicionandoPropriedade(p4);
    }

    @Test
    public void propriedadesDisponiveis() {
        ArrayList<Propriedade> p = construtor.propriedadesDisponiveis();
        assertEquals(4, p.size());
    }

    @Test
    public void construcao() {
        construtor.construcao(1);
        assertEquals(1, p1.getQuantasCasasJaConstruidas());
        assertEquals(p1.getValorASerPago(), p1.getValor1Casa());
        assertEquals(1450, j1.getDinheiro(), 0);
    }

    @Test
    public void opcoes() {
        p1.setQuantasCasasJaConstruidas(5);
        p1.setValorHotel(500);
        construtor.opcoes();
    }

    @Test
    public void pegandoPropriedades() {
        ArrayList<Propriedade> props = construtor.pegandoPropriedades();
        assertEquals(4, props.size());
    }

    @Test
    public void venda() {
        p1.setValorCasa(60);
        construtor.construcao(1);
        construtor.venda(1);
        assertEquals(0, p1.getQuantasCasasJaConstruidas());
        assertEquals(1500, j1.getDinheiro(), 0);
    }

    @Test
    public void construcaoEhValida() {
        assertFalse(construtor.haCasasDisponiveis(2));
    }
}