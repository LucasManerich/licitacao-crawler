package br.com.lucasmanerich.licitacao.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.lucasmanerich.licitacao.enumeration.Modalidade;

public class Licitacao {
  private String numero;
  private String ano;
  private Modalidade modalidade;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataAbertura;
  private String objeto;

  public String getNumero() {
    return numero;
  }
  
  public void setNumero(String numero) {
    this.numero = numero;
  }
  
  public String getAno() {
    return ano;
  }
  
  public void setAno(String ano) {
    this.ano = ano;
  }
  
  public Modalidade getModalidade() {
    return modalidade;
  }
  
  public void setModalidade(Modalidade modalidade) {
    this.modalidade = modalidade;
  }
  
  public Date getDataAbertura() {
    return dataAbertura;
  }

  public void setDataAbertura(Date dataAbertura) {
    this.dataAbertura = dataAbertura;
  }

  public String getObjeto() {
    return objeto;
  }

  public void setObjeto(String objeto) {
    this.objeto = objeto;
  }
}
