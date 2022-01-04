package br.com.lucasmanerich.licitacao.crawler;

import java.util.List;

import br.com.lucasmanerich.licitacao.entity.Licitacao;

public interface Crawler {
  public List<Licitacao> process();
}
