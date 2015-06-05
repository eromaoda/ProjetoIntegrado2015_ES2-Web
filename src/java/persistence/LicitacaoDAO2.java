/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.LicitacaoBean; 
/**
 *
 * @author eduardo
 */
public class LicitacaoDAO2 {
    private Connection connection;
    
    public LicitacaoDAO2() /*throws DAOException{*/{
        try{
            this.connection = ConnectionFactory.getConnection();
        }catch(DAOException e){
        
        }
    }
    
    //n sei se o nosso escopo precisa de um save
    //se nao precisar, apaguem
    public void save(LicitacaoBean l) throws SQLException{
        PreparedStatement statement;
        /*String SQL = "INSERT INTO x" 
                + "(x,y,z) VALUES( ' "
                + l.get;*/
    }
    
    
    public List<LicitacaoBean> getLicitacao(String dominio, String subDominio, String tipoLicitacao)/* throws SQLException{*/{
      
        List<LicitacaoBean> listaLicitacaoBean = new ArrayList<LicitacaoBean>();
        //String result = getListaDespesa("","","",dominio,subDominio,"","", tipoLicitacao);
        String result = getListaDespesa("","","","","","","", "");
        listaLicitacaoBean = procuraCampos(result);
        return listaLicitacaoBean;        
    }
    //Verifica os campos do XML, obs. zuado, mas funciona...
    
    public List<LicitacaoBean> procuraCampos(String result){
        int numeroLicitacao = 0;
        int i;
        List<LicitacaoBean> listaLicitacaoBean = new ArrayList<LicitacaoBean>();
        
        Pattern pattern = Pattern.compile("<Codigo>(.*?)</Codigo>");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            LicitacaoBean licitacao = new LicitacaoBean();
            licitacao.setId(matcher.group(1));
            listaLicitacaoBean.add(licitacao);     
            numeroLicitacao++;
        }
        pattern = Pattern.compile("<DescricaoDominio>(.*?)</DescricaoDominio>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setDominio(matcher.group(1));  
            i++;
        }
        pattern = Pattern.compile("<DescricaoSubDominio>(.*?)</DescricaoSubDominio>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setSubdominio(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<DescricaoTipoLicitacao>(.*?)</DescricaoTipoLicitacao>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setTipoLicitacao(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<DataAno>(.*?)</DataAno>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setAno(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<DataMes>(.*?)</DataMes>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setMes(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<DescricaoNatureza>(.*?)</DescricaoNatureza>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setNatureza(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<CodigoFonte>(.*?)</CodigoFonte>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setFonte(matcher.group(1));   
            i++;
        }
        pattern = Pattern.compile("<CodigoUF>(.*?)</CodigoUF>");
        matcher = pattern.matcher(result);
        i=0;
        while (matcher.find() && i < numeroLicitacao) {            
            listaLicitacaoBean.get(i).setCidade(matcher.group(1));   
            i++;
        }
        return listaLicitacaoBean;
    }
    
    

    private static String getListaDespesa(java.lang.String wNomeCidade, java.lang.String wAno, java.lang.String wMes, java.lang.String wDominio, java.lang.String wSubDominio, java.lang.String wNatureza, java.lang.String wFonte, java.lang.String wTipoLicitacao) {
        
        net.azurewebsites.transparenciaws.TransparenciaWS service = new net.azurewebsites.transparenciaws.TransparenciaWS();
        net.azurewebsites.transparenciaws.TransparenciaWSSoap port = service.getTransparenciaWSSoap();
        return port.getListaDespesa(wNomeCidade, wAno, wMes, wDominio, wSubDominio, wNatureza, wFonte, wTipoLicitacao);
    }

 


    
}
