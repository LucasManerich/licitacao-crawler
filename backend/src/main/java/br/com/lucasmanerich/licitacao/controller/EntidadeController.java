package br.com.lucasmanerich.licitacao.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasmanerich.licitacao.crawler.ListaEntidades;
import br.com.lucasmanerich.licitacao.entity.Entidade;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/entidade")
public class EntidadeController {
  
  @GetMapping
  public Entidade<?>[] getLista() {
    return ListaEntidades.asArray();
  }
}
