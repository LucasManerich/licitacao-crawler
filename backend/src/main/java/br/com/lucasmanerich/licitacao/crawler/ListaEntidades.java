package br.com.lucasmanerich.licitacao.crawler;

import java.util.NoSuchElementException;

import br.com.lucasmanerich.licitacao.crawler.fecam.FecamCrawler;
import br.com.lucasmanerich.licitacao.entity.Entidade;

public class ListaEntidades {
  
  public static Entidade<?> bombinhas() {
    return new Entidade<FecamCrawler>(
      1,
      "Prefeitura Municipal de Bombinhas", 
      "https://www.bombinhas.sc.gov.br/licitacoes/listar", 
      FecamCrawler.class.getName()
    );
  }

  public static Entidade<?> tubarao() {
    return new Entidade<FecamCrawler>(
      2,
      "Prefeitura Municipal de Tubarão", 
      "https://www.tubarao.sc.gov.br/licitacoes/listar", 
      FecamCrawler.class.getName()
    );
  }

  public static Entidade<?> alfredoWagner() {
    return new Entidade<FecamCrawler>(
      3,
      "Prefeitura Municipal de Alfredo Wagner", 
      "https://www.alfredowagner.sc.gov.br/licitacoes/listar", 
      FecamCrawler.class.getName()
    );
  }

  public static Entidade<?>[] asArray() {
    return new Entidade[]{
      bombinhas(),
      tubarao(),
      alfredoWagner(),
    };
  }

  public static Entidade<?> find(int id) {
    for (Entidade<?> element : asArray()) {
      if (element.getId() == id) {
        return element;
      }
    }
    throw new NoSuchElementException();
  }
}
