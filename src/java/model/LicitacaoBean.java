/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author usuario
 */
public class LicitacaoBean {
    //Dominio e Subdom sao outro Bean?
    private String id;
    private String dominio;
    private String subdominio;
    private String mes;
    private String ano;
    private String cidade;
    private String natureza;
    private String fonte;
    private String tipoLicitacao;


    public LicitacaoBean() {
        
    }
    public LicitacaoBean(String dominio, String subdominio, String mes, String ano, String cidade, String natureza
    , String fonte, String tipoLicitacao) {
        this.setDominio(dominio);
        this.setDominio(subdominio);
        this.setDominio(mes);
        this.setDominio(ano);
        this.setDominio(cidade);
        this.setDominio(natureza);
        this.setDominio(fonte);
        this.setDominio(tipoLicitacao);
    }
    public String getCidade() {
        return cidade;
    }

    public String getNatureza() {
        return natureza;
    }

    public String getFonte() {
        return fonte;
    }

    public String getTipoLicitacao() {
        return tipoLicitacao;
    }

    public String getId() {
        return id;
    }

    public String getDominio() {
        return dominio;
    }

    public String getSubdominio() {
        return subdominio;
    }

    public String getMes() {
        return mes;
    }

    public String getAno() {
        return ano;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setSubdominio(String subdominio) {
        this.subdominio = subdominio;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void setTipoLicitacao(String tipoLicitacao) {
        this.tipoLicitacao = tipoLicitacao;
    }
    
}
