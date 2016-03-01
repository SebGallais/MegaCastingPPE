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
import megacasting_ppe.classes.Client;

import static megacasting_ppe.dao.BDD.getINSTANCE;

/**
 *
 * @author Seb
 */
public class clientDAO {

   
     
         public static Client trouverparID(long IdentifiantTemp) {
        Statement stmt = null;
        Client client = null;
        try {

            stmt = getINSTANCE().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Identifiant, NomEntreprise, NomResponsable, PrenomResponsable, CiviliteResponsable, RueEntreprise, CpEntreprise, VilleEntreprise, MailEntreprise, FaxEntreprise, TelephoneEntreprise FROM client WHERE Identifiant = '" + IdentifiantTemp + "'");

            while (rs.next()) {

                 long Identifiant = rs.getLong("Identifiant");
                String NomEntreprise = rs.getString("NomEntreprise");
                String NomResponsable = rs.getString("NomResponsable");
                String PrenomResponsable = rs.getString("PrenomResponsable");
                String CiviliteResponsable = rs.getString("CiviliteResponsable");
                String RueEntreprise = rs.getString("RueEntreprise");
                int CpEntreprise = rs.getInt("CpEntreprise");
                String VilleEntreprise = rs.getString("VilleEntreprise");
                String MailEntreprise = rs.getString("MailEntreprise");
                String FaxEntreprise = rs.getString("FaxEntreprise");
                String TelephoneEntreprise = rs.getString("TelephoneEntreprise");
                

                client = new Client(NomEntreprise ,NomResponsable ,PrenomResponsable ,CiviliteResponsable ,RueEntreprise ,CpEntreprise ,VilleEntreprise ,MailEntreprise ,FaxEntreprise ,TelephoneEntreprise );
                client.setIdentifiant(Identifiant);
                
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
        return client;
    }
     
     
     
     
     
     
    
    
}
