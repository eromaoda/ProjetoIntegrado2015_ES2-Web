/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.*;
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
import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.util.regex.*;

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
            //net.azurewebsites.transparenciaws.TransparenciaWS service = new net.azurewebsites.transparenciaws.TransparenciaWS();
            //net.azurewebsites.transparenciaws.TransparenciaWSSoap port = service.getTransparenciaWSSoap();
            
            LicitacaoBean objLicitacao = new LicitacaoBean();
        
            //objLicitacao.setAno(request.getParameter("ano"));
            objLicitacao.setMes(request.getParameter("mes"));
            objLicitacao.setDominio(request.getParameter("dominio"));
            objLicitacao.setSubdominio(request.getParameter("subdom"));
            objLicitacao.setTipoLicitacao(request.getParameter("licitacao"));
            
            String dominio = objLicitacao.getDominio();
            String subdom = objLicitacao.getSubdominio();
            String licitacao = objLicitacao.getTipoLicitacao();
            String ano = objLicitacao.getAno();
            String mes = objLicitacao.getMes();
            
            String vTotal = getTotalDespesa("Campinas", "2014", mes, dominio, subdom, "", "", licitacao);
            String xml = getListaDespesa("Campinas", "2014", mes, dominio, subdom, "", "", licitacao);
            String resultado = new String();
           
            
            try{
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                InputSource inputSrc = new InputSource();
                inputSrc.setCharacterStream(new StringReader(xml));
                
                Document doc = db.parse(inputSrc);
                NodeList nodes = doc.getElementsByTagName("Despesa");
                
                for(int i = 0; i < nodes.getLength(); i++){
                    Element element = (Element)nodes.item(i);
                    
                    NodeList orgao = element.getElementsByTagName("DescricaoOrgao");
                    Element line = (Element)orgao.item(0);
                    
                    resultado = resultado + "<tr><td>" + getCharacterDataFromElement(line) + "</td>";
                    
                    NodeList credor = element.getElementsByTagName("CpfCnpjCredor");
                    line = (Element)credor.item(0);
                    
                    resultado = resultado + "<td>" + getCharacterDataFromElement(line) + "</td>";
                    
                    NodeList valor = element.getElementsByTagName("Valor");
                    line = (Element)valor.item(0);
                    
                    resultado = resultado + "<td>" + "R$ " + getCharacterDataFromElement(line) + "</td></tr>";
                }
                
            }catch(Exception e){
                response.sendRedirect("./pgErro.jsp");
            }
            
            String pgDestino = new String();
            if(resultado.equals("")) pgDestino = "./noResults.jsp";
            else pgDestino = "./licitacao.jsp";
            request.setAttribute("result", resultado);
            request.setAttribute("valorTotal", vTotal);
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher(pgDestino);
            rd.forward(request, response);
        }catch(Exception e){
            response.sendRedirect("./pgErro.jsp");
        }
        
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

    private String getListaDespesa(java.lang.String wNomeCidade, java.lang.String wAno, java.lang.String wMes, java.lang.String wDominio, java.lang.String wSubDominio, java.lang.String wNatureza, java.lang.String wFonte, java.lang.String wTipoLicitacao) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        net.azurewebsites.transparenciaws.TransparenciaWSSoap port = service.getTransparenciaWSSoap12();
        return port.getListaDespesa(wNomeCidade, wAno, wMes, wDominio, wSubDominio, wNatureza, wFonte, wTipoLicitacao);
    }
    
    private String getTotalDespesa(java.lang.String wNomeCidade, java.lang.String wAno, java.lang.String wMes, java.lang.String wDominio, java.lang.String wSubDominio, java.lang.String wNatureza, java.lang.String wFonte, java.lang.String wTipoLicitacao) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        net.azurewebsites.transparenciaws.TransparenciaWSSoap port = service.getTransparenciaWSSoap12();
        return port.getTotalDespesa(wNomeCidade, wAno, wMes, wDominio, wSubDominio, wNatureza, wFonte, wTipoLicitacao);
    }
    
    public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
       CharacterData cd = (CharacterData) child;
       return cd.getData();
    }
    return "?";
  }

}
