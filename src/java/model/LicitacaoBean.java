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

    public LicitacaoBean() {
    }
}
