/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import megacasting_ppe.classes.Contrat;

import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class contratDAO {
       public static Contrat trouverparID(long IdentifiantTemp) {
        Statement stmt = null;
        Contrat contrat = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle FROM contrat WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
             
                contrat = new Contrat(Libelle);
                contrat.setIdentifiant(Identifiant);
                
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
        return contrat;
    }
}
