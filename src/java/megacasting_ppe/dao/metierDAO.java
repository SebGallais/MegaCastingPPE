/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import megacasting_ppe.classes.Domaine;
import megacasting_ppe.classes.Metier;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class metierDAO {
    public static Metier trouverparID(long IdentifiantTemp) {
        Statement stmt = null;
        Metier metier = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, IdentifiantDomaine FROM metier WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                long IdentifiantDomaine = rs.getLong("IdentifiantDomaine");
                Domaine domaine = domaineDAO.trouverparID(IdentifiantDomaine);
                metier = new Metier(Libelle, domaine);
                metier.setIdentifiant(Identifiant);
                
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
        return metier;
    }
    
     public static ArrayList<Metier> Lister() {
        ArrayList<Metier> ListMetier = new ArrayList();
        Statement stmt = null;
        try {
            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle, IdentifiantDomaine  FROM metier ");
            while (rs.next()) {
                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
                long IdentifiantDomaine = rs.getLong("IdentifiantDomaine");
                Domaine domaine = domaineDAO.trouverparID(IdentifiantDomaine);
                
                Metier metier = new Metier(Libelle, domaine);
                metier.setIdentifiant(Identifiant);
                ListMetier.add(metier);
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

        return ListMetier;
    }
    
}
