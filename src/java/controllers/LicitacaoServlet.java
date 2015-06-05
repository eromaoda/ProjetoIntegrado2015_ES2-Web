/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import model.LicitacaoBean;
import net.azurewebsites.transparenciaws.TransparenciaWS;
import persistence.DAOException;
import persistence.LicitacaoDAO;

/**
 *
 * @author eduardo
 */
public class LicitacaoServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/transparenciaws.azurewebsites.net/TransparenciaWS.asmx.wsdl")
    private TransparenciaWS service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LicitacaoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LicitacaoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    /*private String getListaDespesa(String wNomeCidade, String wAno, String wMes, String wDominio, String wSubDominio, String wNatureza, String wFonte,
String wTipoLicitacao){
        controllers.LicitacaoServlet port = service.getListaDespesa();
    }*/
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        try{
            net.azurewebsites.transparenciaws.TransparenciaWS service = new net.azurewebsites.transparenciaws.TransparenciaWS();
            net.azurewebsites.transparenciaws.TransparenciaWSSoap port = service.getTransparenciaWSSoap();
            
            LicitacaoBean objLicitacao = new LicitacaoBean();
        
            objLicitacao.setAno(request.getParameter("ano"));
            objLicitacao.setMes(request.getParameter("mes"));
            objLicitacao.setDominio(request.getParameter("dominio"));
            objLicitacao.setSubdominio(request.getParameter("subdom"));
            objLicitacao.setTipoLicitacao(request.getParameter("licitacao"));
            
            String dominio = objLicitacao.getDominio();
            String subdom = objLicitacao.getSubdominio();
            String licitacao = objLicitacao.getTipoLicitacao();
            String ano = objLicitacao.getAno();
            String mes = objLicitacao.getMes();
            
            String resultado = port.getListaDespesa("Campinas", ano, mes, dominio, subdom, "", "", licitacao);
            
            //objLicitacao.setResultados(resultado);
            request.setAttribute("result", objLicitacao);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("./licitacao.jsp");
            rd.forward(request, response);
        //ta caindo sempre na excecao, nao sei oq fazer !!
        //aparentemente eh alguma coisa com o metodo do webservice
        }catch(Exception e){
            //tratar excecao
            response.sendRedirect("./index.jsp");
        }
        //Integrar o web service no projeto 
        //Chamar o metodo getLicitacaoList do web service
        
        //LicitacaoBean licitacaoBean = new LicitacaoBean();
        /*List<LicitacaoBean> listaLicitacaoBean = new ArrayList<LicitacaoBean>();
        try{
            LicitacaoDAO licitacaoDAO = new LicitacaoDAO();
            listaLicitacaoBean = licitacaoDAO.getLicitacao();
        }catch(DAOException e){
        
        }catch(SQLException e){
        
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("licitacao.jsp");
        request.setAttribute("LicitacaoBean", listaLicitacaoBean);
        dispatcher.forward(request, response);*/
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    /*private String getListaDespesa(java.lang.String wNomeCidade, java.lang.String wAno, java.lang.String wMes, java.lang.String wDominio, java.lang.String wSubDominio, java.lang.String wNatureza, java.lang.String wFonte, java.lang.String wTipoLicitacao) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.TransparenciaWSSoap port = service.getTransparenciaWSSoap();
        return port.getListaDespesa(wNomeCidade, wAno, wMes, wDominio, wSubDominio, wNatureza, wFonte, wTipoLicitacao);
    }*/

    /*private String getListaDespesa(java.lang.String wNomeCidade, java.lang.String wAno, java.lang.String wMes, java.lang.String wDominio, java.lang.String wSubDominio, java.lang.String wNatureza, java.lang.String wFonte, java.lang.String wTipoLicitacao) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.TransparenciaWSSoap port = service.getTransparenciaWSSoap12();
        return port.getListaDespesa(wNomeCidade, wAno, wMes, wDominio, wSubDominio, wNatureza, wFonte, wTipoLicitacao);
    }*/
    

}
