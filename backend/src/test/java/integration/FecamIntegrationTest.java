package integration;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lucasmanerich.licitacao.LicitacaoApplication;
import br.com.lucasmanerich.licitacao.crawler.ListaEntidades;
import br.com.lucasmanerich.licitacao.crawler.fecam.FecamCrawler;
import br.com.lucasmanerich.licitacao.entity.Licitacao;

@SpringBootTest(classes = LicitacaoApplication.class)
public class FecamIntegrationTest {
  
  private FecamCrawler getSystemUnderTest() {
    return new FecamCrawler(ListaEntidades.bombinhas().getUrl());
  }

  @Test
  void test() {
    FecamCrawler sut = this.getSystemUnderTest();

    List<Licitacao> licitacoes = sut.process();
    
    assertTrue(licitacoes.size() > 0);
    assertNotNull(licitacoes.get(0));
    assertNotNull(licitacoes.get(0).getDataAbertura());
    assertNotNull(licitacoes.get(0).getAno());
    assertNotNull(licitacoes.get(0).getNumero());
    assertNotNull(licitacoes.get(0).getObjeto());
    assertNotNull(licitacoes.get(0).getModalidade());
  }
}
