package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BaralhoTest.class, CompanhiaTest.class, ImpostoTest.class, JogadorTest.class, JogoTest.class,
		LucrosTest.class, PrisaoTest.class, PropriedadeTest.class, SorteOuRevesTest.class, ConstrutorTest.class })
public class AllTests {

}
