/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import megacasting_ppe.classes.Candidat;
import megacasting_ppe.classes.CandidatOffre;
import megacasting_ppe.classes.Client;
import megacasting_ppe.classes.Offre;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class CandidatOffreDAO {
    public static void Creer(Candidat candidat, Offre offre) {
    Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            stmt.executeUpdate("INSERT INTO offrecandidat(IdentifiantOffre, IdentifiantCandidat)"
                    + "VALUES('" + offre.getIdentifiant() + "'"
                     + ",'" + candidat.getIdentifiant() + "')");

            ResultSet rs = stmt.executeQuery("SELECT MAX(Identifiant) FROM candidat ");
            if (rs.next() == true) {
                Long id = rs.getLong(1);
                candidat.setIdentifiant(id);
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

    }
    
    
     public static CandidatOffre trouver(Candidat candidatTemp, Offre offreTemp) {
        Statement stmt = null;
        CandidatOffre candidatoffre = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT IdentifiantOffre, IdentifiantCandidat FROM offrecandidat WHERE IdentifiantCandidat = '" + candidatTemp.getIdentifiant() + "' AND IdentifiantOffre = '" + offreTemp.getIdentifiant()+"'");

            while (rs.next()) {

                 long IdentifiantOffre = rs.getLong("IdentifiantOffre");
                 long IdentifiantCandidat = rs.getLong("IdentifiantCandidat");

                 Offre offre = offreDAO.trouverParId(IdentifiantOffre);
                 Candidat candidat = candidatDAO.trouverparID(IdentifiantCandidat);
                
                 candidatoffre = new CandidatOffre(candidat, offre);
                 
                
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
        return candidatoffre;
    }
    
}
