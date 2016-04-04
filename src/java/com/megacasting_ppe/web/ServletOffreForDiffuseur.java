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
import megacasting_ppe.classes.Offre;
import megacasting_ppe.dao.offreDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletOffreForDiffuseur", urlPatterns = {"/offrefordiffuseur"})
public class ServletOffreForDiffuseur extends HttpServlet {

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
         response.setContentType("application/json;  charset=ISO-8859-1" );
         response.setHeader("Cache-Control", "no-cache");
           JSONObject global = new JSONObject();
           JSONArray arrayoffre = new JSONArray();
         
           //on récupère l'ensemble des offres de casting en BDD
          for (Offre offre : offreDAO.Lister()) {

                JSONObject object = new JSONObject();
                //Par défaut il n'y a pas de fin de contrat, dans le cas si l'offre proposé est un CDI
                String datefincontrat = "Aucune Date";
                if(offre.getDateFinContrat() != null){

                     datefincontrat = offre.getDateFinContrat().toString();

                }
                //on retourne les informations de l'offre
                object.put("Intitule", offre.getLibelle());
                object.put("Reference", offre.getReference());
                object.put("DateDebutPublication", offre.getDateDebutPublication().toString());
                object.put("DateFinPublication", offre.getDateFinPublication().toString());
                object.put("DateDebutContrat", offre.getDateDebutContrat().toString());
                object.put("DateFinContrat", datefincontrat);
                object.put("DescriptionPoste", offre.getDescriptionPoste());
                object.put("DescriptionProfil", offre.getDescriptionProfil());
                object.put("NombresPoste", offre.getNbPoste());
                object.put("NomEntreprise",offre.getClient().getNomEntreprise());
                object.put("NomResponsable", offre.getClient().getNomResponsable());
                object.put("PrenomResponsable", offre.getClient().getPrenomResponsable());
                object.put("CiviliteResponsable", offre.getClient().getCiviliteResponsable());
                object.put("RueEntreprise",offre.getClient().getRueEntreprise());
                object.put("CpEntreprise", offre.getClient().getCpEntreprise());
                object.put("VilleEntreprise", offre.getClient().getVilleEntreprise());
                object.put("MailEntreprise", offre.getClient().getMailEntreprise());
                object.put("FaxEntreprise",offre.getClient().getFaxEntreprise());
                object.put("TelephoneEntreprise",offre.getClient().getTelephoneEntreprise()); 
                object.put("Metier", offre.getMetier().getLibelle());
                object.put("Contrat", offre.getContrat().getLibelle());
            
            
            arrayoffre.add(object);
            
        }
        global.put("offres", arrayoffre);
        
        
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
