package br.com.lucasmanerich.licitacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasmanerich.licitacao.entity.Licitacao;
import br.com.lucasmanerich.licitacao.service.CrawlerFactoryService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/licitacao")
public class CrawlerController {
  
  @Autowired
  private CrawlerFactoryService crawlerFactoryService;

  @GetMapping("/{entidade}")
  public List<Licitacao> buscaDados(@PathVariable("entidade") String idEntidade) throws NumberFormatException, Exception {
    return this.crawlerFactoryService.crawl(Integer.parseInt(idEntidade));
  }
}
