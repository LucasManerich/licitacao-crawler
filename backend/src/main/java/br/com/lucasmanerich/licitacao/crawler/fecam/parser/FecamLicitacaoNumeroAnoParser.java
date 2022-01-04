package br.com.lucasmanerich.licitacao.crawler.fecam.parser;

public class FecamLicitacaoNumeroAnoParser {
  
  private String[] extractPartesCompetenciaFromInput(String input) {
    String[] textos = input.split("-");
    String numeroAno = textos[1].replaceAll("[^0-9/]", "").trim(); // remove qualquer letra do texto extraído
    return numeroAno.split("/");
  }
  
  public String parseNumero(String input) {
    String[] parts = this.extractPartesCompetenciaFromInput(input);
    return parts[0];
  }

  public String parseAno(String input) {
    String[] parts = this.extractPartesCompetenciaFromInput(input);
    return parts[1];
  }
}
