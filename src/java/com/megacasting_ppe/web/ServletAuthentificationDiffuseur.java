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
import megacasting_ppe.classes.Compte;
import megacasting_ppe.classes.Diffuseur;
import megacasting_ppe.dao.compteDAO;
import megacasting_ppe.dao.diffuseurDAO;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletAuthentificationDiffuseur", urlPatterns = {"/servletauthentificationdiffuseur"})
public class ServletAuthentificationDiffuseur extends HttpServlet {

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
        HttpSession session = request.getSession();
         //Recuperer les pseudonymes du formulaires de connexion
        String pseudonyme = request.getParameter("pseudonyme");
        String motdepasse = request.getParameter("motdepasse");
        Diffuseur diffuseur = null;
        
        Boolean diffuseurOk = false;
        //Recherche un compte correspondant au pseudonyme et mot de passe 
        Compte compte = compteDAO.authentification(pseudonyme, motdepasse);
        //Si il y a un compte
        if( compte != null){
        //Verifier que ce compte correspond à un candidat
         diffuseur = diffuseurDAO.trouverparIDCompte(compte.getIdentifiant());
            if(diffuseur != null ){
                diffuseurOk = true;
            }  
        }
        if (compte != null && diffuseurOk == true ) {
            //Ajouter les informations du candidat en session
            session.setAttribute("DiffuseurObject", diffuseur);
            session.setAttribute("ConnecterDiffuseur", "true");

            RequestDispatcher rq = request.getRequestDispatcher("flux.html");
            rq.forward(request, response);

        } else{
            
            RequestDispatcher rq = request.getRequestDispatcher("authentificationDiffuseur.html");
            rq.forward(request, response);
            session.setAttribute("ConnecterDiffuseur", "false");
        
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
