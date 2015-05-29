/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.*;

/**
 *
 * @author eduardo
 */
public class ConnectionFactory {
    public static void  closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) 
            throws DAOException{
        close(conn, ps, rs);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement ps) 
            throws DAOException{
        close(conn, ps, null);
    }
    
    public static void closeConnection(Connection conn) 
            throws DAOException{
        close(conn, null, null);
    }
    
    private static void close(Connection conn, PreparedStatement ps, ResultSet rs)
            throws DAOException{
        try{
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        }catch(SQLException e){
            throw new  DAOException(e.getMessage(), e.fillInStackTrace());
        }
    }
    
    public static Connection getConnection() 
            throws DAOException{
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connection = "jdbc:mysql://localhost/ride";
            //tem que add os campos String dos parametros da busca !!
            
            Connection conn = DriveManager.getConnection(connection); //ainda tem q add os outros parametros
            return conn; 
            //no tutorial ele pede pra add a library do driver JDBC, mas n sei se a gente usa esse tbm
        }catch(SQLException exception) {
            throw new DAOException(exception.getMessage(), exception.fillInStackTrace());
        }catch(ClassNotFoundException exception) {
            throw new DAOException(exception.getMessage(), exception.fillInStackTrace());
        }catch (InstantiationException exception) {
            throw new DAOException(exception.getMessage(), exception.fillInStackTrace());
        }catch (IllegalAccessException exception) {
            throw new DAOException(exception.getMessage(), exception.fillInStackTrace());
        }
    }
}
