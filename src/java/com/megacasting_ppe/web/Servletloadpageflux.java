/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacasting_ppe.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import megacasting_ppe.classes.Candidat;
import megacasting_ppe.classes.Diffuseur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Seb
 */
@WebServlet(name = "Servletloadpageflux", urlPatterns = {"/servletloadpageflux"})
public class Servletloadpageflux extends HttpServlet {

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
             response.setContentType("application/json;  charset=ISO-8859-1");
         HttpSession session = request.getSession();

        JSONObject global = new JSONObject();
    
        
        Diffuseur diffuseur = (Diffuseur)session.getAttribute("DiffuseurObject");
        String connecterOk = (String)session.getAttribute("ConnecterDiffuseur");
        
       
        
        
        if(diffuseur != null && connecterOk != null){
                
        JSONObject infoAuth = new JSONObject();
        
            infoAuth.put("Entreprise", diffuseur.getNomEntreprise());
            infoAuth.put("connecter", connecterOk);
            
            global.put("infoauth", infoAuth);
        
        }else{
            
            JSONObject infoAuth = new JSONObject();
            infoAuth.put("connecter", "false");
            
            global.put("infoauth", infoAuth);
            
       
        };
        
         try (PrintWriter out = response.getWriter()) {          
            out.println(global.toString());
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
