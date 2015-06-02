/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import model.LicitacaoBean;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
/**
 *
 * @author eduardo
 */
public class LicitacaoDAO {
    private Connection connection;
    
    public LicitacaoDAO() throws DAOException{
        this.connection = ConnectionFactory.getConnection();
    }
    
    //n sei se o nosso escopo precisa de um save
    //se nao precisar, apaguem
    public void save(LicitacaoBean l) throws SQLException{
        PreparedStatement statement;
        /*String SQL = "INSERT INTO x" 
                + "(x,y,z) VALUES( ' "
                + l.get;*/
    }
    
    //tem q colocar parametros de busca !!!
    public List<LicitacaoBean> getLicitacao() throws SQLException{
        LicitacaoBean l;
        PreparedStatement stmt;
        ResultSet r;
        String result = "";        
        List<LicitacaoBean> listaLicitacaoBean = new ArrayList<LicitacaoBean>();
        //stmt = connection.prepareStatement(SQL);
        //r = stmt.executeQuery();
        /*
        while(r.next()){
            l = new LicitacaoBean();
            l.setDominio("");
            l.setSubdominio("");
            l.setId("");
        }
        */
        return listaLicitacaoBean;
    }
    /*
    private void getListaDespesa() {
        webService.TransparenciaWS service = new webService.TransparenciaWS();
        QName portQName = new QName("http://tempuri.org/", "TransparenciaWSSoap12");
        String req = "<getListaDespesa  xmlns=\"http://tempuri.org/\"><wNomeCidade>ENTER VALUE</wNomeCidade><wAno>ENTER VALUE</wAno><wMes>ENTER VALUE</wMes><wDominio>ENTER VALUE</wDominio><wSubDominio>ENTER VALUE</wSubDominio><wNatureza>ENTER VALUE</wNatureza><wFonte>ENTER VALUE</wFonte><wTipoLicitacao>ENTER VALUE</wTipoLicitacao></getListaDespesa>";
        try {
            // Call Web Service Operation
            Dispatch<Source> sourceDispatch = null;
            sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
            Source result = sourceDispatch.invoke(new StreamSource(new StringReader(req)));
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        //return result;
    }
    */
}
