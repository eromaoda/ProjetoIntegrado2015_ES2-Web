/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import model.LicitacaoBean;
import java.sql.*;
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
    public LicitacaoBean getLicitacao() 
            throws SQLException{
        LicitacaoBean l;
        PreparedStatement stmt;
        ResultSet r;
        String SQL = "SELECT * FROM x WHERE parametro = '";
        stmt = connection.prepareStatement(SQL);
        r = stmt.executeQuery();
        
        while(r.next()){
            l = new LicitacaoBean();
            l.setDominio("");
            l.setSubdominio("");
            l.setId("");
        }
        
        return l;
    }
}
