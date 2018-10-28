package testes;

import org.junit.Before;
import org.junit.Test;
import posicoes.Posicao;
import posicoes.Propriedade;
import tabuleiro.Tabuleiro;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TabuleiroTest {
    Tabuleiro tab;

    @Before
    public void setUp() throws Exception {
        tab = tab.getInstance();
    }

    @Test
    public void criandoTab() {
        ArrayList<Posicao> posicoes = tab.criandoTab();
        for(int i = 1; i < posicoes.size(); i++) {
            Posicao p = posicoes.get(i);
            System.out.println(p.getNome());
            assertNotNull(p);
        }
        assertEquals(40, posicoes.size());
    }
}