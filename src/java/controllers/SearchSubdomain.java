/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eduardo
 */
public class SearchSubdomain extends HttpServlet {

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
            out.println("<title>Servlet SearchSubdomain</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchSubdomain at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
    
        String dominio = request.getParameter("dominio");
        String subdoms = "";
        
        response.setCharacterEncoding("UTF-8");
        
        if(dominio.equals("Saude")){
            subdoms += "<option value=\"Epidemologia\">Epidemologia</option>";
            subdoms += "<option value=\"Assistencia Hospitalar\">Assistencia Hospitalar</option>";
            subdoms += "<option value=\"Assistencia Ambulatorial\">Assistencia Ambulatorial</option>";            
        }else if(dominio.equals("Educacao")){
            subdoms += "<option value=\"Educacao Superior\">Eduacacao Superior</option>";
            subdoms += "<option value=\"Educacao Infantil\">Eduacacao Infantil</option>";
        }else if(dominio.equals("Saneamento")){
            subdoms += "<option value=\"Coleta de Lixo\">Coleta de Lixo</option>";
            subdoms += "<option value=\"Reciclagem\">Reciclagem</option>";
        }
        
        PrintWriter writer = response.getWriter();
        writer.print(subdoms);
        writer.close();
        
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
        processRequest(request, response);
        
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

}
