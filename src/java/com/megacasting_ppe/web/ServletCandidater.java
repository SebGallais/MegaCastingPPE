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
import megacasting_ppe.classes.Offre;
import megacasting_ppe.dao.CandidatOffreDAO;
import megacasting_ppe.dao.offreDAO;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletCandidater", urlPatterns = {"/servletcandidater"})
public class ServletCandidater extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache");

        HttpSession session = request.getSession();
        //Recuperer identifiant de l'offre dasn les parmètres de l'url de la page web 
        long IdOffreTemp = Long.parseLong(request.getParameter("identifiant_offre"));
       
        //on récupére le candidat stocké en session
        Candidat candidat = (Candidat)session.getAttribute("CandidatObject");
        //trouver l'offre en BDD
        Offre offre = offreDAO.trouverParId(IdOffreTemp);
        
        //ensuite associer l'offre au candididat en BDD
        CandidatOffreDAO.Creer(candidat, offre);
        
         
        RequestDispatcher rq = request.getRequestDispatcher("offre.html?offreid="+IdOffreTemp);
        rq.forward(request, response);
        
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
