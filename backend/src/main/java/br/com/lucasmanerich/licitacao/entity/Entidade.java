package br.com.lucasmanerich.licitacao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.lucasmanerich.licitacao.crawler.Crawler;

public class Entidade<T extends Crawler> {
  private final int id;
  private final String nome;
  private final String url;

  @JsonIgnore
  private final String className;

  public Entidade(int id, String nome, String url, String className) {
    this.id = id;
    this.nome = nome;
    this.url = url;
    this.className = className;
  }

  public int getId() {
    return id;
  }
  
  public String getNome() {
    return nome;
  }
  
  public String getUrl() {
    return url;
  }
  
  public String getClassName() {
    return className;
  }
}
