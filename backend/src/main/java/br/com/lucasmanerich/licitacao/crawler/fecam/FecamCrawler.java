package br.com.lucasmanerich.licitacao.crawler.fecam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.lucasmanerich.licitacao.crawler.Crawler;
import br.com.lucasmanerich.licitacao.crawler.fecam.parser.FecamDateParser;
import br.com.lucasmanerich.licitacao.crawler.fecam.parser.FecamLicitacaoNumeroAnoParser;
import br.com.lucasmanerich.licitacao.crawler.fecam.parser.FecamModalidadeParser;
import br.com.lucasmanerich.licitacao.entity.Licitacao;
import br.com.lucasmanerich.licitacao.enumeration.Modalidade;

public class FecamCrawler implements Crawler {
  private final String url;

  public FecamCrawler(String url) {
    this.url = url;
  }

  @Override
  public List<Licitacao> process() {
    List<Element> elements = this.extractElements();
    return this.getDataFromElements(elements);
  }

  private List<Element> extractElements() {
		try {
			return this.getDocument().select(".item-lista");
		} catch (IOException e) {
			e.printStackTrace();
      return new ArrayList<Element>();
		}
	}

  private Document getDocument() throws IOException {
		return Jsoup.connect(this.url).get();
	}

  private List<Licitacao> getDataFromElements(List<Element> elements) {
    List<Licitacao> listaLicitacoes = new ArrayList<Licitacao>();

    for (Element element : elements) {
      try {
        Licitacao licitacao = new Licitacao();
        licitacao.setNumero(this.makeNumeroLicitacao(element));
        licitacao.setAno(this.makeAnoLicitacao(element));
        licitacao.setModalidade(this.makeModalidade(element));
        licitacao.setDataAbertura(this.makeDataAbertura(element));
        licitacao.setObjeto(this.makeObjeto(element));
        
        listaLicitacoes.add(licitacao);
      } catch(Exception e) {
        e.printStackTrace();
      }
    }

    return listaLicitacoes;
  }

  private String makeNumeroLicitacao(Element element) {
    String tituloPagina = element.select(".nome-objeto > h3").text();
    FecamLicitacaoNumeroAnoParser numeroAnoParser = new FecamLicitacaoNumeroAnoParser();
    return numeroAnoParser.parseNumero(tituloPagina);
  }

  private String makeAnoLicitacao(Element element) {
    String tituloPagina = element.select(".nome-objeto > h3").text();
    FecamLicitacaoNumeroAnoParser numeroAnoParser = new FecamLicitacaoNumeroAnoParser();
    return numeroAnoParser.parseAno(tituloPagina);
  }

  private Modalidade makeModalidade(Element element) {
    String tituloPagina = element.select(".nome-objeto > h3").text();
    FecamModalidadeParser modalidadeParser = new FecamModalidadeParser();
    return modalidadeParser.parse(tituloPagina);
  }

  private Date makeDataAbertura(Element element) {
    final String dia = element.select(".data > .dia").get(0).text();
    final String mes = element.select(".data > .mes").get(0).text();
    final String ano = element.select(".data > .ano").get(0).text();
    
    final FecamDateParser dateParser = new FecamDateParser();
    return dateParser.parse(dia, mes, ano);
  }

  private String makeObjeto(Element element) {
    String textoObjeto = element.select(".nome-objeto > .objeto").text();
    return textoObjeto.replaceAll("Objeto: ", "");
  }
}
