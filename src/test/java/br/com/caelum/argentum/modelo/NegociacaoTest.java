package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test
	  public void dataDaNegociacaoEhImutavel() {
	    // se criar um negocio no dia 15...
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH, 15);
	    Negociacao n = new Negociacao(10, 5, c);
	    

	    // ainda que eu tente mudar a data para 20...
	    n.getData().set(Calendar.DAY_OF_MONTH, 20);
	    
	    // ele continua no dia 15.
	    Assert.assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	  }
	
	@Test
	public void mesmoMilissegundoEhDoMesmoDia() {
	  Calendar agora = Calendar.getInstance();
	  Calendar mesmoMomento = (Calendar) agora.clone();

	  Negociacao negociacao = new Negociacao(40.0, 100, agora);
	  assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
    @Test
    public void mesmoDiaComMesesDiferentesNaoEhMesmoDia() {
            Calendar dia1Jan = new GregorianCalendar(2013, 1, 1, 8, 30);
            Calendar dia1Nov = new GregorianCalendar(2013, 11, 1, 15, 00);

            Negociacao negociacao = new Negociacao(50, 100, dia1Jan);
            assertFalse(negociacao.mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(dia1Nov));
    }
	
	
	@Test
	public void comHorariosDiferentesEhNoMesmoDia() {
	  // usando GregorianCalendar(ano, mes, dia, hora, minuto)
	  Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
	  Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

	  Negociacao negociacao = new Negociacao(40.0, 100, manha);
	  Assert.assertTrue(negociacao.isMesmoDia(tarde));
	}
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
	  new Negociacao(10, 5, null);
	}
}
