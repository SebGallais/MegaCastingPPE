/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import megacasting_ppe.classes.Candidat;
import megacasting_ppe.classes.Compte;
import megacasting_ppe.classes.Diffuseur;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class diffuseurDAO {
    
    public static Diffuseur trouverparIDCompte(long IdentifiantTemp) {
        Statement stmt = null;
        Diffuseur diffuseur = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, NomEntreprise, IdentifiantCompte FROM diffuseur WHERE IdentifiantCompte = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Nom = rs.getString("NomEntreprise");
                long IdentifiantCompte = rs.getLong("IdentifiantCompte");
                
                Compte Compte = compteDAO.trouverparid(IdentifiantCompte);
                
                
                diffuseur = new Diffuseur(Nom, Compte );
                diffuseur.setIdentifiant(Identifiant);
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                }
            }
        }
        return diffuseur;
   
    }
    
    
  
    
}
