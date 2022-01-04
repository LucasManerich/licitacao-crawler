package br.com.lucasmanerich.licitacao.crawler.fecam.parser;

import br.com.lucasmanerich.licitacao.enumeration.Modalidade;

public class FecamModalidadeParser {
  
  public Modalidade parse(String input) {
    String[] textos = input.split("-");
    return this.parseModalidadeFromRawName(textos[0]);
  }

  private Modalidade parseModalidadeFromRawName(String modalidadeRaw) {
    switch(modalidadeRaw.toLowerCase().trim()) {
      case "pregão":
        return Modalidade.PREGAO;
      case "Chamada Pública":
        return Modalidade.PREGAO;
      case "chamamento público":
        return Modalidade.CHAMAMENTO_PUBLICO;
      case "concorrência pública":
        return Modalidade.CONCORRENCIA_PUBLICA;
      case "concurso":
        return Modalidade.CONCURSO;
      case "convite":
        return Modalidade.CONVITE;
      case "credenciamento":
        return Modalidade.CREDENCIAMENTO;
      case "dispensa":
        return Modalidade.DISPENSA;
      case "inexigibilidade":
        return Modalidade.INEXIGIBILIDADE;
      case "leilão":
        return Modalidade.LEILAO;
      case "rdc":
        return Modalidade.RDC;
      case "tomada de preços":
        return Modalidade.TOMADA_DE_PRECOS;
      default:
        return null;
    }
  }
}
