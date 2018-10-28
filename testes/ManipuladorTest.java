package testes;

import org.junit.Before;
import org.junit.Test;
import properties.Manipulador;

import static org.junit.Assert.*;

public class ManipuladorTest {
    Manipulador mani;

    @Before
    public void setUp() throws Exception {
        mani = new Manipulador("testes/teste.properties");
    }

    @Test
    public void setandoAtributos() {
        try {
            mani.setandoAtributos(0);
        } catch(Exception e) {
            e.getMessage();
        }

        assertEquals("teste", mani.getNome());
        assertEquals(100, Integer.parseInt(mani.getPreco()));
        assertEquals(6, Integer.parseInt(mani.getAluguel()));
        assertEquals(30, mani.getValorCasa1());
        assertEquals(90, mani.getValorCasa2());
        assertEquals(270, mani.getValorCasa3());
        assertEquals(400, mani.getValorCasa4());
        assertEquals(500, mani.getValorHotel());
        assertEquals(50, mani.getValorHipoteca());
        assertEquals(50, mani.getValorDaCasa());

    }
}