/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megacasting_ppe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import megacasting_ppe.classes.Domaine;
import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class domaineDAO {
           public static Domaine trouverparID(long IdentifiantTemp) {
        Statement stmt = null;
        Domaine domaine = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, Libelle FROM domaine WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                long Identifiant = rs.getLong("Identifiant");
                String Libelle = rs.getString("Libelle");
             
                domaine = new Domaine(Libelle);
                domaine.setIdentifiant(Identifiant);
                
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
        return domaine;
    }
}
