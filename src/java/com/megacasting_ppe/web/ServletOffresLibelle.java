/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacasting_ppe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import megacasting_ppe.classes.Offre;
import megacasting_ppe.dao.offreDAO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Seb
 */
@WebServlet(name = "ServletOffresLibelle", urlPatterns = {"/servletoffreslibelle"})
public class ServletOffresLibelle extends HttpServlet {

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

        //on récupère la valeur recupéré du moteur de recherche.
        String Libelle = request.getParameter("libelle_recherche");
   
        HttpSession session = request.getSession();

        JSONObject global = new JSONObject();
        JSONArray arrayoffre = new JSONArray();
        
        ArrayList<Offre> listOffresSearch = new ArrayList();
       for (Offre offre : offreDAO.Lister()) {
           
           if(recherche(offre.getLibelle(), Libelle ) > 0 ){
               
               listOffresSearch.add(offre);
               
               
           }
  
       }
        
        
        for (Offre offre : listOffresSearch) {

            JSONObject object = new JSONObject();
            object.put("Identifiant", offre.getIdentifiant());
            object.put("Intitule", offre.getLibelle());
            object.put("Reference", offre.getReference());
            object.put("DateDebutContrat", offre.getDateDebutContrat().toString());
            object.put("NombresPoste", offre.getNbPoste());
            object.put("VilleEntreprise", offre.getClient().getVilleEntreprise());
            arrayoffre.add(object);
            
        }
        global.put("offres", arrayoffre);
        global.put("container_search", Libelle);
      session.setAttribute("offres_lib", global);
        
       RequestDispatcher rq = request.getRequestDispatcher("offres.html");
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

    
    
    
    public static int recherche(String texte, String keyword) 
    {
      int count = 0;
      int index = texte.indexOf(keyword);
      while (index != -1)
             {
        ++count;
        index = texte.indexOf(keyword, index + 1); 
      }
      
      return count;
    }
}
