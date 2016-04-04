/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacasting_ppe.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import megacasting_ppe.classes.Candidat;
import org.json.simple.JSONObject;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletPageError", urlPatterns = {"/servletpageerror"})
public class ServletPageError extends HttpServlet {

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
         response.setContentType("application/json");
         response.setHeader("Cache-Control", "no-cache");
           HttpSession session = request.getSession();
         
           
          JSONObject global = new JSONObject();
        
        if (session.getAttribute("Connecter") != null) {  
            String connecterCandidatOk = (String)session.getAttribute("Connecter");
            if(connecterCandidatOk == "false"){
               
            global.put("candidatAutherreur", "le nom d'utilisateur ou le mot de passe du candidat est incorrect");
            session.removeAttribute("Connecter");
            }
        }
        if (session.getAttribute("ConnecterDiffuseur") != null) {  
            String connecterDiffuseurOk = (String)session.getAttribute("ConnecterDiffuseur");
            if(connecterDiffuseurOk == "false"){
               
            global.put("diffuseurAutherreur", "le nom d'utilisateur ou le mot de passe du diffuseur est incorrect");
            session.removeAttribute("ConnecterDiffuseur");
            }
        }
        
        if (session.getAttribute("ErreurInscriptionCandidat") != null) {  
            String ErreurInscription = (String)session.getAttribute("ErreurInscriptionCandidat");
            if(ErreurInscription == "true"){
               
            global.put("Inscriptionerreur", "Un ou plusieurs champs saisies dans le formulaire d'inscription sont invalide");
            session.removeAttribute("ErreurInscriptionCandidat");
            }
        }
        
        
        
           try (PrintWriter out = response.getWriter()) {          
            out.println(global.toString(  ));
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
