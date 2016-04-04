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
import megacasting_ppe.classes.Offre;
import megacasting_ppe.dao.CandidatOffreDAO;
import megacasting_ppe.dao.offreDAO;
import org.json.simple.JSONObject;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletOffre", urlPatterns = {"/servletoffre"})
public class ServletOffre extends HttpServlet {

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
       JSONObject object = new JSONObject();
       
        //On récupère en paramètre l'identifiant de l'offre
        long IdOffreTemp = Long.parseLong(request.getParameter("identifiant_offre"));
        
        //on récupère l'offre en BDD
        Offre offre = offreDAO.trouverParId(IdOffreTemp);
        
        //on récupère en BDD
        HttpSession session = request.getSession();
        Candidat candidat = (Candidat)session.getAttribute("CandidatObject");
        String connecterOk = (String)session.getAttribute("Connecter");
        
        JSONObject infoAuth = new JSONObject();
        
        //on vérifie si l'offre a déja été candidaté par le candidat
        if(CandidatOffreDAO.trouver(candidat, offre) != null ){
            //si oui on envoie dans le fichier json CandidatOk à true 
            infoAuth.put("CandidaterOk", "true");

        }else{
            //si non on envoie dans le fichier json CandidatOk à false 
            infoAuth.put("CandidaterOk", "false");
        }
        
        //si il ya un candidat de connecter , on retourne les informations du candidat
        if(candidat != null && connecterOk != null){
                
            
            infoAuth.put("Nom", candidat.getNom());
            infoAuth.put("Prenom", candidat.getPrenom());
            infoAuth.put("connecter", connecterOk);
            object.put("infoauth", infoAuth);
        
        }else{
            
            
            infoAuth.put("connecter", "false");
            object.put("infoauth", infoAuth);
            
       
        };
        //Par défaut il n'y a pas de fin de contrat, dans le cas si l'offre proposé est un CDI
        String datefincontrat = "Aucune date";
        if(offre.getDateFinContrat() != null){
            
             datefincontrat = offre.getDateFinContrat().toString();
             
        }
            //on retourne les informations de l'offre
            object.put("Identifiant", offre.getIdentifiant());
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
            
            
            try (PrintWriter out = response.getWriter()) {
            out.println(object.toJSONString());
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
