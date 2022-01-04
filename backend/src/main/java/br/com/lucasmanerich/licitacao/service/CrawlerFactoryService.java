package br.com.lucasmanerich.licitacao.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucasmanerich.licitacao.crawler.Crawler;
import br.com.lucasmanerich.licitacao.crawler.ListaEntidades;
import br.com.lucasmanerich.licitacao.entity.Entidade;
import br.com.lucasmanerich.licitacao.entity.Licitacao;

@Service
public class CrawlerFactoryService {
  
  public List<Licitacao> crawl(int idEntidade) throws Exception {
    Entidade<?> entidade = ListaEntidades.find(idEntidade);

    try {
      Class<?> clazz = Class.forName(entidade.getClassName());
      Crawler instance = (Crawler) clazz.getDeclaredConstructor(String.class).newInstance(entidade.getUrl());
      return instance.process();
    } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
      e.printStackTrace();
      throw new Exception("Ocorreu um erro ao buscar as informações na entidade");
    }
  }
}
