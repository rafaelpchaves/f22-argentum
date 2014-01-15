package br.com.caelum.argentum.reader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

    @Test
    public void carregaXmlComNegociacaoPrecoZeroEmListaUnitaria() {
            String xmlDeTeste = "<list><negociacao><quantidade>1000</quantidade>"
                            + "<data><time>1322233344455</time></data></negociacao></list>";

            LeitorXML leitor = new LeitorXML();

            InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

            List<Negociacao> negociacoes = leitor.carrega(xml);

           assertEquals(1, negociacoes.size());
           assertEquals(0.0, negociacoes.get(0).getPreco(),0.00001);
    }
	

}
