/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacasting_ppe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import megacasting_ppe.classes.Candidat;
import megacasting_ppe.classes.Compte;
import megacasting_ppe.dao.candidatDAO;
import megacasting_ppe.dao.compteDAO;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletInscriptionCandidat", urlPatterns = {"/servletinscriptioncandidat"})
public class ServletInscriptionCandidat extends HttpServlet {

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
        
        String Nom = request.getParameter("nom_inscription");
        String Prenom = request.getParameter("prenom_inscription");
        String Email = request.getParameter("email_inscription");
        String Telephone = request.getParameter("telephone_inscription");
        String Portable = request.getParameter("portable_inscription");
        String Rue = request.getParameter("rue_inscription");
        int CodePostal = Integer.parseInt(request.getParameter("codepostal_inscription"));
        String Ville = request.getParameter("ville_inscription");
        String DateNaissanceString = request.getParameter("datenaissance_inscription");
        String Permis = request.getParameter("permis_inscription");
        String Pseudonyme = request.getParameter("pseudonyme_inscription");
        String MotDePasse = request.getParameter("motdepasse_inscription");
        try
        {
            
            SimpleDateFormat typeFormat = new SimpleDateFormat( "dd/MM/yyyy" );
            java.util.Date UtilDateNaissance = typeFormat.parse(DateNaissanceString);
            java.sql.Date DateNaissance =  new java.sql.Date(UtilDateNaissance.getTime());
        
                HttpSession session = request.getSession();
                boolean Inscription_ok = true;
                //TEST      

                if (Nom == "" || Prenom == "" || Email == "" || Telephone == "" || Portable == "" || Rue == "" || Ville == "" || DateNaissanceString == "" || Permis == "" || Pseudonyme == "" || MotDePasse == "") {
                    Inscription_ok = false;
                }
                if (Nom == null || Prenom == null || Email == null || Telephone == null || Portable == null || Rue == null || Ville == null || DateNaissanceString == null || Permis == null|| Pseudonyme == null || MotDePasse == null ) {
                    Inscription_ok = false;
                }

                if (compteDAO.trouverparPseudonyme(Pseudonyme) != null) {
                    Inscription_ok = false;
                }

                if (Inscription_ok == true) {
                    //declarer aucun message d'erreur
                    session.setAttribute("ErreurInscriptionCandidat", "false");


                    Compte compte = new Compte(Pseudonyme, MotDePasse);
                    compteDAO.Creer(compte);

                    Candidat candidat = new Candidat(Nom, Prenom, Email, Telephone, Portable, Rue, CodePostal, Ville, DateNaissance, Permis, compte );
                    candidatDAO.Creer(candidat);

                    //renvoyer a la page de connexion
                    RequestDispatcher rq = request.getRequestDispatcher("#");
                    rq.forward(request, response);

                } else {
                    //Indiquer message d'erreur
                    session.setAttribute("ErreurInscriptionCandidat", "true");

                    //refresh
                    RequestDispatcher rq = request.getRequestDispatcher("#");
                    rq.forward(request, response);

                }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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
