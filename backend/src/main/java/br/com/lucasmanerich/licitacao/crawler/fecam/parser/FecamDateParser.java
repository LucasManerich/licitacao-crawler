package br.com.lucasmanerich.licitacao.crawler.fecam.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FecamDateParser {

  public Date parse(String dia, String mes, String ano) {
    final String parsedMes = this.parseMes(mes);
    try {
      return new SimpleDateFormat("dd/MM/yyyy").parse(dia + "/" + parsedMes + "/" + ano);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  private String parseMes(String input) {
    switch(input.toLowerCase().trim()) {
      case "jan":
        return "01";
      case "fev":
        return "02";
      case "mar":
        return "03";
      case "abr":
        return "04";
      case "mai":
        return "05";
      case "jun":
        return "06";
      case "jul":
        return "07";
      case "ago":
        return "08";
      case "set":
        return "09";
      case "out":
        return "10";
      case "nov":
        return "11";
      case "dez":
        return "12";
      default:
        return "";
    }
  }
}
